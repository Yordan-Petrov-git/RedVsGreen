package Services.Impl;

import Data.Models.Grid;
import Data.Models.GridElement;
import Data.Models.enums.Colour;
import Data.Repository.GridElementsRepository;
import Services.GameService;
import Utility.Validation.ConsoleInputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameServiceImpl implements GameService {

    /**
     * @author Yordan Petrov
     * @run
     *
     * @updateElementsNeighbours
     *
     * @applyRulesToTheGrid
     *
     * @getElementAtPositionColour
     *
     * @getNeighbours
     *
     * @applyRules
     *
     * @greenCellRules
     *
     * @redCellRules
     *
     * @printResult
     *
     * @getElementAtRowColumnFromElementList
     *
     * @makeGridElements
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
        printResult(getElementAtRowColumnFromElementList(inputResultCellAndGenerationsToPass[1],inputResultCellAndGenerationsToPass[0], gridElementList));
        //----------------------Game main loop-------------------------
    }

    private void updateElementsNeighbours(List<GridElement> gridElementList, Grid grid) {
        //Update NEIGHBOURS OF the  Elements
        // ITERATES TROUGH THE ARRAY
        for (int i = 0; i < grid.getTheGrid().length; i++) {
            for (int j = 0; j < grid.getTheGrid()[i].length; j++) {
                // GETS EACH I J ELEMENT
                GridElement elem = getElementAtRowColumnFromElementList(i, j, gridElementList);
                // AND RECALCULATE ITS NEIGHBOURS
                elem.setNeighbours(getNeighbours(grid.getTheGrid(), i, j));
            }
        }
    }

    private void applyRulesToTheGrid(List<GridElement> gridElementList, Grid grid) {
        for (int i = 0; i < grid.getTheGrid().length; i++) {
            for (int j = 0; j < grid.getTheGrid()[i].length; j++) {
                applyRules(grid.getTheGrid(), Objects.requireNonNull(getElementAtRowColumnFromElementList(i, j, gridElementList)));
            }
        }
    }

    private static int getElementAtPositionColour(int[][] array, int i, int j) {
        return array[i][j];
    }

    public static List<Integer> getNeighbours(int[][] array, int i, int j) {
        //Gets All neighbouring numbers around the index
        List<Integer> neighboursList = new ArrayList<>();
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, array.length); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, array[i].length); y++) {
                if (x >= 0 && y >= 0 && x < array.length && y < array[i].length) {
                    if (x != i || y != j) {
                        //Add them to the list with neighbours
                        neighboursList.add(array[x][y]);
                    }
                }
            }
        }
        return neighboursList;
    }

    private static void applyRules(int[][] array, GridElement gridElement) {
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
            redCellRules(array, gridElement, greenCounter);
        } else if (gridElement.getColour().equals(Colour.GREEN)) {
            greenCellRules(array, gridElement, greenCounter);
        }
    }

    private static void greenCellRules(int[][] array, GridElement gridElement, int greenCells) {
        //Remains Green(1);
        int incrementForTheGreenCounter = gridElement.getWasGreenCounter();
        incrementForTheGreenCounter++;
        gridElement.setWasGreenCounter(incrementForTheGreenCounter);

        if (greenCells == 0 || greenCells == 1 || greenCells == 4 || greenCells == 5 || greenCells == 7 || greenCells == 8) {
            //Shifts colour from Green(1) to Red(0)
            gridElement.setColour(Colour.RED);
            array[gridElement.getRow()][gridElement.getColumn()] = 0;
        }
    }


    private static void redCellRules(int[][] array, GridElement gridElement, int greenCells) {
        if (greenCells == 3 || greenCells == 6) {
            //Shifts colour from Red(0) to Green(1)
            gridElement.setColour(Colour.GREEN);
            array[gridElement.getRow()][gridElement.getColumn()] = 1;
        }
    }

    private static void printResult(GridElement gridElement) {
        System.out.print(String.format("# expected result: %s", gridElement.getWasGreenCounter()));
    }

    private static GridElement getElementAtRowColumnFromElementList(int i, int j, List<GridElement> gridElementList) {
        int row = 0;
        int column = 0;
        for (GridElement gridElement : gridElementList) {
            row = gridElement.getRow();
            column = gridElement.getColumn();
            if (row == i && column == j) {
                return gridElement;
            }
        }
        return null;
    }

    private static List<GridElement> makeGridElements(int[][] array) {
        List<GridElement> gridElementList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                //Creates new ElementObject for each element in the grid
                GridElement gridElement = new GridElement(i, j,
                        getElementAtPositionColour(array, i, j),
                        getNeighbours(array, i, j));

                gridElementList.add(gridElement);
            }
        }
        return gridElementList;
    }
}
