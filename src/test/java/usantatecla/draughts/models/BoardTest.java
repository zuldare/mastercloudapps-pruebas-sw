package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BoardTest {

    private Board board;

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void testPutPieceInTheBoardDimensions() {
        String boardWithWhitePawn =
                " 01234567\n" +
                        " 0        0\n" +
                        " 1        1\n" +
                        " 2        2\n" +
                        " 3        3\n" +
                        " 4        4\n" +
                        " 5        5\n" +
                        " 6  b     6\n" +
                        " 7        7\n" +
                        " 01234567\n";

        putAtCoordinatePiece(6,2, Color.WHITE);
        assertThat(board.toString(), is(equalTo(boardWithWhitePawn)));
    }

    @Test
    public void testGetPiece(){
        putAtCoordinatePiece(5, 5, Color.WHITE);
        assertThat(board.getPiece(this.createCoordinate(5,5)), is(equalTo(new Pawn(Color.WHITE))));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetPieceOutsideBoardShouldReturnException(){
        board.getPiece(this.createCoordinate(25, 56));
    }

    @Test(expected = AssertionError.class)
    public void testRemovePieceWhenNoPieceIsFoundShouldReturnAssertionError(){
        board.remove(this.createCoordinate(5,5));
    }

    @Test
    public void testRemovePiece(){
        putAtCoordinatePiece(5,5, Color.BLACK);
        board.remove(this.createCoordinate(5,5));
        assertNull(board.getPiece(this.createCoordinate(5,5)));
    }


    @Test(expected = AssertionError.class)
    public void testMovePieceWhenOriginalPieceIsNullShouldReturnAssertError(){
        board.move(this.createCoordinate(5,5), this.createCoordinate(6,6));
    }

    @Test
    public void testMovePiece(){
        Coordinate coordinate55 = this.createCoordinate(5,5);
        Coordinate coordinate66 = this.createCoordinate(6,6);

        this.putAtCoordinatePiece(5,5, Color.BLACK);
        board.move(coordinate55, coordinate66);
        assertNull(board.getPiece(coordinate55));
        assertThat(board.getPiece(coordinate66), is(equalTo(new Pawn(Color.BLACK))));
    }

    @Test
    public void testGetBetweenDiagonalPiecesOutOfTheBoardDimensions() {

        Coordinate originCoordinate = new Coordinate(0, 1);
        Coordinate targetCoordinate = new Coordinate(2, 3);

        board.put(originCoordinate, new Pawn(Color.BLACK));
        board.put(new Coordinate(1, 2), new Pawn(Color.WHITE));

        List<Piece> betweenDiagonalPieces = board.getBetweenDiagonalPieces(originCoordinate, targetCoordinate);

        assertThat(betweenDiagonalPieces.size(), is(equalTo(1)));
        assertThat(betweenDiagonalPieces.get(0), is(new Pawn(Color.WHITE)));
    }

    @Test
    public void testGetColorWhenNoPieceAtCoordinateShouldReturnNull(){
        assertThat(board.getColor(this.createCoordinate(5,5)), is(Color.NONE));
    }

    @Test
    public void testGetColor(){
        this.putAtCoordinatePiece(5,5, Color.WHITE);
        assertThat(board.getColor(createCoordinate(5,5)), is(equalTo(Color.WHITE)));
    }


    private void putAtCoordinatePiece(int row, int col, Color color) {
        board.put(new Coordinate(row, col), new Pawn(color));
    }

    private Coordinate createCoordinate(int row, int col){
        return new Coordinate(row, col);
    }
}
