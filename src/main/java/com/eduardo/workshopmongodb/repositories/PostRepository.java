package com.eduardo.workshopmongodb.repositories;

import com.eduardo.workshopmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);//Spring Boot query methods
}
