package ra.model.dao.student;

import ra.model.entity.ClassRoom;
import ra.model.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Boolean saveOrUpdate(Student student);
    void delete(Integer id);
    Student findById(Integer id);
}
