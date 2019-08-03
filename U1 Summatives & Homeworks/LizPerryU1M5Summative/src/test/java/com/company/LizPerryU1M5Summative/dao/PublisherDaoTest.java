package com.company.LizPerryU1M5Summative.dao;

import com.company.LizPerryU1M5Summative.model.Author;
import com.company.LizPerryU1M5Summative.model.Book;
import com.company.LizPerryU1M5Summative.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherDaoTest {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        List<Author> aList = authorDao.getAllAuthors();
        for (Author a : aList) {
            authorDao.deleteAuthor(a.getId());
        }

        List<Book> bList = bookDao.getAllBooks();
        for (Book b : bList) {
            bookDao.deleteBook(b.getId());
        }

        List<Publisher> pList = publisherDao.getAllPublishers();
        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getId());
        }
    }

    @Test
    public void addGetDeleteLabel() {

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher2, publisher);

        publisherDao.deletePublisher(publisher.getId());

        publisher2 = publisherDao.getPublisher(publisher.getId());

        assertNull(publisher2);

    }

    @Test
    public void getAllPublishers() {

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("JB Lippincott Company");
        publisher.setStreet("100 Publish Street");
        publisher.setCity("Philadelphia");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("21567");
        publisher.setPhone("1-800-Lippincott");
        publisher.setEmail("lippincott@publishing.com");
        publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Hachette Books");
        publisher.setStreet("23 New York Street");
        publisher.setCity("New York");
        publisher.setState("New York");
        publisher.setPostalCode("34987");
        publisher.setPhone("1-800-Hachette");
        publisher.setEmail("hachette@publishing.com");
        publisherDao.addPublisher(publisher);

        List<Publisher> pList = publisherDao.getAllPublishers();

        assertEquals(pList.size(), 3);

    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisherDao.addPublisher(publisher);

        publisher.setName("Perry Publishing");
        publisher.setStreet("2 Main Street");
        publisher.setCity("Newcastle");
        publisher.setState("Liverpool");
        publisher.setPostalCode("V2M C1R");
        publisher.setPhone("1-800-Perry");
        publisher.setEmail("perry@publishing.com");
        publisherDao.updatePublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getId());

        assertEquals(publisher2, publisher);
    }



}
