package Utility.Validation;

import Exceptions.InvalidConsoleInputException;
import Exceptions.InvalidMatrixDimension;

/**
 * @author Yordan Petrov
 */
public class GridValidation {

    int rowOfTheGrid;
    int columnsOfTheGrid;

    /**
     * @param withX   Coordinate  for  row(x) of the Grid
     * @param heightY Coordinate  for  column(y) of the Grid
     * @return the validated output
     */
    public boolean isTheGridValidHeightAnWith(int withX, int heightY) {
        boolean isValid = false;
        if (withX <= heightY && heightY < 1000) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidMatrixDimension("Dimension of the matrix should be x <= y = 1000 ");
        }
        return isValid;
    }

    /**
     * @param arrayToBeChecked
     * @return
     */
    public boolean isTheInputGridValidHeightAnWithNumbers(String[] arrayToBeChecked) {
        boolean isValid = false;

        if (!arrayLengthChecker(arrayToBeChecked, 2)) {
            isValid = false;
            throw new InvalidMatrixDimension("Dimension of the matrix should be only two numbers");
        } else if (arrayValidator(arrayToBeChecked, "\\d*")) {
            isValid = true;
        }

        if (isValid) {
            rowOfTheGrid = Integer.parseInt(arrayToBeChecked[0]);
            columnsOfTheGrid = Integer.parseInt(arrayToBeChecked[1]);
        }

        if (!isValid) {
            throw new InvalidMatrixDimension("Dimension of the matrix should be coma separated numbers");
        }
        return isValid;
    }

    /**
     * @param arrayToBeChecked
     * @return
     */
    public boolean isTheInputGridValid(String[] arrayToBeChecked) {
        boolean isValid = false;
        if (arrayValidator(arrayToBeChecked, "[0,1]")) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidConsoleInputException("Cells of the Grid should be only 1(Green) or 0(Red).");
        }
        return isValid;
    }

//    public boolean isTheInputGridValidDimensions(int x, int y) {
//        boolean isValid = false;
//        if (rowOfTheGrid == x && columnsOfTheGrid == y) {
//            isValid = true;
//        }
//        if (!isValid) {
//            throw new InvalidConsoleInputException(
//                    String.format("Dimensions of the Grid should be" +
//                            " as specified : rows: (%s) columns (%s) .", rowOfTheGrid, columnsOfTheGrid));
//        }
//        return isValid;
//    }

    /**
     * @param arrayToBeChecked
     * @return
     */
    public boolean isTheInputResultCellAndGenerationsValid(String[] arrayToBeChecked) {
        boolean isValid = false;

        if (!arrayLengthChecker(arrayToBeChecked, 3)) {
            isValid = false;
            throw new InvalidMatrixDimension("Position of the Cell should be only two numbers" +
                    " followed by the number of generations to pass.");
        } else if (arrayValidator(arrayToBeChecked, "\\d*")) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidConsoleInputException("Position of the Cell and number of Generations to" +
                    " pass should be only numbers.");
        }
        return isValid;
    }

    /**
     * @param arrayToBeChecked
     * @param checkedLength
     * @return
     */
    public boolean arrayLengthChecker(String[] arrayToBeChecked, int checkedLength) {
        boolean isValid;
        isValid = arrayToBeChecked.length == checkedLength;
        return isValid;
    }

    /**
     * @param arrayToBeChecked
     * @param matcherRegEx
     * @return
     */
    public boolean arrayValidator(String[] arrayToBeChecked, String matcherRegEx) {
        boolean isValid = false;
        for (String cell : arrayToBeChecked) {
            isValid = cell.matches(matcherRegEx);
            if (isValid == false) {
                break;
            }
        }
        return isValid;
    }

}
