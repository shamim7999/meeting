package org.dsi.meeting.services;

import lombok.AllArgsConstructor;
import org.dsi.meeting.models.User;
import org.dsi.meeting.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserSevice {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new RuntimeException("Resource Not found");
        }
    }
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.delete(findUserById(userId));
    }
}
