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
package teistris;

import java.awt.Color;
import javax.swing.text.Position;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 * @author Mateo Alfaya & Xaquin Alves
 */
public abstract class Piece {

    
    protected int position=0;
    /**
     * Referenza ao obxecto xogo
     */
    protected Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    protected Square squares[];

    /**
     *
     * @return referencia a game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game Establecer partida
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return array de cadrados
     */
    public Square[] getSquares() {
        return squares;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {

        for (Square sq : squares) {

            if (!game.isValidPosition(sq.getX() + Game.SQUARE_SIDE, sq.getY())) {
                return false;
            }

        }
        for (Square sq : squares) {

            sq.setX(sq.getX() + Game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {

        for (Square sq : squares) {

            if (!game.isValidPosition(sq.getX() - Game.SQUARE_SIDE, sq.getY())) {
                return false;
            }

        }
        for (Square sq : squares) {

            sq.setX(sq.getX() - Game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {

        for (Square sq : squares) {

            if (!game.isValidPosition(sq.getX(), sq.getY() + Game.SQUARE_SIDE)) {
                return false;
            }

        }
        for (Square sq : squares) {

            sq.setY(sq.getY() + Game.SQUARE_SIDE);
        }

        return true;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public abstract boolean rotate();
}
