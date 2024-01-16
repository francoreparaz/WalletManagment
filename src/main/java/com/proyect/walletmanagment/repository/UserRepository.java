package com.proyect.walletmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyect.walletmanagment.models.UserData;

public interface UserRepository extends JpaRepository<UserData, Long> {
    UserData findByUsername(String username);
}
