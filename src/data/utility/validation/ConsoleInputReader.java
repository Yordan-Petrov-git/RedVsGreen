package data.utility.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Yordan Petrov
 */

public class ConsoleInputReader {

    /**
     * @param bufferedReader Buffered reader that reads the input from the console.
     * @param gridValidation Validator for the input.
     */

    private final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    private final GridValidation gridValidation = new GridValidation();


    /**
     * This method reads the size of the grid from the console input.
     *
     * @return result of the input for the size of the Grid.
     * @throws IOException If an I/O error occurs for the input from the bufferedReader.
     */
    public int[] readTheSizeOfTheGrid() throws IOException {
        String[] inputArray = bufferedReader.readLine().split(",\\s*");
        try {
            gridValidation.isTheInputGridValidHeightAndWithNumbers(inputArray);
            gridValidation.isTheGridValidHeightAnWith(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return arrayIntParser(inputArray);
    }

    /**
     * This method reads the values for the grid from the console input.
     *
     * @param rows    length of the row of the input for the grid.
     * @param columns height of the row of the input for the grid.
     * @return result of the filled grid from the console.
     * @throws IOException If an I/O error occurs for the input from the bufferedReader.
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
     * This method reads coordinates(x,y) of the cell and how many generations to pass.
     *
     * @return result of the input for witch cell
     * to calculate the result and for how many generations.
     * @throws IOException If an I/O error occurs for the input from the bufferedReader.
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
     * This method parses string array to integer array.
     *
     * @param arrayToBeParsedToInteger String array to be parsed.
     * @return the parsed array to integer.
     */
    public int[] arrayIntParser(String[] arrayToBeParsedToInteger) {
        return Arrays.stream(arrayToBeParsedToInteger).mapToInt(Integer::parseInt).toArray();
    }

}
