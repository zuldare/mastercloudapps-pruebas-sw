package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DirectionTest {

    /*
              SW(-1,-1)              SE(-1,1)
              (2,2)                  (2,4)
                         (3,3)
              (4,2)                  (4,4)
              NW(1,-1)               NE(1,1)
     */
    @Test
    public void testIsOnNEDirectionWhenRowIsZero() {
        assertThat(Direction.NE.isOnDirection(Coordinate.getInstance("11")), is(Boolean.FALSE));
        assertThat(Direction.NW.isOnDirection(Coordinate.getInstance("11")), is(Boolean.FALSE));
        assertThat(Direction.SW.isOnDirection(Coordinate.getInstance("11")), is(Boolean.FALSE));
        assertThat(Direction.SE.isOnDirection(Coordinate.getInstance("11")), is(Boolean.FALSE));
    }


    @Test
    public void testAllDirectionsWhenRowNotEqualsColShouldReturnFalse(){
        for(int row=1; row<=8;row++){
            for(int col=1; col<=8; col++){
                if (row != col) {
                    assertThat(Direction.NE.isOnDirection(Coordinate.getInstance(row+""+col)), is(Boolean.FALSE));
                    assertThat(Direction.NW.isOnDirection(Coordinate.getInstance(row+""+col)), is(Boolean.FALSE));
                    assertThat(Direction.SW.isOnDirection(Coordinate.getInstance(row+""+col)), is(Boolean.FALSE));
                    assertThat(Direction.SE.isOnDirection(Coordinate.getInstance(row+""+col)), is(Boolean.FALSE));
                }
            }
        }
    }

    @Test
    public void testIsOnDirectionWhenDirectionFacesHorizontalDiagonalShouldReturnFalse(){
        assertThat(Direction.SW.isOnDirection(Coordinate.getInstance("33")), is(Boolean.FALSE));
        assertThat(Direction.SE.isOnDirection(Coordinate.getInstance("33")), is(Boolean.FALSE));
    }

    @Test
    public void testIsOnDirectionWhenDirectionFacesVerticalLeft(){
        assertThat(Direction.NW.isOnDirection(Coordinate.getInstance("33")), is(Boolean.FALSE));
    }

    @Test
    public void testIsOnDirectionOK(){
        assertThat(Direction.NE.isOnDirection(Coordinate.getInstance("33")), is(Boolean.TRUE));
    }



    @Test
    public void getDistanceCoordinate() {
    }
}