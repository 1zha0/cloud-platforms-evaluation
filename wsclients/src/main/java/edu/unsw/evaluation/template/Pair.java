package edu.unsw.evaluation.template;

/**
 *
 * @author shrimpy
 */
public class Pair<N, V> {

    private N name;
    private V value;

    public Pair(N name, V value) {
        this.name = name;
        this.value = value;
    }

    public N getName() {
        return name;
    }

    public void setName(N key) {
        this.name = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
