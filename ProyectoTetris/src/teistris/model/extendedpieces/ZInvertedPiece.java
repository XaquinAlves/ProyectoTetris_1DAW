package model.Pieces;

import model.Game;
import model.Square;

import java.awt.Color;

/**
 *
 * @author Xaquin Alves Gonzalez
 */
public class ZInvertedPiece extends Piece {
    
    private int position;
    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game referencia ao xogo actual
     */
    public ZInvertedPiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2 + Game.SQUARE_SIDE, 0, Color.GREEN, game),
            new Square(Game.MAX_X / 2, 0, Color.GREEN, game),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.GREEN, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.GREEN, game)
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
        if (position == 0) {
            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)) {
                if (game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[3].getX() , squares[3].getY()- 2 * Game.SQUARE_SIDE)){
                       
                        squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                        squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);

                        squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                        squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);

                        squares[3].setY(squares[3].getY() - 2 * Game.SQUARE_SIDE);

                        position = 1;

                        return true;
                    }
                }
            }
        } else {
            if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)) {
                if (game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)) {
                    if (game.isValidPosition(squares[3].getX() , squares[3].getY()+ 2 * Game.SQUARE_SIDE)) {

                        squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                        squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);

                        squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                        squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);

                        squares[3].setY(squares[3].getY() + 2 * Game.SQUARE_SIDE);

                        position = 0;

                        return true;
                    }
                }
            }
        }
        return false;

    }
}
