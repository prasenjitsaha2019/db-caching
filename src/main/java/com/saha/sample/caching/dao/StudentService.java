package com.saha.sample.caching.dao;

import org.springframework.stereotype.Service;

@Service
public interface StudentService<T> {

    T get(String key);

    void put(T object);
    
}
