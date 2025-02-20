
package teistris.view;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import teistris.model.Game;

/**
 *
 * @author xaquin.alvesgonzalez
 */
public class KeyDispatcher implements KeyEventDispatcher{
    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent e){
        if( game != null  && (e.getID() == KeyEvent.KEY_PRESSED)){
            if(e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP){
                game.rotatePiece();
            }else if(e.getKeyChar()  == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT  ){
                game.movePieceLeft();
            }else if(e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT){
                game.movePieceRight();
            }else if(e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN){
                game.movePieceDown();
            }
      
        }
        
        return false;
        
    }
}
