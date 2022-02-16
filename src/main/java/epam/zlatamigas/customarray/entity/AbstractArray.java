package epam.zlatamigas.customarray.entity;

public abstract class AbstractArray {

    protected int id;

    public AbstractArray(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
