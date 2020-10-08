



package org.example.data_access;

import org.example.models.Student;
import org.example.sequence.StudentSequence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component("StudentDao")
public class StudentDaoListImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();
    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(StudentSequence.nextStudentId());
            students.add(student);
        } else {
            Optional<Student> findStudent =  find(student.getId());
            Student student1 = findStudent.orElseThrow(IllegalArgumentException::new);
            student1.setName(student.getName());
        }
        return student;
    }

    @Override
    public Optional<Student> find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();

        return null;
    }

    @Override
    public void delete(int id) {
        Student student = find(id).orElseThrow(IllegalArgumentException::new);
        students.remove(student);
    }
}