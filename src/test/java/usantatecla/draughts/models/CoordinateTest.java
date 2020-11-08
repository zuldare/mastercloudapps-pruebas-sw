package usantatecla.draughts.models;

import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoordinateTest {

    @Test(expected= NullPointerException.class)
    public void testIsLastWhenRowIsNotWithinDownLimit(){
        Coordinate.getInstance("00").isLast();
    }

    @Test(expected= NullPointerException.class)
    public void testIsLastWhenRowIsNotWithinUpperLimit(){
        Coordinate.getInstance("99").isLast();
    }

    @Test
    public void testIsLastWhenRowIsNotWithinLimitsButNotLast(){
        for(int i=1; i<8;i++) {
            assertThat(Coordinate.getInstance(i + "" + i).isLast(), is(Boolean.FALSE));
        }
    }

    @Test
    public void testIsLastWhenRowIsLast(){
        assertThat(Coordinate.getInstance("88").isLast(), is(Boolean.TRUE));
    }

    @Test(expected= NullPointerException.class)
    public void testIsFirstWhenRowIsNotWithinDownLimit(){
        Coordinate.getInstance("00").isFirst();
    }

    @Test(expected= NullPointerException.class)
    public void testIsFirstWhenRowIsNotWithinUpperLimit(){
        Coordinate.getInstance("99").isFirst();
    }

    @Test
    public void testIsLastWhenRowIsNotWithinLimitsButNotFirst(){
        for(int i=2; i<8;i++) {
            assertThat(Coordinate.getInstance(i + "" + i).isFirst(), is(Boolean.FALSE));
        }
    }

    @Test
    public void testIsFirstWhenRowIsFirst(){
        assertThat(Coordinate.getInstance("11").isFirst(), is(Boolean.TRUE));
    }

    @Test
    public void testIsBlackRowColIsWhitePosition(){
        for(int row=1; row<=8; row=row+2){
            for (int col=1; col<=8; col=col+2){
                assertThat(Coordinate.getInstance(row+""+col).isBlack(), is(Boolean.FALSE));
            }
        }
    }

    @Test
    public void testIsBlackRowColIsBlackPosition(){
        for(int row=2; row<=8; row=row+2){
            for (int col=2; col<=8; col=col+2){
                assertThat(Coordinate.getInstance(row+""+col).isBlack(), is(Boolean.FALSE));
            }
        }
    }

    @Test
    public void testGetInstanceIsOutOfRange(){
        for(String input: Arrays.asList("00", "09", "90", "09")){
            assertNull(Coordinate.getInstance(input));
        }
    }

    @Test
    public void testGetInstanceIsWithInRange(){
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
    public void testGetInstanceWhenInputIsNotIntegerParseable(){
        assertNull(Coordinate.getInstance("ua"));
    }

    @Test
    public void testDiagonalDirectionsAreOk(){
        List<Triplet<Coordinate, Coordinate, Direction>> originDestinationExpectedDirectionList = Arrays.asList(
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("15"), Direction.SE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("22"), Direction.SW),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("42"), Direction.NW),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("66"), Direction.NE)
        );

        for(Triplet<Coordinate, Coordinate, Direction> triplet: originDestinationExpectedDirectionList){
            assertThat(triplet.getValue0().getDirection(triplet.getValue1()), is(triplet.getValue2()));
        }
    }

    @Test
    public void testHorizontalVerticalDirectionsAreErrors(){
        List<Triplet<Coordinate, Coordinate, Direction>> originDestinationExpectedDirectionList = Arrays.asList(
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("23"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("32"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("43"), null),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("34"), null)
        );

        for(Triplet<Coordinate, Coordinate, Direction> triplet: originDestinationExpectedDirectionList){
            assertThat(triplet.getValue0().getDirection(triplet.getValue1()), is(triplet.getValue2()));
        }
    }

    @Test
    public void testIsOnDiagonal(){
        List<Triplet<Coordinate, Coordinate, Boolean>> originDestinationExpectedDirectionList = Arrays.asList(
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("15"), Boolean.TRUE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("22"), Boolean.TRUE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("42"), Boolean.TRUE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("66"), Boolean.TRUE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("23"), Boolean.FALSE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("32"), Boolean.FALSE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("43"), Boolean.FALSE),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("34"), Boolean.FALSE)
        );

        originDestinationExpectedDirectionList
                .forEach(triplet -> assertThat(triplet.getValue0().isOnDiagonal(triplet.getValue1()), is(triplet.getValue2())));
    }

    @Test(expected= AssertionError.class)
    public void testDiagonalDistanceWhenNotInDiagonalShouldFail(){
        Coordinate.getInstance("33").getDiagonalDistance(Coordinate.getInstance("99"));
    }

    @Test
    public void testDiagonalDistanceWhenInDiagonalOutside(){
        List<Triplet<Coordinate, Coordinate, Integer>> originDestinationExpectedDistance = Arrays.asList(
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("66"), 3),
                new Triplet<>(Coordinate.getInstance("33"), Coordinate.getInstance("11"), 2)
        );

        originDestinationExpectedDistance
                .forEach(triplet -> assertThat(triplet.getValue0().getDiagonalDistance(triplet.getValue1()), is(triplet.getValue2())));
    }

    @Test(expected = AssertionError.class)
    public void testGetBetweenDiagonalCoordinatesWhenIsNotOnDiagonal(){
        Coordinate.getInstance("33").getBetweenDiagonalCoordinates(Coordinate.getInstance("23"));
    }

    @Test(expected = AssertionError.class)
    public void testGetBetweenDiagonalSameCoordinate(){
        Coordinate.getInstance("77").getBetweenDiagonalCoordinates(Coordinate.getInstance("77"));
    }

    @Test
    public void testGetBetweenDiagonalMainLeftDiagonal(){
        List<Coordinate> coordinatesBetween = Coordinate.getInstance("11").getBetweenDiagonalCoordinates(Coordinate.getInstance("88"));
        assertNotNull(coordinatesBetween);
        assertThat(coordinatesBetween.size(), is(6));

        int rowCol = 1;
        for (int i=0; i < coordinatesBetween.size(); i++){
            rowCol++;
            assertThat(coordinatesBetween.get(i).toString(), is(Coordinate.getInstance(rowCol + "" + rowCol).toString()));
        }
    }

    @Test
    public void testGetDiagonalCoordinatesLevelGreaterThanBoardLimit(){
        assertThat(Coordinate.getInstance("11").getDiagonalCoordinates(60).size(), is(0));
    }

    @Test
    public void testGetDiagonalCoordinateInLeftUpperCornerShouldReturnOneCoordinate(){
        for(int level=1; level<8; level++){
            assertThat(Coordinate.getInstance("11").getDiagonalCoordinates(level).get(0), is(Coordinate.getInstance( (level+1) + "" + (level+1))));
        }
    }

    @Test
    public void testGetDiagonalCoordinateInRightUpperCornerShouldReturnOneCoordinate(){
        int row = 1;
        int col = 8;
        for(int level=1; level<8; level++){
            assertThat(Coordinate.getInstance("18").getDiagonalCoordinates(level).get(0), is(Coordinate.getInstance( (row + level) + "" + (col - level))));
        }
    }

    @Test
    public void testGetDiagonalCoordinateInLeftDownCornerShouldReturnOneCoordinate(){
        int row = 8;
        int col = 1;
        for(int level=1; level<8; level++){
            assertThat(Coordinate.getInstance("81").getDiagonalCoordinates(level).get(0), is(Coordinate.getInstance( (row - level) + "" + (col + level))));
        }
    }

    @Test
    public void testGetDiagonalCoordinateInRightDownCornerShouldReturnOneCoordinate(){
        int row = 8;
        int col = 8;
        for(int level=1; level<8; level++){
            assertThat(Coordinate.getInstance("88").getDiagonalCoordinates(level).get(0), is(Coordinate.getInstance( (row - level) + "" + (col - level))));
        }
    }

    //TODO is good to  to check this possibilities
    @Test
    public void testGetDiagonalCoordinateWithin_RowTwoColTwo_RowSeven_ColSeven_ShouldReturnFourCoordinates() {
        for (int row = 2; row < 8; row++) {
            for (int col = 2; col < 8; col++) {
                List<Coordinate> coordinatesInDiagonal = Coordinate.getInstance(row + "" + col).getDiagonalCoordinates(1);

                List<String> coordinatesInDiagonalString = coordinatesInDiagonal.stream()
                        .map(coordinate -> coordinate.toString())
                        .collect(Collectors.toList());
                coordinatesInDiagonalString.contains(Coordinate.getInstance((row - 1) + "" + (col - 1)).toString());
                coordinatesInDiagonalString.contains(Coordinate.getInstance((row - 1) + "" + (col + 1)).toString());
                coordinatesInDiagonalString.contains(Coordinate.getInstance((row + 1) + "" + (col - 1)).toString());
                coordinatesInDiagonalString.contains(Coordinate.getInstance((row + 1) + "" + (col + 1)).toString());
            }
        }
    }
}
