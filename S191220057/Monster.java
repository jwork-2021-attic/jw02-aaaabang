package S191220057;

import S191220057.Line.Position;

public class Monster implements Linable {


    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int rank = 0;
    private Position position;


    public void setMonster(int r, int g, int b,int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank = rank;
    }

    // public static Monster getMonsterByRank(int rank) {

    //     for (Monster Monster : Monster.values()) {
    //         if (Monster.rank == rank) {
    //             return Monster;
    //         }
    //     }
    //     return null;

    // }


    @Override
    public String toString() {
        String s = Integer.toString(this.rank);
        if(s.length()<2)
        {
            if(s.length()==1) 
            {
                s = s + " ";
            }
            else
            {
                s = s + " ";
            }
        }
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m"+" "+ this.rank + "\033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void swapPosition(Linable another) {
        Position p = another.getPosition();
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank;
    }

}