package teistris.model.clasicpieces;

import java.awt.Color;
import teistris.model.Game;
import teistris.model.Piece;
import teistris.model.Square;

/**
 * Representa a peza L Invertida
 *
 * @author Xaquin Alves
 */
public class LInvertedPiece extends Piece {

    public LInvertedPiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2, 0, Color.ORANGE, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 2),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.ORANGE, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, Color.ORANGE, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 4),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE,
                       Color.ORANGE, game, Game.SQUARE_SIDE, Game.SQUARE_SIDE * 4)
        };

        position = 0;

    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    @Override
    public boolean rotate() {
        switch (position) {
            case 0:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].
                                         getY() + Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                             squares[2].getY() - Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX() + 2 * Game.SQUARE_SIDE,
                                                 squares[3].getY())) {

                            squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                            squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);

                            squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                            squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);

                            squares[3].setX(squares[3].getX() + 2 * Game.SQUARE_SIDE);

                            position = 1;

                            return true;
                        }
                    }
                }
                return false;
            case 1:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].
                                         getY() + Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                             squares[2].getY() - Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX(), squares[3].getY() -
                                                 2 * Game.SQUARE_SIDE)) {

                            squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                            squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);

                            squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                            squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);

                            squares[3].setY(squares[3].getY() - 2 * Game.SQUARE_SIDE);

                            position = 2;

                            return true;
                        }
                    }
                }
                return false;
            case 2:
                if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].
                                         getY() - Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                             squares[2].getY() + Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX() - 2 * Game.SQUARE_SIDE,
                                                 squares[3].getY())) {

                            squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                            squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);

                            squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                            squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);

                            squares[3].setX(squares[3].getX() - 2 * Game.SQUARE_SIDE);

                            position = 3;

                            return true;
                        }
                    }
                }
                return false;
            default:
                if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].
                                         getY() - Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                             squares[2].getY() + Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX(), squares[3].getY() +
                                                 2 * Game.SQUARE_SIDE)) {

                            squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                            squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);

                            squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                            squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);

                            squares[3].setY(squares[3].getY() + 2 * Game.SQUARE_SIDE);

                            position = 0;

                            return true;
                        }
                    }
                }
                return false;
        }

    }
}
