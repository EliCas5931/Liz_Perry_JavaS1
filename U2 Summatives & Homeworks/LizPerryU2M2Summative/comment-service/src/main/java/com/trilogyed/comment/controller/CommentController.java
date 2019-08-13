package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDaoJdbcTemplateImpl;
import com.trilogyed.comment.exception.NotFoundException;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentDaoJdbcTemplateImpl commentDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody @Valid Comment comment){
        return commentDao.createComment(comment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getCommentById(@PathVariable int id){

        Comment comment = commentDao.getComment(id);

        if (comment == null){

            throw new NotFoundException("No note was found with id " + id);
        }

        return comment;
    }

    @GetMapping("/post/{post_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentByPostId(@PathVariable int post_id){

        return commentDao.getAllCommentsByPostId(post_id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        return commentDao.getAllComments();
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String updateComment(@PathVariable int id, @RequestBody @Valid Comment comment){
//
//        if (comment.getCommentId() == 0){
//
//            comment.setCommentId(id);
//
//        }
//
//        if (id != comment.getCommentId()){
//
//            throw new IllegalArgumentException("ID does not match!");
//        }
//        // Ask tutor for help with this. Seem to be doing it wrong
//
////      commentDao.updateComment(comment);
//        String updateResponse = commentDao.updateComment(comment);
//        String response = updateResponse;
//
//        return response;
//    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@RequestBody @Valid Comment comment, @PathVariable int id) {

        if (comment.getCommentId() == 0)

            comment.setCommentId(id);

        if (id != comment.getCommentId()) {

            throw new IllegalArgumentException("ID does not match!");

        }

        commentDao.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable int id){
        commentDao.deleteComment(id);
    }

}
