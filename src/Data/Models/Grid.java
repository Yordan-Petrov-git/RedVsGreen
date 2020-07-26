package Data.Models;

public class Grid {

    private int gridWidthCoordinateAxisX;
    private int gridHeightCoordinateAxisY;
    private int[][] theGrid = new int[gridWidthCoordinateAxisX][gridHeightCoordinateAxisY];
//TODO ADD THE INPUT FROM THE KEYBOARD HERE


    public Grid(int gridWidthCoordinateAxisX, int gridHeightCoordinateAxisY, int[][] theGrid) {
        setGridWidthCoordinateAxisX(gridWidthCoordinateAxisX);
        setGridHeightCoordinateAxisY(gridHeightCoordinateAxisY);
    }

    public int getGridWidthCoordinateAxisX() {
        return this.gridWidthCoordinateAxisX;
    }

    public void setGridWidthCoordinateAxisX(int gridWidthCoordinateAxisX) {
        this.gridWidthCoordinateAxisX = gridWidthCoordinateAxisX;
    }

    public int getGridHeightCoordinateAxisY() {
        return this.gridHeightCoordinateAxisY;
    }

    public void setGridHeightCoordinateAxisY(int gridHeightCoordinateAxisY) {
        this.gridHeightCoordinateAxisY = gridHeightCoordinateAxisY;
    }

}
