package unam.fi.computomovil.loteria.util;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by José Ángel García Salinas on 29/05/15.
 */
public class WinnerVerifier {

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman una diagonal derecha
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos forman una diagonal derecha
     */
    public boolean isDiagonalDerecha(ArrayList<Integer> selectedCards,int tamTablero){
        Integer[] tres=new Integer[]{2,4,6};
        Integer[] cuatro=new Integer[]{3,6,9,12};
        Integer[] cinco=new Integer[]{4,8,12,16,20};
        switch (tamTablero){
            case 3:
                if (selectedCards.contains(tres)){
                    return true;
                }else{
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatro)){
                    return true;
                }else{
                    return false;
                }
            case 5:
                if (selectedCards.contains(cinco)){
                    return true;
                }else{
                    return false;
                }
            default:
                Log.d("ERROR","Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman una diagonal izquierda
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos forman una diagonal izquierda
     */
    public boolean isDiagonalIzquierda(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tres = new Integer[]{0, 4, 8};
        Integer[] cuatro = new Integer[]{0, 5, 10, 15};
        Integer[] cinco = new Integer[]{0, 6, 12, 18, 24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tres)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatro)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cinco)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman una equis
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos forman una equis
     */
    public boolean isEquis(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tres = new Integer[]{0,2,4,6,8};
        Integer[] cuatro = new Integer[]{0,3,5,6,9,10,12,15};
        Integer[] cinco = new Integer[]{0,4,6,8,12,16,18,20,24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tres)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatro)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cinco)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman todas las esquinas estan seleccionadas
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos todas las esquinas seleccionadas
     */
    public boolean isEsquinas(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tres = new Integer[]{0,2,6,8};
        Integer[] cuatro = new Integer[]{0,3,12,15};
        Integer[] cinco = new Integer[]{0,4,20,24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tres)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatro)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cinco)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman una linea horizontal
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos forman una dlinea horizontal
     */
    public boolean isLineaHorizontal(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tresA = new Integer[]{0,1,2};
        Integer[] tresB = new Integer[]{3,4,5};
        Integer[] tresC = new Integer[]{6,7,8};
        Integer[] cuatroA = new Integer[]{0,1,2,3};
        Integer[] cuatroB = new Integer[]{4,5,6,7};
        Integer[] cuatroC = new Integer[]{8,9,10,11};
        Integer[] cuatroD = new Integer[]{12,13,14,15};
        Integer[] cincoA = new Integer[]{0,1,2,3,4};
        Integer[] cincoB = new Integer[]{5,6,7,8,9};
        Integer[] cincoC = new Integer[]{10,11,12,13,14};
        Integer[] cincoD = new Integer[]{15,16,17,18,19};
        Integer[] cincoE = new Integer[]{20,21,22,23,24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tresA)||selectedCards.contains(tresB)||selectedCards.contains(tresC)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatroA)||selectedCards.contains(cuatroB)||selectedCards.contains(cuatroC)||
                        selectedCards.contains(cuatroD)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cincoA)||selectedCards.contains(cincoB)||selectedCards.contains(cincoC)||
                        selectedCards.contains(cincoD)||selectedCards.contains(cincoE)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman una linea horizontal
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos forman una dlinea horizontal
     */
    public boolean isLineaVertical(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tresA = new Integer[]{0,3,6};
        Integer[] tresB = new Integer[]{1,4,7};
        Integer[] tresC = new Integer[]{2,5,8};
        Integer[] cuatroA = new Integer[]{0,4,8,12};
        Integer[] cuatroB = new Integer[]{1,5,9,13};
        Integer[] cuatroC = new Integer[]{2,6,10,14};
        Integer[] cuatroD = new Integer[]{3,7,11,15};
        Integer[] cincoA = new Integer[]{0,5,10,15,20};
        Integer[] cincoB = new Integer[]{1,6,11,16,21};
        Integer[] cincoC = new Integer[]{2,7,12,17,22};
        Integer[] cincoD = new Integer[]{3,8,13,18,23};
        Integer[] cincoE = new Integer[]{4,9,14,19,24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tresA)||selectedCards.contains(tresB)||selectedCards.contains(tresC)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatroA)||selectedCards.contains(cuatroB)||selectedCards.contains(cuatroC)||
                        selectedCards.contains(cuatroD)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cincoA)||selectedCards.contains(cincoB)||selectedCards.contains(cincoC)||
                        selectedCards.contains(cincoD)||selectedCards.contains(cincoE)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }

    /**
     * Método que verifica si el usuario tiene frijoles posicionados en el tablero de tal forma
     * que forman todas las cartas esten seleccionadas
     * @param selectedCards lista de cartas con frijol  EJ: [0,3,4,7,9,12,20,21] para matriz de 5x5
     * @param tamTablero identificador de el tamaño de tablero (3, 4, 5)
     * @return si los frijoles que tenemos todas las cartas seleccionadas
     */
    public boolean isClasico(ArrayList<Integer> selectedCards,int tamTablero) {
        Integer[] tres = new Integer[]{0,1,2,3,4,5,6,7,8};
        Integer[] cuatro = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Integer[] cinco = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        switch (tamTablero) {
            case 3:
                if (selectedCards.contains(tres)) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (selectedCards.contains(cuatro)) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (selectedCards.contains(cinco)) {
                    return true;
                } else {
                    return false;
                }
            default:
                Log.d("ERROR", "Tabero no definido");
                return false;

        }
    }
}
