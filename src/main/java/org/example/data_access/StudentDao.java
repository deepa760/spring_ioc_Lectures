package org.example.data_access;


import org.example.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Student save (Student student);
    Optional<Student> find(Integer id);
    List<Student> findAll();
    void delete (int id);
}