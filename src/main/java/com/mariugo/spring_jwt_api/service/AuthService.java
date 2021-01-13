package com.mariugo.spring_jwt_api.service;

import com.mariugo.spring_jwt_api.dto.RegisterRequest;
import com.mariugo.spring_jwt_api.model.Usuario;
import com.mariugo.spring_jwt_api.model.VerificationToken;
import com.mariugo.spring_jwt_api.repository.UserRepository;
import com.mariugo.spring_jwt_api.repository.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;


    @Transactional
    public void signUp(RegisterRequest registerRequest){
        Usuario user = new Usuario();

        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEnabled(false);
        user.setCreated(Instant.now());

        userRepository.save(user);

        String token = generateVerificationToken(user);

    }

    private String generateVerificationToken(Usuario user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);

        return token;
    }
}
