package org.maintech.objeto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Objeto> getAllTopics(){
		List<Objeto> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Objeto getTopic (Integer id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Objeto topic) {		
		topicRepository.save(topic);
	}

	public void updateTopic(Integer id, Objeto topic) {		
		topicRepository.save(topic);
	}

	public void deleteTopic(Integer id) {
		topicRepository.delete(id);
	}
}
