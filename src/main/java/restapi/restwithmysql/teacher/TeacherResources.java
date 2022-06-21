package restapi.restwithmysql.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restapi.restwithmysql.student.StudentRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TeacherResources {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getById(@PathVariable int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if(! teacher.isPresent()) return null;
        else return teacher.get();
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherRepository.save(teacher);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
