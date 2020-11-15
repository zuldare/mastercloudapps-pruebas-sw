package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class StartControllerTest extends InteractorControllerTest {

    @InjectMocks
    private StartController startController;

    @Test
    public void testStart(){
        startController.start();
        verify(state).next();
    }

    @Test
    public void testAcceptControllerVisitor(){
        startController.accept(this.interactorControllersVisitor);
        verify(this.interactorControllersVisitor).visit(eq(startController));
    }
}
