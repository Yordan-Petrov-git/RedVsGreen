package data.models;

import data.models.enums.Colour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yordan Petrov
 */

public class GridElement {

    /**
     * @param row row of the GridElement.
     * @param column column of the GridElement.
     * @param colour enumeration for the colour of the GridElement.
     * @param neighbours list of neighbouring cells of the GridElement.
     * @param wasGreenCounter This is the counter for the how many times
     * after the four Rules are applied for the Element from the Grid was green(1).
     */

    private int row;
    private int column;
    private Colour colour;
    private List<Integer> neighbours = new ArrayList<>();

    int wasGreenCounter = 0;

    /**
     * @param row        row of the GridElement for the constructor.
     * @param column     column of the GridElement for the constructor.
     * @param colour     enumeration for the colour of the GridElement for the constructor.
     * @param neighbours list of neighbouring cells of the GridElement for the constructor.
     */
    public GridElement(int row, int column, int colour, List<Integer> neighbours) {
        setRow(row);
        setColumn(column);
        elementAddColour(colour);
        setNeighbours(neighbours);
    }

    /**
     * This method is getter for the row of the GridElement.
     *
     * @return GridElement row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * This method is setter for the row.
     *
     * @param row GridElement row.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * This method is getter for the column.
     *
     * @return GridElement column.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * This method is setter for the column.
     *
     * @param column GridElement column.
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * This method is getter for the colour enumeration.
     *
     * @return enumeration for the GridElement colour.
     */
    public Colour getColour() {
        return this.colour;
    }


    /**
     * This method is  setter for the colour enumeration.
     *
     * @param colour enumeration for the GridElement colour.
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * This method is setting the correct enumeration for each colour.
     *
     * @param colour int for the colour of the gridElement.
     */
    public void elementAddColour(int colour) {
        if (colour == 0) {
            setColour(Colour.RED);
        } else {
            setColour(Colour.GREEN);
        }
    }

    /**
     * This method is getter for the neighbours list.
     *
     * @return GridElements's neighbours list.
     */
    public List<Integer> getNeighbours() {
        return this.neighbours;
    }

    /**
     * This method is setter for the neighbours list.
     *
     * @param neighbours GridElements's neighbours list.
     */
    public void setNeighbours(List<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * This method is getter for the  was green counter.
     *
     * @return counter for how many times GridElement(cell)
     * was green the generation cycle is passed.
     */
    public int getWasGreenCounter() {
        return this.wasGreenCounter;
    }

    /**
     * This method is setter for the was green counter.
     *
     * @param wasGreenCounter counter for how many times GridElement(cell)
     *                        was green the generation cycle is passed.
     */
    public void setWasGreenCounter(int wasGreenCounter) {
        this.wasGreenCounter = wasGreenCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GridElement)) return false;
        GridElement gridElement = (GridElement) o;
        return column == gridElement.column &&
                row == gridElement.row &&
                colour == gridElement.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row, colour);
    }


    @Override
    public String toString() {
        return "Element{" + "row=" + row +
                ", column=" + column +
                ", colour=" + colour +
                ", wasGreenCounter=" + wasGreenCounter +
                '}';
    }
}
