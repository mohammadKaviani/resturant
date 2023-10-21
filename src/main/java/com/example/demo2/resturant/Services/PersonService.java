package com.example.demo2.resturant.Services;


import com.example.demo2.resturant.Models.PersonsModel;
import com.example.demo2.resturant.Repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonsModel addPerson(PersonsModel personsModel) {
        return personRepository.save(personsModel);
    }

    public Page<PersonsModel> getPaginatedList(int offset, int pageSize) {

        Page<PersonsModel> personsModelsPaginate = personRepository.findAll(PageRequest.of(offset, pageSize));
        return personsModelsPaginate;
    }

    public Page<PersonsModel> findPersonEithPaginatAndSort(int offset, int pageSize, String field) {

        Page<PersonsModel> personsModelsPaginate = personRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return personsModelsPaginate;
    }

    public ResponseEntity<String> deletePerson(Integer id) {
        if (personRepository.findById(id).isPresent()) {
            personRepository.deleteById(id);
            return new ResponseEntity<>("Person was Deleted ....", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person was not found....", HttpStatus.OK);
        }
    }


    public PersonsModel updatePerson(PersonsModel personsModel) {

        PersonsModel personsModel1 = new PersonsModel();
        personsModel1 = personRepository.findById(personsModel.getId().intValue()).get();

        personsModel1.setFirstName(personsModel.getFirstName());
        personsModel1.setLastName(personsModel.getLastName());
        personsModel1.setPersonType(personsModel.getPersonType());
        personsModel1.setAddress(personsModel.getAddress());
        personsModel1.setPhoneNumbers(personsModel.getPhoneNumbers());



        return  personRepository.save(personsModel1);

    }

}
