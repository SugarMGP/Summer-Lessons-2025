package com.github.sugarmgp.demoproject.service;

import com.github.sugarmgp.demoproject.dto.response.GetPostDetailResponse;
import com.github.sugarmgp.demoproject.dto.response.GetPostListElement;

import java.util.List;

/**
 * @author SugarMGP
 */
public interface PostService {
    void publishPost(Integer userId, String title, String content);

    void deletePost(Integer userId, Integer postId);

    void updatePost(Integer userId, Integer postId, String title, String content);

    List<GetPostListElement> getAllPosts();

    GetPostDetailResponse getPostDetail(Integer id);
}
