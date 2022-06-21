package restapi.restwithmysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import restapi.restwithmysql.student.Student;
import restapi.restwithmysql.student.StudentRepository;
import restapi.restwithmysql.teacher.Teacher;
import restapi.restwithmysql.teacher.TeacherRepository;

import java.util.Optional;

@SpringBootApplication
public class RestwithmysqlApplication implements CommandLineRunner {
    @Autowired
    StudentRepository repository;
    TeacherRepository teacherRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {
        SpringApplication.run(RestwithmysqlApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        repository.save(new Student("Anna",20,"London"));
//        repository.save(new Student("Bob",18,"Ha Noi"));
//        repository.save(new Student("Chan",19,"HCMC"));
//        logger.info("find student by name- Anna: {}",repository.findByName("Anna"));
//        teacherRepository.save(new Teacher("Mrs Hoa"));
//        logger.info("get Student By id: {}",repository.findById(2));
    }
}
