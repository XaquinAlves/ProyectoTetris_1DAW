package teistris.model;

import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Esta clase xenera unha pila con X pezas aleatorias sen repeticion
 *
 * @author Xaquin Alves Gonzalez
 */
public class BagOfPieces {

    /**
     * Obten unha pila de pezas aleatorias sen repeticion
     *
     * @param numberOfPieces numeros de pezas distintas
     * @param game referencia a partida actual
     * @return pila de pezas
     */
    public static Stack<Piece> fillBag(int numberOfPieces, Game game) {
        int[] piecesIds = generateBag(numberOfPieces);
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
