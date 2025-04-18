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
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;

/**
 * Clase que implementa un cadrado do xogo do Tetris
 *
 * @author Profe de Programación
 * @author Mateo Alfaya & Xaquin Alves
 */
public class Square {

    /**
     * Coordenadas do cadrado no panel do xogo
     */
    private int x, y;
    /**
     * Cordenadas do cadrado no panel lateral
     */
    private int nextX, nextY;
    /**
     *
     */
    private final int initialX, initialY;
    /**
     * Etiqueta que mostra o cadrado no panel
     */
    private JLabel lblSquare;
    /**
     * Referenza á cor do cadrado
     */
    private Color fillColor;

    /**
     * @return Coordenada x do cadrado
     */
    public int getX() {
        return x;
    }

    /**
     * Establece a coordenada x do cadrado
     *
     * @param x Coordenada x do cadrado
     */
    public void setX(int x) {
        this.x = x;
        // Establecemos a nova localización da etiqueta e repintámola
        lblSquare.setBounds(x, y, Game.SQUARE_SIDE, Game.SQUARE_SIDE);
        lblSquare.repaint();
    }

    /**
     * @return Coordenada y do cadrado
     */
    public int getY() {
        return y;
    }

    /**
     * Establece a coordenada y do cadrado
     *
     * @param y Coordenada y do cadrado
     */
    public void setY(int y) {
        this.y = y;
        // Establecemos a nova localización da etiqueta e repintámola
        lblSquare.setBounds(x, y, Game.SQUARE_SIDE, Game.SQUARE_SIDE);
        lblSquare.repaint();
    }

    /**
     * Obten a cordenada X do cadrado para os paneis laterais
     *
     * @return cordenada x nos paneis laterais
     */
    public int getNextX() {
        return nextX;
    }

    /**
     * Establece a cordenada x para o cadrado nos paneis laterais
     *
     * @param nextX cordenada x nos paneis laterais
     */
    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    /**
     * Obten a cordenada Y do cadrado para os paneis laterais
     *
     * @return cordenada y nos paneis laterais
     */
    public int getNextY() {
        return nextY;
    }

    /**
     * Establece a cordenada y para o cadrado nos paneis laterais
     *
     * @param nextY cordenada y nos paneis laterais
     */
    public void setNextY(int nextY) {
        this.nextY = nextY;
    }

    /**
     * Pinta o cadrado na ventana principal
     */
    public void repaintOnMainWindow() {
        lblSquare.setBounds(x, y, Game.SQUARE_SIDE, Game.SQUARE_SIDE);
        lblSquare.repaint();
    }

    /**
     * Pinta o cadrado no panel lateral de gardado
     */
    public void repaintOnSaved() {
        lblSquare.setBounds(nextX, nextY, Game.SQUARE_SIDE, Game.SQUARE_SIDE);
        lblSquare.repaint();
    }

    /**
     * Obtén a representación das coordenadas x, y do cadrado en forma de String
     *
     * @return O string que representa as coordenadas x,y do cadrado
     */
    public String getCoordinates() {
        return String.valueOf(x) + "," + String.valueOf(y);
    }

    /**
     * Obtén a referenza á etiqueta que representa graficamente o cadrado
     *
     * @return Referenza á etiqueta do cadrado
     */
    public JLabel getLblSquare() {
        return lblSquare;
    }

    /**
     * @return Cor de recheo do cadrado
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Establece a cor do cadrado
     *
     * @param fillColor Cor do recheo para establecer ao cadrado
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        // Establecemos a cor de fondo para a etiqueta e repintámola
        lblSquare.setBackground(fillColor);
        lblSquare.repaint();
    }

    /**
     * Construtor da clase que crea un cadrado establecendo as súas coordenadas, cor e
     * referenza ao xogo
     *
     * @param x Coordenada x
     * @param y Coordenada y
     * @param fillColor Referenza á cor do cadrado
     * @param game Referenza ao obxecto xogo
     * @param nextX cordenada x no panel seguinte ou gardado
     * @param nextY cordenada y no panel seguinte ou gardado
     */
    public Square(int x, int y, Color fillColor, Game game, int nextX, int nextY) {
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
        this.nextX = nextX;
        this.nextY = nextY;
        this.initialX = x;
        this.initialY = y;

        // Creamos a etiqueta e establecemos a cor de fondo, coordenadas, 
        // e atributos para que se vexa no panel do xogo
        lblSquare = new JLabel();
        lblSquare.setBackground(fillColor);
        lblSquare.setBounds(nextX, nextY, Game.SQUARE_SIDE, Game.SQUARE_SIDE);
        lblSquare.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        lblSquare.setVisible(true);
        lblSquare.setOpaque(true);

        // Chamamos á ventá principal do xogo para pintar o cadrado no panel
        //game.getMainWindow().drawSquare(this.lblSquare);
    }

    /**
     * Borra o cadrado do panel de xogo(visiblemente, non fisicamente)
     */
    public void hide() {
        lblSquare.setVisible(false);
    }

    /**
     * Pinta o cadrado no panel de xogo
     */
    public void show() {
        lblSquare.setVisible(true);
    }

    /**
     * Resetea o cadrado a posicion inicial
     */
    public void resetPosition() {
        this.x = initialX;
        this.y = initialY;
    }
}
