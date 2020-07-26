package Utility.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleInputReader {

    public BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

   public  int[] readTheSizeOfTheGrid() throws IOException {
       return Arrays.stream(bufferedReader.readLine().split(",\\s*")).mapToInt(Integer::parseInt).toArray();
   }

    public int[][] readTheTheGrid(int rows,int columns) throws IOException {
        int[][] twoDm = new int[rows][columns];
        int i, j;
        for (i = 0; i < twoDm.length; i++) {
            String[] line = this.bufferedReader.readLine().split("");
            for (j = 0; j < twoDm[i].length; j++) {
                twoDm[i][j] = Integer.parseInt(line[j]);
            }
        }
        return twoDm;
    }

    public int[] readCoordinatesOfTheElementAndGenerationsToIterate() throws IOException {
        return Arrays.stream(bufferedReader.readLine().split(",\\s*")).mapToInt(Integer::parseInt).toArray();
    }

}
