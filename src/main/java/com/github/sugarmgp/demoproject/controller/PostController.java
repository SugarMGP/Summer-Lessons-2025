package com.github.sugarmgp.demoproject.controller;

import com.github.sugarmgp.demoproject.dto.request.DeletePostRequest;
import com.github.sugarmgp.demoproject.dto.request.PublishPostRequest;
import com.github.sugarmgp.demoproject.dto.request.UpdatePostRequest;
import com.github.sugarmgp.demoproject.dto.response.BaseListResponse;
import com.github.sugarmgp.demoproject.dto.response.GetPostDetailResponse;
import com.github.sugarmgp.demoproject.dto.response.GetPostListElement;
import com.github.sugarmgp.demoproject.result.AjaxResult;
import com.github.sugarmgp.demoproject.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * @author SugarMGP
 */
@RestController
@RequestMapping("/api/post")
@Slf4j
@Validated
public class PostController {
    @Resource
    private PostService postService;

    @PostMapping
    public AjaxResult<Void> publishPost(@Valid @RequestBody PublishPostRequest request) {
        postService.publishPost(request.getUserId(), request.getTitle(), request.getContent());
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult<Void> updatePost(@Valid @RequestBody UpdatePostRequest request) {
        postService.updatePost(request.getUserId(), request.getPostId(), request.getTitle(), request.getContent());
        return AjaxResult.success();
    }

    @DeleteMapping
    public AjaxResult<Void> deletePost(@Valid DeletePostRequest request) {
        postService.deletePost(request.getUserId(), request.getPostId());
        return AjaxResult.success();
    }

    @GetMapping("/all")
    public AjaxResult<BaseListResponse<GetPostListElement>> getAllPosts() {
        return AjaxResult.success(new BaseListResponse<>(postService.getAllPosts()));
    }

    @GetMapping
    public AjaxResult<GetPostDetailResponse> getPostDetail(@RequestParam("id") @NotNull Integer id) {
        return AjaxResult.success(postService.getPostDetail(id));
    }
}
