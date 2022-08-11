package spring.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.test.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<?> getAllUsers() {
        return userRepository.findAll();
    }
}
