package com.pluralsight.dealership.dao;

//generic DataManager interface
public interface DataManager<T> {
//    TODO: change to multiple dealerships / contracts
    T load();
    void save(T data);
}
