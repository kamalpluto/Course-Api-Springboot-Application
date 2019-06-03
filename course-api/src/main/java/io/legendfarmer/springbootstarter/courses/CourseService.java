package io.legendfarmer.springbootstarter.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses(String id){
		//return courses; 
		return (List<Course>) courseRepository.findByTopicId(id) ;  
	}
	
	public Course getCourse(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course) {
		//courses.add(course);
		courseRepository.save(course);
	}

	public void updateCourse(Course course, String id) {
//		Course top = courses.stream().filter(t-> t.getId().equals(id)).findFirst().get();
//		top.setName(course.getName());
//		top.setDescription(course.getDescription());
		courseRepository.save(course);
		
	}

	public void deleteCourse(Course course, String id) {
		//courses.removeIf(t->t.getId().equals(id));
		courseRepository.delete(id);
		
	}
}
