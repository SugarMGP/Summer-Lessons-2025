package com.github.sugarmgp.demoproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author SugarMGP
 */
@Data
@AllArgsConstructor
@Builder
public class LoginRequest {
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    private String password;
}
