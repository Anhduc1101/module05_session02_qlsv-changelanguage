package ra.model.service.classroom;

import ra.model.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> findAll();
    Boolean saveOrUpdate(ClassRoom classRoom);
    void delete(Integer id);
    ClassRoom findById(Integer id);
}
