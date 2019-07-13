package com.saha.sample.caching.service;

public interface Service <T> {

    T get(String key);

    void put(String key, T value);

}
