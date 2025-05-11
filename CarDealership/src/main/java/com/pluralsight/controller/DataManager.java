package com.pluralsight.controller;

//generic DataManager interface
public interface DataManager<T> {
    T load();

    void save(T data);
}
