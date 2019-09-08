/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.poc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Vikram
 */
@Entity
@Table(name = "enquiry")
public class Enquiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquiryId")
    private Long enquiryId;
    
    @Column(name = "doe")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date doe;
    @Column(name = "nextCallDate")
    @Temporal(TemporalType.DATE)
    private Date nextCallDate;
    @Column(name = "remark")
    private String remark;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "committedFees")
    private Double committedFees;
    @Column(name = "lastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    
    @Transient
    private List<Followup> followupList;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    
    @Transient
    private List<EnquiryCourse> enquiryCourseList;

    @JoinColumn(name = "contactId", referencedColumnName = "contactId")
    @ManyToOne
    private Contact contact;
    
    @JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
    @ManyToOne
    private Institute institute;
    @JoinColumn(name = "enquirySourceId", referencedColumnName = "enquirySourceId")
    @ManyToOne
    private EnquirySource enquirySource;

    public Enquiry() {
    }

    public Enquiry(Long enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Enquiry(Long enquiryId, String remark) {
        this.enquiryId = enquiryId;
        this.remark = remark;
    }

    public Long getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Long enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }

    public Date getNextCallDate() {
        return nextCallDate;
    }

    public void setNextCallDate(Date nextCallDate) {
        this.nextCallDate = nextCallDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getCommittedFees() {
        return committedFees;
    }

    public void setCommittedFees(Double committedFees) {
        this.committedFees = committedFees;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public EnquirySource getEnquirySource() {
        return enquirySource;
    }

    public void setEnquirySource(EnquirySource enquirySource) {
        this.enquirySource = enquirySource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquiryId != null ? enquiryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquiry)) {
            return false;
        }
        Enquiry other = (Enquiry) object;
        if ((this.enquiryId == null && other.enquiryId != null) || (this.enquiryId != null && !this.enquiryId.equals(other.enquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ezeon.poc.domain.Enquiry[ enquiryId=" + enquiryId + " ]";
    }

    public List<Followup> getFollowupList() {
        return followupList;
    }

    public void setFollowupList(List<Followup> followupList) {
        this.followupList = followupList;
    }

    public List<EnquiryCourse> getEnquiryCourseList() {
        return enquiryCourseList;
    }

    public void setEnquiryCourseList(List<EnquiryCourse> enquiryCourseList) {
        this.enquiryCourseList = enquiryCourseList;
    }
    

}
