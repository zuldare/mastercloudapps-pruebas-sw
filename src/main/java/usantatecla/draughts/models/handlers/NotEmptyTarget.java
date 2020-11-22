package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;

public class NotEmptyTarget extends MovementHandler {
    public NotEmptyTarget(MovementHandler nextMovementHandler) {
        super(nextMovementHandler);
    }

    @Override
    public Error check(Movement movement) {
        if (! movement.getBoard().isEmpty(movement.getCoordinates()[movement.getPair() +1 ]))
            return Error.NOT_EMPTY_TARGET;
        return this.next(movement);
    }
}
