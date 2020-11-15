package usantatecla.draughts.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game;

    // METERLE UN BUILDER
//    private static Game game(String... rows){
//        return Game.build()
//    }

    @Before
    public void before(){
        this.game = new Game();
    }

    @Test
    public void testInitialStatus(){
        assertThat(this.game.getDimension(), is(8));
        assertThat(this.game.toString()
                , is( " 01234567\n" +
                            " 0 n n n n0\n" +
                            " 1n n n n 1\n" +
                            " 2 n n n n2\n" +
                            " 3        3\n" +
                            " 4        4\n" +
                            " 5b b b b 5\n" +
                            " 6 b b b b6\n" +
                            " 7b b b b 7\n" +
                            " 01234567\n" +
                            "\n" +
                            "WHITE"));
        assertThat(this.game.getTurnColor(), is(Color.WHITE));
    }

//    @Test
//    public void testResetWhenBlackIsPlaying(){
//        this.game.t
//        assertThat(this.game.getDimension(), is(8));
//        assertThat(this.game.toString()
//                , is(   "  01234567\n" +
//                        " 0 n n n n0\n" +
//                        " 1n n n n 1\n" +
//                        " 2 n n n n2\n" +
//                        " 3        3\n" +
//                        " 4        4\n" +
//                        " 5b b b b 5\n" +
//                        " 6 b b b b6\n" +
//                        " 7b b b b 7\n" +
//                        " 01234567\n" +
//                        "\n" +
//                        "WHITE"));
//        assertThat(this.game.getTurnColor(), is(Color.WHITE));
//    }

    @Test
    public void testGetTurnColor(){
        assertThat(this.game.getTurnColor(), is(Color.WHITE));
    }

    @Test
    public void testGetColor(){
        assertThat(this.game.getColor(Coordinate.getInstance("12")), is(Color.BLACK));
        assertThat(this.game.getColor(Coordinate.getInstance("81")), is(Color.WHITE));
    }

    @Test
    public void testGetPiece(){
       assertTrue(this.game.getPiece(Coordinate.getInstance("12")) instanceof Pawn);
       Pawn pawn = (Pawn) this.game.getPiece(Coordinate.getInstance("12"));
       assertThat(pawn.getColor(), is(Color.BLACK));
    }


    @Test
    public void testCancel(){
        this.game.cancel();
        assertThat(this.game.toString(), is(    " 01234567\n" +
                " 0 n n n n0\n" +
                " 1n n n n 1\n" +
                " 2 n n n n2\n" +
                " 3        3\n" +
                " 4        4\n" +
                " 5        5\n" +
                " 6        6\n" +
                " 7        7\n" +
                " 01234567\n\n" +
                "BLACK"));
        assertThat(this.game.getTurnColor(), is(Color.BLACK));
    }


    @Test
    public void testIsNotBlocked(){
        assertFalse(this.game.isBlocked());
    }

    @Test
    public void testMoveEmptyOrigin(){
        assertThat(this.game.move(Coordinate.getInstance("43"), Coordinate.getInstance("54")), is(Error.EMPTY_ORIGIN));
    }

    @Test
    public void testMoveOppositePiece(){
        assertThat(this.game.move(Coordinate.getInstance("12"), Coordinate.getInstance("14")), is(Error.OPPOSITE_PIECE));
    }

    @Test
    public void testMoveNotEmptyTarget(){
        assertThat(this.game.move(Coordinate.getInstance("81"), Coordinate.getInstance("72")), is(Error.NOT_EMPTY_TARGET));
    }
}
