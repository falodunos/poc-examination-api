package com.etz.pocexaminationapi.pocexaminationapi.service;

import com.etz.pocexaminationapi.pocexaminationapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
