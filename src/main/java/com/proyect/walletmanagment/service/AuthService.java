package com.proyect.walletmanagment.service;

import com.proyect.walletmanagment.DataTypes.AuthToken;
import com.proyect.walletmanagment.models.UserData;
import com.proyect.walletmanagment.repository.UserRepository;
import com.proyect.walletmanagment.utils.AuthJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthJWT authJWT;

    @Autowired
    public AuthToken token;

    public void registerUser(UserData user) {
        if (user.getUsername() != null && user.getPassword() != null) {
            user.setUsername((user.getUsername()));
            String hashed_password = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashed_password);

            if (user.getEmail() != null) {
                user.setEmail(user.getEmail());
            }
            if (user.getPhone() != null) {
                user.setPhone(user.getPhone());
            }

            userRepository.save(user);
        }
    }

    public String loginUser(UserData user) throws Exception {
        try {
            if (user.getPassword() != null) {
                UserData user_db = userRepository.findByUsername(user.getUsername());
                if (user_db != null
                        && passwordEncoder.matches(user.getPassword(), user_db.getPassword())) {
                    String create_token = authJWT.createToken(user_db.getId());
                    token.setToken(create_token);
                    return create_token;
                }
                throw new Exception();
            }
            throw new Exception();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return e.getMessage();
        }
    }
}
