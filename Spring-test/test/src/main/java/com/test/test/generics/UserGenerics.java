package com.test.test.generics;

public class UserGenerics<T> {
    private T info;

    public UserGenerics(T info){
        this.info = info;
    }

    public T returnInfo(T info){
        return info;
    }
}
