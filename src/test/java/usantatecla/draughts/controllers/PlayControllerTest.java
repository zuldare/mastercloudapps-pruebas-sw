package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayControllerTest extends InteractorControllerTest {

    @InjectMocks
    private PlayController playController;

    @Test
    public void testAcceptControllerVisitor(){
        playController.accept(this.interactorControllersVisitor);
        verify(this.interactorControllersVisitor).visit(eq(playController));
    }

    @Test
    public void testGetColor(){
        playController.getColor();
        verify(this.game, times(1)).getTurnColor();
    }

    @Test
    public void testIsBlocked(){
        playController.isBlocked();
        verify(this.game,times(1)).isBlocked();
    }
}
