package com.names.service.service;

import com.names.service.entity.Person;

public interface PersonService {
    public Person getPersonByName(String name);
    public Person getPersonOfMaxAge();
}
