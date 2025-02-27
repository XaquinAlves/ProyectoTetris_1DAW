package teistris.view;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import teistris.model.Game;

/**
 * Esta clase permite capturar pulsacions de teclas sen problemas de foco
 *
 * @author Xaquin Alves & Mateo Alfaya
 */
public class KeyDispatcher implements KeyEventDispatcher {

    private Game game; // referencia á partida

    /**
     *
     * @return referecia a partida actuual
     */
    public Game getGame() {
        return game;
    }

    /**
     * Establece a partida actual
     *
     * @param game partida actual
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Move as pezas en funcion das teclas pulsadas
     *
     * @param e
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (game != null && (e.getID() == KeyEvent.KEY_PRESSED)) {
            if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP) {
                game.rotatePiece();
            }
            else if (e.getKeyChar() == 'a' || e.getKeyCode() == KeyEvent.VK_LEFT) {
                game.movePieceLeft();
            }
            else if (e.getKeyChar() == 'd' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
                game.movePieceRight();
            }
            else if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN) {
                game.movePieceDown();
            }
            else if (e.getKeyChar() == 'c' || e.getKeyChar() == 'g') {
                game.savePiece();
            }

        }

        return false;

    }
}
