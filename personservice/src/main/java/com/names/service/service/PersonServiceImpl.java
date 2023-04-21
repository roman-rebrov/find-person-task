package com.names.service.service;

import com.names.service.entity.Person;
import com.names.service.exception.ServerErrorException;
import com.names.service.repository.PersonRepository;
import com.names.service.util.LineFinder;
import com.names.service.util.MathHandlers;
import com.names.service.request.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;


    @Override
    public Person getPersonByName(String name) {

        Person person = null;

        String line = LineFinder.findLineByName(name);

        if (line == null) {

            final Request<Person> request = new Request<>(Person.class);
            request.sendRequest(Request.AGIFY_IO_NAME_URL, name);
            person = request.fromJson();

        } else {

            String[] separatedLine = line.split("_");
            int stat = repository.getStatisticByName(name);
            int age = Integer.parseInt(separatedLine[1]);
            person = new Person(name, age, stat);

        }

        if(person == null){
            throw new ServerErrorException("Server error");
        }else{
            if (person.getAge() < 1){
                int randomAge = MathHandlers.getRandom(1, 100);
                person.setAge(randomAge);
                int stat = repository.getStatisticByName(person.getName());
                person.setCount(stat);
            }
        }

        return person;
    }

    @Override
    public Person getPersonOfMaxAge() {


        Person person = null;
        String line = LineFinder.findMaxAge();


        if (line != null) {

            String[] data = line.split("_");
            String name = data[0];

            int age = Integer.parseInt(data[1]);
            int stat = repository.getStatisticByName(name);
            person = new Person(name, age, stat);

        }

        return person;
    }
}
