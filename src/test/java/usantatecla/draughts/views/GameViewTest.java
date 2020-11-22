package usantatecla.draughts.views;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.Console;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.spy;

public class GameViewTest extends SubViewTest {

    // USING https://www.baeldung.com/java-testing-system-out-println in order to mock/capture System output console
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private StartController startController;

    @Spy
    private Console console;

    @InjectMocks
    private ViewForTesting view;

    @Before
    public void beforeGameView() {
        //In order to reassign the standard output stream
        System.setOut(new PrintStream(outputStreamCaptor));

        MockitoAnnotations.initMocks(this);
        startController = spy(this.startControllerBuilder());
    }

    public StartController startControllerBuilder(){
        return new StartController(new Game(), new State());
    }

    // IMPORTANT: Restore standart output to original state
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testBoard() {

        String board =
                " 12345678\n" +
                "1 n n n n1\n" +
                "2n n n n 2\n" +
                "3 n n n n3\n" +
                "4        4\n" +
                "5        5\n" +
                "6b b b b 6\n" +
                "7 b b b b7\n" +
                "8b b b b 8\n" +
                " 12345678\n";

        this.view.writeGame(startController);
        assertThat(board, is(equalTo(outputStreamCaptor.toString())));
    }
}
