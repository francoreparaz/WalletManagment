package com.proyect.walletmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.walletmanagment.service.AuthService;
import com.proyect.walletmanagment.DataTypes.AuthToken;
import com.proyect.walletmanagment.models.UserData;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthToken token;

    @PostMapping("/registro")
    public String registerUser(@RequestBody UserData usuario) {
        authService.registerUser(usuario);
        return "Usuario registrado exitosamente";
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserData usuario) {
        try {
            authService.loginUser(usuario);
            if (token.getToken() != null) {
                return ResponseEntity.ok(token);
            }
            throw new Exception();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Datos incorrectos");
        }
    }

    @GetMapping("/refresh/token")
    public String refreshToken(@RequestBody UserData usuario) {
        return "JWT";
    }
}
