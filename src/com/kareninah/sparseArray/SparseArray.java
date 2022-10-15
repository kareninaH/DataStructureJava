package com.kareninah.sparseArray;

import java.io.IOException;

/**
 * @FileName DataStructure.sparseArray.sparseArray
 * @Description TODO
 * @Author hgy
 * @Date 2022/10/7:21:23
 * @Version V1.0
 */
public class SparseArray {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[3][3] = 1;
        System.out.println("原二维数组");
        int values = 0;
        for (int[] data : chessArray) {
            for (int v : data) {
                if (v != 0) {
                    values+=1;
                }
                System.out.printf("%d\t", v);
            }
            System.out.println();
        }

        System.out.println("稀疏数组");
        toSparse(chessArray, values);
        
        System.out.println("稀疏数组->二维数组");
        int[][] array = reverse();
        for (int[] data : chessArray) {
            for (int v : data) {
                System.out.printf("%d\t", v);
            }
            System.out.println();
        }
    }

    /**
     * 二维数组转稀疏数组
     * @param array
     * @param values
     * @return
     */
    private static void toSparse(int[][] array ,int values) throws IOException {
        int col = array.length;
        int row = array[0].length;
        int[][] sparseArray = new int[values+1][3];
        sparseArray[0][0] = col;
        sparseArray[0][1] = row;
        sparseArray[0][2] = values;

        int c = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    c++;
                    sparseArray[c][0] = i;
                    sparseArray[c][1] = j;
                    sparseArray[c][2] = array[i][j];
                }
            }
        }
        for (int[] data : sparseArray) {
            System.out.printf("%d\t%d\t%d\n", data[0], data[1], data[2]);
        }
        FileIO.save(sparseArray);
//        return sparseArray;
    }

    private static int[][] reverse() throws IOException, ClassNotFoundException {
        int[][] sparseArray = FileIO.upload();
        int col = sparseArray[0][0];
        int row = sparseArray[0][1];
        int values = sparseArray[0][2];

        int[][] array = new int[col][row];
        for (int i = 1 ; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][0]] = sparseArray[i][2];
        }
        return array;
    }
}
