package data.repository;

import data.models.GridElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yordan Petrov
 */


public class GridElementsRepository {

    /**
     * @param gridElementList Storage for the Elements of the Grid.
     */
    private List<GridElement> gridElementList;

    /**
     * Constructor with StorageList.
     *
     * @param gridElementList Storage for the Elements of the Grid.
     */
    public GridElementsRepository(final List<GridElement> gridElementList) {
        setGridElementList(gridElementList);
    }

    /**
     * Empty Constructor.
     */
    public GridElementsRepository() {
        setGridElementList(new ArrayList<>());
    }

    /**
     * This method is getter for the element list.
     *
     * @return list of elements from the repository.
     */
    public List<GridElement> getGridElementList() {
        return this.gridElementList;
    }

    /**
     * This method is setter for the element list.
     *
     * @param gridElementList list of elements for the repository.
     */
    public void setGridElementList(final List<GridElement> gridElementList) {
        this.gridElementList = gridElementList;
    }
}
