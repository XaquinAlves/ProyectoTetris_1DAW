package teistris.model.clasicpieces;

import java.awt.Color;
import teistris.model.Game;
import teistris.model.Piece;
import teistris.model.Square;

/**
 * Clase para a peza cadrada
 *
 * @author Mateo
 */
public class SquarePiece extends Piece {

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game referencia a partida actual
     */
    public SquarePiece(Game game) {
        this.game = game;

        squares = new Square[]{
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game,
                       Game.SQUARE_SIDE, Game.SQUARE_SIDE * 2),
            new Square(Game.MAX_X / 2, 0, Color.BLUE, game, Game.SQUARE_SIDE * 2,
                       Game.SQUARE_SIDE * 2),
            new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,
                       Color.BLUE, game, Game.SQUARE_SIDE, Game.SQUARE_SIDE * 3),
            new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game,
                       Game.SQUARE_SIDE * 2, Game.SQUARE_SIDE * 3)
        };
    }

    /**
     * A rotación da ficha cadrada non supón ningunha variación na ficha, por iso
     * simplemente devolvemos true
     *
     * @return
     */
    @Override
    public boolean rotate() {

        return true;
    }
}
