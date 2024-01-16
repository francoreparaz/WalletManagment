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
        if (user.getPassword() != null) {
            System.out.println("USER PASSWORD INGRESADA: " + user.getPassword());
            UserData user_db = userRepository.findByUsername(user.getUsername());
            if (user_db != null
                    && passwordEncoder.matches(user.getPassword(), user_db.getPassword())) {
                System.out.println("Las contraseñas coinciden");
                String create_token = authJWT.createToken(user.getUsername());
                token.setToken(create_token);
                return create_token;
            }
            throw new Exception();
        }
        throw new Exception();
    }
}
