package pd.workshop.springjpadatademo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pd.workshop.springjpadatademo.model.Person;
import pd.workshop.springjpadatademo.repository.PersonRepository;

@RestController
@RequestMapping("/api/vi/people")
public class PersonController {
    PersonRepository personRepository;
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @GetMapping
    private Page<Person> findAllPerson(@RequestParam int page, @RequestParam int size){
        // Pages-->50(0-49)   100/2
        Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        return personRepository.findAll(pageRequest);
    }
}
