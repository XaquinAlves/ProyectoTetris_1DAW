package teistris.model;

import teistris.model.clasicpieces.TPiece;
import teistris.model.clasicpieces.LPiece;
import teistris.model.clasicpieces.SquarePiece;
import teistris.model.clasicpieces.ZPiece;
import teistris.model.clasicpieces.BarPiece;
import teistris.model.clasicpieces.ZInvertedPiece;
import teistris.model.clasicpieces.LInvertedPiece;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;
import teistris.model.extendedpieces.BigLInvertedPiece;
import teistris.model.extendedpieces.BigLPiece;
import teistris.model.extendedpieces.BridgePiece;
import teistris.model.extendedpieces.CrossPiece;
//TODO: fillBagExtended

/**
 * Esta clase xenera unha pila con X pezas aleatorias sen repeticion
 *
 * @author Xaquin Alves Gonzalez
 */
public class BagOfPieces {

    /**
     * Obten unha pila de pezas aleatorias sen repeticion
     *
     * @param game referencia a partida actual
     * @return pila de pezas
     */
    public static Stack<Piece> fillBagClassic(Game game) {
        int[] piecesIds = generateBag(7);
        Stack<Piece> pieces = new Stack<>();

        for (int i = 0; i < piecesIds.length; i++) {
            switch (piecesIds[i]) {
                case 0:
                    pieces.add(new SquarePiece(game));
                    break;
                case 1:
                    pieces.add(new BarPiece(game));
                    break;
                case 2:
                    pieces.add(new LPiece(game));
                    break;
                case 3:
                    pieces.add(new TPiece(game));
                    break;
                case 4:
                    pieces.add(new LInvertedPiece(game));
                    break;
                case 5:
                    pieces.add(new ZPiece(game));
                    break;
                case 6:
                    pieces.add(new ZInvertedPiece(game));
            }
        }

        return pieces;
    }

    /**
     * Obten unha pila de pezas aleatorias sen repeticion
     *
     * @param game referencia a partida actual
     * @return pila de pezas
     */
    public static Stack<Piece> fillBagExtended(Game game) {
        int[] piecesIds = generateBag(11);
        Stack<Piece> pieces = new Stack<>();

        for (int i = 0; i < piecesIds.length; i++) {
            switch (piecesIds[i]) {
                case 0:
                    pieces.add(new SquarePiece(game));
                    break;
                case 1:
                    pieces.add(new BarPiece(game));
                    break;
                case 2:
                    pieces.add(new LPiece(game));
                    break;
                case 3:
                    pieces.add(new TPiece(game));
                    break;
                case 4:
                    pieces.add(new LInvertedPiece(game));
                    break;
                case 5:
                    pieces.add(new ZPiece(game));
                    break;
                case 6:
                    pieces.add(new ZInvertedPiece(game));
                    break;
                case 7:
                    pieces.add(new CrossPiece(game));
                    break;
                case 8:
                    pieces.add(new BigLPiece(game));
                    break;
                case 9:
                    pieces.add(new BigLInvertedPiece(game));
                    break;
                case 10:
                    pieces.add(new BridgePiece(game));
                    break;
            }
        }

        return pieces;
    }

    /**
     * Xera un array de enteiros e desordenaos, usado no metodo fillBag
     *
     * @param numberOfPieces cantidade de enteiros( xerase de 0 a este)
     * @return lista de enteiros desordenada
     */
    private static int[] generateBag(int numberOfPieces) {
        int[] pieces = IntStream.rangeClosed(0, numberOfPieces).toArray();
        //desordenando los elementos
        Random r = new Random();
        for (int i = pieces.length; i > 0; i--) {
            int posicion = r.nextInt(i);
            int tmp = pieces[i - 1];
            pieces[i - 1] = pieces[posicion];
            pieces[posicion] = tmp;
        }

        return pieces;
    }

}
