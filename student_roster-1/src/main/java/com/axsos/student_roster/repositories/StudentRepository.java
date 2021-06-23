package com.axsos.student_roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.student_roster.models.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{
          
	List <Student> findAll();
	List<Student> findByContactIdIsNull();
}
