package com.ironhack.erp.providerservice.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nif;
    private String email;
    private String commercialName;
    private String fiscalName;
    private String address;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Provider(String nif, String email, String commercialName, String fiscalName, String address) {
        this.nif = nif;
        this.email = email;
        this.commercialName = commercialName;
        this.fiscalName = fiscalName;
        this.address = address;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getFiscalName() {
        return fiscalName;
    }

    public void setFiscalName(String fiscalName) {
        this.fiscalName = fiscalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}