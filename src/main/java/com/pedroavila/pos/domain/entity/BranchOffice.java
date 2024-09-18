package com.pedroavila.pos.domain.entity;

import com.pedroavila.pos.domain.entity.enums.StatusBranchOffice;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BranchOffice")
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "CompanyId")
    private int companyId;

    @Column(name = "Code")
    private int code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Status")
    private int status;

    @Column(name = "CreationDate")
    private Date creationDate;


    public BranchOffice() { }

    /*public BranchOffice(int companyId, int code, String name, String address, String phone, int status, Date creationDate) {
        this.companyId = companyId;
        this.code = code;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.creationDate = creationDate;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
