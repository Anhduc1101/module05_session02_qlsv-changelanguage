package ra.model.dao.classroom;

import ra.model.entity.ClassRoom;

import java.util.List;

public interface ClassRoomDAO {
    List<ClassRoom> findAll();
    Boolean saveOrUpdate(ClassRoom classRoom);
    void delete(Integer id);
    ClassRoom findById(Integer id);
}
