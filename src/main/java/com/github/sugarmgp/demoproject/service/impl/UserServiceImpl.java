package com.github.sugarmgp.demoproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sugarmgp.demoproject.entity.User;
import com.github.sugarmgp.demoproject.mapper.UserMapper;
import com.github.sugarmgp.demoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author SugarMGP
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public Integer login(String username, String password) {
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUsername, username);

        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            user = User.builder().username(username).password(password).build();
            userMapper.insert(user);
        } else if (!user.getPassword().equals(password)) {
            return -1;
        }
        return user.getId();
    }
}
