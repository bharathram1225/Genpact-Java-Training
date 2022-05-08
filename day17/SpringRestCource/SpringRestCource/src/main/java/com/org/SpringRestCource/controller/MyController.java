package com.org.SpringRestCource.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.org.SpringRestCource.Helper.FileUploadHelper;
import com.org.SpringRestCource.entities.Course;
import com.org.SpringRestCource.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private FileUploadHelper fileuploadhelper;

	@GetMapping("/home")
	public String home() {
		return "Welcome to cources application";
	}
	
	//get the courses
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Integer.parseInt(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//replace the course with respect to id
	@PutMapping("/courses/{courseid}")
	public Course replaceCourse(@RequestBody Course course, @PathVariable int courseid) {
		this.courseService.replaceCourse(course, courseid);
		return course;
	}
	
	//delete the course of perticular id
	@DeleteMapping("/courses/{courseid}")
	public void deleteCourse(@PathVariable int courseid) {
		this.courseService.deleteCourse(courseid);
		
	}
	
	//Find by title
	@GetMapping("/courses/title/{title}")
	public List<Course> getTitle(@PathVariable String title) {
		return this.courseService.findBytitles(title);
	}
	
	//find the course where the id is greater then provided id
	@GetMapping("courses/greater/{id}")
	public List<Course> getCourseGreaterThanid(@PathVariable int id){
		return this.courseService.findByCourseGreaterThanid(id);
	}
	
	//find by title and sort by description
	@GetMapping("course/title/sort/{title}")
	public List<Course> getTitleSortedByDescription(@PathVariable String title){
		return this.courseService.findByTitleSortByDescripttion(title);
	}
	
	//to handling the file uploads 
	@PostMapping("courses/fileupload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		try 
		{
			
//			System.out.println(file.getSize());
//			System.out.println(file.getOriginalFilename());
//			System.out.println(file.getName());
//			if(file.isEmpty()) {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("file is empty!....");
//			}
			
//			if(!file.getContentType().equals("image/jpg")) {
//				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Only jpeg files are allowed !......");
//			}
			
			
			//file upload code
			boolean f = fileuploadhelper.uploadfile(file);
			if(f) 
			{
//				return ResponseEntity.ok("File uploaded successfully");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Not uploaded");
	}
	
	
}
