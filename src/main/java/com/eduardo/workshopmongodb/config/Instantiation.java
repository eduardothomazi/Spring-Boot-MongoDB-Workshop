package com.eduardo.workshopmongodb.config;

import com.eduardo.workshopmongodb.dto.AuthorDTO;
import com.eduardo.workshopmongodb.dto.CommentDTO;
import com.eduardo.workshopmongodb.entities.Comment;
import com.eduardo.workshopmongodb.entities.Post;
import com.eduardo.workshopmongodb.entities.User;
import com.eduardo.workshopmongodb.repositories.PostRepository;
import com.eduardo.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        //saving users first is needed because if you create a Post obj the author id will be null

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

        Comment comment1 = new Comment(null, "Boa viagem mano!",sdf.parse("21/03/2018"),alex ,post1);
        CommentDTO c1 = new CommentDTO(comment1);
        Comment comment2 = new Comment(null, "Aproveite!",sdf.parse("22/03/2018"),bob ,post1);
        CommentDTO c2 = new CommentDTO(comment2);
        Comment comment3 = new Comment(null, "Tenha um otimo dia!",sdf.parse("23/03/2018"),alex ,post2);
        CommentDTO c3 = new CommentDTO(comment3);

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));


        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
