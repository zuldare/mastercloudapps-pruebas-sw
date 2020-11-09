package usantatecla.draughts.models;


import org.javatuples.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class DraughtTest extends PieceTest {

    private Draught blackDraught;
    private Draught whiteDraught;

    @Before
    public void before(){
        this.blackDraught = new Draught(Color.BLACK);
        this.whiteDraught = new Draught(Color.WHITE);
        this.origin = Mockito.mock(Coordinate.class);
        this.destination = Mockito.mock(Coordinate.class);
    }

    @Override
    protected Pair<Piece, Piece> getBlackWhitePiece(){
        return new Pair(blackDraught, whiteDraught);
    }

    @Test
    public void testIsCorrectDiagonalMovement(){
      assertThat(whiteDraught.isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(2), getPair(0), origin, destination)
              , is(Error.TOO_MUCH_EATINGS));
    }

    @Test
    public void testIsCorrectDiagonalMovementJustOneEat(){
        assertNull(whiteDraught.isCorrectDiagonalMovement(this.getAmountBetweenDiagonalDistance(1), getPair(0), origin, destination));
    }

    @Test
    public void testGetCodeWhenUppercaseShouldReturnCodeInUpperCase(){
        assertThat(this.whiteDraught.getCode(),is("B"));
        assertThat(this.blackDraught.getCode(),is("N"));
    }

}