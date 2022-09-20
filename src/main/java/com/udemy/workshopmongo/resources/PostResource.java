package com.udemy.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.workshopmongo.domain.Post;
import com.udemy.workshopmongo.resources.util.URL;
import com.udemy.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value ="text", defaultValue = "") String text) {
		text = URL.decoderParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
	@RequestParam(value ="text", defaultValue = "") String text,
	@RequestParam(value ="minDate", defaultValue = "") String minDate,
	@RequestParam(value ="maxDate", defaultValue = "") String maxDate){
		text = URL.decoderParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());		
		List<Post> list = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);

	}
	
	
}
