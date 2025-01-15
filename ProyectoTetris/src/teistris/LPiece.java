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
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        for (Square sq : squares) {

            if (!game.isValidPosition(sq.getX() - Game.SQUARE_SIDE, sq.getY())) {
                return false;
            }

        }
        if (position == 0) {
            squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
            squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX());

            squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
            squares[3].setY(squares[3].getY() - Game.SQUARE_SIDE * 2);
            
            position = 1;
            
        } else if (position == 1) {
            squares[0].setX(squares[0].getX() + Game.SQUARE_SIDE);
            squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX()-Game.SQUARE_SIDE*2);

            squares[0].setY(squares[0].getY() + Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() - Game.SQUARE_SIDE);
            squares[3].setY(squares[3].getY());
            
            position = 2;
            
        } else if (position == 2) {
            squares[0].setX(squares[0].getX()+Game.SQUARE_SIDE);
            squares[2].setX(squares[2].getX() - Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX());

            squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
            squares[3].setY(squares[3].getY() + Game.SQUARE_SIDE * 2);
            
            position = 3;
            
        } else if (position == 3) {
            squares[0].setX(squares[0].getX() - Game.SQUARE_SIDE);
            squares[2].setX(squares[2].getX() + Game.SQUARE_SIDE);
            squares[3].setX(squares[3].getX()+ Game.SQUARE_SIDE*2);

            squares[0].setY(squares[0].getY() - Game.SQUARE_SIDE);
            squares[2].setY(squares[2].getY() + Game.SQUARE_SIDE);
            squares[3].setY(squares[3].getY());
            
            position = 0;
        }
        return true;
    }

}
