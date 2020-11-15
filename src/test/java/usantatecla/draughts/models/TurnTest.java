package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TurnTest {

    private static Color initialColor = Color.WHITE;
    private Turn turn;

    @Before
    public void before(){
        this.turn = new Turn();
    }

    @Test
    public void testInitialColorIsOk() {
        assertThat(this.turn.getColor(), is(initialColor));
    }

    @Test
    public void testGetOppositeColorIsOk(){

        assertThat(this.turn.getColor(), is(initialColor));
        assertThat(this.turn.getOppositeColor(), not(initialColor));
    }

    @Test
    public void testChangeColorIsOk(){
        turn.change();
        assertThat(turn.getColor(), not(initialColor));
    }
}