package patrick.archipelagobackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import patrick.archipelagobackend.model.Connection;
import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.service.ConnectionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConnectionServiceImpl implements ConnectionService {



    @Override
    public Connection addConnection(User user, String fromMovieIMDbId, String toMovieIMDbId, String reason) {
        return null;
    }

    @Override
    public List<Connection> getConnectionsByUser(User user) {
        return List.of();
    }

    @Override
    public void deleteConnection(Long connectionId) {

    }

    @Override
    public Connection updateConnection(Long connectionId, String fromMovieIMDbId, String toMovieIMDbId, String newReason) {
        return null;
    }
}
