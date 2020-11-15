package usantatecla.draughts.models;

enum Direction {

    //TODO ARE THIS NAMES CORRECT???
    /*
              SW(-1,-1)              SE(-1,1)
              (2,2)                  (2,4)
                         (3,3)
              (4,2)                  (4,4)
              NW(1,-1)               NE(1,1)


     */

    NE(1, 1),
    SE(-1, 1), 
    SW(-1, -1), 
    NW(1, -1);


    private int horizontalShift;
    private int verticalShift;
    
    private Direction(int horizontalShift, int verticalShift) {
        this.horizontalShift = horizontalShift;
        this.verticalShift = verticalShift;
    }

    public boolean isOnDirection(Coordinate coordinate) {
        if (Math.abs(coordinate.getRow()) != Math.abs(coordinate.getColumn())) 
            return false;
        if (coordinate.getRow()==0)
            return false;
        if (horizontalShift * coordinate.getRow() < 0) 
            return false;
        if (verticalShift * coordinate.getColumn() < 0) 
            return false;
        return true;
    }
    
    Coordinate getDistanceCoordinate(int distance) {
        int row = this.horizontalShift * distance;
        int column = this.verticalShift * distance;
        return new Coordinate(row, column);
    }

}