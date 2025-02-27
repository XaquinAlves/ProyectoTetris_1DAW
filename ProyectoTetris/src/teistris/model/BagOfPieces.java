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
import teistris.model.extendedpieces.DotSquareInvertedPiece;
import teistris.model.extendedpieces.DotSquarePiece;
import teistris.model.extendedpieces.FInvertedPiece;
import teistris.model.extendedpieces.FPiece;

/**
 * Esta clase xenera unha pila con X pezas aleatorias sen repeticion
 *
 * @author Xaquin Alves Gonzalez
 */
public class BagOfPieces {

    /**
     * Obten unha pila de pezas aleatorias sen repeticion, coas pezas do tetris clásico
     *
     * @param game referencia a partida actual
     * @return pila de pezas
     */
    public static Stack<Piece> fillBagClassic(Game game) {
        int[] piecesIds = generateBag(7);
        Stack<Piece> pieces = new Stack<>();

        for (int i = 0; i < piecesIds.length; i++) {
            switch (piecesIds[i]) {
                case 0 ->
                    pieces.add(new SquarePiece(game));
                case 1 ->
                    pieces.add(new BarPiece(game));
                case 2 ->
                    pieces.add(new LPiece(game));
                case 3 ->
                    pieces.add(new TPiece(game));
                case 4 ->
                    pieces.add(new LInvertedPiece(game));
                case 5 ->
                    pieces.add(new ZPiece(game));
                case 6 ->
                    pieces.add(new ZInvertedPiece(game));
            }
        }

        return pieces;
    }

    /**
     * Obten unha pila de pezas aleatorias sen repeticion, con pezas extra respecto ao
     * tetris orixinal
     *
     * @param game referencia a partida actual
     * @return pila de pezas
     */
    public static Stack<Piece> fillBagExtended(Game game) {
        int[] piecesIds = generateBag(15);
        Stack<Piece> pieces = new Stack<>();

        for (int i = 0; i < piecesIds.length; i++) {
            switch (piecesIds[i]) {
                case 0 ->
                    pieces.add(new SquarePiece(game));
                case 1 ->
                    pieces.add(new BarPiece(game));
                case 2 ->
                    pieces.add(new LPiece(game));
                case 3 ->
                    pieces.add(new TPiece(game));
                case 4 ->
                    pieces.add(new LInvertedPiece(game));
                case 5 ->
                    pieces.add(new ZPiece(game));
                case 6 ->
                    pieces.add(new ZInvertedPiece(game));
                case 7 ->
                    pieces.add(new CrossPiece(game));
                case 8 ->
                    pieces.add(new BigLPiece(game));
                case 9 ->
                    pieces.add(new BigLInvertedPiece(game));
                case 10 ->
                    pieces.add(new BridgePiece(game));
                case 11 ->
                    pieces.add(new DotSquareInvertedPiece(game));
                case 12 ->
                    pieces.add(new DotSquarePiece(game));
                case 13 ->
                    pieces.add(new FPiece(game));
                case 14 ->
                    pieces.add(new FInvertedPiece(game));
            }
        }

        return pieces;
    }

    /**
     * Xera un array de enteiros e desordenaos, usado nos metodos fillBag
     *
     * @param numberOfPieces cantidade de enteiros( xerase de 0 a este)
     * @return lista de enteiros desordenada
     */
    private static int[] generateBag(int numberOfPieces) {
        int[] pieces = IntStream.rangeClosed(0,
                                             numberOfPieces).toArray();
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
