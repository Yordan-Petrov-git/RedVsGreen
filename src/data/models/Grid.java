package data.models;

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

    /**
     * @param gridWidthCoordinateAxisX
     * @param gridHeightCoordinateAxisY
     */
    public Grid(int gridWidthCoordinateAxisX, int gridHeightCoordinateAxisY) {
        setGridWidthCoordinateAxisX(gridWidthCoordinateAxisX);
        setGridHeightCoordinateAxisY(gridHeightCoordinateAxisY);
        setTheGrid(new int[gridWidthCoordinateAxisX][gridHeightCoordinateAxisY]);
    }

    /**
     * @return
     */
    public int getGridWidthCoordinateAxisX() {
        return this.gridWidthCoordinateAxisX;
    }

    /**
     * @param gridWidthCoordinateAxisX
     */
    public void setGridWidthCoordinateAxisX(int gridWidthCoordinateAxisX) {
        this.gridWidthCoordinateAxisX = gridWidthCoordinateAxisX;
    }

    /**
     * @return
     */
    public int getGridHeightCoordinateAxisY() {
        return this.gridHeightCoordinateAxisY;
    }

    /**
     * @param gridHeightCoordinateAxisY
     */
    public void setGridHeightCoordinateAxisY(int gridHeightCoordinateAxisY) {
        this.gridHeightCoordinateAxisY = gridHeightCoordinateAxisY;
    }

    /**
     * @return
     */
    public int[][] getTheGrid() {
        return this.theGrid;
    }

    /**
     * @param theGrid
     */
    public void setTheGrid(int[][] theGrid) {
        this.theGrid = theGrid;
    }

}
