package com.eduardo.workshopmongodb.repositories;

import com.eduardo.workshopmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
