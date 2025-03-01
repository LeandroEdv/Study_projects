package com.santana.real_estate.service.userservice;

import com.santana.real_estate.domain.userdomain.User;
import com.santana.real_estate.dto.userdto.RegisterRequestDTO;
import com.santana.real_estate.repository.userrepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(RegisterRequestDTO data) {

        if (this.userRepository.findByUsername(data.username()).isPresent()) {
            throw new RuntimeException("This user is already registered");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = User.builder()
                .username(data.username())
                .password(encryptedPassword)
                .build();
        return userRepository.save(user);
    }
}
