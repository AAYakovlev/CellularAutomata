public class Field {

    private int[][] field;
    private int xSize;
    private int ySize;

    public Field(int xSize, int ySize) {
        field = new int[xSize][ySize];
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public boolean apply(int x, int y, Rule r) {
        boolean fLeft;
        int sampleY = y;
        if (y == 0) {
            sampleY = this.ySize-1;
        }
        if (x == 0) {
            fLeft = field[this.xSize-1][sampleY - 1] > 0;
        } else {
            fLeft = field[x - 1][sampleY - 1] > 0;
        }

        boolean fMid = field[x][sampleY - 1] > 0;

        boolean fRight;
        if (x == this.xSize-1) {
            fRight = field[0][sampleY - 1] > 0;
        } else {
            fRight = field[x + 1][sampleY - 1] > 0;
        }
        if (r.getLeft() == fLeft && r.getMidle() == fMid && r.getRight() == fRight) {
            if(r.getErase())
                field[x][y]=0;
            else
                field[x][y]++;
            return true;
        } else return false;
    }

    public int getValue(int x, int y){
        return field[x][y];
    }

    public void setValue(int x, int y, int v){
        field[x][y] = v;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
