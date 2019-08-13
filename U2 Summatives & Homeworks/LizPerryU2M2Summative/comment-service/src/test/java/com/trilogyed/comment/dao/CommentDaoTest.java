package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    protected CommentDao commentDao;

    @Before
    public void setUp() throws Exception{
        List<Comment> commentList = commentDao.getAllComments();

        for (Comment comment : commentList) {
            commentDao.deleteComment(comment.getCommentId());
        }
    }

    @Test
    public void addGetDeleteComment(){
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,4,15));
        comment.setCommenterName("John Smith");
        comment.setComment("This is John's first comment!");

        comment = commentDao.createComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());
        assertEquals(comment1, comment);

        commentDao.deleteComment(comment.getCommentId());

        comment1 = commentDao.getComment(comment.getCommentId());

        assertNull(comment1);
    }

    @Test
    public void getAllComments() {

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019, 02, 01));
        comment1.setCommenterName("Winston Smith");
        comment1.setComment("This is pretty nice!");

        comment1 = commentDao.createComment(comment1);

        List<Comment> commentList = commentDao.getAllComments();
        assertEquals(1, commentList.size());

        Comment comment2 = new Comment();
        comment2.setPostId(1);
        comment2.setCreateDate(LocalDate.of(2019, 02, 01));
        comment2.setCommenterName("Winston Smith");
        comment2.setComment("This is pretty nice!");

        comment2 = commentDao.createComment(comment2);

        commentList = commentDao.getAllComments();
        assertEquals(2, commentList.size());
    }

    @Test
    public void updateComment(){
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,5,15));
        comment.setCommenterName("John Smith");
        comment.setComment("This is John's first comment!");

        comment = commentDao.createComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,6,15));
        comment.setCommenterName("John Smith");
        comment.setComment("This is John's second comment!");

        commentDao.updateComment(comment);

        Comment comment1 = commentDao.getComment(comment.getCommentId());

        assertEquals(comment1, comment);
    }


    @Test
    public void getAllCommentsByPostId(){
        Comment comment = new Comment();

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,5,15));
        comment.setCommenterName("John Smith");
        comment.setComment("This is John's first comment!");

        comment = commentDao.createComment(comment);

        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,6,15));
        comment.setCommenterName("John Smith");
        comment.setComment("This is John's second comment!");

        commentDao.createComment(comment);

        List<Comment> commentList = commentDao.getAllCommentsByPostId(1);
        assertEquals(2, commentList.size());
    }
}
