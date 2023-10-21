package com.example.demo2.resturant.Controllers;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo2.resturant.Models.PersonsModel;
import com.example.demo2.resturant.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {


    PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @RequestMapping(value = "/person-add",method = RequestMethod.POST)
    public PersonsModel addPerson(@RequestBody PersonsModel personsModel)
    {  return  personService.addPerson(personsModel);
    }
    @GetMapping(value = "/person-paginate/{offset}/{pageSize}")
    public Page<PersonsModel> getAllpersonPaginate(@PathVariable int offset,@PathVariable int pageSize)
    {
       Page<PersonsModel>  PersonWithPagination = personService.getPaginatedList(offset,pageSize);
       return  PersonWithPagination;
    }
    @GetMapping(value = "/person-paginate-sort/{offset}/{pageSize}/{field}")
    public Page<PersonsModel> getAllpersonPaginateAndSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
    {
        Page<PersonsModel>  PersonWithPagination = personService.findPersonEithPaginatAndSort(offset,pageSize,field);
        return  PersonWithPagination;
    }
    @DeleteMapping("/delete-persons/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id){
         return personService.deletePerson(id);
    }
    @PostMapping("/update-person")
    public PersonsModel updatePerson(@RequestBody PersonsModel personsModel){
      return personService.updatePerson(personsModel);
    }


}
