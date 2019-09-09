package net.ezeon.poc.controller;

import java.util.List;
import net.ezeon.poc.domain.Course;
import net.ezeon.poc.domain.EnquirySource;
import net.ezeon.poc.domain.Institute;
import net.ezeon.poc.dto.EnquiryCommand;

import net.ezeon.poc.repo.CourseRepository;
import net.ezeon.poc.repo.EnquiryRepository;
import net.ezeon.poc.repo.EnquirySourceRepository;
import net.ezeon.poc.repo.InstituteRepository;
import net.ezeon.poc.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Vikram
 */
@Controller
public class EnquiryController {

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    EnquirySourceRepository enquirySourceRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CommonService commonService;

    @Autowired
    EnquiryRepository enquiryRepository;

    @GetMapping("/")
    public String index(Model m) {       
        m.addAttribute("cmd", new EnquiryCommand());
        return "/index"; //index.html page
    }

    @GetMapping("/save-enquiry")
    @ResponseBody
    public String save(@ModelAttribute EnquiryCommand cmd) {
        commonService.saveEnquiry(cmd);
        return "Enquiry Saved Successfully"; //TODO : go to enquiry list
    }

    @GetMapping("/get-courses")
    @ResponseBody
    public List<Course> getCoursesByInstituteId(@RequestParam Long instId) {
        return courseRepository.findCourseListByInstitute_instituteId(instId);
    }

    @ModelAttribute("instituteList")
    public List<Institute> getInstList() {
        return instituteRepository.getInstCostomList();
    }

    @ModelAttribute("sourceList")
    public List<EnquirySource> getSourceList() {
        return enquirySourceRepository.findAll();
    }

    @GetMapping("/enq-list")
    public String enquiryList(@RequestParam(required = false) Long instId, Model m) {
        m.addAttribute("enquiryList", enquiryRepository.getEnquiryDTOList(instId));
        return "/enq-list"; //html
    }

    @GetMapping("/test-get-inst-ids")
    @ResponseBody
    public String getInstIds() {
        return enquiryRepository.findAllIds();
    }
    @PostMapping("/save-followup")    
    public String saveFollowup(@RequestParam Long enquiryId, @RequestParam String followup) {
        commonService.saveFollowup(enquiryId, followup);
        return "redirect:/enq-list";
    }

}
