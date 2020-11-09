package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class PawnTest extends PieceTest {

    private Pawn blackPawn;
    private Pawn whitePawn;

    @Before
    public void before(){
        this.blackPawn = new Pawn(Color.BLACK);
        this.whitePawn = new Pawn(Color.WHITE);
        this.origin = Mockito.mock(Coordinate.class);
        this.destination = Mockito.mock(Coordinate.class);
    }

    @Override
    protected Pair<Piece, Piece> getBlackWhitePiece(){
        return new Pair(blackPawn, whitePawn);
    }

    @Test
    public void testIsCorrectDiagonalMovementWhiteNotAdvancedShouldReturnNotAdvanced(){
        when(this.origin.getRow()).thenReturn(5);
        when(this.destination.getRow()).thenReturn(5);
        assertThat(this.whitePawn
                .isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(1), this.getPair(0), origin, destination)
                , is(Error.NOT_ADVANCED));
    }

    @Test
    public void testIsCorrectDiagonalMovementTooMuchDistanceShouldReturnTooMuchAdvanced(){
        when(this.origin.getRow()).thenReturn(5);
        when(this.destination.getRow()).thenReturn(2);

        when(this.origin.getDiagonalDistance(this.destination)).thenReturn(3);
        assertThat(this.whitePawn
                        .isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(1), this.getPair(0), origin, destination)
                , is(Error.TOO_MUCH_ADVANCED));
    }

    @Test
    public void testIsCorrectDiagonalMovementWithoutEating(){
        when(origin.getRow()).thenReturn(7);
        when(destination.getRow()).thenReturn(6);
        when(origin.getDiagonalDistance(destination)).thenReturn(2);

        assertThat(whitePawn.isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(2), getPair(0), origin, destination)
                , is(Error.WITHOUT_EATING));
    }

    @Test
    public void testIsCorrectDiagonalMovementWrong(){
        when(origin.getRow()).thenReturn(7);
        when(destination.getRow()).thenReturn(6);
        when(origin.getDiagonalDistance(destination)).thenReturn(1);

        assertNull(whitePawn.isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(1), getPair(0), origin, destination));
    }

}
