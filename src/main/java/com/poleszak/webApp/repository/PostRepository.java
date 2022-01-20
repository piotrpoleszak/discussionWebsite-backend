package com.poleszak.webApp.repository;

import com.poleszak.webApp.model.Post;
import com.poleszak.webApp.model.Subpost;
import com.poleszak.webApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>
{
    List<Post> findAllBySubpost(Subpost subpost);
    List<Post> findByUser(User user);
}
