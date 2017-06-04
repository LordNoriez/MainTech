package org.maintech.objeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ObjetoController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/welcome.html")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/topics")
	public ModelAndView getAllTopics() {
		return new ModelAndView("welcome");
		//return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{foo}")
	public Objeto getTopic(@PathVariable("foo") Integer id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Objeto topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Objeto topic, @PathVariable("id") Integer id) {
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable Integer id){
		topicService.deleteTopic(id);
	}
}
