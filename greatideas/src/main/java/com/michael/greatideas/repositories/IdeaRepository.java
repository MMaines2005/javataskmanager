package com.michael.greatideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michael.greatideas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository <Idea, Long> {

	//Grabs all ideas from database
	List<Idea>findAll();
	
}
