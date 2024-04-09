package Characters;

public abstract class Character {

    private int hp;
    private int atk;
    private int def;
    private int mat;
    private int mdf;

    public Character(int hp, int atk, int def, int mat, int mdf) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mat = mat;
        this.mdf = mdf;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getMdf() {
        return mdf;
    }

    public void setMdf(int mdf) {
        this.mdf = mdf;
    }
}
