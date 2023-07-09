package com.example.jpapaging.controller;

import com.example.jpapaging.model.Person;
import com.example.jpapaging.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    //method required for pagination
    @GetMapping()
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size) {
        PageRequest pr = PageRequest.of(page,size);
        return repository.findAll(pr);
    }


    //methods required for sorting//
    @GetMapping("/sorted/lastName")
    public Iterable<Person> findAllSorted() {
        return repository.findAll(Sort.by(Sort.Direction.ASC,
                "lastName"));
    }

    @GetMapping("/sorted/firstName")
    public Iterable<Person> findAllSortedByFirstName() {
        return repository.findAll(Sort.by(Sort.Direction.ASC,
                "firstName"));
    }

}
