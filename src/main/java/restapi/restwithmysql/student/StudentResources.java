package restapi.restwithmysql.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentResources {
    @Autowired
    StudentRepository repository;


    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable int id) {
        Optional<Student> student=  repository.findById(id);
        if(!student.isPresent()){
            throw new StudentNotFoundException("id-"+id);
        }
        return student.get();
    }
    @GetMapping("/students/get")
    public Student getByName(@RequestParam(value = "name") String name) {
        Optional<Student> student=  repository.findByName(name);
        if(!student.isPresent()){
            throw new StudentNotFoundException("name-"+name);
        }
        return student.get();
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student student1 = repository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(student1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
