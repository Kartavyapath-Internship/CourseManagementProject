package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.SectionDao;
import com.app.dao.TopicDao;
import com.app.dto.TopicDto;
import com.app.entity.Section;
import com.app.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	SectionDao sectionDao;
	
	@Autowired
	TopicDao topicDao;

	@Override
	public Topic addTopic(TopicDto topicDto) {
		Section section =sectionDao.findById(topicDto.getSectionId()).orElseThrow(() -> new RuntimeException("Section not found"));
		Topic topic = new Topic(topicDto.getName() , section);
		
		return topicDao.save(topic);
	}

	@Override
	public Topic editTopic(TopicDto topicDto, int topicId) {
		
		Topic topic  = topicDao.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));
		topic.setName(topicDto.getName());
		
		 if (!topic.getSection().getId().equals(topicDto.getSectionId())) {
		        Section section = sectionDao.findById(topicDto.getSectionId())
		            .orElseThrow(() -> new RuntimeException("Section not found"));
		        topic.setSection(section);
		    }
		return topicDao.save(topic);
		
		
	
	
	}

	@Override
	public String deleteTopic(int topicId) {
		Topic topic = topicDao.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));
		topicDao.delete(topic);
		return "Deleted Successfully";
	}

	@Override
	public List<Topic> getAllTopic(int sectionId) {
		return topicDao.findAllBySectionId(sectionId);
	
	}

	@Override
	public Topic getTopicbyId(int topicId) {
		Topic topic  = topicDao.findById(topicId).orElseThrow(() -> new RuntimeException("Topic not found"));
		return topic;
	}
	

}
