package com.example.jpapaging.data;

import com.example.jpapaging.model.Address;
import com.example.jpapaging.model.Person;
import com.example.jpapaging.repository.PersonRepository;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//spring manages this class for us
@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository repository;
    private final Faker faker;//Faker is used to load fake data

    public SampleDataLoader(PersonRepository repository, Faker faker) {
        this.repository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading sample data...");

        //create 100 rows of people for our db
        List<Person> people = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .collect(Collectors.toList());

    }


}
