/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teistris;

import java.awt.Color;

/**
 *
 * @author Mateo
 */
public class LPiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game
     */
    public LPiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE - Game.SQUARE_SIDE, Color.GREEN, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.GREEN, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2, Color.GREEN, game),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 2, Color.GREEN, game)
        };

    }

    @Override
    public boolean rotate() {

        if (position == 0) {
            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX(), squares[3].getY() - Game.SQUARE_SIDE * 2)) {

                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX());

                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);

                position = 1;

                return true;
            }

        } else if (position == 1) {

            if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE * 2, squares[3].getY())) {

                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE * 2);

                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY());

                position = 2;

                return true;
            }
        } else if (position
                == 2) {

            if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX(), squares[3].getY() + Game.SQUARE_SIDE * 2)) {

                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX());

                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE * 2);

                position = 3;

                return true;
            }
        } else if (position
                == 3) {
            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2, squares[3].getY())) {

                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);

                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY());

                position = 0;

                return true;
            }
        }
        return false;
    }

}
