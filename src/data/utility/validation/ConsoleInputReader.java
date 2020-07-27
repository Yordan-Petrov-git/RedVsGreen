package data.utility.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleInputReader {

    /**
     * @author Yordan Petrov
     * @param bufferedReader Buffered reader that reads the input from the console.
     * @param gridValidation Validator  for the input.
     * @param gridValidation Validator  for the Grid.
     * @readTheSizeOfTheGrid Method for reading the input from the console,
     * for the coordinates:(width(row(x)),height(column(y))) of the Grid.
     * @readTheTheGrid Method for reading the input from the console, for
     * the values for each coordinates:(width(row(x)),height(column(y))) of the grid.
     * @readCoordinatesOfTheElementAndGenerationsToIterate Method for
     * reading the input from the console,
     * for the Element(cell from the input's array three values(0,0(row);0,1(column);0,2(NumberOfGenerations)))'s
     * position coordinates:(width(row(x(0,0)),height(column(y(0,1)))) of the Grid that the Number of times
     * that it was with value 1(Green)
     * and the number of Generations(N) that have to pass witch is cell(0,2).
     * @arrayIntParser Parses the input array from String to Integer.
     */

    private final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    private final GridValidation gridValidation = new GridValidation();


    /**
     * @return
     * @throws IOException
     */
    public int[] readTheSizeOfTheGrid() throws IOException {
        String[] inputArray = bufferedReader.readLine().split(",\\s*");
        try {
            gridValidation.isTheInputGridValidHeightAnWithNumbers(inputArray);
            gridValidation.isTheGridValidHeightAnWith(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return arrayIntParser(inputArray);
    }

    /**
     * @param rows
     * @param columns
     * @return
     * @throws IOException
     */
    public int[][] readTheTheGrid(final int rows, final int columns) throws IOException {

//        try {
//            gridValidation.isTheInputGridValidDimensions(rows,columns);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.exit(-1);
//        }

        int[][] gridInput = new int[rows][columns];

        for (int i = 0; i < gridInput.length; i++) {
            String[] inputArray = this.bufferedReader.readLine().split("");

            try {
                gridValidation.isTheInputGridValid(inputArray);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }

            int[] line = arrayIntParser(inputArray);
            for (int j = 0; j < gridInput[i].length; j++) {
                gridInput[i][j] = line[j];
            }
        }
        return gridInput;
    }

    /**
     * @return
     * @throws IOException
     */
    public int[] readCoordinatesOfTheElementAndGenerationsToIterate() throws IOException {
        String[] inputArray = bufferedReader.readLine().split(",\\s*");
        try {
            gridValidation.isTheInputResultCellAndGenerationsValid(inputArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return arrayIntParser(inputArray);
    }

    /**
     * @param arrayToBeParsedToInteger
     * @return
     */
    public int[] arrayIntParser(String[] arrayToBeParsedToInteger) {
        return Arrays.stream(arrayToBeParsedToInteger).mapToInt(Integer::parseInt).toArray();
    }

}
