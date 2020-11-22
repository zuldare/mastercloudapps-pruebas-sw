package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ResumeViewTest extends SubViewTest {

    @Mock
    private YesNoDialog yesNoDialog;

    private ResumeController resumeController;

    @InjectMocks
    private ViewForTesting view;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        resumeController = spy(resumeControllerBuilder());
    }

    private ResumeController resumeControllerBuilder(){
        return new ResumeController(new Game(), new State());
    }


    @Test
    public void testResetGame() {
        when(this.yesNoDialog.read(anyString())).thenReturn(true);
        view.interact(resumeController);
        verify(resumeController).reset();
        verify(resumeController, never()).next();
    }

    @Test
    public void testFinishGame() {
        when(this.yesNoDialog.read(anyString())).thenReturn(false);
        view.interact(resumeController);
        verify(resumeController).next();
        verify(resumeController, never()).reset();
    }
}
