package com.pedroavila.pos.domain.service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class BranchOfficeDTO {

       private int id;

       private int companyId;

       private int code;

       @NotNull
       @NotEmpty
       private String name;

       @NotNull
       @NotEmpty
       private String address;

       @Size(max = 10, message = "El número de teléfono no puede tener más de 10 caracteres")
       private String phone;

       private int status;

       private Date creationDate;

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
