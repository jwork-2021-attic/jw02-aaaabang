package S191220057;

import S191220057.Line.Position;

public interface Linable {

    
    public void setPosition(Position position);

    public Position getPosition();

    public int getValue();

    public void swapPosition(Linable another);
}