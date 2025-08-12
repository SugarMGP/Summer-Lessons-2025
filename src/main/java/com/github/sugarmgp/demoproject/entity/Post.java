package com.github.sugarmgp.demoproject.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author SugarMGP
 * @TableName post
 */
@TableName(value = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Integer viewCount;

    @TableLogic
    private Boolean deleted;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}