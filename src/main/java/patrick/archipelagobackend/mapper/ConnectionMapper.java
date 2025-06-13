package patrick.archipelagobackend.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import patrick.archipelagobackend.model.Connection;

import java.util.List;


@Mapper
public interface ConnectionMapper {
    List<Connection> findByUserId(@Param("userId") Long userId);

    void insertConnection(Connection connection);

    void updateConnection(Connection connection);

    void deleteConnection(@Param("id") Long id);

}
