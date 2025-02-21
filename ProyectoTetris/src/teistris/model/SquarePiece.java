
package teistris.model;


import java.awt.Color;

/**
 * Clase para a peza cadrada
 *
 * @author Mateo
 */
public class SquarePiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     */
    public SquarePiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game),
            new Square(Game.MAX_X / 2, 0, Color.BLUE, game),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.BLUE, game),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game)
        };
    }

    /**
     * A rotación da ficha cadrada non supón ningunha variación na ficha, por
     * iso simplemente devolvemos true
     *
     * @return
     */
    @Override
    public boolean rotate() {

        return true;
    }
}
