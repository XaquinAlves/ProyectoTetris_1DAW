
package teistris.view;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * @author xaquin.alvesgonzalez
 */
public class KeyDispatcher implements KeyEventDispatcher{
    @Override
    public boolean dispatchKeyEvent(KeyEvent e){
        if(e.getID() == KeyEvent.KEY_TYPED){
            System.out.println("tecla pulsada");
        }
        
        return false;
        
    }
}
