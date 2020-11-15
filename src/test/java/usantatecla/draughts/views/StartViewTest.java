package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.StartController;

import static org.mockito.Mockito.*;

public class StartViewTest extends SubViewTest {

    private static final String TITTLE = "Draughts";

    @InjectMocks
    private StartView startView;

    @Mock
    private StartController startController;

    @Mock
    private GameView gameView;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        this.startView = spy(this.startView);
    }

    @Test
    public void testInteract(){
        when(startView.createGameView()).thenReturn(this.gameView);

        this.startView.interact(this.startController);

        verify(this.console).writeln(eq(TITTLE));
        verify(this.gameView).write(eq(startController));
        verify(this.startController).start();
    }
}
