package data.models;

/**
 * @author Yordan Petrov
 */

public class Grid {

    /**
     * @param gridWidthCoordinateAxisX row dimension for the Grid.
     * @param gridHeightCoordinateAxisY column dimension for the Grid.
     * @param theGrid Array for the Grid.
     */

    private int gridWidthCoordinateAxisX;
    private int gridHeightCoordinateAxisY;
    private int[][] theGrid;

    /**
     * Constructor for the Grid
     *
     * @param gridWidthCoordinateAxisX  row dimension for the Grid
     *                                  for the constructor of the Grid.
     * @param gridHeightCoordinateAxisY column dimension for the Grid f
     *                                  or the constructor of the Grid..
     */
    public Grid(final int gridWidthCoordinateAxisX, final int gridHeightCoordinateAxisY) {
        setGridWidthCoordinateAxisX(gridWidthCoordinateAxisX);
        setGridHeightCoordinateAxisY(gridHeightCoordinateAxisY);
        setTheGrid(new int[gridWidthCoordinateAxisX][gridHeightCoordinateAxisY]);
    }

    /**
     * This method is getter for the rows.
     *
     * @return grids row.
     */
    public int getGridWidthCoordinateAxisX() {
        return this.gridWidthCoordinateAxisX;
    }

    /**
     * This method is setter for the rows.
     *
     * @param gridWidthCoordinateAxisX grids row.
     */
    public void setGridWidthCoordinateAxisX(final int gridWidthCoordinateAxisX) {
        this.gridWidthCoordinateAxisX = gridWidthCoordinateAxisX;
    }

    /**
     * This method is getter for the columns.
     *
     * @return grids column.
     */
    public int getGridHeightCoordinateAxisY() {
        return this.gridHeightCoordinateAxisY;
    }

    /**
     * This method is setter for the columns.
     *
     * @param gridHeightCoordinateAxisY grids column.
     */
    public void setGridHeightCoordinateAxisY(final int gridHeightCoordinateAxisY) {
        this.gridHeightCoordinateAxisY = gridHeightCoordinateAxisY;
    }

    /**
     * This method is getter for the Grid.
     *
     * @return the grid two dimensional integer array.
     */
    public int[][] getTheGrid() {
        return this.theGrid;
    }

    /**
     * This method is setter for the Grid.
     *
     * @param theGrid the grid two dimensional integer array.
     */
    public void setTheGrid(final int[][] theGrid) {
        this.theGrid = theGrid;
    }

}
