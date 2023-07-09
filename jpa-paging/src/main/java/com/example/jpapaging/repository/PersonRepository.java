package com.example.jpapaging.repository;

import com.example.jpapaging.model.Person;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {


}
