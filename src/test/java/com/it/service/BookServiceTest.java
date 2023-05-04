package com.it.service;

import com.it.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.it.domain.Book;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;


    @Test
    public void testGetById(){
        Book book = bookService.getById(1);
        System.out.println(book);
    }
    @Test
    public void testSelectAll(){
        List<Book> books = bookService.selectAll();
        System.out.println(books);
    }
    @Test
    public void save(){
        Book book1=new Book();
        book1.setType("计算机");
        book1.setName("spring入门");
        book1.setDescription("小试牛刀");

        Book book2=new Book();
        book2.setType("计算机");
        book2.setName("spring实战");
        book2.setDescription("一代宗师");

        Book book3=new Book();
        book3.setType("计算机");
        book3.setName("spring进阶");
        book3.setDescription("一代宗师呕血创造");

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

    }
}
