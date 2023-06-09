package com.codewave.project.projectcryptoadmin.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHANNEL_COIN_MAPPINGS")
public class ChannelCoinMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "COIN_CODE")
    private String coinCode;

    @Column(name = "COIN_ID")
    private String coinId;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }

    public ChannelCoinMapping() {
        // Default constructor
    }

    public ChannelCoinMapping(Channel channel, String coinCode, String coinId) {
        this.channel = channel;
        this.coinCode = coinCode;
        this.coinId = coinId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
}

/* 
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHANNEL_COIN_MAPPINGS")
public class ChannelCoinMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "COIN_CODE")
    private String coinCode;

    @Column(name = "COIN_ID")
    private String coinId;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;


    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }


    //Please provide Constructors, getters, and setters
}
*/
