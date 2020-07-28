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
     **/

    protected static final int WIDTH_AND_HEIGHT_OF_THE_GRID = 2;
    protected static final int ROW_CELL_AND_GENERATIONS_FOR_RESULT = 3;
    protected static final int MAXIMUM_NUMBER_OF_COLUMNS = 1000;
    protected static final Collection<Integer> GREEN_CELL_NEIGHBOURS_COUNT_FOR_RULE_THREE = Arrays.asList(0, 1, 4, 5, 7, 8);
    protected static final Collection<Integer> RED_CELL_NEIGHBOURS_COUNT_FOR_RULE_ONE = Arrays.asList(3, 6);


}
