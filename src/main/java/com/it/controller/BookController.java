package com.it.controller;


import domain.Book;
import com.it.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books",produces = "application/json;charset=utf8")

public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public Result save(@RequestBody Book book) {
        System.out.println(book);
        boolean flag=bookService.save(book);
        return new Result(flag? Code.SAVE_OK:Code.SAVE_ERR,flag) ;
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag=bookService.update(book);
        return new Result(flag? Code.UPDATE_OK:Code.UPDATE_ERR,flag) ;

    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag=bookService.delete(id);
        return new Result(flag? Code.DELETE_OK:Code.DELETE_ERR,flag) ;

    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        Integer code=book!=null?Code.GET_OK:Code.GET_ERR;
        String msg=book!=null?"":"数据查询失败，请重试！";
        return new Result(book,code,msg) ;
    }

    @GetMapping
    @ResponseBody
    public Result selectAll() {
        List<Book> books = bookService.selectAll();
        Integer code=books!=null?Code.GET_OK:Code.GET_ERR;
        String msg=books!=null?"":"数据查询失败，请重试！";
        return new Result(books,code,msg) ;

    }
}
