package com.pluralsight.data;

//generic DataManager interface
public interface DataManager<T> {
    T load();

    void save(T data);
}
