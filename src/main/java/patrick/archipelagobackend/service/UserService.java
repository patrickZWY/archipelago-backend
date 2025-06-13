package patrick.archipelagobackend.service;

import patrick.archipelagobackend.model.User;

public interface UserService {
    User createUser(String email, String password, String username);
    void deleteUser(String email, String password, String username);
    User loginUser(String username, String password);
    void logout(String token);

}
