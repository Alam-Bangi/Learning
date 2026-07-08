package student.service;

import student.entity.Student;
import student.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImplementation
        implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {

        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return repository.findById(id)
                .orElseThrow();
    }

    @Override
    public Student updateStudent(Long id,
                                 Student student) {

        Student existing = repository.findById(id)
                        .orElseThrow();

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {

        repository.deleteById(id);
    }
}