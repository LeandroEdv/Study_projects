package com.santana.real_estate.service.userservice;

import com.santana.real_estate.domain.userdomain.User;
import com.santana.real_estate.domain.userdomain.UserRole;
import com.santana.real_estate.dto.userdto.LoginRequestDTO;
import com.santana.real_estate.dto.userdto.RegisterRequestDTO;
import com.santana.real_estate.dto.userdto.UserResponseDTO;
import com.santana.real_estate.repository.userrepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public UserResponseDTO register(RegisterRequestDTO data) {

        if (this.userRepository.findByUsername(data.username()) != null) {
            throw new RuntimeException("This user is already registered");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = User.builder()
                .username(data.username())
                .password(encryptedPassword)
                .role(UserRole.USER)
                .build();
        userRepository.save(user);

        return new UserResponseDTO(user.getUsername());
    }

    public void login(LoginRequestDTO data) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication authenticate = this.authenticationManager.authenticate(authenticationToken);

    }
}
