package com.names.service.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PersonRepositoryImpl implements PersonRepository{

    private final Map<String, Integer> nameStatistics = new ConcurrentHashMap<>();

    @Override
    public synchronized int getStatisticByName(String name) {

        int result = 0;

        if (this.nameStatistics.containsKey(name)){
            int stat = this.nameStatistics.get(name);
            result = ++stat;
            this.nameStatistics.replace(name, result);
        }else{
            result = 1;
            this.nameStatistics.put(name, result);
        }
        return result;
    }
}
