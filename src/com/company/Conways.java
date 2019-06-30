package com.company;

import java.io.IOException;
import java.util.List;

public class Conways {

    private boolean[][] cells;
    private int height;
    private int width;

    private boolean computeCell(int y, int x) {
        int aliveCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int cx = x + j;
                int cy = y + i;
                if (cx < 0 || cx > width - 1 || cy < 0 || cy > height - 1) {
                    continue;
                }
                aliveCount += cells[cy][cx] ? 1 : 0;
            }
        }
        return aliveCount == 3 || aliveCount == 4;
    }

    private void recomputeBoard() {
        boolean[][] newBoard = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                newBoard[i][j] = computeCell(i, j);
            }
        }
        cells = newBoard;
    }

    public void play() {
        while(true) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(cells[i][j] ? 'x' : 'o');
                }
                System.out.println();
            }
            recomputeBoard();
            try {
                System.in.read();
            } catch(IOException e) {
                continue;
            }
        }
    }

    public Conways(int height, int width) {
        this.cells = new boolean[height][width];
        cells[1][1] = true;
        cells[1][3] = true;
        cells[2][2] = true;
        cells[2][3] = true;
        cells[3][2] = true;

        this.height = height;
        this.width = width;
    }
}
