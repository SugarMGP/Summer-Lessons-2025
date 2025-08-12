package com.github.sugarmgp.demoproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SugarMGP
 * @TableName user
 */
@TableName(value = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;
}