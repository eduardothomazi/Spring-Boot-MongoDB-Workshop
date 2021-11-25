package com.eduardo.workshopmongodb.repositories;

import com.eduardo.workshopmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);//Spring Boot query methods

    @Query("{ 'title': { $regex: ?0, $options: 'i'} }") // (title) search in title, (?0) first regular expression,  (i) ignore case sensitive
    List<Post> findByTitle(String text);

    @Query("{$and: [ { date:{$gte: ?1} }, { date: { $lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i'} }, { 'body': { $regex: ?0, $options: 'i'} }, { 'comments.text': { $regex: ?0, $options: 'i'} } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
