package usantatecla.draughts.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @Mock
    protected Game game;

    @Mock
    protected State state;

    @InjectMocks
    private Controller controller;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetDimension(){
        when(game.getDimension()).thenReturn(getDimension(7));
        assertThat(controller.getDimension(), is(equalTo(getDimension(7))));
    }

    private Integer getDimension(int dimension) {
        return dimension;
    }
}
