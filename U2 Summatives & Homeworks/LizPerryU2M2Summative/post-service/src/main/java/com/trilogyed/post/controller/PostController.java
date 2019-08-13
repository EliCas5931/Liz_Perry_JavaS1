package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.dao.PostDaoJdbcTemplateImpl;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao postDao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Post createPost(@RequestBody @Valid Post post) {

        return postDao.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id) {

        return postDao.getPost(id);
    }

    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts(){
        return postDao.getAllPosts();
    }

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostByPosterName(@PathVariable("poster_name") String poster_name){

       return postDao.getPostByPosterName(poster_name);

    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {

        if (post.getPostID() == 0){
            post.setPostID(id);
        }
        if (id != post.getPostID()){
            throw new IllegalArgumentException("ID's do not match!");
        }
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }
}
