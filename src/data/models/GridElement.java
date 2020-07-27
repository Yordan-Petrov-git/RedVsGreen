package data.models;

import data.models.enums.Colour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GridElement {

    /**
     * @author Yordan Petrov
     * @param row
     * @param column
     * @param colour
     * @param neighbours
     * @param wasGreenCounter This is the counter for the how many times
     * after the four Rules are applied certain element from the Grid was green;
     */

    private int row;
    private int column;
    private Colour colour;
    private List<Integer> neighbours = new ArrayList<>();

    int wasGreenCounter = 0;

    /**
     * @param row
     * @param column
     * @param colour
     * @param neighbours
     */
    public GridElement(int row, int column, int colour, List<Integer> neighbours) {
        setRow(row);
        setColumn(column);
        elementAddColour(colour);
        setNeighbours(neighbours);
    }

    /**
     * @return
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * @return
     */
    public Colour getColour() {
        return this.colour;
    }


    /**
     * @param colour
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * @param colour
     */
    public void elementAddColour(int colour) {
        if (colour == 0) {
            setColour(Colour.RED);
        } else {
            setColour(Colour.GREEN);
        }
    }

    /**
     * @return
     */
    public List<Integer> getNeighbours() {
        return this.neighbours;
    }

    /**
     * @param neighbours
     */
    public void setNeighbours(List<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * @return
     */
    public int getWasGreenCounter() {
        return this.wasGreenCounter;
    }

    /**
     * @param wasGreenCounter
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
        final StringBuilder sb = new StringBuilder("Element{");
        sb.append("row=").append(row);
        sb.append(", column=").append(column);
        sb.append(", colour=").append(colour);
        sb.append(", wasGreenCounter=").append(wasGreenCounter);
        sb.append('}');
        return sb.toString();
    }
}
