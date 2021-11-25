package com.eduardo.workshopmongodb.services;

import com.eduardo.workshopmongodb.entities.Post;
import com.eduardo.workshopmongodb.repositories.PostRepository;
import com.eduardo.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
         Optional<Post> post = postRepository.findById(id);
         if (post == null){
             throw new ObjectNotFoundException("Object not found!");
         }
         return post.get();
    }
/*
    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
    Commented to use the new query made on repository with @Query;
 */
    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);//converting in milliseconds
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
