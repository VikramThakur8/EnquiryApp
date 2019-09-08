package net.ezeon.poc.controller;

import java.util.List;
import java.util.Map;
import net.ezeon.poc.domain.Course;
import net.ezeon.poc.domain.Institute;
import net.ezeon.poc.repo.CourseRepository;
import net.ezeon.poc.repo.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vikram
 */
@Controller
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    InstituteRepository  instituteRepository;
    
    @GetMapping("/courses")
    public String form(Model m){
        m.addAttribute("cmd", new Course());
        return "/courses"; //html
    }
    
    @GetMapping("/save-course")
    public String save(@ModelAttribute Course c){
        courseRepository.save(c);
        return "redirect:/courses"; //action
    }
    
    @ModelAttribute("instituteList")
    public List<Institute> getInstituteList(){
        //return instituteRepository.findAll();
        return instituteRepository.getInstCostomList();
    }
    
    @ModelAttribute("courseList")
    public List<Map<String,Object>> getcourseList(){       
//        return courseRepository.findAll();
        return courseRepository.getCourses();
    }
    
    @GetMapping("/tmp-courses")
    @ResponseBody
    public  List<Map<String,Object>> courseListTemp(){
        return courseRepository.getCourses();
    }
}
