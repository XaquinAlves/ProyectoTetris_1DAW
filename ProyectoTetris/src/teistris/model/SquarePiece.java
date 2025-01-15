/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teistris.model;

import teistris.model.Piece;
import teistris.model.Square;
import teistris.model.Game;
import java.awt.Color;

/**
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

    @Override
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }
}
