/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.poc.service;

import java.util.Date;
import net.ezeon.poc.domain.Address;
import net.ezeon.poc.domain.Contact;
import net.ezeon.poc.domain.Enquiry;
import net.ezeon.poc.domain.EnquiryCourse;
import net.ezeon.poc.domain.EnquirySource;
import net.ezeon.poc.domain.Institute;
import net.ezeon.poc.dto.EnquiryCommand;
import net.ezeon.poc.repo.AddressRepository;
import net.ezeon.poc.repo.ContactRepository;
import net.ezeon.poc.repo.CourseRepository;
import net.ezeon.poc.repo.EnquiryCourseRepository;
import net.ezeon.poc.repo.EnquiryRepository;
import net.ezeon.poc.repo.EnquirySourceRepository;
import net.ezeon.poc.repo.FollowupRepository;
import net.ezeon.poc.repo.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vikram
 */
@Service
public class CommonService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    EnquirySourceRepository enquirySourceRepository;
    @Autowired
    EnquiryRepository enquiryRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    EnquiryCourseRepository enquiryCourseRepository;
    @Autowired
    FollowupRepository followupRepository;

    @Transactional
    public void saveInstitute(Institute inst) {
        //address
        addressRepository.save(inst.getContact().getPermanentAddress());
        //contact
        contactRepository.save(inst.getContact());
        //institute
        instituteRepository.save(inst);
    }

    @Transactional
    public void saveEnquiry(EnquiryCommand cmd){
        Address a = cmd.getEnquiry().getContact().getPermanentAddress();
        addressRepository.save(a);
        
        Contact c = cmd.getEnquiry().getContact();
        contactRepository.save(c);
        
        Enquiry e = cmd.getEnquiry();
        e.setInstitute(instituteRepository.getOne(e.getInstitute().getInstituteId()));
        e.setEnquirySource(enquirySourceRepository.getOne(e.getEnquirySource().getEnquirySourceId()));
        Date d = new Date();
        e.setDoe(d);
        e.setLastUpdate(d);        
        enquiryRepository.save(e);
        
        Long[] courseIds = cmd.getCourses();
        for (Long courseId : courseIds) {
            EnquiryCourse ec = new EnquiryCourse();
            ec.setEnquiry(e);
            ec.setCourse(courseRepository.getOne(courseId));
            enquiryCourseRepository.save(ec);
        }
        
    }   
    
}
