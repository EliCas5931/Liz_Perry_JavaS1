package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@RequestBody @Valid Post post);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts();

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPostById(@PathVariable int id);

    @RequestMapping(value = "/posts/user/{posterName}", method = RequestMethod.GET)
    public List<Post> getPostByPosterName(@PathVariable("posterName") String posterName);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody @Valid Post post, @PathVariable("id") int id);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id);

}
