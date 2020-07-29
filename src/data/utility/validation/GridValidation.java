package data.utility.validation;

import data.constants.Constants;
import exceptions.InvalidConsoleInputException;
import exceptions.InvalidMatrixDimension;

/**
 * @author Yordan Petrov
 */
public class GridValidation extends Constants {

    /**
     * @param rowOfTheGrid Coordinate  for  column(y) of the Grid used for validation.
     * @param columnsOfTheGrid Coordinate  for  column(y) of the Grid used for validation.
     */
    int rowOfTheGrid;
    int columnsOfTheGrid;

    /**
     * This method validates if the input grid dimensions are correct.
     *
     * @param withX   Coordinate  for  row(x) of the Grid.
     * @param heightY Coordinate  for  column(y) of the Grid.
     * @return the validated output withX <= heightY < 1000.
     */
    public boolean isTheGridValidHeightAnWith(final int withX, final int heightY) {
        boolean isValid = false;
        if (withX <= heightY && heightY < MAXIMUM_NUMBER_OF_COLUMNS) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidMatrixDimension(INVALID_MATRIX_DIMENSIONS);
        }
        return isValid;
    }

    /**
     * This method validates if the input grid dimensions are correct.
     *
     * @param arrayToBeChecked The Array to be validated.
     * @return result of validation is the array input dimensions (x,y) are correct.
     */
    public boolean isTheInputGridValidHeightAndWithNumbers(final String[] arrayToBeChecked) {
        boolean isValid = false;

        if (!arrayLengthChecker(arrayToBeChecked, WIDTH_AND_HEIGHT_OF_THE_GRID)) {
            isValid = false;
            throw new InvalidMatrixDimension(INVALID_MATRIX_DIMENSIONS_PARAMETERS);
        } else if (arrayRegExValidator(arrayToBeChecked, REGULAR_EXPRESSION_FOR_VALIDATION_OF_CONSOLE_INPUT)) {
            isValid = true;
        }

        if (isValid) {
            rowOfTheGrid = Integer.parseInt(arrayToBeChecked[0]);
            columnsOfTheGrid = Integer.parseInt(arrayToBeChecked[1]);
        }

        if (!isValid) {
            throw new InvalidMatrixDimension(INVALID_MATRIX_DIMENSION_VALUES);
        }
        return isValid;
    }

    /**
     * This method validates if the input grid values are correct.
     *
     * @param arrayToBeChecked The Array to be validated.
     * @return result of validation is the array input values 0 and 1's .
     */
    public boolean isTheInputGridValid(final String[] arrayToBeChecked) {
        boolean isValid = false;
        if (arrayRegExValidator(arrayToBeChecked, REGULAR_EXPRESSION_FOR_VALIDATION_OF_THE_CELL)) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidConsoleInputException(INVALID_MATRIX_CELL_PARAMETERS);
        }
        return isValid;
    }

    /**
     * This method validates if the input cell's coordinates
     * for calculating how many times the cell was green and
     * the generations to pass.
     *
     * @param arrayToBeChecked The Array to be validated.
     * @return result of validation for the Cell that the
     * result should be calculated and the number of generations to pass.
     */
    public boolean isTheInputResultCellAndGenerationsValid(final String[] arrayToBeChecked) {
        boolean isValid = false;

        if (!arrayLengthChecker(arrayToBeChecked, ROW_CELL_AND_GENERATIONS_FOR_RESULT)) {
            isValid = false;
            throw new InvalidMatrixDimension(INVALID_CELL_POSITION_AND_GENERATIONS_PARAMETERS);
        } else if (arrayRegExValidator(arrayToBeChecked, REGULAR_EXPRESSION_FOR_VALIDATION_OF_CONSOLE_INPUT)) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidConsoleInputException(INVALID_CELL_POSITION_AND_GENERATIONS);
        }
        return isValid;
    }

    /**
     * This method that checks if the array is certain length.
     *
     * @param arrayToBeChecked The Array to be validated.
     * @param checkedLength    the length of the array.
     * @return result if the passed array is the checked length.
     */
    public boolean arrayLengthChecker(final String[] arrayToBeChecked, final int checkedLength) {
        boolean isValid;
        isValid = arrayToBeChecked.length == checkedLength;
        return isValid;
    }

    /**
     * This method that checks for each element of the array
     * if the element is maced with certain regex.
     *
     * @param arrayToBeChecked The Array to be validated.
     * @param matcherRegEx     String for the RegularExpression for the validation.
     * @return result of the validation if the array is valid.
     */
    public boolean arrayRegExValidator(final String[] arrayToBeChecked, final String matcherRegEx) {
        boolean isValid = false;
        for (String cell : arrayToBeChecked) {
            isValid = cell.matches(matcherRegEx);
            if (!isValid) {
                break;
            }
        }
        return isValid;
    }

}
