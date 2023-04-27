package com.names.service.controller;

import com.names.service.entity.Person;
import com.names.service.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="${client.url.allowed-origins}")
@RestController
@RequestMapping("/")
public class PersonControllerImpl implements PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("person")
    @Override
    public ResponseEntity<Person> getPersonByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(service.getPersonByName(name));
    }

    @GetMapping("person/max-age")
    @Override
    public ResponseEntity<Person> getPersonOfMaxAge() {
        return ResponseEntity.ok(service.getPersonOfMaxAge());
    }
}
