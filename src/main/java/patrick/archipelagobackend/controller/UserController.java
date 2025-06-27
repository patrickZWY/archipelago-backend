package patrick.archipelagobackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patrick.archipelagobackend.dto.request.LoginRequest;
import patrick.archipelagobackend.dto.request.RegisterRequest;
import patrick.archipelagobackend.dto.response.LoginResponse;
import patrick.archipelagobackend.dto.response.RegisterResponse;
import patrick.archipelagobackend.mapper.UserMapper;
import patrick.archipelagobackend.model.User;
import patrick.archipelagobackend.service.UserService;
import patrick.archipelagobackend.util.ApiResponse;
import patrick.archipelagobackend.util.JwtUtil;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterResponse>> register(@RequestBody RegisterRequest request) {
        User user = userService.createUser(request.getEmail(), request.getPassword(), request.getUsername());
        String token = jwtUtil.generateToken(user);
        ApiResponse<RegisterResponse> response = ApiResponse.success(new RegisterResponse(token), "user registration successful");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {
        User user = userService.loginUser(request.getUsername(), request.getPassword());
        String token = jwtUtil.generateToken(user);
        ApiResponse<LoginResponse> response = ApiResponse.success(new LoginResponse(token), "user login successful");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<Void>> logout(@RequestHeader("Authorization") String token) {
        userService.logout(token);
        return ResponseEntity.ok(ApiResponse.success(null, "logout successful"));
    }


























}
