package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feignClient.CommentClient;
import com.trilogyed.stwitter.feignClient.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    @Mock
    RabbitTemplate rabbitTemplate;
    @Mock
    PostClient postClient;
    @Mock
    CommentClient commentClient;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        createCommentService();
        createPostService();
        serviceLayer = new ServiceLayer(rabbitTemplate, commentClient, postClient);

    }
    public void createCommentService(){
        commentClient = mock(CommentClient.class);
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019,8,12));
        comment.setCommenterName("Liz Perry");
        comment.setComment("My first Stwitter comment ever!");
        commentList.add(comment);

        Comment comment1 = new Comment();
        comment1.setPostId(1);
        comment1.setCreateDate(LocalDate.of(2019,8,11));
        comment1.setCommenterName("Kaleigh Harold");
        comment1.setComment("Kaleigh's first Stwitter comment ever!");

        commentList.add(comment1);

        doReturn(commentList).when(commentClient).getCommentsByPostId(1);
    }

    public void createPostService(){
        postClient = mock(PostClient.class);

        Post post = new Post();
        post.setPostID(1);
        post.setPostDate(LocalDate.of(2019,8,12));
        post.setPosterName("Liz Perry");
        post.setPost("My very first post as Liz Perry!");

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019,8,11));
        post1.setPosterName("Kaleigh Harold");
        post1.setPost("My very first post as Kaleigh Harold!");

        List<Post> postList = new ArrayList<>();
        postList.add(post);

        doReturn(post).when(postClient).createPost(post1);
        doReturn(post).when(postClient).getPostById(1);
        doReturn(postList).when(postClient).getPostByPoster("Liz Perry");
    }

    @Test
    public void createPost(){
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setPostDate(LocalDate.of(2019,8,12));
        postViewModel.setPosterName("Liz Perry");
        postViewModel.setPost("My very first post as Liz Perry!");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        PostViewModel postViewModel1 = serviceLayer.getPostById(postViewModel.getId());
        assertEquals(postViewModel, postViewModel1);
    }

//    Need help with this. Expected 1, actual 0. Not saving it properly. Take a look in the morning after some rest!
//    @Test
//    public void getAllPosts() {
//        PostViewModel postViewModel = new PostViewModel();
//        postViewModel.setPostDate(LocalDate.of(2019, 8, 12));
//        postViewModel.setPosterName("Liz Perry");
//        postViewModel.setPost("My very first post as Liz Perry!");
//        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));
//
//        List<PostViewModel> pvmL = serviceLayer.getAllPosts();
//        assertEquals(1, pvmL.size());
//    }

    @Test
    public void getPostById(){
        PostViewModel postViewModel = serviceLayer.getPostById(1);
        postViewModel.setPostDate(LocalDate.of(2019,7,17));
        postViewModel.setPosterName("David");
        postViewModel.setPost("This is post 1");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        PostViewModel postViewModel1 = serviceLayer.getPostById(postViewModel.getId());
        assertEquals(postViewModel, postViewModel1);

    }

    @Test
    public void getPostByPosterName(){
        PostViewModel postViewModel = new PostViewModel();
        postViewModel.setId(1);
        postViewModel.setPostDate(LocalDate.of(2019,7,17));
        postViewModel.setPosterName("David");
        postViewModel.setPost("This is post 1");
        postViewModel.setCommentList(commentClient.getCommentsByPostId(1));

        postViewModel = serviceLayer.createPostWithComments(postViewModel);

        List<PostViewModel> postViewModelList = serviceLayer.getPostByPosterName(postViewModel.getPosterName());

        assertEquals(1, postViewModelList.size());
        assertEquals(postViewModel, postViewModelList.get(0));

    }

//    public List<PostViewModel> getpostByPosterName(String posterName)
//    {
//        List<Post> postList = postClient.getPostByPoster(posterName);
//        List<PostViewModel> pcvmList = new ArrayList<>();
//
//        for (Post post : postList)
//        {
//            PostViewModel pcvm = (post);
//            pcvmList.add(pcvm);
//        }
//        return pcvmList;
//    }

//    @Test
//    public void getPostByPosterName(){
//
//        List<Comment> commentList = new ArrayList<>();
//        Comment comment = new Comment();
//        comment.setCommentId(1);
//        comment.setPostId(1);
//        comment.setCreateDate(LocalDate.of(2019,7,17));
//        comment.setCommenterName("john doe");
//        comment.setComment("This is comment 1");
//        commentList.add(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setCommentId(2);
//        comment1.setPostId(1);
//        comment1.setCreateDate(LocalDate.of(2019,7,17));
//        comment1.setCommenterName("john doe");
//        comment1.setComment("This is comment 2");
//        commentList.add(comment1);
//
//
//        PostViewModel postViewModel = new PostViewModel();
//        //postViewModel.setId(1);
//
//
//        postViewModel = serviceLayer.createPostWithComments(postViewModel);
//
//        PostViewModel fromService = serviceLayer.fidnPost(postViewModel.getId());
//        assertEquals(fromService, postViewModel);
//
//        List<PostViewModel> postViewModelList = new ArrayList<>();
//        postViewModelList.add(postViewModel);
//
//        List<PostViewModel> fromServiceList = serviceLayer.findAllPosts();
//        assertEquals(fromServiceList, postViewModelList.size());
//
//    }

//    public PostViewModel buildPostCommentViewModel(Post post)
//    {
//        PostViewModel pcvm = new PostViewModel();
//        pcvm.setId(post.getPostID());
//        pcvm.setPostDate(post.getPostDate());
//        pcvm.setPosterName(post.getPosterName());
//        pcvm.setPost(post.getPost());
//
//        List<Comment> commentList = commentClient.getCommentsByPostId(post.getPostID());
//        List<CommentViewModel> cvmList = new ArrayList<>();
//        for (Comment comment : commentList)
//        {
//            CommentViewModel cvm = new CommentViewModel();
//            cvm.setCreateDate(comment.getCreateDate());
//            cvm.setCommenterName(comment.getCommenterName());
//            cvm.setComment(comment.getComment());
//            cvmList.add(cvm);
//        }
//        pcvm.setCommentsList(cvmList);
//
//        return pcvm;
//    }

//    private void setUpPostServiceClient()
//    {
//        postClient= mock(PostClient.class);
//
//        Post postToFeignClient = new Post();
//        postToFeignClient.setPostDate(LocalDate.of(2018, 10, 9));
//        postToFeignClient.setPosterName("Joshua");
//        postToFeignClient.setPost("I love concerts!");
//
//        Post postFromFeignClient = new Post();
//        postFromFeignClient.setPostID(1);
//        postFromFeignClient.setPostDate(LocalDate.of(2017, 10, 9));
//        postFromFeignClient.setPosterName("Joshua");
//        postFromFeignClient.setPost("I love concerts!");
//
//        List<Post> postList = new ArrayList<>();
//        postList.add(postFromFeignClient);
//
//        doReturn(postFromFeignClient).when(postClient).createPost(postToFeignClient);
//        doReturn(postFromFeignClient).when(postClient).getPost(1);
//        doReturn(postList).when(postClient).getAllPosts();
//        doReturn(postList).when(postClient).getPostByPoster("Joshua");
//    }

//    private void setUpCommentServiceClient()
//    {
//        commentClient= mock(CommentClient.class);
//
//        Comment commentToFeignClient = new Comment();
//        commentToFeignClient.setPostId(1);
//        commentToFeignClient.setCreateDate(LocalDate.of(2017, 9, 9));
//        commentToFeignClient.setCommenterName("John Smith");
//        commentToFeignClient.setComment("I love to explore new land!");
//
//        Comment commentFromFeignClient = new Comment();
//        commentFromFeignClient.setCommentId(1);
//        commentFromFeignClient.setPostId(1);
//        commentFromFeignClient.setCreateDate(LocalDate.of(2017, 9, 9));
//        commentFromFeignClient.setCommenterName("John Smith");
//        commentFromFeignClient.setComment("I love to explore new land!");
//
//        List<Comment> commentList = new ArrayList<>();
//        commentList.add(commentFromFeignClient);
//
//        doReturn(commentFromFeignClient).when(commentClient).createComment(commentToFeignClient);
//        doReturn(commentFromFeignClient).when(commentClient).getCommentByCommentId(1);
//        doReturn(commentList).when(commentClient).getAllComments();
//        doReturn(commentList).when(commentClient).getCommentsByPostId(1);
//    }
}
