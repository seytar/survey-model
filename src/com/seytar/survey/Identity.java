package com.seytar.survey;

public class Identity<T> {
    protected T key;
    public Identity(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
