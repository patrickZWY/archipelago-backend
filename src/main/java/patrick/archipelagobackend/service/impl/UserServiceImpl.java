package patrick.archipelagobackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {



    @Override
    public User createUser(String email, String password, String username) {
        return null;
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
