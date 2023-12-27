package ra.model.service.student;

import ra.model.entity.ClassRoom;
import ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Boolean saveOrUpdate(Student classRoom);
    void delete(Integer id);
    Student findById(Integer id);
}
