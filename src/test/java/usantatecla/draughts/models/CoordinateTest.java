package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getInstanceIsOutOfRange(){
        List<Pair<String, Coordinate>> inputExpectedOutputResults = new ArrayList();
        inputExpectedOutputResults.add(new Pair<>("00", null));
        inputExpectedOutputResults.add(new Pair<>("09", null));
        inputExpectedOutputResults.add(new Pair<>("90", null));
        inputExpectedOutputResults.add(new Pair<>("09", null));

        for(Pair<String, Coordinate> pair: inputExpectedOutputResults){
            assertThat(Coordinate.getInstance(pair.getValue0()), is(pair.getValue1()));
        }
    }

    @Test
    public void getInstanceIsWithInRange(){
        List<Pair<String, Coordinate>> inputExpectedOutputResults = new ArrayList();
        inputExpectedOutputResults.add(new Pair<>("13", new Coordinate(0,2)));
        inputExpectedOutputResults.add(new Pair<>("88", new Coordinate(7,7)));
        inputExpectedOutputResults.add(new Pair<>("13", new Coordinate(0,2)));
        inputExpectedOutputResults.add(new Pair<>("61", new Coordinate(5,0)));

        for(Pair<String, Coordinate> pair: inputExpectedOutputResults){
            assertThat(Coordinate.getInstance(pair.getValue0()), is(pair.getValue1()));
        }
    }

}