package ra.model.service.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.dao.classroom.ClassRoomDAO;
import ra.model.entity.ClassRoom;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomDAO classRoomDAO;

    @Override
    public List<ClassRoom> findAll() {
        return classRoomDAO.findAll();
    }

    @Override
    public Boolean saveOrUpdate(ClassRoom classRoom) {
        return classRoomDAO.saveOrUpdate(classRoom);
    }

    @Override
    public void delete(Integer id) {
        classRoomDAO.delete(id);
    }

    @Override
    public ClassRoom findById(Integer id) {
        return classRoomDAO.findById(id);
    }
}
