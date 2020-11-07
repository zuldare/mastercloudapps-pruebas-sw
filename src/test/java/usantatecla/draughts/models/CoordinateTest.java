package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getInstanceIsOutOfRange(){
        for(String input: Arrays.asList("00", "09", "90", "09")){
            assertNull(Coordinate.getInstance(input));
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

    @Test
    public void getInstanceWhenInputIsNotIntegerParseable(){
        assertNull(Coordinate.getInstance("ua"));
    }


    @Test
    public void testDirections(){

        List<Triplet<Coordinate, Coordinate, Direction>> originDestinationExpectedDirectionList = Arrays.asList(
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("15"), Direction.SE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("22"), Direction.SW),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("42"), Direction.NW),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("66"), Direction.NE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("23"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("32"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("43"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("34"), null)
        );

        for(Triplet<Coordinate, Coordinate, Direction> triplet: originDestinationExpectedDirectionList){
            assertThat(triplet.getValue0().getDirection(triplet.getValue1()), is(triplet.getValue2()));
        }
    }

}