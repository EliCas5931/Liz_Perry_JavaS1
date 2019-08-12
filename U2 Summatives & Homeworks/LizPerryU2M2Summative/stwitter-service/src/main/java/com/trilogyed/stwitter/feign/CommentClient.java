package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment);

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Comment> getAllComments();

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Comment getCommentByCommentId(@PathVariable int id);

    @RequestMapping(value = "/comments/post/{postId}", method = RequestMethod.GET)
    public List<Comment> getCommentsByPostId(@PathVariable int postId);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@RequestBody @Valid Comment comment, @PathVariable("id") int id);

    @RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int id);
}
