package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CancelControllerTest extends ControllerTest {

    @InjectMocks
    private CancelController cancelController;

    @Test
    public void testCancel(){
        cancelController.cancel();
        verify(this.game, times(1)).cancel();
        verify(this.state, times(1)).next();
    }

}
