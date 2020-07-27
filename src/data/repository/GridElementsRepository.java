package data.repository;

import data.models.GridElement;

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

    private List<GridElement> gridElementList;


    /**
     * @param gridElementList
     */
    public GridElementsRepository(List<GridElement> gridElementList) {
        setGridElementList(gridElementList);
    }

    /**
     *
     */
    public GridElementsRepository() {
        setGridElementList(new ArrayList<>());
    }

    /**
     * @return
     */
    public List<GridElement> getGridElementList() {
        return this.gridElementList;
    }

    /**
     * @param gridElementList
     */
    public void setGridElementList(List<GridElement> gridElementList) {
        this.gridElementList = gridElementList;
    }
}
