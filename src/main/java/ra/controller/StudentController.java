package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.ClassRoom;
import ra.model.entity.Student;
import ra.model.service.classroom.ClassRoomService;
import ra.model.service.student.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/student")
    public String student(Model model){
        List<Student> studentList=studentService.findAll();
        model.addAttribute("studentList",studentList);
        return "student/student-list";
    }

      @GetMapping("add-student")
    public String add(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        List<ClassRoom> classRoomList=classRoomService.findAll();
        model.addAttribute("classroomList",classRoomList);
        return "student/student-add";
      }

      @PostMapping("add-student")
    public String add(@ModelAttribute("student") Student student){
        if (studentService.saveOrUpdate(student)){
            return "redirect:/student";
        }
        return "redirect:/add-student";
      }
    @GetMapping("delete-student/{id}")
    public String delete(@PathVariable("id") Integer id){
        studentService.delete(id);
        return "redirect:/student";
    }

    @GetMapping("edit-student/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        List<ClassRoom> classRoomList=classRoomService.findAll();
        model.addAttribute("classroomList",classRoomList);
        return "student/student-edit";
    }
    @PostMapping("update-student")
    public String update(@ModelAttribute("student") Student student){
        if (studentService.saveOrUpdate(student)){
            return "redirect:/student";
        }
        return "redirect:/edit-student/";
    }
}
