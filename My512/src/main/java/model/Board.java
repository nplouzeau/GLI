package model;

/**
 * Created by plouzeau on 2014-10-09.
 * <p/>
 * A square board from hosting tiles.
 */
public interface Board {


    public int getSideSizeInSquares();

    /**
     * Return the tile at a given coordinate, or null if none exists there.
     *
     * @param lineNumber   must be >=1 and <= getSideSizeInSquares()
     * @param columnNumber must be >=1 and <= getSideSizeInSquares()
     * @return a tile or null if none
     * @throws java.lang.IllegalArgumentException if parameters are out of board's bounds
     */
    Tile getTile(int lineNumber, int columnNumber);

    public enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }

    void packIntoDirection(Direction direction);

    void commit();


}
