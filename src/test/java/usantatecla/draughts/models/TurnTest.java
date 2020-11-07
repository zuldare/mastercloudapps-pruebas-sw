package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TurnTest {

    private static Color initialColor = Color.WHITE;

    @Test
    public void testInitialColorIsOk() {
        assertThat(new Turn().getColor(), is(initialColor));
    }

    @Test
    public void testGetOppositeColorIsOk(){
        Turn initialTurn = new Turn();
        assertThat(initialTurn.getColor(), is(initialColor));
        assertThat(initialTurn.getOppositeColor(), not(initialColor));
    }

    @Test
    public void testChangeColorIsOk(){
        Turn turn = new Turn();
        turn.change();
        assertThat(turn.getColor(), not(initialColor));
    }
}