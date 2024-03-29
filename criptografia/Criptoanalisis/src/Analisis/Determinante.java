    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    package Analisis;

    import Ciphers.*;


    public class Determinante {

            /**
             * Crea una matriz, la escribe por pantalla, calcula su determinante y lo escribe
             * por pantalla.
             * @param args
             */
            public static void main(String[] args) {

                    int [][] matriz = {
                                    {11,8},
                                    {3,7}
                    };

            int [] matriz2 = {
                                    2,5,1
                    };



            //matriz=Matriz.inversa(matriz, 2);

          Hill texc5=new Hill("delw");

          System.out.println("hilll->"+texc5.descifrar(matriz,2));



             System.out.println("after");
                    for (int i=0;i<2;i++)
                    {
                            for (int j=0;j<2;j++)
                                    System.out.print(matriz[i][j]+" ");
                            System.out.println();
                    }
                    System.out.println("El determinante es "+Determinante.determinante(matriz)%26);
            }

            /**
             * Calcula el determinante de la matriz.
             * Para ello coge la primera fila y se va multiplicando cada coeficiente por el
             * determinante de la matriz de orden n-1 que resulta de suprimir la fila y columna
             * del coeficiente. Hay que ir alternando los signos.
             * Ver http://www.marcevm.com/determinantes/determinantes_def.php
             * @param matriz
             * @return
             */
            public static int determinante (int [][] matriz)
            {
                    //assert matriz != null;
                    //assert matriz.length>0;
                    //assert matriz.length == matriz[0].length;

                    int determinante = 0;

                    int filas = matriz.length;
                    int columnas = matriz[0].length;

                    // Si la matriz es 1x1, el determinante es el elemento de la matriz
                    if ((filas==1) && (columnas==1))
                            return matriz[0][0];


                    int signo=1;

                    for (int columna=0;columna<columnas;columna++)
                    {
                            // Obtiene el adjunto de fila=0, columna=columna, pero sin el signo.
                            int[][] submatriz = getSubmatriz(matriz, filas, columnas,
                                            columna, 0);
                            determinante = determinante + signo*matriz[0][columna]*determinante(submatriz);
                            signo*=-1;
                    }

          determinante=determinante%26;
            if(determinante<0)determinante=determinante+26;
           determinante=determinante%26;
                    return determinante;
            }

            /**
             * Obtiene la matriz que resulta de eliminar la primera fila y la columna que se
             * pasa como parámetro.
             * @param matriz Matriz original
             * @param filas Numero de filas de la matriz original
             * @param columnas Numero de columnas de la matriz original
             * @param columna Columna que se quiere eliminar, junto con la fila=0
             * @return Una matriz de N-1 x N-1 elementos
             */
            public static int[][] getSubmatriz(int[][] matriz,
                            int filas,
                            int columnas,
                            int columna,
                int fila) {
                    int [][] submatriz = new int[filas-1][columnas-1];
                    int contador=0;
            int contador2=0;

                    for (int j=0;j<columnas;j++)
                    {
                            if (j==fila) continue;
                contador=0;
                            for (int i=0;i<filas;i++){
                    if (i==columna) continue;
                                    submatriz[contador2][contador]=matriz[j][i];
                    contador++;
                }

                contador2++;
                    }
                    return submatriz;
            }
    }

