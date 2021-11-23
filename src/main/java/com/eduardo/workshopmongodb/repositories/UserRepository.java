package com.eduardo.workshopmongodb.repositories;

import com.eduardo.workshopmongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
