package com.codewave.project.projectcryptoadmin.service.impl;

import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.repository.ChannelRepository;
import com.codewave.project.projectcryptoadmin.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel getChannelById(Long id) {
        return channelRepository.findById(id).orElse(null);
    }

    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    // Add additional methods as needed

}



/* 
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.repository.ChannelRepository;
import com.codewave.project.projectcryptoadmin.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel getChannelById(Long id) {
        return channelRepository.findById(id).orElse(null);
    }

    @Override
    public Channel createChannel(Channel channel) {
        return channelRepository.save(channel);
    }
}
*/
