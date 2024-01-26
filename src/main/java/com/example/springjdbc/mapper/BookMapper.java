package com.example.springjdbc.mapper;

import com.example.springjdbc.dto.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {


    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setBookName(rs.getString("bookname"));
        book.setBookAuthor(rs.getString("bookauthor"));
        book.setAdded(rs.getTimestamp("added").toLocalDateTime());

        return book;
    }
}
