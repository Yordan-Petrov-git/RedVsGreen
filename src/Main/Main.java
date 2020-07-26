package Main;

import Data.Models.GridElement;
import Data.Models.enums.Colour;
import Utility.Validation.ConsoleInputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
//        int[][] array = {
//                {0, 0, 0},
//                {1, 1, 1},
//                {0, 0, 0}
//        };
        //TODO x and y are reversed
        int[][] array = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 0}
        };

//        int[][] array = {
//                {1, 0},
//                {1, 1},
//                {0, 1},
//                {1, 0}
//        };

//        int[][] array = {
//                {1, 0, 1, 0},
//                {1, 1, 1, 0},
//        };
//
//        List<GridElement> gridElementList = makeGridElements(array);
//
//        int generationCounter = 15;
//        while (generationCounter >= 0) {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array[i].length; j++) {
//                    GridElement elem = getElementAtRowColumnFromElementList(i, j, gridElementList);
//                    assert elem != null;
//                    rules(array, elem);
//                }
//            }
//            // ITERATES TROUGH THE ARRAY
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array[i].length; j++) {
//                    // GETS EACH I J ELEMENT
//                    GridElement elem = getElementAtRowColumnFromElementList(i, j, gridElementList);
//                    // AND RECALCULATE ITS NEIGHBOURS
//                    List<Integer> integers = getNeighbours(array, i, j);
//                    elem.setNeighbours(integers);
//                }
//            }
//            //System.out.print(Arrays.deepToString(array));
//            generationCounter--;
//        }
//      //  printResult(getElementAtRowColumnFromElementList(0,1,gridElementList));
//        printResult(getElementAtRowColumnFromElementList(2,2,gridElementList));
//

        ConsoleInputReader consoleInputReader = new ConsoleInputReader();

        int[] elements = consoleInputReader.readTheSizeOfTheGrid();
        int[][] grid = consoleInputReader.readTheTheGrid(3, 3);
        int[] fin = consoleInputReader.readCoordinatesOfTheElementAndGenerationsToIterate();
        System.out.println(Arrays.toString(elements));
        System.out.println(Arrays.deepToString(grid));
        System.out.println(Arrays.toString(fin));
    }


    private static void printResult(GridElement gridElement) {
        System.out.println(gridElement.getWasGreenCounter());
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

    private static int getElementAtPositionColour(int[][] array, int i, int j) {
        return array[i][j];
    }

    private static List<Integer> getNeighbours(int[][] array, int i, int j) {
        //Gets All neighbouring numbers around the index
        List<Integer> neighboursList = new ArrayList<>();
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, array.length); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, array[i].length); y++) {
                if (x >= 0 && y >= 0 && x < array.length && y < array[i].length) {
                    if (x != i || y != j) {
                        neighboursList.add(array[x][y]);
                    }
                }
            }
        }
        return neighboursList;
    }

    private static void rules(int[][] array, GridElement gridElement) {
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

}
