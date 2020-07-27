package services.Impl;

import data.constants.Constants;
import data.models.Grid;
import data.models.GridElement;
import data.models.enums.Colour;
import data.repository.GridElementsRepository;
import data.utility.validation.ConsoleInputReader;
import services.GameService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yordan Petrov
 */

public class GameServiceImpl extends Constants implements GameService {

    /**
     * This method runs the program.
     *
     * @throws IOException Exception for the console input.
     */
    @Override
    public void run() throws IOException {

        //----------------------Get the input-----------------------------
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        int[] inputWidthAndHeight = consoleInputReader.readTheSizeOfTheGrid();
        int[][] inputArray = consoleInputReader.readTheTheGrid(inputWidthAndHeight[0], inputWidthAndHeight[1]);
        int[] inputResultCellAndGenerationsToPass = consoleInputReader.readCoordinatesOfTheElementAndGenerationsToIterate();
        //----------------------Get the input-----------------------------

        //----------------------Create grid element Repository-------------------
        GridElementsRepository gridElementsRepository = new GridElementsRepository(makeGridElements(inputArray));
        List<GridElement> gridElementList = gridElementsRepository.getGridElementList();
        //----------------------Create grid element Repository-------------------

        //----------------------Create Grid-----------------------------
        Grid grid = new Grid(inputWidthAndHeight[0], inputWidthAndHeight[1]);
        grid.setTheGrid(inputArray);
        //----------------------Create Grid-----------------------------

        //----------------------Game main loop-------------------------
        int generationCounter = inputResultCellAndGenerationsToPass[2];
        while (generationCounter >= 0) {
            applyRulesToTheGrid(gridElementList, grid);
            updateElementsNeighbours(gridElementList, grid);
            generationCounter--;
        }
        printResult(Objects.requireNonNull(getElementAtRowColumnFromElementList(inputResultCellAndGenerationsToPass[1],
                inputResultCellAndGenerationsToPass[0], gridElementList)));
        //----------------------Game main loop-------------------------
    }

    /**
     * This method updates the GridElement's neighbour cells colours.
     *
     * @param gridElementList List of Elements of the grid to be updated.
     * @param grid            The Grid.
     */
    private void updateElementsNeighbours(final List<GridElement> gridElementList, final Grid grid) {
        //Iterates trough the grid
        for (int i = 0; i < grid.getTheGrid().length; i++) {
            for (int j = 0; j < grid.getTheGrid()[i].length; j++) {
                //Gets each cell
                GridElement elem = getElementAtRowColumnFromElementList(i, j, gridElementList);
                //Update neighbours of each Element
                assert elem != null;
                elem.setNeighbours(getNeighbours(grid.getTheGrid(), i, j));
            }
        }
    }

    /**
     * This method iterates trough all of the grids cells and apples all the rules.
     *
     * @param gridElementList List of all the GridElement's created for each Grid cell.
     * @param grid            The Grid.
     */
    private void applyRulesToTheGrid(final List<GridElement> gridElementList, final Grid grid) {
        //Method for iterating trough the grid and
        // applying the rules for each cell according to its colour.
        for (int i = 0; i < grid.getTheGrid().length; i++) {
            for (int j = 0; j < grid.getTheGrid()[i].length; j++) {
                applyRules(grid.getTheGrid(), Objects.requireNonNull(getElementAtRowColumnFromElementList(i, j, gridElementList)));
            }
        }
    }

    /**
     * This method gets the colour of the selected GridElement.
     *
     * @param arrayForTheGrid Array containing all the cells of the Grid.
     * @param i               row for the selected Grid.
     * @param j               column for the selected Grid.
     * @return integerArray for Colour of the GridElement.
     */
    private static int getElementAtPositionColour(final int[][] arrayForTheGrid, final int i, final int j) {
        return arrayForTheGrid[i][j];
    }

    /**
     * This method gets the neighbours of  the selected GridElement
     * at certain cell's coordinates(x,y).
     *
     * @param arrayForTheGrid Array containing all the cells of the Grid.
     * @param i               row for the selected GridElement.
     * @param j               column for the selected GridElement.
     * @return list of Neighbours of the GridElement.
     */
    public static List<Integer> getNeighbours(final int[][] arrayForTheGrid, final int i, final int j) {
        //Gets All neighbouring numbers around the index at cell(i,j) from the Grid.
        List<Integer> neighboursList = new ArrayList<>();
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, arrayForTheGrid.length); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, arrayForTheGrid[i].length); y++) {
                if (x >= 0 && y >= 0 && x < arrayForTheGrid.length && y < arrayForTheGrid[i].length) {
                    if (x != i || y != j) {
                        //Add them to the list with neighbours
                        neighboursList.add(arrayForTheGrid[x][y]);
                    }
                }
            }
        }
        return neighboursList;
    }

    /**
     * This method method applies the rules.
     *
     * @param arrayForTheGrid Array containing all the cells of the Grid.
     * @param gridElement     GridElement cell from the Grid.
     */
    private static void applyRules(final int[][] arrayForTheGrid, final GridElement gridElement) {
        List<Integer> neighbours = gridElement.getNeighbours();
        //Counter for for the number of green neighbours of the index
        int greenCounter = 0;
        for (Integer neighbour : neighbours) {
            //Checks if neighbour is Green(1) and increments the  counter
            if (neighbour == 1) {
                greenCounter++;
            }
        }
        if (gridElement.getColour().equals(Colour.RED)) {
            redCellRules(arrayForTheGrid, gridElement, greenCounter);
        } else if (gridElement.getColour().equals(Colour.GREEN)) {
            greenCellRules(arrayForTheGrid, gridElement, greenCounter);
        }
    }

    /**
     * This method applies the rules to the Grid for the green cells.
     *
     * @param arrayForTheGrid              Array containing all the cells of the Grid.
     * @param gridElement                  GridElement cell from the Grid.
     * @param numberOfGreenCellsNeighbours Green cells that are neighbours to the gridElement.
     */
    private static void greenCellRules(final int[][] arrayForTheGrid, final GridElement gridElement, final int numberOfGreenCellsNeighbours) {
        //Rules for when the cell is Green(1);
        //Remains Green(1);
        int incrementForTheGreenCounter = gridElement.getWasGreenCounter();
        incrementForTheGreenCounter++;
        gridElement.setWasGreenCounter(incrementForTheGreenCounter);

        if (numberOfGreenCellsNeighbours == 0 || numberOfGreenCellsNeighbours == 1 || numberOfGreenCellsNeighbours == 4
                || numberOfGreenCellsNeighbours == 5 || numberOfGreenCellsNeighbours == 7 || numberOfGreenCellsNeighbours == 8) {
            //Shifts colour from Green(1) to Red(0) for the GridElement.
            gridElement.setColour(Colour.RED);
            //Shifting the Grid cell value.
            arrayForTheGrid[gridElement.getRow()][gridElement.getColumn()] = 0;
        }
    }


    /**
     * This method applies the rules to the Grid for the red cells.
     *
     * @param arrayForTheGrid              Array containing all the cells of the Grid.
     * @param gridElement                  GridElement cell from the Grid.
     * @param numberOfGreenCellsNeighbours Green cells that are neighbours to the gridElement.
     */
    private static void redCellRules(final int[][] arrayForTheGrid, final GridElement gridElement, final int numberOfGreenCellsNeighbours) {
        //Rules for when the cell is Red(0) for the GridElement.
        if (numberOfGreenCellsNeighbours == 3 || numberOfGreenCellsNeighbours == 6) {
            //Shifts colour from Red(0) to Green(1)
            gridElement.setColour(Colour.GREEN);
            //Shifting the Grid cell value.
            arrayForTheGrid[gridElement.getRow()][gridElement.getColumn()] = 1;
        }
    }

    /**
     * This method prints the result of the calculation.
     *
     * @param gridElement GridElement to print its GreenCounter
     *                    number(the counter for how many Generations this specific GridElement was green).
     */
    private static void printResult(final GridElement gridElement) {
        System.out.print(String.format("# expected result: %s", gridElement.getWasGreenCounter()));
    }

    /**
     * This method gets GridElement from cell at certain Grid coordinates(x(i),y(j)).
     *
     * @param i               row for the selected GridElement.
     * @param j               column for the selected GridElement.
     * @param gridElementList List of all the GridElement's created for each Grid cell.
     * @return GridElement for the coordinates(row(x),column(y)) of the selected cell.
     */
    private static GridElement getElementAtRowColumnFromElementList(final int i, final int j, final List<GridElement> gridElementList) {
        int row;
        int column;
        for (GridElement gridElement : gridElementList) {
            row = gridElement.getRow();
            column = gridElement.getColumn();
            if (row == i && column == j) {
                return gridElement;
            }
        }
        return null;
    }

    /**
     * This method iterates trough the Grid and initializes
     * new GridElement Object for each cell.
     *
     * @param arrayForTheGrid Array containing all the cells of the Grid.
     * @return List of all the GridElement's created for each Grid cell.
     */
    private static List<GridElement> makeGridElements(final int[][] arrayForTheGrid) {
        //Creates Object of Grid Element Class for each cell in the grid
        List<GridElement> gridElementList = new ArrayList<>();
        for (int i = 0; i < arrayForTheGrid.length; i++) {
            for (int j = 0; j < arrayForTheGrid[i].length; j++) {
                //Creates new ElementObject for each element in the grid
                GridElement gridElement = new GridElement(i, j,
                        getElementAtPositionColour(arrayForTheGrid, i, j),
                        getNeighbours(arrayForTheGrid, i, j));
                gridElementList.add(gridElement);
            }
        }
        return gridElementList;
    }
}
