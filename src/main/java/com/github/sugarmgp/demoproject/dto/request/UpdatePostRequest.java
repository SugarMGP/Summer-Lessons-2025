package com.github.sugarmgp.demoproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author SugarMGP
 */
@Data
@AllArgsConstructor
@Builder
public class UpdatePostRequest {
    @NotNull
    private Integer userId;

    @NotNull
    private Integer postId;

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
