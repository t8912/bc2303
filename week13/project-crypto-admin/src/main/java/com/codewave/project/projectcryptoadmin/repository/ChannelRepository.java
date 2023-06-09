package com.codewave.project.projectcryptoadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewave.project.projectcryptoadmin.model.entity.Channel;


public interface ChannelRepository extends JpaRepository<Channel, Long> {
}


/* 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewave.project.projectcryptoadmin.model.entity.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}

*/