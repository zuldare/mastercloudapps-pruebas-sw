package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Board;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;

public class NotEmptyOrigin extends MovementHandler {

    public NotEmptyOrigin(MovementHandler nextMovementHandler) {
        super(nextMovementHandler);
    }

    @Override
    public Error check(Movement movement) {
        if (movement.getBoard().isEmpty(movement.getCoordinates()[movement.getPair()]))
            return Error.EMPTY_ORIGIN;
        return this.next(movement);
    }
}
