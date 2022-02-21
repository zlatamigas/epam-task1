package epam.zlatamigas.customarray.entity;

import epam.zlatamigas.customarray.observer.CustomArrayEvent;
import epam.zlatamigas.customarray.observer.CustomArrayObservable;
import epam.zlatamigas.customarray.observer.CustomArrayObserver;

import java.util.*;

public class CustomArray extends AbstractArray implements CustomArrayObservable {

    private int[] array;

    private List<CustomArrayObserver> observers = new ArrayList<>();

    public CustomArray(int id, int... array) {
        super(id);
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int... array) {
        this.array = array.clone();
        notifyObservers();
    }

    public int getSize(){
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("CustomArray ");
        sb.append("#").append(id).append(' ')
                .append(Arrays.toString(array));

        return sb.toString();
    }

    @Override
    public void attach(CustomArrayObserver observer) {
        if(observer!=null){
            observers.add(observer);
        }
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        if(observer!=null && observers.size()!=0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {

        CustomArrayEvent event = new CustomArrayEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
    }
}
