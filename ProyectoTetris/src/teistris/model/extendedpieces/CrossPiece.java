package teistris.model.extendedpieces;

import  teistris.model.Game;
import teistris.model.Piece;


public class CrossPiece extends Piece{

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game referencia ao xogo actual
     */
    public CrossPiece(Game game) {
        this.game = game;

        /*        squares = new Square[]{
        new Square(Game.MAX_X / 2, 0, Color.YELLOW, game),
        new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.YELLOW, game),
        new Square(Game.MAX_X / 2, 2*Game.SQUARE_SIDE,
        Color.YELLOW, game),
        new Square(Game.MAX_X / 2 + Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.YELLOW, game),
        new Square(Game.MAX_X/2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE, Color.YELLOW, game)
        };*/

    }
    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    @Override
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }
}
