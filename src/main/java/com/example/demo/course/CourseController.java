package com.example.demo.course;

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

import com.example.demo.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	CourseService courseSerive;

	@GetMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {

		return courseSerive.getAllCourses(topicId);
	}

	@GetMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseSerive.getCourse(id);
	}

	@PostMapping("/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseSerive.addCourse(course);
		return course;
	}

	@PutMapping("/topics/{topicId}/courses/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseSerive.updateCourse(course);
		return course;
	}

	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> deleteCourse(@PathVariable String id) {
		Optional<Course> course = courseSerive.getCourse(id);
		courseSerive.deleteCourse(id);
		return course;
	}
}
