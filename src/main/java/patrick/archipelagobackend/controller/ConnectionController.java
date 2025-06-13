package patrick.archipelagobackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping
    public ResponseEntity<ApiResponse<List<Connection>>> getConnections(@RequestAttribute User user) {
        List<Connection> connections = connectionService.getConnectionsByUser(user);
        return ResponseEntity.ok(ApiResponse.success(connections, "Connections retrieved successfully"));
    }

























}
