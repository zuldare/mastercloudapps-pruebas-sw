package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ViewTest {

    @Mock
    private StartView startView;

    @Mock
    private PlayView playView;

    @Mock
    private ResumeView resumeView;

    @InjectMocks
    private View view;

    private InteractorControllerBuilder interactorControllerBuilder;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        this.interactorControllerBuilder = new InteractorControllerBuilder();
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
        verify(startView).interact(eq(interactorControllerBuilder.startController));
        verifyZeroInteractions(playView);
        verifyZeroInteractions(resumeView);
    }

    @Test
    public void testVisitPlayController(){
        view.visit(interactorControllerBuilder.playController);
        verify(playView).interact(eq(interactorControllerBuilder.playController));
        verifyZeroInteractions(startView);
        verifyZeroInteractions(resumeView);
    }

    @Test
    public void testVisitResumeController(){
        view.visit(interactorControllerBuilder.resumeController);
        verify(resumeView).interact(eq(interactorControllerBuilder.resumeController));
        verifyZeroInteractions(startView);
        verifyZeroInteractions(playView);
    }
}

