package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.service.ServiceLayer;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
//@CacheConfig(cacheNames = {switter})
public class StwitterController {

    ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel postViewModel) {
        System.out.println("CREATING POST");
        return service.createPost(postViewModel);
    }

    @Cacheable
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<PostViewModel> getAllPosts() {
        return service.getAllPosts();
    }

    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPostById(@PathVariable int id) {
        System.out.println("GETTING POST ID = " + id);
        return service.getPostById(id);
    }
}
