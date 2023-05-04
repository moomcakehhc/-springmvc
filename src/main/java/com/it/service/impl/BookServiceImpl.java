package com.it.service.impl;

import com.it.dao.BookDao;
import com.it.domain.Book;
import domain.Book;
import com.it.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    /**
     * 增加，保存
     * @param book
     * @return
     */
    public boolean save(Book book) {
        System.out.println(book);
        Integer save = bookDao.save(book);
        if(save==null){
            return false;
        }
        return true;
    }
    /**
     * 改
     * @param book
     * @return
     */
   public boolean update(Book book) {
       Integer update = bookDao.update(book);
       if(update==null){
           return false;
       }
       return true;
   }
    /**
     * 根据id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id){
        Integer delete = bookDao.delete(id);
        if(delete==null){
            return false;
        }
        return true;
    }

    /**id
     * 根据id查询
     * @param id
     * @return
     */
    public Book getById(Integer id){
        Book book = bookDao.getById(id);

        return book;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Book> selectAll() {
        List<Book> books = bookDao.selectAll();
        return books;

    }
}
