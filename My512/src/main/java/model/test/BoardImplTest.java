package model.test;


import model.Board;
import model.BoardImpl;
import model.Tile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardImplTest {

    BoardImpl testBoard;
    final int defaultBoardSize = 3;

    @Before
    public void setUp() throws Exception {
        testBoard = new BoardImpl(defaultBoardSize);
    }

    @Test
    public void testGetSideSizeInSquares() throws Exception {

        Assert.assertEquals(defaultBoardSize, testBoard.getSideSizeInSquares());
    }

    @Test
    public void testGetTile() throws Exception {
        Assert.fail("test case not implemented");
    }

    /*
     * Identity test for packing
     * The current and next board should be the same
    */
    @Test
    public void testPackIntoDirection1() throws Exception {
        testBoard.loadBoard(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        Tile uniqueTile = testBoard.getTile(1, 1);
        Assert.assertNotNull(uniqueTile);
        testBoard.packIntoDirection(Board.Direction.LEFT);
        testBoard.commit();
        uniqueTile = testBoard.getTile(1, 1);
        Assert.assertNotNull(uniqueTile);
        Assert.assertEquals(1, uniqueTile.getRank());
    }

    /*
     * Check that one tile in (1,3) is moved to (1,1)
     */
    @Test
    public void testPackIntoDirection2() throws Exception {
        testBoard.loadBoard(new int[][]{{0,0,1},{0,0,0},{0,0,0}});
        testBoard.packIntoDirection(Board.Direction.LEFT);
        testBoard.commit();
        Tile uniqueTile = testBoard.getTile(1,1);
        Assert.assertNotNull(uniqueTile);
        Assert.assertEquals(1,uniqueTile.getRank());
        Assert.assertNull(testBoard.getTile(1,3));
    }

    /*
    * Check that tiles in (1,2) and (1,3) with different ranks
    * are moved in (1,1 and (1,2)
    */
    @Test
    public void testPackIntoDirection3() throws Exception {
        testBoard.loadBoard(new int[][]{{0,1,2},{0,0,0},{0,0,0}});
        testBoard.packIntoDirection(Board.Direction.LEFT);
        testBoard.commit();
        Tile uniqueTile = testBoard.getTile(1,1);
        Assert.assertNotNull(uniqueTile);
        Assert.assertEquals(1,uniqueTile.getRank());
        Assert.assertNotNull(testBoard.getTile(1,2));
        Assert.assertEquals(2,testBoard.getTile(1,2).getRank());
    }


    @Test
    public void testCommit() throws Exception {
        Assert.fail("test case not implemented");

    }
}