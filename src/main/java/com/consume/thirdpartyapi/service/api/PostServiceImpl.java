package com.consume.thirdpartyapi.service.api;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consume.thirdpartyapi.service.PostService;



@Service
public class PostServiceImpl implements PostService {
	
	
	@Autowired
		private RestTemplate restTemplate;
	
	
	//This is baseurl of consumeing api
	String baseUrl = "https://jsonplaceholder.typicode.com/";
	
	StringBuilder stringBuilder = new StringBuilder(baseUrl);
	
	String posts = "/posts";
	
	String getSinglePost = "/posts/";
	
	String updatePostById = "/posts/";
	
	String deletePost = "/posts/";

	
	

	//This api consume get all posts
	@Override
	public List<Map<String, Object>> getAllPosts() {
		HttpEntity<Void> httpEntity = new HttpEntity<>(getPostHttpHeaders());
		String url = stringBuilder.append(posts).toString();
		ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
		return responseEntity.getBody();
	}
	
	//This api  is consume get single post
	@Override
	public Map<String, Object> getPostById(Integer id) {
		HttpEntity httpEntity = new HttpEntity<>(getPostHttpHeaders());
		String url = stringBuilder.append(getSinglePost).append(id).toString();
		ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
		return responseEntity.getBody();
	}
	
	//This is api payloder 
	public HttpHeaders getPostHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	//This is method insert post
	@Override
	public Map<String, Object> insertPost(Map<String, Object> paylaod) {
		HttpEntity<Map> httpEntity = new HttpEntity<>(paylaod,getPostHttpHeaders());
		String url = stringBuilder.append(posts).toString();
		ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
		return responseEntity.getBody();
	}

	//This method is update post
	@Override
	public Map<String, Object> updatePostById(Map<String, Object> payload, Integer id) {
		HttpEntity<Map> httpEntity = new HttpEntity<Map>(payload,getPostHttpHeaders());
		String url = stringBuilder.append(updatePostById).append(id).toString();
		ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);
		return responseEntity.getBody();
	}

	@Override
	public Map<String, Object> deletePost(Integer id) {
		HttpEntity<Map> httpEntity = new HttpEntity<Map>(getPostHttpHeaders());
		String url = stringBuilder.append(deletePost).append(id).toString();
		ResponseEntity<Map>responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);
		return responseEntity.getBody();
	}
	
}


