package com.example.cleancode.authentication;

import com.example.cleancode.authentication.dto.AssignRoleDTO;
import com.example.cleancode.authentication.dto.CreateUserDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/auth/keycloak")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KeycloakController {

    private final KeycloakService keycloakService;

    public KeycloakController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @GetMapping("/getAdminToken")
    public String getAdminToken() throws Exception {

        return keycloakService.getAdminToken();
    }

    @PostMapping("/createUser")
    public String createUser (@RequestBody CreateUserDTO createUserDTO) {
        return keycloakService.createUser(createUserDTO);
    }

    @PostMapping("/getUserId/{username}")
    public String getUserId(@PathVariable String username, @RequestHeader String adminToken) {

        return keycloakService.getUserId(username, adminToken);

    }

    @PostMapping("/assignRoleToUser")
    public String assignRoleToUser(@RequestBody AssignRoleDTO assignRoleDTO) {
        return keycloakService.assignRoleToUser(assignRoleDTO.getRole(), assignRoleDTO.getUsername(), assignRoleDTO.getAdminToken());

    }

}
