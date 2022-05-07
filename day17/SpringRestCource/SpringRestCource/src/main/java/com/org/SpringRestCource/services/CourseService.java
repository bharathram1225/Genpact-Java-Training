package com.org.SpringRestCource.services;

import java.util.List;

import com.org.SpringRestCource.entities.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(int courseId);
	public Course addCourse(Course course);
	public void replaceCourse(Course course, int courseid);
	public void deleteCourse(int courseid);
}
