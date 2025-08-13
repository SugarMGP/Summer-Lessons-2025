package com.github.sugarmgp.demoproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.sugarmgp.demoproject.entity.Post;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author SugarMGP
 * @description 针对表【post】的数据库操作Mapper
 * @createDate 2025-08-10 13:46:46
 * @Entity com.github.sugarmgp.demoproject.entity.Post
 */
public interface PostMapper extends BaseMapper<Post> {
    @Update("UPDATE post SET view_count = view_count + 1 WHERE ${id}")
    void incrementViewCount(@Param("id") Integer id);
}




