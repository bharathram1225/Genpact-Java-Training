package com.org.SpringRestCource.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringRestCource.dao.UserRepository;
import com.org.SpringRestCource.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	UserRepository userRepository;
	
	List<Course> list;
	
	
	
	
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145,"Java core Course","This course contins basics of java"));
		list.add(new Course(434, "Spring boot course", "Create  spring boot applications"));
	}



	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		List<Course> course = (List<Course>) userRepository.findAll();
		
		return course;
	}



	@Override
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		Course c=null;
//		for (Course course : list) {
//			if(course.getId()==courseId) {
//				c = course;
//				break;
//			}
//		}
		c = userRepository.findById(courseId).orElse(new Course());
		return c;
	}



	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);
		userRepository.save(course);
		return course;
	}



	@Override
	public void replaceCourse(Course course, int courseid) {
		// TODO Auto-generated method stub
		list = list.stream().map(c->{
			if(c.getId() == courseid) {
				c.setTitle(course.getTitle());
				c.setDiscription(course.getDiscription());
			}
			return c;
		}).collect(Collectors.toList());
	}



	@Override
	public void deleteCourse(int courseid) {
		userRepository.deleteById(courseid);
		
		
		
	}

}
