package com.company.LizPerryU1M5Summative.dao;

import com.company.LizPerryU1M5Summative.model.Author;
import com.company.LizPerryU1M5Summative.model.Book;
import com.company.LizPerryU1M5Summative.model.Publisher;
import org.junit.After;
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
public class AuthorDaoTest {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {

        //Clean test db
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

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void addGetDeleteAuthor() {

        Author author = new Author();

        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");

        author = authorDao.addAuthor(author);

        Author author2 = authorDao.getAuthor(author.getId());

        assertEquals(author2, author);

        authorDao.deleteAuthor(author.getId());

        author2 = authorDao.getAuthor(author.getId());

        assertNull(author2);

    }

    @Test
    public void updateAuthor() {

        Author author = new Author();

        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");

        author = authorDao.addAuthor(author);

        author.setFirstName("Harper");
        author.setLastName("Lee");
        author.setStreet("246 Main Street");
        author.setCity("Monroeville");
        author.setState("Alabama");
        author.setPostalCode("36460");
        author.setPhone("1-800-HARPER-LEE");
        author.setEmail("harperlee@gmail.com");

        authorDao.updateAuthor(author);

        Author author2 = authorDao.getAuthor(author.getId());

        assertEquals(author2, author);

    }

    @Test
    public void getAllAuthors() {

        Author author = new Author();

        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");

        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Becca");
        author.setLastName("Fitzpatrick");
        author.setStreet("45 Stover Street");
        author.setCity("North Platte");
        author.setState("Nebraska");
        author.setPostalCode("69101");
        author.setPhone("1-800-HUSH-BECCA");
        author.setEmail("beccafitzpatrick@gmail.com");

        author = authorDao.addAuthor(author);

        List<Author> aList = authorDao.getAllAuthors();
        assertEquals(aList.size(), 2);
    }

}
