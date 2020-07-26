package Data.Models;

public class Grid {

    private int gridWidthCoordinateAxisX;
    private int gridHeightCoordinateAxisY;
    private int[][] theGrid = new int[gridWidthCoordinateAxisX][gridHeightCoordinateAxisY];

    public Grid(int gridWidthCoordinateAxisX, int gridHeightCoordinateAxisY) {
       // setGridWidthCoordinateAxisX(gridWidthCoordinateAxisX);
       // setGridHeightCoordinateAxisY(gridHeightCoordinateAxisY);
       // createGridWithSizeHeightWidth();
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

    public void createGridWithSizeHeightWidth(int widthCoordinateAxisX,int heightCoordinateAxisY){

       // setTheGrid();
    }

}
