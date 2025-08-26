package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.TopicDto;
import com.app.entity.Topic;
import com.app.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewTopic(@RequestBody TopicDto topicDto)
	{
		Topic topic = topicService.addTopic(topicDto);
		return ResponseEntity.ok(topic);
	}
	
	@DeleteMapping("/delete/{topicId}")
	public ResponseEntity<?> deleteTopic(@PathVariable("topicId") int id)
	{
		topicService.deleteTopic(id);
		return ResponseEntity.ok("Topic Deleted");
		
	}
	
	@GetMapping("/getTopicById/{topicId}")
	public ResponseEntity<?> getTopicById(@PathVariable("topicId") int id)
	{
		Topic topic = topicService.getTopicbyId(id);
		return ResponseEntity.ok(topic);
	}
	
	@GetMapping("getAllTopics/{sectionId}")
	public ResponseEntity<?> getAllTopics(@PathVariable ("sectionId") int id)
	{
		List<Topic> list = topicService.getAllTopic(id);
		return ResponseEntity.ok(list);
		
	}
	
	@PutMapping("/editTopic/{topicId}")
	public ResponseEntity<?> editTopic(@RequestBody TopicDto topicDto , @PathVariable("topicId") int id)
	{
		Topic topic = topicService.editTopic(topicDto, id);
		return ResponseEntity.ok(topic);
		
	}
}
