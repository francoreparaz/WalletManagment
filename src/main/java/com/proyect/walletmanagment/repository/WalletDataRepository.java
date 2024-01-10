package com.proyect.walletmanagment.repository;

import com.proyect.walletmanagment.models.WalletData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletDataRepository extends JpaRepository<WalletData,Long> {

}
