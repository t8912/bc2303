package com.codewave.project.projectcryptoadmin.service;


import com.codewave.project.projectcryptoadmin.model.entity.Channel;

public interface ChannelService {

    Channel getChannelById(Long id);

    Channel createChannel(Channel channel);
}


/* 
import com.codewave.project.projectcryptoadmin.model.entity.Channel;

public interface ChannelService {

    Channel getChannelById(Long id);

    Channel createChannel(Channel channel);
}

*/