package usantatecla.draughts.models.handlers;

import usantatecla.draughts.models.Error;
import usantatecla.draughts.models.Movement;

public class MovementChecker {

    private final MovementHandler movementHandler;

    public MovementChecker() {
        MovementHandler okMovement = new OkMovement();
        MovementHandler notEmptyTarget = new NotEmptyTarget(okMovement);
        MovementHandler oppositePiece = new OppositePieceMovement(notEmptyTarget);
        this.movementHandler = new NotEmptyOrigin(oppositePiece);
    }

    public Error check(Movement movement){
        return this.movementHandler.check(movement);
    }

}
