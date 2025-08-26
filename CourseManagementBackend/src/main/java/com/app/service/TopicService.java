package com.app.service;

import java.util.List;

import com.app.dto.TopicDto;
import com.app.entity.Topic;

public interface TopicService {
	
Topic addTopic(TopicDto topicDto);

Topic editTopic(TopicDto topicDto , int topicId);

String deleteTopic(int topicId);

List<Topic> getAllTopic(int sectionId);

Topic getTopicbyId(int topicId);

}
