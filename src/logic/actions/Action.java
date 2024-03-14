package Actions;

public abstract class Action {
    protected String name;

    public Action(String name) {
        this.name = name;
    }

    abstract void execute(Character character);
}
