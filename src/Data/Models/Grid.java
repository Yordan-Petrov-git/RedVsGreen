package Data.Models;

public class Grid {

    /**
     * @author Yordan Petrov
     * @param gridWidthCoordinateAxisX
     * @param gridHeightCoordinateAxisY
     * @param theGrid
     */

    private int gridWidthCoordinateAxisX;
    private int gridHeightCoordinateAxisY;
    private int[][] theGrid;

    public Grid(int gridWidthCoordinateAxisX, int gridHeightCoordinateAxisY) {
        setGridWidthCoordinateAxisX(gridWidthCoordinateAxisX);
        setGridHeightCoordinateAxisY(gridHeightCoordinateAxisY);
        setTheGrid(new int[gridWidthCoordinateAxisX][gridHeightCoordinateAxisY]);
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

    public int[][] getTheGrid() {
        return this.theGrid;
    }

    public void setTheGrid(int[][] theGrid) {
        this.theGrid = theGrid;
    }

}
