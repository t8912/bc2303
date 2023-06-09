package com.codewave.project.projectcryptoadmin.service.impl;

import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;
import com.codewave.project.projectcryptoadmin.repository.ChannelTransactionRepository;
import com.codewave.project.projectcryptoadmin.service.ChannelTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelTransactionServiceImpl implements ChannelTransactionService {

    private final ChannelTransactionRepository transactionRepository;

    @Autowired
    public ChannelTransactionServiceImpl(ChannelTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ChannelTransaction createTransaction(ChannelTransaction transaction, Long channelId) {
        // Set the channel ID for the transaction
        transaction.setChannelId(channelId);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<ChannelTransaction> getTransactionsBySourceAndTranType(String source, String tranType) {
        return transactionRepository.findBySourceAndTranType(source, tranType);
    }
}


/* 
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;
import com.codewave.project.projectcryptoadmin.repository.ChannelRepository; // Add this import statement
import com.codewave.project.projectcryptoadmin.repository.ChannelTransactionRepository;
import com.codewave.project.projectcryptoadmin.service.ChannelTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelTransactionServiceImpl implements ChannelTransactionService {

    private final ChannelTransactionRepository transactionRepository;
    private final ChannelRepository channelRepository; // Add this field

    @Autowired
    public ChannelTransactionServiceImpl(ChannelTransactionRepository transactionRepository, ChannelRepository channelRepository) {
        this.transactionRepository = transactionRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public List<ChannelTransaction> getTransactionsBySourceAndTranType(String source, String tranType) {
        return transactionRepository.findBySourceAndTranType(source, tranType);
    }

    @Override
    public ChannelTransaction createTransaction(ChannelTransaction transaction, Long channelId) {
        // Set the channel for the transaction
        Channel channel = channelRepository.findById(channelId).orElse(null);
        if (channel != null) {
            transaction.setChannel(channel);
            return transactionRepository.save(transaction);
        }
        return null;
    }
}
*/

/* 
import com.codewave.project.projectcryptoadmin.model.entity.Channel;
import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;
import com.codewave.project.projectcryptoadmin.repository.ChannelTransactionRepository;
import com.codewave.project.projectcryptoadmin.service.ChannelTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelTransactionServiceImpl implements ChannelTransactionService {

    private final ChannelTransactionRepository transactionRepository;

    @Autowired
    public ChannelTransactionServiceImpl(ChannelTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<ChannelTransaction> getTransactionsBySourceAndTranType(String source, String tranType) {
        return transactionRepository.findBySourceAndTranType(source, tranType);
    }

    @Override
    public ChannelTransaction createTransaction(ChannelTransaction transaction, Long channelId) {
        // Set the channel for the transaction
        // Assuming you have a ChannelRepository to retrieve the channel by ID
        Channel channel = channelRepository.findById(channelId).orElse(null); // please fix : channelRepository cannot be resolved
        if (channel != null) {
            transaction.setChannel(channel); // please fix: the method setChannel(channel) is undefined for the ChannelRepository
            return transactionRepository.save(transaction);
        }
        return null;
    }
}
*/
