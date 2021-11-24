package com.eduardo.workshopmongodb.services;

import com.eduardo.workshopmongodb.entities.User;
import com.eduardo.workshopmongodb.repositories.UserRepository;
import com.eduardo.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

}
