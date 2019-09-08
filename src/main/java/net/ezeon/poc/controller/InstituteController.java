package net.ezeon.poc.controller;

import java.util.Date;
import net.ezeon.poc.domain.Institute;
import net.ezeon.poc.repo.InstituteRepository;
import net.ezeon.poc.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Vikram
 */
@Controller
public class InstituteController {

    @Autowired
    CommonService commonService;
    
    @Autowired
    InstituteRepository instituteRepository;

    @GetMapping("/institute-form")
    public String form(Model m) {
        m.addAttribute("cmd", new Institute());
        return "/institute-form"; //html
    }

    @GetMapping("/save-institute")
    public String save(@ModelAttribute Institute inst) {
        inst.getContact().setName(inst.getName());
        inst.setDoe(new Date());
        commonService.saveInstitute(inst);
        return "redirect:/institute-list";
    }
    @GetMapping("/institute-list")
    public String list(Model m) {
        //m.addAttribute("instList", instituteRepository.findAll());
        m.addAttribute("instList", instituteRepository.getInstList());
        return "/institute-list"; //html
    }
}
