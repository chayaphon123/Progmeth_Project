package Effects;

public class Buff extends Effect{
    private int atkBoost;
    private int matBoost;

    public Buff(int atkBoost, int matBoost) {
        this.atkBoost = atkBoost;
        this.matBoost = matBoost;
    }

    public int getAtkBoost() {
        return atkBoost;
    }

    public void setAtkBoost(int atkBoost) {
        this.atkBoost = atkBoost;
    }

    public int getMatBoost() {
        return matBoost;
    }

    public void setMatBoost(int matBoost) {
        this.matBoost = matBoost;
    }
}
