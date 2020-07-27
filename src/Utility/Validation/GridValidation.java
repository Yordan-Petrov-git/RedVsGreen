package Utility.Validation;

import Exceptions.InvalidConsoleInputException;
import Exceptions.InvalidMatrixDimension;

public class GridValidation {

    /**
     * @author Yordan Petrov
     * @isTheGridValidHeightAnWith
     * @isTheInputGridValidHeightAnWithNumbers
     * @isTheInputGridValid
     * @isTheInputResultCellAndGenerationsValid
     */

    public boolean isTheGridValidHeightAnWith(int withX, int heightY) {
        boolean isValid = false;
        if (heightY < 1000 && heightY <= withX) {
            isValid = true;
        }
        if (!isValid) {
            throw new InvalidMatrixDimension("Dimension of the matrix should be x <= y = 1000 ");
        }
        return isValid;
    }

    public boolean isTheInputGridValidHeightAnWithNumbers(String[] arrayToBeChecked) {
        boolean isValid = false;

        if (!arrayLengthChecker(arrayToBeChecked, 2)) {
            isValid = false;
            throw new InvalidMatrixDimension("Dimension of the matrix should be only two numbers");
        } else {
            for (String i : arrayToBeChecked) {
                isValid = i.matches("\\d*");
            }
        }
        if (!isValid) {
            throw new InvalidMatrixDimension("Dimension of the matrix should be coma separated numbers");
        }
        return isValid;
    }

    public boolean isTheInputGridValid(String[] arrayToBeChecked) {
        boolean isValid = false;
        for (String i : arrayToBeChecked) {
            isValid = i.matches("[0,1]");
        }
        //TODO FIX IT
        if (!isValid) {
            throw new InvalidConsoleInputException("Cells of the Grid should be only 1(Green) or 0(Red).");
        }
        return isValid;
    }


    public boolean isTheInputResultCellAndGenerationsValid(String[] arrayToBeChecked) {
        boolean isValid = false;

        if (arrayLengthChecker(arrayToBeChecked, 3)) {
            isValid = false;
            throw new InvalidMatrixDimension("Position of the Cell should be only two numbers" +
                    " followed by the number of generations to pass.");

        } else {
            //TODO FIX IT
            for (String i : arrayToBeChecked) {
                isValid = i.matches("\\d*");
            }
        }
        if (!isValid) {
            throw new InvalidConsoleInputException("Position of the Cell and number of Generations to" +
                    " pass should be only numbers.");
        }
        return isValid;
    }

    public boolean arrayLengthChecker(String[] arrayToBeChecked, int checkedLength) {
        boolean isValid;
        isValid = arrayToBeChecked.length == checkedLength;
        return isValid;
    }

}
