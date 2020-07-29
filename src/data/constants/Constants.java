package data.constants;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Yordan Petrov
 */

public class Constants {
    /**
     * @param WIDTH_AND_HEIGHT_OF_THE_GRID holds how many dimensions the Grid have.
     * @param ROW_CELL_AND_GENERATIONS_FOR_RESULT hods how many number the calculation for the result of
     * coordinates(row,column) and the number of Generations to pass.
     * @param MAXIMUM_NUMBER_OF_COLUMNS holds the maximum number of columns for the grid.
     * @param GREEN_CELL_NEIGHBOURS_COUNT_FOR_RULE_THREE hods a list of all the neighbours count
     * for rule number three if the cell is green(1).
     * @param RED_CELL_NEIGHBOURS_COUNT_FOR_RULE_ONE hods a list of all the neighbours count
     * * for rule number one if the cell is red(0).
     * @param INVALID_MATRIX_DIMENSIONS String for validation exception for when the console input of
     * the x y  grid dimensions are not correct.
     * @param INVALID_MATRIX_DIMENSIONS_PARAMETERS String for validation exception for when
     * the console input of the grid dimensions are not two positive numbers.
     * @param INVALID_MATRIX_DIMENSION_VALUES String for validation exception for when the console
     * input of the matrix are not numbers.
     * @param INVALID_MATRIX_CELL_PARAMETERS String for validation exception for when the console input
     * of the cell's value are not 0(RED) or 1(GREEN).
     * @param INVALID_CELL_POSITION_AND_GENERATIONS_PARAMETERS String for validation exception for when
     * the console input of the cell to be checked how many times it was green and the number of generations
     * to pass are not correct.
     * @param INVALID_CELL_POSITION_AND_GENERATIONS String for validation exception for when
     * the console input of the cell to be checked how many times it was green and the number of generations
     * to pass are not numbers.
     * @param REGULAR_EXPRESSION_FOR_VALIDATION_OF_CONSOLE_INPUT Regular Expression for validating one or moore number.
     * @param REGULAR_EXPRESSION_FOR_VALIDATION_OF_THE_CELL Regular Expression for validating if the number is one or zero.
     **/

    protected static final int WIDTH_AND_HEIGHT_OF_THE_GRID = 2;
    protected static final int ROW_CELL_AND_GENERATIONS_FOR_RESULT = 3;
    protected static final int MAXIMUM_NUMBER_OF_COLUMNS = 1000;
    protected static final Collection<Integer> GREEN_CELL_NEIGHBOURS_COUNT_FOR_RULE_THREE = Arrays.asList(0, 1, 4, 5, 7, 8);
    protected static final Collection<Integer> RED_CELL_NEIGHBOURS_COUNT_FOR_RULE_ONE = Arrays.asList(3, 6);
    protected static final String INVALID_MATRIX_DIMENSIONS = ("\nDimension of the matrix should be x <= y < 1000 ");
    protected static final String INVALID_MATRIX_DIMENSIONS_PARAMETERS = ("\nDimension of the matrix should be only two positive numbers");
    protected static final String INVALID_MATRIX_DIMENSION_VALUES = ("\nDimension of the matrix should be coma separated positive numbers");
    protected static final String INVALID_MATRIX_CELL_PARAMETERS = ("\nCells of the Grid should be only positive 1(Green) or 0(Red).");
    protected static final String INVALID_CELL_POSITION_AND_GENERATIONS_PARAMETERS = ("\nPosition of the Cell should be only two positive numbers "
            + "followed by the number of generations to pass.");
    protected static final String INVALID_CELL_POSITION_AND_GENERATIONS = ("\nPosition of the Cell and number of Generations to " +
            " pass should be only positive numbers.");
    protected static final String REGULAR_EXPRESSION_FOR_VALIDATION_OF_CONSOLE_INPUT = ("\\d*");
    protected static final String REGULAR_EXPRESSION_FOR_VALIDATION_OF_THE_CELL = ("[0,1]");

}
