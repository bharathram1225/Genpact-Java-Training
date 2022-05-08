package com.org.SpringRestCource.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.SpringRestCource.dao.UserRepository;
import com.org.SpringRestCource.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	UserRepository userRepository;
	
//	List<Course> list;
//	
//	
//	
//	
//	
//	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145,"Java core Course","This course contins basics of java"));
//		list.add(new Course(434, "Spring boot course", "Create  spring boot applications"));
//	}



	@Override
	public ResponseEntity<List<Course>> getCourses() {
		// TODO Auto-generated method stub
		List<Course> course = (List<Course>) userRepository.findAll();
		if(course.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(course));
		
		
	}



	@Override
	public ResponseEntity<Course> getCourse(int courseId) {
		// TODO Auto-generated method stub
		Course c=null;
//		for (Course course : list) {
//			if(course.getId()==courseId) {
//				c = course;
//				break;
//			}
//		}		
//		
//		c = userRepository.findById(courseId).orElse(new Course());
//		return c;
		
		c = userRepository.findById(courseId).orElse(new Course());
		return ResponseEntity.of(Optional.of(c));
	}



	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		userRepository.save(course);
		return course;
	}



	@Override
	public void replaceCourse(Course course, int courseid) {
//		// TODO Auto-generated method stub
//		list = list.stream().map(c->{
//			if(c.getId() == courseid) {
//				c.setTitle(course.getTitle());
//				c.setDiscription(course.getDiscription());
//			}
//			return c;
//		}).collect(Collectors.toList());
		String title = course.getTitle();
		String des = course.getDiscription();
		userRepository.findByIDReplaceCourse(title, courseid, des);		
	}



	@Override
	public void deleteCourse(int courseid) {
		userRepository.deleteById(courseid);
		
		
		
	}

	public List<Course> findBytitles(String title){
		return userRepository.findBytitle(title);
	}



	@Override
	public List<Course> findByCourseGreaterThanid(int id) {
		// TODO Auto-generated method stub
		return userRepository.findByidGreaterThan(id);
		
	}



	@Override
	public List<Course> findByTitleSortByDescripttion(String title) {
		
		return userRepository.findBytitleSorted(title);
	}


}
