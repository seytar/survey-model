package com.seytar;

public class Identity<T> {
    protected T key;
    public Identity(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
