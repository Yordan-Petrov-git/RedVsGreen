package Utility.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleInputReader {

    public BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int[] readTheSizeOfTheGrid() throws IOException {
        return Arrays.stream(bufferedReader.readLine().
                split(",\\s*")).mapToInt(Integer::parseInt).toArray();
    }

    public int[][] readTheTheGrid(int rows, int columns) throws IOException {
        int[][] gridInput = new int[rows][columns];
        int i, j;
        for (i = 0; i < gridInput.length; i++) {
            //  String[] line = this.bufferedReader.readLine().split("");
            int[] line = Arrays.stream(bufferedReader.readLine()
                    .split("")).mapToInt(Integer::parseInt).toArray();
            for (j = 0; j < gridInput[i].length; j++) {
                // gridInput[i][j] = Integer.parseInt(line[j]);
                gridInput[i][j] = line[j];
            }
        }
        return gridInput;
    }

    public int[] readCoordinatesOfTheElementAndGenerationsToIterate() throws IOException {
        return Arrays.stream(bufferedReader.readLine()
                .split(",\\s*")).mapToInt(Integer::parseInt).toArray();
    }

}
