package Utility.Validation;

public class GridValidation {

    public boolean isTheGridValidHeightAnWith(int withX, int heightY) {
        boolean isValid = false;
        if (heightY < 1000 && heightY <= withX) {
            isValid = true;
        }
        return isValid;
    }

    //TODO VALIDATE IF THE grid is valid x and y ("^\d+,\s\d+$")


    //TODO VALIDATE IF THE GRID VALUES RE BETWEEN 0 AND 1 ("^[0,1]+$")


    //TODO VALIDATE IF THE result element and generations are correct  ("^\d+,\s+\d+,\s+\d+$")
}
