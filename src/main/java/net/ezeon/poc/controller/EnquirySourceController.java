package net.ezeon.poc.controller;

import java.util.List;
import net.ezeon.poc.domain.EnquirySource;
import net.ezeon.poc.repo.EnquirySourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Vikram
 */
@Controller
public class EnquirySourceController {
    
    @Autowired
    EnquirySourceRepository enquirySourceRepository;
    
    @RequestMapping("/sources")
    public String enquirySources(Model model) {
        EnquirySource cmd = new EnquirySource();
        model.addAttribute("cmd", cmd);
        return "/sources"; //sources.html
    }
    
    @RequestMapping("/enquiry-source-edit/{id}")
    public String edit(@PathVariable Long id , Model model) {
        EnquirySource cmd = enquirySourceRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "/sources"; //sources.html
    }
    
    @RequestMapping("/save-enquiry-source")
    public String save(@ModelAttribute EnquirySource es) {
        enquirySourceRepository.save(es);
        return "redirect:/sources"; 
    }
    
    @RequestMapping("/enquiry-source-delete/{id}")
    public String delete(@PathVariable Long id) {
        enquirySourceRepository.deleteById(id);
        return "redirect:/sources"; 
    }
    
    @ModelAttribute("enquirySourceList")
    public List<EnquirySource> getEnquirySourceList(){
        return enquirySourceRepository.findAll();
    }
    
}
