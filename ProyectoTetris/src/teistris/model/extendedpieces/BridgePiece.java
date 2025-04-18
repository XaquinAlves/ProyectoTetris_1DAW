package teistris.model.extendedpieces;

import java.awt.Color;
import teistris.model.Game;
import teistris.model.Piece;
import teistris.model.Square;

public class BridgePiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game referencia ao xogo actual
     */
    public BridgePiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.MAGENTA, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2, 0, Color.MAGENTA, game, Game.SQUARE_SIDE,
                       Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2, 2 * Game.SQUARE_SIDE, Color.MAGENTA, game,
                       Game.SQUARE_SIDE * 3, Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2 + Game.SQUARE_SIDE, 0, Color.MAGENTA, game,
                       Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2),
            new Square(Game.MAX_X / 2 + Game.SQUARE_SIDE, 2 * Game.SQUARE_SIDE,
                       Color.MAGENTA, game, Game.SQUARE_SIDE * 3, Game.SQUARE_SIDE * 2)
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
        return switch (position) {
            case 0 -> {
                if (game.isValidPosition(squares[1].getX() - Game.SQUARE_SIDE, squares[1].
                                         getY() + Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                             squares[2].getY() - Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX() - 2 * Game.SQUARE_SIDE,
                                                 squares[3].getY())) {
                            if (game.isValidPosition(squares[4].getX(),
                                                     squares[4].getY() - 2 *
                                                     Game.SQUARE_SIDE)) {

                                squares[1].setX(squares[1].getX() - Game.SQUARE_SIDE);
                                squares[1].setY(squares[1].getY() + Game.SQUARE_SIDE);

                                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);

                                squares[3].setX(squares[3].getX() - 2 * Game.SQUARE_SIDE);

                                squares[4].setY(squares[4].getY() - 2 * Game.SQUARE_SIDE);

                                position = 1;

                                yield true;
                            }
                        }
                    }
                }
                yield false;
            }
            case 1 -> {
                if (game.isValidPosition(squares[1].getX() + Game.SQUARE_SIDE, squares[1].
                                         getY() + Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                             squares[2].getY() - Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX(), squares[3].getY() +
                                                 2 * Game.SQUARE_SIDE)) {
                            if (game.isValidPosition(squares[4].getX() - 2 *
                                    Game.SQUARE_SIDE, squares[4].getY())) {

                                squares[1].setX(squares[1].getX() + Game.SQUARE_SIDE);
                                squares[1].setY(squares[1].getY() + Game.SQUARE_SIDE);

                                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);

                                squares[3].setY(squares[3].getY() + 2 * Game.SQUARE_SIDE);

                                squares[4].setX(squares[4].getX() - 2 * Game.SQUARE_SIDE);
                                position = 2;

                                yield true;
                            }
                        }
                    }
                }
                yield false;
            }
            case 2 -> {
                if (game.isValidPosition(squares[1].getX() + Game.SQUARE_SIDE, squares[1].
                                         getY() - Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE,
                                             squares[2].getY() + Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX() + 2 * Game.SQUARE_SIDE,
                                                 squares[3].getY())) {
                            if (game.isValidPosition(squares[4].getX(),
                                                     squares[4].getY() + 2 *
                                                     Game.SQUARE_SIDE)) {

                                squares[1].setX(squares[1].getX() + Game.SQUARE_SIDE);
                                squares[1].setY(squares[1].getY() - Game.SQUARE_SIDE);

                                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);

                                squares[3].setX(squares[3].getX() + 2 * Game.SQUARE_SIDE);

                                squares[4].setY(squares[4].getY() + 2 * Game.SQUARE_SIDE);

                                position = 3;

                                yield true;
                            }
                        }
                    }
                }
                yield false;
            }
            default -> {
                if (game.isValidPosition(squares[1].getX() - Game.SQUARE_SIDE, squares[1].
                                         getY() - Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE,
                                             squares[2].getY() + Game.SQUARE_SIDE)) {
                        if (game.isValidPosition(squares[3].getX(), squares[3].getY() -
                                                 2 * Game.SQUARE_SIDE)) {
                            if (game.isValidPosition(squares[4].getX() + 2 *
                                    Game.SQUARE_SIDE, squares[4].getY())) {
                                squares[1].setX(squares[1].getX() - Game.SQUARE_SIDE);
                                squares[1].setY(squares[1].getY() - Game.SQUARE_SIDE);

                                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);

                                squares[3].setY(squares[3].getY() - 2 * Game.SQUARE_SIDE);

                                squares[4].setX(squares[4].getX() + 2 * Game.SQUARE_SIDE);

                                position = 0;

                                yield true;
                            }
                        }
                    }
                }
                yield false;
            }
        };

    }
}
