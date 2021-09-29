package S191220057;

public class Matrix {
    private Position[] positions;
    final int col;
    final int row;

    public Matrix(int col,int row) {
        this.positions = new Position[col*row];
        this.col = col;
        this.row = row;
    }

    

    public void put(Linable linable, int i) {
        //找到一个空位置放入妖怪
        while (this.positions[i] != null) {
            i = (i+1) % positions.length;
        }
        this.positions[i] = new Position(null);
        this.positions[i].setLinable(linable);
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String matrixString = "\t";
        for (int i = 0; i<this.row; ++i) 
        {
            for(int j = 0; j< this.col; ++j)
            {
                Position p = positions[i*col+j];
                matrixString += p.linable.toString();//即Monster的toString,一块彩色的打印
            }
            matrixString += "\n";
            matrixString += "\t";
        }
        return matrixString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }


}
