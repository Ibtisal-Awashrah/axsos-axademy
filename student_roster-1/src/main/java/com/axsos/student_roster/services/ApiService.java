package com.axsos.student_roster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.student_roster.models.Contact;
import com.axsos.student_roster.models.Student;
import com.axsos.student_roster.repositories.ContactRepostitory;
import com.axsos.student_roster.repositories.StudentRepository;

@Service
public class ApiService {

	private final ContactRepostitory contactRepo;
	private final StudentRepository studentRepo;

	public ApiService(ContactRepostitory contactRepo, StudentRepository studentRepo) {
		this.contactRepo = contactRepo;
		this.studentRepo = studentRepo;
	}

	public Student createStudent(Student student) {

		return studentRepo.save(student);

	}

	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}

	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	public List<Contact> allContacts() {
		return contactRepo.findAll();
	}
	public List<Student> allNullStudents() {
		return studentRepo.findByContactIdIsNull();
	}
	
}
