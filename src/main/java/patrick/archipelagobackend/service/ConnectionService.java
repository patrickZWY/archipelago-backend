package patrick.archipelagobackend.service;

import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.model.Connection;

import java.util.List;

public interface ConnectionService {
    Connection addConnection(User user, String fromMovieIMDbId, String toMovieIMDbId, String reason);
    List<Connection> getConnectionsByUser(User user);
    void deleteConnection(Connection connection);
    Connection updateConnection(User user, String fromMovieIMDbId, String toMovieIMDbId, String newReason);
}




















