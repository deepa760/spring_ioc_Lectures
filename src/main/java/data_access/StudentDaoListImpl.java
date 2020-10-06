package data_access;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import models.Student;

@Component
public class StudentDaoListImp implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId()==id)
                return student;
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(int id) {
        Student student = this.findById(id);
        students.remove(student);

        return false;
    }

}
