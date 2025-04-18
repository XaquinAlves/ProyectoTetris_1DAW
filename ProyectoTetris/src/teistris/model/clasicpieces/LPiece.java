package teistris.model.clasicpieces;

import java.awt.Color;
import teistris.model.Game;
import teistris.model.Piece;
import teistris.model.Square;

/**
 * Clase para a peza en L
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
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.GREEN, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 2),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                       Color.GREEN, game, Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2,
                       Color.GREEN, game, Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 4),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE * 2, Color.GREEN, game,
                       Game.SQUARE_SIDE * 3, Game.SQUARE_SIDE * 4)
        };

    }

    /**
     * Método para rotar a peza. Cambia a posición dos cadrados que a compoñen segundo a
     * posición actual
     *
     * @return
     */
    @Override
    public boolean rotate() {

        switch (position) {
            case 0:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].
                                         getY() + Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                              squares[2].getY() - Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[3].getX(), squares[3].getY() -
                                              Game.SQUARE_SIDE * 2)) {

                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX());

                    squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);

                    position = 1;

                    return true;
                }
            case 1:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].
                                         getY() + Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                              squares[2].getY() - Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE * 2,
                                              squares[3].getY())) {

                    squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE * 2);

                    squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY());

                    position = 2;

                    return true;
                }
            case 2:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].
                                         getY() - Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                              squares[2].getY() + Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[3].getX(), squares[3].getY() +
                                              Game.SQUARE_SIDE * 2)) {

                    squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX());

                    squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE * 2);

                    position = 3;

                    return true;
                }
            case 3:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].
                                         getY() - Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                              squares[2].getY() + Game.SQUARE_SIDE) &&
                         game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2,
                                              squares[3].getY())) {

                    squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                    squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                    squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);

                    squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                    squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                    squares[3].setY(squares[3].getY());

                    position = 0;

                    return true;
                }
            default:
                return false;
        }
    }

}
