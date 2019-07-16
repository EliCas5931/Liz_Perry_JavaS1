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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao BookDao;

    @Autowired
    AuthorDao AuthorDao;

    @Autowired
    PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {
        //clean out the test db
        //Book
        List<Book> bList = BookDao.getAllBooks();

        bList.stream()
                .forEach(book -> BookDao.deleteBook(book.getId()));

        //Author
        List<Author> aList = AuthorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> AuthorDao.deleteAuthor(author.getId()));

        //Publisher
        List<Publisher> pList = PublisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> PublisherDao.deletePublisher(publisher.getId()));
    }

    @Test
    public void addGetDeleteBook() {

        //Create Author and Publisher
        Author author = new Author();
        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");
        author = AuthorDao.addAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisher = PublisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("9788700631625");
        book.setPublishDate(LocalDate.of(1997, 6, 26));
        book.setAuthorId(author.getId());
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.99"));

        book = BookDao.addBook(book);

        Book book2 = BookDao.getBook(book.getId());

        assertEquals(book2, book);

        BookDao.deleteBook(book.getId());

        book2 = BookDao.getBook(book.getId());

        assertNull(book2);

    }

    @Test(expected = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Book book = new Book();
        book.setIsbn("9788700631625");
        book.setPublishDate(LocalDate.of(1997, 6, 26));
        book.setAuthorId(15);
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        book.setPublisherId(10);
        book.setPrice(new BigDecimal("14.99"));

        book = BookDao.addBook(book);

    }

    @Test
    public void getAllBooks() {

        //Create publisher and author!
        Author author = new Author();
        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");
        author = AuthorDao.addAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisher = PublisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("9788700631625");
        book.setPublishDate(LocalDate.of(1997, 6, 26));
        book.setAuthorId(author.getId());
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.99"));

        book = BookDao.addBook(book);

        book = new Book();
        book.setIsbn("9781428113701");
        book.setPublishDate(LocalDate.of(1960, 7, 11));
        book.setAuthorId(author.getId());
        book.setTitle("To Kill a Mockingbird");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("6.99"));

        book = BookDao.addBook(book);

        book = new Book();
        book.setIsbn("9786218016439");
        book.setPublishDate(LocalDate.of(2003, 9, 23));
        book.setAuthorId(author.getId());
        book.setTitle("Five People You Meet In Heaven");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("3.99"));

        book = BookDao.addBook(book);

        List<Book> bList = BookDao.getAllBooks();
        assertEquals(bList.size(), 3);

    }

    @Test
    public void updateBook() {

        Author author = new Author();
        author.setFirstName("Joanne");
        author.setLastName("Rowling");
        author.setStreet("4 Privet Drive, Under the Staircase");
        author.setCity("Little Whinging");
        author.setState("Surrey");
        author.setPostalCode("V1M 2R1");
        author.setPhone("1-800-HARRY-POTTER");
        author.setEmail("jkrowling@gmail.com");
        author = AuthorDao.addAuthor(author);

        Publisher publisher = new Publisher();
        publisher.setName("Bloomsbury Publishing");
        publisher.setStreet("1 Main Street");
        publisher.setCity("London");
        publisher.setState("Camden");
        publisher.setPostalCode("V1M C2R");
        publisher.setPhone("1-800-BLOOMSBURY");
        publisher.setEmail("bloomsbury@publishing.com");
        publisher = PublisherDao.addPublisher(publisher);

        Book book = new Book();
        book.setIsbn("9788700631625");
        book.setPublishDate(LocalDate.of(1997, 6, 26));
        book.setAuthorId(author.getId());
        book.setTitle("Harry Potter and the Sorcerer's Stone");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("14.99"));

        book = BookDao.addBook(book);

        book.setIsbn("9781781101544");
        book.setPublishDate(LocalDate.of(2000, 7, 8));
        book.setAuthorId(author.getId());
        book.setTitle("Harry Potter and the Goblet of Fire");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("18.99"));

        BookDao.updateBook(book);

        Book book2 = BookDao.getBook(book.getId());
        assertEquals(book2, book);

    }



}
