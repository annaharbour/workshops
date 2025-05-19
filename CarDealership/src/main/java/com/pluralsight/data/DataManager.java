package com.pluralsight.data;

import java.util.List;

//generic DataManager interface
public interface DataManager<T> {
//    TODO: change to multiple dealerships / contracts
    T load();
    void save(T data);
}
