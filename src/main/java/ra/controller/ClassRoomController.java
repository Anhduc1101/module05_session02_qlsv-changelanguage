package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.entity.ClassRoom;
import ra.model.service.classroom.ClassRoomService;

import java.util.List;

@Controller
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/classroom")
    public String classroom(Model model){
        List<ClassRoom> classRoomList=classRoomService.findAll();
        model.addAttribute("classroomList",classRoomList);
        return "classroom/classroom-list";
    }

    @GetMapping("add-classroom")
    public String add_classroom(Model model){
        ClassRoom classRoom=new ClassRoom();
        model.addAttribute("classroom",classRoom);
        return "classroom/classroom-add";
    }

    @PostMapping("add-classroom")
    public String add_classroom(@ModelAttribute("classroom") ClassRoom classRoom){
        if(classRoomService.saveOrUpdate(classRoom)){
         return "redirect:/classroom";
        }
        return "redirect:/add-classroom";
    }

    @GetMapping("delete-classroom/{id}")
    public String delete(@PathVariable("id") Integer id){
        classRoomService.delete(id);
        return "redirect:/classroom";
    }

    @GetMapping("edit-classroom/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        ClassRoom classRoom=classRoomService.findById(id);
        model.addAttribute("classroom",classRoom);
        return "classroom/classroom-edit";
    }
    @PostMapping("update-classroom")
    public String update(@ModelAttribute("classroom") ClassRoom classRoom){
        if(classRoomService.saveOrUpdate(classRoom)){
            return "redirect:/classroom";
        }
        return "redirect:/edit-classroom/";
    }
}
