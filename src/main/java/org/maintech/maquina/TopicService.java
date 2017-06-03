package org.maintech.maquina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*private List<Topic> topics =  new ArrayList<>(Arrays.asList(
			new Topic(1, "Spring Framework", "Spring Framework Description"),
			new Topic(2, "Core Java", "Java Core Description"),
			new Topic(3, "JavaScript", "JavaScript Description")
		));*/
	
	public List<Objeto> getAllTopics(){
		//return topics;
		List<Objeto> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Objeto getTopic (Integer id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Objeto topic) {		
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Integer id, Objeto topic) {		
		/*for (int i = 0;i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		topicRepository.save(topic);
	}

	public void deleteTopic(Integer id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
}
