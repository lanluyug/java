package com.lanluyug.datastruct;

import org.junit.jupiter.api.Test;

public class sparseMatrix {
    @Test
    void test(){
        System.out.println("it's starting.......");
        int[][] chessBoard = new int[11][11];
        for (int[] row: chessBoard) {
            for (int item: row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
