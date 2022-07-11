package com.etz.pocexaminationapi.pocexaminationapi.service.impl;

import com.etz.pocexaminationapi.pocexaminationapi.exception.ResourceNotFoundException;
import com.etz.pocexaminationapi.pocexaminationapi.model.Post;
import com.etz.pocexaminationapi.pocexaminationapi.payload.PostDto;
import com.etz.pocexaminationapi.pocexaminationapi.repository.PostRepository;
import com.etz.pocexaminationapi.pocexaminationapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // convert Dto to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to Dto
        PostDto postResponse = mapToDTO(newPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setName(postDto.getName());
        post.setDescription(postDto.getDescription());
        post.setCode(postDto.getCode());
        post.setLevels(postDto.getLevels());
        post.setStatus(postDto.getStatus());
        post.setCertificates(postDto.getCertificates());
        post.setDate_established(postDto.getDate_established());

        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        //get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    //convert Entity to DTO
    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setName(post.getName());
        postDto.setDescription(post.getDescription());
        postDto.setCode(post.getCode());
        postDto.setLevels(post.getLevels());
        postDto.setStatus(post.getLevels());
        postDto.setCertificates(post.getCertificates());
        postDto.setDate_established(post.getDate_established());
        return postDto;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setName(postDto.getName());
        post.setDescription(postDto.getDescription());
        post.setCode(postDto.getCode());
        post.setLevels(postDto.getLevels());
        post.setStatus(postDto.getStatus());
        post.setCertificates(postDto.getCertificates());
        post.setDate_established(postDto.getDate_established());
        return post;
    }
}
