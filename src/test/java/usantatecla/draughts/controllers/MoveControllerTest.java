package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.InjectMocks;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MoveControllerTest extends  ControllerTest {

    @InjectMocks
    private MoveController moveController;

    @Test
    public void testMoveWithErrorAndGameIsBlockedShouldGoToNextState(){
        Coordinate origin = new Coordinate(2,2);
        Coordinate destination = new Coordinate(1,1);
        when(this.game.move(origin, destination)).thenReturn(Error.BAD_FORMAT);
        when(this.game.isBlocked()).thenReturn(true);
        assertThat(this.moveController.move(origin, destination),is(equalTo(Error.BAD_FORMAT)));
        verify(this.state, times(1)).next();
    }

    @Test
    public void testMoveWithErrorAndGameIsNotBlockedShouldRemainState(){
        Coordinate origin = new Coordinate(2,2);
        Coordinate destination = new Coordinate(1,1);
        when(this.game.move(origin, destination)).thenReturn(Error.BAD_FORMAT);
        when(this.game.isBlocked()).thenReturn(false);
        assertThat(this.moveController.move(origin, destination),is(equalTo(Error.BAD_FORMAT)));
        verify(this.state, never()).next();
    }

    @Test
    public void testMoveNoErrors(){
        when(this.game.move(any(Coordinate.class), any(Coordinate.class))).thenReturn(null);
        when(this.game.isBlocked()).thenReturn(false);

        assertNull(this.moveController.move(new Coordinate(2,2), new Coordinate(1,1)));
        verifyZeroInteractions(this.state);
    }

    @Test(expected = AssertionError.class)
    public void testMoveIncorrectNumberOfCoordinatesShouldReturnAssertionError(){
        this.moveController.move(new Coordinate(1,1));
    }
}
