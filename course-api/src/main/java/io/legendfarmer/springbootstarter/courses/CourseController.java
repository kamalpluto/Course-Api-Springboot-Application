package io.legendfarmer.springbootstarter.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.legendfarmer.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getCourses(id);
	}
	
	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value="topics/{id}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String id) {
		course.setTopic(new Topic("id","",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value="topics/{id}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course,@PathVariable String courseId) {
		course.setTopic(new Topic("id","",""));
		courseService.updateCourse(course,courseId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, value="topics/{id}/courses/{courseId}")
	public void deleteCourse(@RequestBody Course course,@PathVariable String courseId) {
		courseService.deleteCourse(course,courseId);
	}
}
