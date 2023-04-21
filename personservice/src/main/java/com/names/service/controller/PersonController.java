package com.names.service.controller;

import com.names.service.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonController {
    public ResponseEntity<Person> getPersonByName(@RequestParam String name);
    public ResponseEntity<Person> getPersonOfMaxAge();
}
