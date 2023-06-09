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
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "DOMAIN_VERSION")
    private String domainVersion;

    @Column(name = "DOMAIN_URL")
    private String domainUrl;

    @Column(name = "SOURCE_APP")
    private String sourceApp;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @Column(name = "SOURCE")
    private String source;

    @PrePersist
    public void prePersist() {
        // overwrite logic
        lastUpdDate = LocalDateTime.now();
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setChannelId(Long channelId) {
        this.channel = new Channel();
        this.channel.setId(channelId);
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

    public String getDomainVersion() {
        return domainVersion;
    }

    public void setDomainVersion(String domainVersion) {
        this.domainVersion = domainVersion;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "DOMAIN_VERSION")
    private String domainVersion;

    @Column(name = "DOMAIN_URL")
    private String domainUrl;

    @Column(name = "SOURCE_APP")
    private String sourceApp;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @PrePersist
    public void prePersist() {
        // overwrite logic
        lastUpdDate = LocalDateTime.now();
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setChannelId(Long channelId) {
        this.channel = new Channel();
        this.channel.setId(channelId);
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

    public String getDomainVersion() {
        return domainVersion;
    }

    public void setDomainVersion(String domainVersion) {
        this.domainVersion = domainVersion;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
}
*/

/* 
import java.io.Serializable;
import java.time.LocalDateTime;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "DOMAIN_VERSION")
    private String domainVersion;

    @Column(name = "DOMAIN_URL")
    private String domainUrl;

    @Column(name = "SOURCE_APP")
    private String sourceApp;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }

    public ChannelTransaction() {
        // Default constructor
    }

    public ChannelTransaction(Channel channel, String domainVersion, String domainUrl, String sourceApp, String tranType) {
        this.channel = channel;
        this.domainVersion = domainVersion;
        this.domainUrl = domainUrl;
        this.sourceApp = sourceApp;
        this.tranType = tranType;
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

    public String getDomainVersion() {
        return domainVersion;
    }

    public void setDomainVersion(String domainVersion) {
        this.domainVersion = domainVersion;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

    public void setChannelId(Long channelId) {
    }
}
*/

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
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "DOMAIN_VERSION")
    private String domainVersion;

    @Column(name = "DOMAIN_URL")
    private String domainUrl;

    @Column(name = "SOURCE_APP")
    private String sourceApp;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @PrePersist
    public void prePersist() {
        lastUpdDate = LocalDateTime.now();
    }

    public ChannelTransaction() {
        // Default constructor
    }

    public ChannelTransaction(Channel channel, String domainVersion, String domainUrl, String sourceApp, String tranType) {
        this.channel = channel;
        this.domainVersion = domainVersion;
        this.domainUrl = domainUrl;
        this.sourceApp = sourceApp;
        this.tranType = tranType;
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

    // public void setChannel(Channel channel) {
    //     this.channel = channel;
    // }

    public void setChannelId(Long channelId) {
        this.channel.setId(channelId);
    }

    public String getDomainVersion() {
        return domainVersion;
    }

    public void setDomainVersion(String domainVersion) {
        this.domainVersion = domainVersion;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public LocalDateTime getLastUpdDate() {
        return lastUpdDate;
    }

    public void setLastUpdDate(LocalDateTime lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
}
*/

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
@Table(name = "CHANNEL_TRANS")
public class ChannelTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID")
    private Channel channel;

    @Column(name = "DOMAIN_VERSION")
    private String domainVersion;

    @Column(name = "DOMAIN_URL")
    private String domainUrl;

    @Column(name = "SOURCE_APP")
    private String sourceApp;

    @Column(name = "TRAN_TYPE")
    private String tranType;

    @Column(name = "LAST_UPD_DATE")
    private LocalDateTime lastUpdDate;

    @PrePersist
    public void prePersist() {
        // overwrite logic
        lastUpdDate = LocalDateTime.now();
    }

    public void setChannel(Channel channel2) {
    }

    public void setChannelId(Long channelId) {
    }
     
    

    //Please provide Constructors, getters, and setters
}
*/