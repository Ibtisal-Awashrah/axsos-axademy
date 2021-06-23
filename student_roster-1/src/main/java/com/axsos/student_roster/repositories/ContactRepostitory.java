package com.axsos.student_roster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.student_roster.models.Contact;


@Repository
public interface ContactRepostitory extends CrudRepository<Contact, Long>{
      List<Contact> findAll();
}
