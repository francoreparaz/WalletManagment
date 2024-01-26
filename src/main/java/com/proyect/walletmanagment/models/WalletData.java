package com.proyect.walletmanagment.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "wallet_data")
public class WalletData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Date date;

    private String currencyName;

    private Long depositedMoney;

    private Long currencyPrice;

    public WalletData() {
    }

    public WalletData(Long id, Long userId, Date date, String currencyName, Long depositedMoney, Long currencyPrice) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.currencyName = currencyName;
        this.depositedMoney = depositedMoney;
        this.currencyPrice = currencyPrice;
    }

    public WalletData(Date date, String currencyName, Long depositedMoney, Long currencyPrice) {
        this.date = date;
        this.currencyName = currencyName;
        this.depositedMoney = depositedMoney;
        this.currencyPrice = currencyPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Long getDepositedMoney() {
        return depositedMoney;
    }

    public void setDepositedMoney(Long depositedMoney) {
        this.depositedMoney = depositedMoney;
    }

    public Long getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(Long currencyPrice) {
        this.currencyPrice = currencyPrice;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
