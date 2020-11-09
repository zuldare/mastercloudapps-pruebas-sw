package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public abstract class PieceTest {

    protected Coordinate origin;
    protected Coordinate destination;

    protected abstract Pair<Piece, Piece> getBlackWhitePiece();

    @Test
    public void testIsLimitWhenIsLastAndBlackPiece(){
        when(destination.isFirst()).thenReturn(false);
        when(destination.isLast()).thenReturn(true);
        assertTrue(getBlackWhitePiece().getValue0().isLimit(destination));
    }

    @Test
    public void testIsLimitWhenIsNotLastAndWhitePiece(){
        when(destination.isFirst()).thenReturn(false);
        when(destination.isLast()).thenReturn(false);
        assertFalse(getBlackWhitePiece().getValue0().isLimit(destination));
    }

    @Test
    public void testIsLimitWhenIsNotFirstAndWhitePiece(){
        when(destination.isFirst()).thenReturn(false);
        assertFalse(getBlackWhitePiece().getValue1().isLimit(destination));
    }

    @Test
    public void testIsLimitWhenIsFirstAndWhitePiece(){
        when(destination.isFirst()).thenReturn(true);
        assertTrue(getBlackWhitePiece().getValue1().isLimit(destination));
    }


    @Test
    public void isAdvancedOriginFromTargetWhitePieceShouldReturnTrue(){
        when(this.origin.getRow()).thenReturn(5);
        when(this.destination.getRow()).thenReturn(4);

        assertTrue(this.getBlackWhitePiece().getValue1().isAdvanced(this.origin, this.destination));
    }

    @Test
    public void isAdvancedOriginFromTargetFalseWhitePieceShouldReturnFalse(){
        when(this.origin.getRow()).thenReturn(4);
        when(this.destination.getRow()).thenReturn(5);

        assertFalse(this.getBlackWhitePiece().getValue1().isAdvanced(this.origin, this.destination));
    }

    @Test
    public void isAdvancedOriginFromTargetBlackPieceShouldReturnFalse(){
        when(this.origin.getRow()).thenReturn(4);
        when(this.destination.getRow()).thenReturn(5);

        assertFalse(this.getBlackWhitePiece().getValue1().isAdvanced(origin,destination));
    }

    @Test
    public void isAdvancedTargetFromOriginBlackPieceShouldReturnTrue(){
        when(this.origin.getRow()).thenReturn(5);
        when(this.destination.getRow()).thenReturn(4);

        assertTrue(this.getBlackWhitePiece().getValue1().isAdvanced(origin,destination));
    }

    protected int getAmountBetweenDiagonalDistance(int amountBetweenDiagonalPieces){
        return amountBetweenDiagonalPieces;
    }

    protected int getPair(int pair){
        return pair;
    }
}