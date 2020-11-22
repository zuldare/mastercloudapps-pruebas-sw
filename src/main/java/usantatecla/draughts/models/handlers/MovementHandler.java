package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;

public abstract class MovementHandler {

    private final MovementHandler nextMovementHandler;

    public MovementHandler(MovementHandler nextMovementHandler) {
        this.nextMovementHandler = nextMovementHandler;
    }

    public Error next(Movement movement) {
        return this.nextMovementHandler.check(movement);
    }

    public abstract Error check(Movement movement);
}
