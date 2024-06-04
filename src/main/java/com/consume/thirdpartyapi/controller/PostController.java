package com.consume.thirdpartyapi.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consume.thirdpartyapi.service.PostService;



@RestController
@RequestMapping("/api")
public class PostController {
	
	
	@Autowired
		private PostService postService;
	
	//This endpoint consume get all posts
	@GetMapping("/getPosts")
	public List<Map<String, Object>> getAllPosts() {
		return postService.getAllPosts();
	}
	
	//This endpoint consume get single dd
	@GetMapping("/getsinglepost/{id}")
	public Map<String, Object> getSinglePost(@PathVariable Integer id) {
		return postService.getPostById(id);
	}

	//This endpoint sonsume insert post
	@PostMapping("/insertposts")
	public Map<String, Object> insertPost(@RequestBody Map<String, Object> paylaod) {
		return postService.insertPost(paylaod);
	}
	
	//This endpoint update post
	@PutMapping("/updatepost/{id}")
	public Map<String, Object> updatePost(@RequestBody Map<String, Object> paylaod, @PathVariable Integer id) {
		return postService.updatePostById(paylaod, id);
		
	}
	
	//This endpoint delete post
	@DeleteMapping("/deletepost/{id}")
	public Map<String, Object> deletePost(@PathVariable Integer id) {
		return postService.deletePost(id);
	}
	
}
