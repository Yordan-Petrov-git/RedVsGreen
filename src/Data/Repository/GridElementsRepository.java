package Data.Repository;

import Data.Models.GridElement;

import java.util.ArrayList;
import java.util.List;

public class GridElementsRepository {
    /**
     * @author Yordan Petrov
     * @param gridElementList Storage for the Elements of the Grid
     * @GridElementsRepository
     * @getGridElementList
     * @setGridElementList
     */

    private List<GridElement> gridElementList = new ArrayList<>();

    public GridElementsRepository(List<GridElement> gridElementList) {
        setGridElementList(gridElementList);
    }

    public List<GridElement> getGridElementList() {
        return this.gridElementList;
    }

    public void setGridElementList(List<GridElement> gridElementList) {
        this.gridElementList = gridElementList;
    }
}
