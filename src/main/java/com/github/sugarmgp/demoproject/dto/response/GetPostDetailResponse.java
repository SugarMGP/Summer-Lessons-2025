package com.github.sugarmgp.demoproject.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author SugarMGP
 */
@Data
@Builder
public class GetPostDetailResponse {
    private String title;
    private String content;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
