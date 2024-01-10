package com.proyect.walletmanagment.service;

import com.proyect.walletmanagment.models.WalletData;
import com.proyect.walletmanagment.repository.WalletDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WalletDataService {

    private final WalletDataRepository walletDataRepository;

    @Autowired
    public WalletDataService (WalletDataRepository walletDataRepository){
        this.walletDataRepository = walletDataRepository;
    }

    public List getWalletData() {
        return walletDataRepository.findAll();
    }

    public void insertDataInWallet(WalletData walletData) {
        
    }


}
