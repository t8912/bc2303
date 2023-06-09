package com.codewave.project.projectcryptoadmin.service;


import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

import java.util.List;

public interface ChannelTransactionService {

    ChannelTransaction createTransaction(ChannelTransaction transaction, Long channelId);

    List<ChannelTransaction> getTransactionsBySourceAndTranType(String source, String tranType);
}


/* 
import java.util.List;

import com.codewave.project.projectcryptoadmin.model.entity.ChannelTransaction;

public interface ChannelTransactionService {

    List<ChannelTransaction> getTransactionsBySourceAndTranType(String source, String tranType);

    ChannelTransaction createTransaction(ChannelTransaction transaction, Long channelId);
}
*/
