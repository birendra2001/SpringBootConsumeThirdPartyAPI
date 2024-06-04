package com.consume.thirdpartyapi.service;

import java.util.List;
import java.util.Map;

public interface PostService {
	
	//This is get all posts
	List<Map<String, Object>> getAllPosts();
	
	//This is get single record of post
	Map<String, Object> getPostById(Integer id);
	
	//This is insert the post
	Map<String, Object> insertPost(Map<String, Object> paylaod);
	
	//This method update post
	Map<String, Object> updatePostById(Map<String, Object> payload, Integer id);
	
	Map<String, Object> deletePost(Integer id);
	
	
}
