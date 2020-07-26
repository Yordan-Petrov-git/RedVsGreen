package Utility.Validation;

public class GridValidation {

    public boolean isTheGridValidHeightAnWith(int withX, int heightY) {
        boolean isValid = false;
        if (heightY < 1000 && heightY <= withX) {
            isValid = true;
        }
        return isValid;
    }


    //TODO VALIDATE IF THE GRID VALUES RE BETWEEN 0 AND 1
}
