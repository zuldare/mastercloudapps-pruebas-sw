package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ViewTest {

    private static final String MESSAGE_START_TITTLE = "Draughts";
    private static final String MESSAGE_RESUME = "¿Queréis jugar otra";

    @Mock
    private YesNoDialog yesNoDialog;

    @Mock
    private Console console;

    @Mock
    private ResumeController resumeController;

    @InjectMocks
    private ViewForTesting view;

    private InteractorControllerBuilder interactorControllerBuilder;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        this.interactorControllerBuilder = new InteractorControllerBuilder();
    }

    private ResumeController resumeControllerBuilder(){
        return new ResumeController(new Game(), new State());
    }

    @Test
    public void testInteract(){
        usantatecla.draughts.controllers.InteractorController controller = mock(usantatecla.draughts.controllers.InteractorController.class);
        view.interact(controller);
        verify(controller).accept(eq(view));
    }

    @Test
    public void testVisitStartController(){
        view.visit(interactorControllerBuilder.startController);
        verify(console).writeln(eq(MESSAGE_START_TITTLE));
    }


    @Test
    public void testVisitResumeController(){
        view.visit(interactorControllerBuilder.resumeController);
        verify(yesNoDialog, times(1)).read(eq(MESSAGE_RESUME));
    }

    @Test
    public void testResetGame() {
        resumeController = spy(resumeControllerBuilder());

        when(this.yesNoDialog.read(anyString())).thenReturn(true);
        view.interact(resumeController);
        verify(resumeController).reset();
        verify(resumeController, never()).next();
    }

    @Test
    public void testFinishGame() {
        resumeController = spy(resumeControllerBuilder());

        when(this.yesNoDialog.read(anyString())).thenReturn(false);
        view.interact(resumeController);
        verify(resumeController).next();
        verify(resumeController, never()).reset();
    }
}


