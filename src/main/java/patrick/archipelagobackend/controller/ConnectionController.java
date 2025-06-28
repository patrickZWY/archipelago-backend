package patrick.archipelagobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patrick.archipelagobackend.model.Connection;
import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.service.ConnectionService;
import patrick.archipelagobackend.util.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/connection")
@RequiredArgsConstructor
public class ConnectionController {
    private final ConnectionService connectionService;

    @GetMapping("/getConnection")
    public ResponseEntity<ApiResponse<List<Connection>>> getConnections(@RequestAttribute User user) {
        List<Connection> connections = connectionService.getConnectionsByUser(user);
        return ResponseEntity.ok(ApiResponse.success(connections, "Connections retrieved successfully"));
    }

    @PostMapping("/addConnection")
    public ResponseEntity<ApiResponse<Connection>> addConnection(@RequestAttribute User user,
                                                                 @RequestParam String fromMovieId,
                                                                 @RequestParam String toMovieId,
                                                                 @RequestParam String reason) {
        Connection connection = connectionService.addConnection(user, fromMovieId, toMovieId, reason);
        return ResponseEntity.ok(ApiResponse.success(connection, "Connection added success"));
    }

    @PutMapping("/updateConnection/{id}")
    public ResponseEntity<ApiResponse<Connection>> updateConnection(@PathVariable("id") Long id, @RequestParam String reason, @RequestParam String fromMovieIMDbId, @RequestParam String toMovieIMDbId)
    {
        Connection connection = connectionService.updateConnection(id, fromMovieIMDbId, toMovieIMDbId, reason);
        return ResponseEntity.ok(ApiResponse.success(connection, "Connection update successful"));

    }

    @DeleteMapping("/deleteConnection/{id}")
    public ResponseEntity<ApiResponse<String>> deleteConnection(@PathVariable Long id) {
        connectionService.deleteConnection(id);
        return ResponseEntity.ok(ApiResponse.success("Connection delete successful"));
    }
























}
