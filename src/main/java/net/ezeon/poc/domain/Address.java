/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.poc.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.*;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Vikram
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "addressId")
    private Long addressId;
    
    @Column(name = "detail")
    private String detail;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "zip")
    private Integer zip;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient   
    private List<Contact> contactList;   
   
    public Address() {
    }

    public Address(Long addressId) {
        this.addressId = addressId;
    }

    public Address(String detail) {
        this.detail = detail;
    }
    

    public Address(String detail, String city, String country, Integer zip) {
        this.detail = detail;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }
    

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.ezeon.poc.domain.Address[ addressId=" + addressId + " ]";
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }
    
    
}
