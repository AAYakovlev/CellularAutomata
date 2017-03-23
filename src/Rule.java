public class Rule {
    private boolean left;
    private boolean midle;
    private boolean right;
    private boolean erase;  //not used

    public Rule(boolean left, boolean midle, boolean right, boolean erase) {
        this.left = left;
        this.midle = midle;
        this.right = right;
        this.erase = erase;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getMidle() {
        return midle;
    }

    public boolean getRight() {
        return right;
    }

    public boolean getErase(){
        return erase;
    }
}
