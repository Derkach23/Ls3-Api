package task2;

import org.springframework.beans.factory.annotation.Autowired;
import task1.Person;

import java.util.List;
import java.util.Optional;

public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    public Person addPerson(Person person) {
        return personRepository.save(person);
    }


    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(personDetails.getName());
            person.setAge(personDetails.getAge());
            return personRepository.save(person);
        } else {
            return null;
        }
    }


    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }


    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }
}
