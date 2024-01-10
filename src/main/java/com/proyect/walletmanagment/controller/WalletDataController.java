package com.proyect.walletmanagment.controller;

import com.proyect.walletmanagment.models.WalletData;
import com.proyect.walletmanagment.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/walletData")
public class WalletDataController {

    private final WalletDataService walletDataService;

    @Autowired
    public WalletDataController(WalletDataService walletDataService){
        this.walletDataService = walletDataService;
    }

    @GetMapping
    public List<WalletData>getWalletData(){
        return walletDataService.getWalletData();
    }

    @PostMapping
    public void insertDataInWallet(WalletData walletData){
       walletDataService.insertDataInWallet(walletData);
    }
}
