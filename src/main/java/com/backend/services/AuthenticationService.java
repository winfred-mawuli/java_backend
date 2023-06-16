package com.backend.services;


import com.backend.utils.JwtService;
import com.backend.controllers.auth.AuthenticationRequest;
import com.backend.controllers.auth.AuthenticationResponse;
import com.backend.controllers.auth.RegisterRequest;
import com.backend.enums.Role;
import com.backend.models.User;
import com.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    //Dependencies
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    //Register new Member
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.MEMBER)
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findUsersByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user.getName());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
