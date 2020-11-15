package usantatecla.draughts.controllers;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ResumeControllerTest extends InteractorControllerTest {

    @InjectMocks
    private ResumeController resumeController;

    @Test
    public void testNext(){
        resumeController.next();
        verify(state).next();
    }

    @Test
    public void testReset(){
        resumeController.reset();
        verify(this.state).reset();
        verify(this.game).reset();
    }

    @Test
    public void testAcceptControllerVisitor(){
        resumeController.accept(this.interactorControllersVisitor);
        verify(this.interactorControllersVisitor).visit(eq(resumeController));
    }
}
