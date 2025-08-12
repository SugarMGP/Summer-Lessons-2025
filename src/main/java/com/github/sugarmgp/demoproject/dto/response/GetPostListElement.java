package com.github.sugarmgp.demoproject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author SugarMGP
 */
@Data
@Builder
public class GetPostListElement {
    private Integer id;

    private String title;

    private LocalDateTime createdAt;
}
