package com.proyect.walletmanagment.controller;

import com.proyect.walletmanagment.Middleware.JwtValidation;
import com.proyect.walletmanagment.models.WalletData;
import com.proyect.walletmanagment.service.WalletDataService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/walletData")
public class WalletDataController {

    private final WalletDataService walletDataService;

    @Autowired
    private JwtValidation jwtValidation;

    @Autowired
    public WalletDataController(WalletDataService walletDataService) {
        this.walletDataService = walletDataService;
    }

    @GetMapping
    public List<WalletData> getWalletData() {
        return walletDataService.getWalletData();
    }

    @PostMapping(path = "/save")
    public void insertDataInWallet(@RequestBody WalletData walletData, HttpServletRequest request) {
        try {
            String authorizationHeader = request.getHeader("Authorization").substring(7);
            Long userId = jwtValidation.validateToken(authorizationHeader).get("userId", Long.class);
            walletData.setUserId(userId);
            walletData.setDate(new Date());
            walletDataService.insertDataInWallet(walletData);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
