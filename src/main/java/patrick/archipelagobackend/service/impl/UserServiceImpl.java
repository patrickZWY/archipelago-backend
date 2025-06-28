package patrick.archipelagobackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patrick.archipelagobackend.exception.EmailAlreadyExistsException;
import patrick.archipelagobackend.exception.UsernameAlreadyExistsException;
import patrick.archipelagobackend.mapper.UserMapper;
import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import patrick.archipelagobackend.util.JwtUtil;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    @Override
    public User createUser(String email, String password, String username) {
        if (userMapper.countUserByEmail(email) > 0) {
            throw new EmailAlreadyExistsException("email used already: " + email);
        }

        if (userMapper.countByUsernameIgnoreCase(username) > 0) {
            throw new UsernameAlreadyExistsException("username used already: " + username);
        }

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .username(username)
                .build();
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public void deleteUser(String email, String password, String username) {

    }

    @Override
    public User loginUser(String username, String password) {
        return null;
    }

    @Override
    public void logout(String token) {
    }
}
