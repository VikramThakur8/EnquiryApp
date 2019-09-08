package net.ezeon.poc.controller;

import java.util.List;
import net.ezeon.poc.domain.EnquirySource;
import net.ezeon.poc.repo.EnquirySourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vikram
 */
@RestController
public class TestController {

    @Autowired
    EnquirySourceRepository enquirySourceRepository;

    @GetMapping("/test-save-source")
    public String testSaveSource() {
        EnquirySource es = new EnquirySource("Website Partner");
        enquirySourceRepository.save(es);
        return "Success";
    }
    @GetMapping("/test-source-list")
    public List<EnquirySource> getSourceList() {       
        return enquirySourceRepository.findAll();
    }
}
