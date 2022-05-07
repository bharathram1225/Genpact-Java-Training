package com.org.SpringRestCource.dao;

import org.springframework.data.repository.CrudRepository;

import com.org.SpringRestCource.entities.Course;

public interface UserRepository extends CrudRepository<Course, Integer>  {

}
