package com.codewave.project.projectcryptoadmin.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHANNELS")
public class Channel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHANNEL_CODE", unique = true)
    private String channelCode;

    @Column(name = "CHANNEL_DOMAIN")
    private String channelDomain;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<ChannelCoinMapping> channelCoinMappings;

     @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
     private List<ChannelTransaction> channelTransactions;
    

    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }

    public Channel() {
        // Default constructor
    }

    public Channel(String channelCode, String channelDomain) {
        this.channelCode = channelCode;
        this.channelDomain = channelDomain;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelDomain() {
        return channelDomain;
    }

    public void setChannelDomain(String channelDomain) {
        this.channelDomain = channelDomain;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    public List<ChannelCoinMapping> getChannelCoinMappings() {
        return channelCoinMappings;
    }

    public void setChannelCoinMappings(List<ChannelCoinMapping> channelCoinMappings) {
        this.channelCoinMappings = channelCoinMappings;
    }

    // public List<ChannelTransaction> getChannelTransactions() {
    //     return channelTransactions;
    // }

    // public void setChannelTransactions(List<ChannelTransaction> channelTransactions) {
    //     this.channelTransactions = channelTransactions;
    // }
}


/* 
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHANNELS")
public class Channel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHANNEL_CODE", unique = true)
    private String channelCode;

    @Column(name = "CHANNEL_DOMAIN")
    private String channelDomain;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<ChannelCoinMapping> channelCoinMappings;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private List<ChannelTransaction> channelTransactions;
    

    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }

    //Pls provide Constructors, getters, and setters
}

*/