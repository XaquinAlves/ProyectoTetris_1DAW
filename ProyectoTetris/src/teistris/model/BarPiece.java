package teistris.model;

import java.awt.Color;

/**
 *Clase para a peza de barra
 * @author Mateo
 */
public class BarPiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game
     */
    public BarPiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.YELLOW, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.YELLOW, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2, Color.YELLOW, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE * 3, Color.YELLOW, game)
        };

    }
    
    /**
     * Método para rotar a peza. Cambia a posición dos cadrados que a compoñen segundo a posición actual
     * @return 
     */
    @Override
    public boolean rotate() {

        if (position == 0) {
            if (game.isValidPosition(squares[0].getX() - Game.SQUARE_SIDE, squares[0].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() + Game.SQUARE_SIDE, squares[2].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() + Game.SQUARE_SIDE * 2, squares[3].getY() - Game.SQUARE_SIDE * 2)) {

                squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() + Game.SQUARE_SIDE * 2);

                squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);

                position = 1;
                return true;
            }
        } else {
            if (game.isValidPosition(squares[0].getX() + Game.SQUARE_SIDE, squares[0].getY() - Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[2].getX() - Game.SQUARE_SIDE, squares[2].getY() + Game.SQUARE_SIDE)
                    && game.isValidPosition(squares[3].getX() - Game.SQUARE_SIDE * 2, squares[3].getY() + Game.SQUARE_SIDE * 2)) {
                squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
                squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
                squares[3].setX(squares[3].getX() - Game.SQUARE_SIDE * 2);

                squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
                squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
                squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE * 2);

                position = 0;
                return true;
            }
        }
        return false;
    }
}
