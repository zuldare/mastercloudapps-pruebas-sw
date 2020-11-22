package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;

public class OppositePieceMovement extends MovementHandler {
    public OppositePieceMovement(MovementHandler nextMovementHandler) {
        super(nextMovementHandler);
    }

    @Override
    public Error check(Movement movement) {
        if (movement.getTurn().getOppositeColor() == movement.getBoard().getColor(movement.getCoordinates()[movement.getPair()]))
            return Error.OPPOSITE_PIECE;
        return this.next(movement);
    }


}
