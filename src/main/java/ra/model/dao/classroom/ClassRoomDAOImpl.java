package ra.model.dao.classroom;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.model.entity.ClassRoom;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRoomDAOImpl implements ClassRoomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ClassRoom> findAll() {
        Session session = sessionFactory.openSession();
        List<ClassRoom> classRooms = new ArrayList<>();
        try {
            classRooms = session.createQuery("from ClassRoom ", ClassRoom.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classRooms;
    }

    @Override
    public Boolean saveOrUpdate(ClassRoom classRoom) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(classRoom);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public ClassRoom findById(Integer id) {
        Session session = sessionFactory.openSession();
        ClassRoom classRoom;
        try {
            classRoom = session.get(ClassRoom.class, id);
            return classRoom;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
