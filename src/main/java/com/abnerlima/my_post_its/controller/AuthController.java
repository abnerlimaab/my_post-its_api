package com.abnerlima.my_post_its.controller;

import com.abnerlima.my_post_its.dto.AuthResponseDTO;
import com.abnerlima.my_post_its.dto.TokenRequestDTO;
import com.abnerlima.my_post_its.entity.User;
import com.abnerlima.my_post_its.service.TokenValidationService;
import com.abnerlima.my_post_its.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final TokenValidationService tokenValidationService;
    private final UserService userService;

    public AuthController(TokenValidationService tokenValidationService, UserService userService) {
        this.tokenValidationService = tokenValidationService;
        this.userService = userService;
    }

    @PostMapping("/google")
    public ResponseEntity<?> authenticateWithGoogle(@RequestBody TokenRequestDTO tokenRequest) {
        String idToken = tokenRequest.getToken();

        User user = tokenValidationService.validateGoogleToken(idToken);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        User userDB = userService.findByEmail(user.getEmail());
        if (userDB != null) {
            user.setId(userDB.getId());
        }
        userService.save(user);

        return ResponseEntity.ok(new AuthResponseDTO(idToken, user));
    }
}
