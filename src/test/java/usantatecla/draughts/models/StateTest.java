package usantatecla.draughts.models;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StateTest {

    private static List<StateValue> stateValues;

    @BeforeClass
    public static void initializeConditions(){
        stateValues = new ArrayList<>();
        stateValues.add(StateValue.INITIAL);
        stateValues.add(StateValue.IN_GAME);
        stateValues.add(StateValue.FINAL);
        stateValues.add(StateValue.EXIT);
    }


    @Test
    public void resetObjectJustCreatedIsInitial() {
        assertThat((new State()).getValueState(), is(stateValues.get(0)));
    }

    @Test
    public void nextReturnsProperOrder(){
        State state = new State();
        for(int stateOrder=0; stateOrder < stateValues.size()-1; stateOrder++){
            assertThat(state.getValueState(), is(stateValues.get(stateOrder)));
            state.next();
        }
    }


    @Test
    public void resetObjectReturnsInitialState(){
        State state = new State();
        state.next();
        assertThat(state.getValueState(), is(stateValues.get(1)));
    }


}