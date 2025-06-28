package patrick.archipelagobackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;
import patrick.archipelagobackend.model.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);

    Optional<User> findUserByEmail(@Param("email") String email);

    void updateUser(User user);

    int countUserByEmail(String email);

    int countByUsernameIgnoreCase(String username);


}
