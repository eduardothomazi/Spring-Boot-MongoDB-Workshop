package com.eduardo.workshopmongodb.repositories;

import com.eduardo.workshopmongodb.entities.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
