package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.viewmodel.CommentViewModel;
import com.trilogyed.stwitter.viewmodel.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    CommentClient commentClient;

    @Autowired
    PostClient postClient;

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "create.controller";

    public ServiceLayer() {

    }

    public ServiceLayer(RabbitTemplate rabbitTemplate, CommentClient commentClient, PostClient postClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.commentClient = commentClient;
        this.postClient = postClient;
    }

    @Transactional
    public PostViewModel createPost(PostViewModel postViewModel) {
        Post post = new Post();

        post.setPost(postViewModel.getPost());
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());

        post = postClient.createPost(post);

        postViewModel.setId(post.getPostID());

        return postViewModel;
    }

    public PostViewModel getPostById(int id) {

        try {
            Post post = postClient.getPostById(id);

            List <Comment> commentList = commentClient.getCommentsByPostId(post.getPostID());

            PostViewModel pvm = new PostViewModel();
            pvm.setId(post.getPostID());
            pvm.setPost(post.getPost());
            pvm.setPostDate(post.getPostDate());
            pvm.setPosterName(post.getPosterName());

            List<CommentViewModel> cvmList = new ArrayList<>();
            for (Comment comment : commentList) {
                CommentViewModel cvm = new CommentViewModel();

                cvm.setComment(comment.getComment());
                cvm.setCreateDate(comment.getCreateDate());
                cvm.setCommenterName(comment.getCommenterName());

                cvmList.add(cvm);
            }

            pvm.setCommentList(cvmList);

            return pvm;

        } catch (NullPointerException e) {

            return null;

        }

    }












    // tutor help
    private PostViewModel buildViewModelFromPosts (Post post) {

        PostViewModel pvm = new PostViewModel();

        pvm.setId(post.getPostID());
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());

        if (commentClient.getCommentsByPostId(post.getPostID()) != null) {

            pvm.setCommentList(commentClient.getCommentsByPostId(post.getPostID()));

        } else {

            pvm.setCommentList(null);

        }

        return pvm;
    }








    private Post buildPostViewModel(PostViewModel postViewModel) {

        Post post = new Post();

        post.setPost(postViewModel.getPost());
        post.setPostID(postViewModel.getId());
        post.setPostDate(postViewModel.getPostDate());
        post.setPosterName(postViewModel.getPosterName());

        return post;
    }


}
