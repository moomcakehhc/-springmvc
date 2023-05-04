package com.it.dao;

import com.it.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDao {

    @Insert("insert into tb_book value(null,#{type},#{name},#{description})")
    public Integer save(Book book);

    @Update("update tb_book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    public Integer update(Book book);

    @Delete("delete from tb_book where id=#{id}")
    public Integer delete(Integer id);

    @Select("select * from tb_book where id=#{id}")
    public Book getById(Integer id);

    @Select("select * from tb_book")
    public List<Book> selectAll();

}
