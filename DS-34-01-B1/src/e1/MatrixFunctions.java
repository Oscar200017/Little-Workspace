package e1;

import java.util.*;

public class MatrixFunctions {

    public static int matriz[][] = {{2, 3, 4, 5},
    {15, 16, 1, 6},
    {10, 11, 7, 12},
    {14, 9, 8, 13}};

//devuelve el numero de elementos de la fila mas grande o lo que es lo mismo el numero de columnas
    private static int elementosFila(int[][] a) {
        int filaMax = 0;
        int fila = 0;
        for (int i = 0; i < a.length; i++) {
            fila = a[i].length;
            if (fila > filaMax) {
                filaMax = fila;
            }

        }
        return filaMax;
    }

    //devuelve un array con el numero de elementos de cada fila
    private static int[] numeroElementosPorFila(int[][] a) {
        int[] numeros = new int[a.length];
        int cont;
        for (int i = 0; i < a.length; i++) {
            cont = 0;
            for (int j = 0; j <= a[i].length; j++) {
                cont = j;
            }
            numeros[i] = cont;

        }

        return numeros;
    }

    // devuelve el numero de filas
    private static int numeroFilas(int[][] a) {
        int num = a.length;
        return num;
    }
// devuelve los elementos de la primera diagonal en un array

    private static int[] elementosDiagonalPrimera(int[][] a) {
        int[] elementos = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            elementos[i] = a[i][i];

        }

        return elementos;
    }

    // devuelve los elementos de la segunda diagonal en un array
    private static int[] elementosDiagonalSegunda(int[][] a) {
        int[] elementos = new int[a.length];
        int cont = a.length - 1;
        for (int i = 0; i < a.length; i++) {

            elementos[i] = a[i][cont];
            cont--;
        }
        return elementos;
    }

    private static int sumaElementosArray(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];

        }

        return suma;
    }

    private static int sumaFilas(int[][] a) {
        int suma = 0;

        return suma;
    }

    //devuelve un array con los elementos de la matriz
    private static int[] elementosMatriz(int[][] a) {
        int orden = 0;
        int enesimo = 0;
        int[] elementos;
        int columna = 0;
        int fila = 0;

        orden = elementosFila(a);
        enesimo = orden * orden;
        elementos = new int[enesimo];

        for (int i = 0; i < enesimo; i++) {

            elementos[i] = a[fila][columna];
            columna++;
            if (columna == a.length) {
                columna = 0;
                fila++;
            }
        }

        return elementos;
    }

    //  Returns  the  maximun  value  of a matrix
    public static int max(int[][] a) {
        int maxi = a[0][0];
        for (int i = 0; i <= a.length - 1; i++) {
            for (int o = 0; o <= a[i].length - 1; o++) {
                if (maxi <= a[i][o]) {
                    maxi = a[i][o];
                }
            }
        }
        return maxi;
    }

//  Returns  the  sum of the  values  of a given  row
    public static int rowSum(int[][] a, int row) {
        int suma = 0;

        for (int i = 0; i <= a[row].length - 1; i++) {
            suma = suma + a[row][i];
        }

        return suma;
    }

//  Returns  the  sum of the  values  of a given  column
    public static int columnSum(int[][] a, int column) {

        int suma = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            try {
                suma = suma + a[i][column];
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        return suma;
    }

// Sums  the  value  of each  row and  returns  the  results  in an array.
    public static int[] allRowSums(int[][] a) {
        int suma = 0;
        int[] array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            suma = rowSum(a, i);
            array[i] = suma;
        }
        return array;
    }

// Sums  the  value  of each  column  and  returns  the  results  in an  array.
// If a position  does  not  exist  because  the  array  is "ragged" that  position
// is  considered a zero  value.
    public static int[] allColumnSums(int[][] a) {
        int suma = 0;
        int[] array = new int[elementosFila(a)];

        for (int i = 0; i < elementosFila(a); i++) {
            suma = columnSum(a, i);
            array[i] = suma;
        }

        return array;
    }

//  Checks  if an  array  is "row -magic", that is, if all  its  rows  have  the  same
// sum of all  its  values.
    public static boolean isRowMagic(int[][] a) {
        boolean magic = true;

        int[] suma = allRowSums(a);

        for (int i = 0; i < a.length; i++) {

            try {
                if (suma[i] != suma[i + 1]) {
                    magic = false;

                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

        }

        return magic;
    }

//  Checks  if an  array  is "column -magic", that is, if all its  columns  have
// the  same  sum of all  its  values.
    public static boolean isColumnMagic(int[][] a) {
        boolean magic = true;
        int[] suma = allColumnSums(a);

        for (int i = 0; i < elementosFila(a); i++) {

            try {
                if (suma[i] != suma[i + 1]) {
                    magic = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

        }

        return magic;
    }

//  Checks  that a matrix  is square , that is , it has  the  same  number  of rows
// as  columns  and  all  rows  have  the  same  length.
    public static boolean isSquare(int[][] a) {
        boolean square = false;
        for (int i = 0; i < a.length; i++) {
            if (numeroElementosPorFila(a)[i] == numeroFilas(a)) {
                square = true;

            } else {
                square = false;
                break;
            }

        }
        return square;
    }

//  Check  if the  matrix  is a magic  square. A matrix  is  magic  square  if it is
// square , all  the  rows  add up to the same , all the  columns  add up to the
// same  and  the two  main  diagonals  add up to the  same. Also  all  these  sums
// are  the  same.
    public static boolean isMagic(int[][] a) {
        boolean magic = false;
        int filas = 0;
        int colum = 0;
        int diag = 0;
        if (isSquare(a)) {

            for (int i = 0; i < a.length - 1; i++) {
                if (allRowSums(a)[i] == allRowSums(a)[i + 1]) {

                    filas = allRowSums(a)[i];

                } else {
                    magic = false;
                    break;
                }
                if (allColumnSums(a)[i] == allColumnSums(a)[i + 1]) {

                    colum = allColumnSums(a)[i];
                } else {
                    magic = false;
                    break;
                }
                if (sumaElementosArray(elementosDiagonalPrimera(a)) == sumaElementosArray(elementosDiagonalSegunda(a))) {

                    diag = sumaElementosArray(elementosDiagonalPrimera(a));

                } else {

                    magic = false;
                    break;
                }

                if (filas == colum && diag == filas) {
                    magic = true;
                } else {

                    magic = false;
                    break;
                }

            }

        } else {

            magic = false;
        }

        return magic;
    }

//  Checks  if the  given  matrix  forms a sequence , that is, it is  square
// (of  order n) and  contains  all  the  elementos  from 1 to n * n, regardless  of
//  their  order.
    public static boolean isSequence(int[][] a) {
        boolean sequence = true;
        int digito = 1;
        int cont = 0;

        if (isSquare(a)) {
            for (int i = 0; i < elementosMatriz(a).length; i++) {
                for (int j = 0; j < elementosMatriz(a).length; j++) {
                    if (digito == elementosMatriz(a)[j]) {
                        cont++;
                        digito++;
                    }
                }
            }
            if (cont == elementosMatriz(a).length) {
                sequence = true;
            } else {
                sequence = false;
            }
        } else {
            sequence = false;
        }
        return sequence;
    }

    public static void main(String[] args) {
        
       
        
        System.out.println("Elemento máximo: " + max(matriz));
        System.out.println("Suma de la fila dada: " + rowSum(matriz, 2));
        System.out.println("Suma de la columna dada:" + columnSum(matriz, 2));
        System.out.println("Suma de todas las filas: " + Arrays.toString(allRowSums(matriz)));
        System.out.println("Suma de todas las columnas: " + Arrays.toString(allColumnSums(matriz)));
        System.out.println("Filas magicas: " + isRowMagic(matriz));
        System.out.println("Columnas magicas: " + isColumnMagic(matriz));
        System.out.println("Matriz magica: " + isMagic(matriz));
        System.out.println("Matriz cuadrada: " + isSquare(matriz));
        System.out.println("Forma una secuencia: " + isSequence(matriz));
    }

}
