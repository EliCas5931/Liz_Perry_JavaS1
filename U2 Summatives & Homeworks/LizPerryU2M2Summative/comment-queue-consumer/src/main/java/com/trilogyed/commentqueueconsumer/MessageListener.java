package com.trilogyed.commentqueueconsumer;

//import com.trilogyed.notequeue.consumer.util.feign.NoteClient;
//import com.trilogyed.notequeue.consumer.util.messages.Note;
import com.trilogyed.commentqueueconsumer.util.feign.CommentClient;
import com.trilogyed.commentqueueconsumer.util.messages.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    CommentClient client;

    public MessageListener(CommentClient client) {
        this.client = client;
    }

    @RabbitListener(queues =  CommentQueueConsumerApplication.QUEUE_NAME)
    private void receiveList (Comment message){

        if (message.getCommentId() == 0){

            Comment comment = client.createComment(message);

            System.out.println("Created: " + comment.toString());

        }else {

            Comment comment = message;

            client.updateComment(message, message.getCommentId());

            System.out.println("Updated: " + comment.toString());

        }
    }
}
