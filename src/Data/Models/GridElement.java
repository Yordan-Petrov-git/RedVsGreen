package Data.Models;

import Data.Models.enums.Colour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GridElement {

    private int row;
    private int column;
    private Colour colour;
    private List<Integer> neighbours = new ArrayList<>();

    int wasGreenCounter = 0;

    public GridElement(int row, int column, int colour, List<Integer> neighbours) {
        setRow(row);
        setColumn(column);
        elementAddColour(colour);
        setNeighbours(neighbours);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Colour getColour() {
        return this.colour;
    }


    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void elementAddColour(int colour) {
        if (colour == 0) {
            setColour(Colour.RED);
        } else {
            setColour(Colour.GREEN);
        }
    }

    public List<Integer> getNeighbours() {
        return this.neighbours;
    }

    public void setNeighbours(List<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public int getWasGreenCounter() {
        return this.wasGreenCounter;
    }

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
