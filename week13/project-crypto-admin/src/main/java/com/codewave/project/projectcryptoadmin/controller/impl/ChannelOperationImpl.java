package com.codewave.project.projectcryptoadmin.controller.impl;

import com.codewave.project.projectcryptoadmin.controller.ChannelOperation;
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;
import com.codewave.project.projectcryptoadmin.service.ChannelService;
import com.codewave.project.projectcryptoadmin.service.ChannelTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crypto/admin/v1")
public class ChannelOperationImpl implements ChannelOperation {

    private final ChannelService channelService;
    private final ChannelTransactionService transactionService;

    @Autowired
    public ChannelOperationImpl(ChannelService channelService, ChannelTransactionService transactionService) {
        this.channelService = channelService;
        this.transactionService = transactionService;
    }

    // @Autowired
    // public ChannelOperationImpl(ChannelService channelService) {
    //     this.channelService = channelService;
    // }

    @GetMapping(value = "/channel/{id}")
    public Channel getChannel(@PathVariable Long id) {
        return channelService.getChannelById(id);
    }

    @PostMapping(value = "/channel")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    // @Override
    // public ChannelTransaction createTransaction(Long channelId, ChannelTransaction transaction) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createTransaction'");
    // }

    // @Override
    // public List<ChannelTransaction> getTransactions(String source, String tranType) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getTransactions'");
    // }

    @PostMapping(value = "/channel/{channelId}/transaction")
    public ChannelTransaction createTransaction(@PathVariable Long channelId, @RequestBody ChannelTransaction transaction) {
        return transactionService.createTransaction(transaction, channelId);
    }

    @GetMapping(value = "/channel/transactions")
    public List<ChannelTransaction> getTransactions(@RequestParam(value = "source") String source,
                                                    @RequestParam(value = "tranType") String tranType) {
        return transactionService.getTransactionsBySourceAndTranType(source, tranType);
    }
}


/* 
import com.codewave.project.projectcryptoadmin.controller.ChannelOperation;
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;
import com.codewave.project.projectcryptoadmin.service.ChannelService;
import com.codewave.project.projectcryptoadmin.service.ChannelTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crypto/admin/v1")
public class ChannelOperationImpl implements ChannelOperation {

    private final ChannelService channelService;
    private final ChannelTransactionService transactionService;

    @Autowired
    public ChannelOperationImpl(ChannelService channelService, ChannelTransactionService transactionService) {
        this.channelService = channelService;
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/channel/{id}")
    public Channel getChannel(@PathVariable Long id) {
        return channelService.getChannelById(id);
    }

    @PostMapping(value = "/channel")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    @PostMapping(value = "/channel/{channelId}/transaction")
    public ChannelTransaction createTransaction(@PathVariable Long channelId, @RequestBody ChannelTransaction transaction) {
        return transactionService.createTransaction(transaction, channelId);
    }

    @GetMapping(value = "/channel/transactions")
    public List<ChannelTransaction> getTransactions(@RequestParam(value = "source") String source,
                                                    @RequestParam(value = "tranType") String tranType) {
        return transactionService.getTransactionsBySourceAndTranType(source, tranType);
    }
}

*/