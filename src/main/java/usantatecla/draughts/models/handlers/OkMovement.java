package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;
import usantatecla.draughts.models.Piece;

import java.util.List;

public class OkMovement extends MovementHandler {

    public OkMovement() {
        super(null);
    }

    @Override
    public Error check(Movement movement) {

        List<Piece> betweenDiagonalPieces =
                movement.getBoard().getBetweenDiagonalPieces(movement.getCoordinates()[movement.getPair()], movement.getCoordinates()[movement.getPair() + 1]);

        return movement.getBoard().getPiece(movement.getCoordinates()[movement.getPair()]).isCorrectMovement(betweenDiagonalPieces, movement.getPair(), movement.getCoordinates());
    }
}
