package com.pluralsight.data;

import java.util.List;

//generic DataManager interface
public interface DataManager<T> {
    T load();
    void save(T data);
}
