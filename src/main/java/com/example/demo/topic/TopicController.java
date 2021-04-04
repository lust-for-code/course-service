package com.example.demo.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}

	@GetMapping("/topics/{id}")
	public Optional<Topic> geTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@PostMapping("/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}

	@PutMapping("/topics/{id}")
	public Topic updateTopic(@PathVariable String id, @RequestBody Topic topic) {
		topicService.updateTopic(id, topic);
		return topic;
	}

	@DeleteMapping("/topics/{id}")
	public Optional<Topic> deleteTopic(@PathVariable String id) {
		Optional<Topic> topic = topicService.getTopic(id);
		topicService.deleteTopic(id);
		return topic;
	}
}
