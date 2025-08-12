package com.github.sugarmgp.demoproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.sugarmgp.demoproject.dto.response.GetPostDetailResponse;
import com.github.sugarmgp.demoproject.dto.response.GetPostListElement;
import com.github.sugarmgp.demoproject.entity.Post;
import com.github.sugarmgp.demoproject.mapper.PostMapper;
import com.github.sugarmgp.demoproject.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SugarMGP
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    @Override
    public void publishPost(Integer userId, String title, String content) {
        Post post = Post.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .viewCount(0)
                .build();
        postMapper.insert(post);
    }

    @Override
    public void deletePost(Integer userId, Integer postId) {
        Post post = postMapper.selectById(postId);
        if (post == null) {
            // 缺失错误处理
            return;
        }
        if (!post.getUserId().equals(userId)) {
            // 缺失错误处理
            return;
        }
        postMapper.deleteById(postId);
    }

    @Override
    public void updatePost(Integer userId, Integer postId, String title, String content) {
        Post post = postMapper.selectById(postId);
        if (post == null) {
            // 缺失错误处理
            return;
        }
        if (!post.getUserId().equals(userId)) {
            // 缺失错误处理
            return;
        }
        post.setTitle(title);
        post.setContent(content);
        postMapper.updateById(post);
    }

    @Override
    public List<GetPostListElement> getAllPosts() {
        LambdaQueryWrapper<Post> postQueryWrapper = new LambdaQueryWrapper<Post>()
                .orderByDesc(Post::getCreatedAt);
        List<Post> list = postMapper.selectList(postQueryWrapper);
        return list.stream()
                .map(post -> GetPostListElement.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .createdAt(post.getCreatedAt())
                        .build()
                ).toList();
    }

    @Override
    public GetPostDetailResponse getPostDetail(Integer id) {
        Post post = postMapper.selectById(id);
        if (post == null) {
            // 缺失错误处理
            return null;
        }
        GetPostDetailResponse resp = GetPostDetailResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .viewCount(post.getViewCount())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
        post.setViewCount(post.getViewCount() + 1);
        postMapper.updateById(post);
        return resp;
    }
}
