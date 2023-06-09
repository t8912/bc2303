package com.codewave.project.projectcryptoadmin.controller;

import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ChannelOperation {

    @GetMapping(value = "/channel/{id}")
    Channel getChannel(@PathVariable Long id);

    @PostMapping(value = "/channel")
    Channel createChannel(@RequestBody Channel channel);

    @PostMapping(value = "/channel/{channelId}/transaction")
    ChannelTransaction createTransaction(@PathVariable Long channelId, @RequestBody ChannelTransaction transaction);

    @GetMapping(value = "/channel/transactions")
     List<ChannelTransaction> getTransactions(@RequestParam(value = "source") String source, @RequestParam(value = "tranType") String tranType);
}


/* 
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ChannelOperation {

    @GetMapping(value = "/channel/{id}")
    Channel getChannel(@PathVariable Long id);

    @PostMapping(value = "/channel")
    Channel createChannel(@RequestBody Channel channel);

    @PostMapping(value = "/channel/{channelId}/transaction")
    ChannelTransaction createTransaction(@PathVariable Long channelId, @RequestBody ChannelTransaction transaction);

    @GetMapping(value = "/channel/transactions")
    List<ChannelTransaction> getTransactions(@RequestParam(value = "source") String source, @RequestParam(value = "tranType") String tranType);
}
*/
