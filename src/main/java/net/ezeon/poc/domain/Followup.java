/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.poc.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vikram
 */
@Entity
@Table(name = "followup")
public class Followup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followupId")
    private Long followupId;
    @Column(name = "doe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doe;
    @Column(name = "detail")
    private String detail;
    @JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
    @ManyToOne
    private Enquiry enquiry;

    public Followup() {
    }

    public Followup(Long followupId) {
        this.followupId = followupId;
    }

    public Long getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Long followupId) {
        this.followupId = followupId;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date doe) {
        this.doe = doe;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry enquiry) {
        this.enquiry = enquiry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followupId != null ? followupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followup)) {
            return false;
        }
        Followup other = (Followup) object;
        if ((this.followupId == null && other.followupId != null) || (this.followupId != null && !this.followupId.equals(other.followupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ezeon.poc.domain.Followup[ followupId=" + followupId + " ]";
    }
    
}
