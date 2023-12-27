package ra.model.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.student.StudentDAO;
import ra.model.entity.Student;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Student classRoom) {
        return studentDAO.saveOrUpdate(classRoom);
    }

    @Override
    public void delete(Integer id) {
studentDAO.delete(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }
}
