/*
 * Copyright (C) 2019 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package teistris.model;

import java.awt.Color;
import java.util.ArrayList;
import teistris.view.MainWindow;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Clase que implementa o comportamento do xogo do Tetris
 *
 * @author Profe de Programación
 * @author Mateo Alfaya & Xaquin Alves xasdaasdfdas
 */
public class Game {

    /**
     * Almacena os cadrados do chan
     */
    private HashMap<String, Square> groundSquares;
    /**
     * Constante que define o tamaño en pixels do lado dun cadrado
     */
    public final static int SQUARE_SIDE = 20;
    /**
     * Constante que define o valor máximo da coordenada x no panel de cadrados
     */
    public final static int MAX_X = 240;
    /**
     * Constante que define o valor máximo da coordenada y no panel de cadrados
     */
    public final static int MAX_Y = 320;

    /**
     * Referenza á peza actual do xogo, que é a única que se pode mover
     */
    private Piece currentPiece;
    /**
     * Referenza a seguinte penza que saldra
     */
    private Piece nextPiece;
    /**
     * Referenza a peza en reserva
     */
    private Piece savedPiece;
    /**
     * Bolsa de pezas das que se saca a peza actual
     */
    private Stack<Piece> bagPieces = new Stack<>();

    /**
     * Referenza á ventá principal do xogo
     */
    private MainWindow mainWindow;

    /**
     * Flag que indica se o xogo está en pausa ou non
     */
    private boolean paused = false;

    /**
     * Número de liñas feitas no xogo
     */
    private int numberOfLines = 0;

    /**
     * @return Referenza á ventá principal do xogo
     */
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    /**
     * @param mainWindow Ventá principal do xogo a establecer
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * @return O estado de pausa do xogo
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * @param paused O estado de pausa a establecer
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * @return Número de liñas feitas no xogo
     */
    public int getNumberOfLines() {
        return numberOfLines;
    }

    /**
     * @param numberOfLines O número de liñas feitas no xogo
     */
    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public Piece getSavedPiece() {
        return savedPiece;
    }

    /**
     * Construtor da clase, que crea unha primeira peza
     *
     * @param mainWindow Referenza á ventá principal do xogo
     */
    public Game(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.createNewPiece();
        savedPiece = null;
        this.groundSquares = new HashMap<>();
    }

    /**
     * Move a ficha actual á dereita, se o xogo non está pausado
     */
    public void movePieceRight() {
        if (!paused) {
            currentPiece.moveRight();
        }
    }

    /**
     * Move a ficha actual á esquerda, se o xogo non está pausado
     */
    public void movePieceLeft() {
        if (!paused) {
            currentPiece.moveLeft();
        }
    }

    /**
     * Rota a ficha actual, se o xogo non está pausado
     */
    public void rotatePiece() {
        if (!paused) {
            currentPiece.rotate();
        }
    }

    /**
     * Move a peza actual abaixo, se o xogo non está pausado Se a peza choca con
     * algo e xa non pode baixar, pasa a formar parte do chan e créase unha nova
     * peza
     */
    public void movePieceDown() {
        if ((!paused) && (!currentPiece.moveDown())) {
            this.addPieceToGround();
            this.createNewPiece();
            if (this.hitPieceTheGround()) {

                this.mainWindow.showGameOver();
            }
        }
    }

    /**
     * Garda unha peza, para poder usala mais adiante
     */
    public void savePiece() {
        if (!paused && currentPiece.moveDown()) {
            // Si non hay peza gardada, gardamos a actual e xeramos unha nova
            if (savedPiece == null) {

                savedPiece = currentPiece;

                for (Square sq : savedPiece.getSquares()) {

                    mainWindow.deleteSquare(sq.getLblSquare());

                    sq.repaintOnSaved();

                    mainWindow.drawSavedSquare(sq.getLblSquare());

                }

                savedPiece.resetPiece();

                createNewPiece();
                //Si hay peza gardada, gardamos a actual e pomos a gardada comon actual  
            } else {

                Piece temp = currentPiece;
                currentPiece = savedPiece;
                savedPiece = temp;

                for (Square sq : currentPiece.getSquares()) {
                    mainWindow.deleteSavedSquare(sq.getLblSquare());
                    sq.repaintOnMainWindow();
                    mainWindow.drawSquare(sq.getLblSquare());
                }

                for (Square sq : savedPiece.getSquares()) {
                    mainWindow.deleteSquare(sq.getLblSquare());
                    sq.repaintOnSaved();
                    mainWindow.drawSavedSquare(sq.getLblSquare());
                }

                savedPiece.resetPiece();
            }
        }
    }

    /**
     * Método que permite saber se unha posición x,y é válida para un cadrado
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @return true se esa posición é válida, se non false
     */
    public boolean isValidPosition(int x, int y) {
        return !((x == MAX_X) || (x < 0) || (y == MAX_Y) || groundSquares.containsKey(String.valueOf(x) + "," + String.valueOf(y)));
    }

    /**
     * Saca unha peza da bolsa e a establece como peza actual do xogo, se a
     * bolsa esta vacia, xera unha nova
     */
    private void createNewPiece() {
        //Enchemos a bolsa se esta vacía 
        if (bagPieces.isEmpty()) {
            if (mainWindow.isExtendedGamemode()) {
                bagPieces = BagOfPieces.fillBagExtended(this);
            } else {
                bagPieces = BagOfPieces.fillBagClassic(this);
            }
        }

        if (nextPiece == null) {
            this.nextPiece = bagPieces.pop();
        }

        this.currentPiece = this.nextPiece;

        this.nextPiece = bagPieces.pop();

        for (Square sq : currentPiece.getSquares()) {
            sq.repaintOnMainWindow();
            mainWindow.drawSquare(sq.getLblSquare());
        }

        for (Square sq : nextPiece.getSquares()) {
            mainWindow.drawNextSquare(sq.getLblSquare());
        }
    }

    /**
     * Engade unha peza ao chan
     */
    private void addPieceToGround() {
        // Engadimos os cadrados da peza ao chan
        for (Square sq : currentPiece.getSquares()) {
            groundSquares.put(sq.getCoordinates(), sq);
        }
        // Chamamos ao método que borra as liñas do chan que estean completas
        this.deleteCompletedLines();
    }

    /**
     * Borra a peza gardada
     */
    public void deleteSavedPiece() {
        for (Square sq : savedPiece.getSquares()) {
            mainWindow.deleteSavedSquare(sq.getLblSquare());
        }
        savedPiece = null;
    }

    /**
     * Se os cadrados que están forman unha liña completa, bórranse eses
     * cadrados do chan e súmase unha nova liña no número de liñas realizadas
     */
    private void deleteCompletedLines() {
        boolean isEmpty;

        for (int i = 0; i < MAX_Y; i += SQUARE_SIDE) {
            isEmpty = false;
            for (int j = 0; j < MAX_X && !isEmpty; j += SQUARE_SIDE) {
                if (!groundSquares.containsKey(j + "," + i)) {
                    isEmpty = true;
                }
            }
            if (!isEmpty) {
                deleteLine(i);
                numberOfLines += 1;
                mainWindow.showNumberOfLines(numberOfLines);
            }

        }
    }

    /**
     * Borra todos os cadrados que se atopan na liña indicada pola coordenada y,
     * e baixa todos os cadrados que estean situados por enriba unha posición
     * cara abaixo
     *
     * @param y Coordenada y da liña a borrar
     */
    private void deleteLine(int y) {
        for (int i = 0; i < MAX_X; i += SQUARE_SIDE) {
            Square sq = groundSquares.get(i + "," + y);
            mainWindow.deleteSquare(sq.getLblSquare());
            groundSquares.remove(sq.getCoordinates());
        }

        for (int i = y; i >= 0; i -= SQUARE_SIDE) {
            for (int j = 0; j < MAX_X; j += SQUARE_SIDE) {
                if (groundSquares.containsKey(j + "," + i)) {

                    Square tempSq = groundSquares.get(j + "," + i);
                    Square sq = new Square(j, i + SQUARE_SIDE, tempSq.getFillColor(), this, tempSq.getNextX(), tempSq.getNextY());

                    groundSquares.put(j + "," + (i + SQUARE_SIDE), sq);
                    sq.repaintOnMainWindow();
                    mainWindow.drawSquare(sq.getLblSquare());

                    mainWindow.deleteSquare(tempSq.getLblSquare());
                    groundSquares.remove(j + "," + i);
                }
            }
        }
    }

    /**
     * Engade unha linea con cadrados aleatorios no chan, empurrando as demais
     * hacia arriba
     */
    public void addLine() {
        //Cantidade de cadrados que apareceran, de 3 a 11
        int numberOfSquares = new java.util.Random().nextInt(9) + 3;
        //Posibles posicions no eixo Y
        int[] positions = IntStream.rangeClosed(0, 11).toArray();
        //Para gardar temporalmente os cadrados creados
        ArrayList<Square> squares = new ArrayList<>();
        //Desordenamos as posicions
        Random r = new Random();
        for (int i = positions.length; i > 0; i--) {
            int posicion = r.nextInt(i);
            int tmp = positions[i - 1];
            positions[i - 1] = positions[posicion];
            positions[posicion] = tmp;
        }
        //Creamos os cadrados
        for (int i = 0; i < numberOfSquares; i++) {
            squares.add(new Square((positions[i] * SQUARE_SIDE), MAX_Y - SQUARE_SIDE, Color.GRAY,
                    this, 0, 0));
        }
        //Subimos as lineas existentes
        for (int i = SQUARE_SIDE; i < MAX_Y; i += SQUARE_SIDE) {
            for (int j = 0; j < MAX_X; j += SQUARE_SIDE) {
                if (groundSquares.containsKey(j + "," + i)) {

                    Square tempSq = groundSquares.get(j + "," + i);
                    Square sq = new Square(j, i - SQUARE_SIDE, tempSq.getFillColor(), this, tempSq.getNextX(), tempSq.getNextY());

                    groundSquares.put(j + "," + (i - SQUARE_SIDE), sq);
                    sq.repaintOnMainWindow();
                    mainWindow.drawSquare(sq.getLblSquare());

                    mainWindow.deleteSquare(tempSq.getLblSquare());
                    groundSquares.remove(j + "," + i);
                }
            }
        }
        //Agregamos a nova linea
        for (Square sq: squares){
            groundSquares.put(sq.getCoordinates(), sq);
            sq.repaintOnMainWindow();
            mainWindow.drawSquare(sq.getLblSquare());
        }
    }

    /**
     * Comproba se a peza actual choca cos cadrados do chan
     *
     * @return true se a peza actual choca cos cadrados do chan; se non false
     */
    private boolean hitPieceTheGround() {
        // 
        for (Square sq : currentPiece.getSquares()) {
            if (groundSquares.containsKey(sq.getCoordinates())) {
                return true;
            }
        }
        return false;
    }
}
