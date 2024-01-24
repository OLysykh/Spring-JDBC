package com.example.springjdbc.data.repository;

import com.example.springjdbc.dto.Book;
import com.example.springjdbc.mapper.BookMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookRepository {

    NamedParameterJdbcTemplate template;

    //Old-fashioned way
    JdbcTemplate jdbcTemplate;

    public Long createBook(Book book) {
        String sql = "INSERT INTO book (bookname, bookauthor) VALUES (:bookName, :bookAuthor) RETURNING ID";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
            .addValue("bookName", book.getBookName())
            .addValue("bookAuthor", book.getBookAuthor());
        return template.queryForObject(sql, sqlParameterSource, Long.class);
    }

    //PO JDBC
    public Long createBookOldFashioned(Book book) {
        String sql = "INSERT INTO book (bookname, bookauthor) VALUES (?, ?) RETURNING ID";
        return jdbcTemplate.queryForObject(sql, Long.class, book.getBookName(), book.getBookAuthor());
    }

    public Book getBookById(Long id){
        String sql = "SELECT * FROM book where book.id = :id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, sqlParameterSource, new BookMapper());
    }

    public void editBook(Book book){
        String sql = "UPDATE book SET bookname = :bookName, bookauthor = :bookAuthor WHERE id = :id";
        SqlParameterSource sqlParameterSource =  new MapSqlParameterSource()
            .addValue("id",book.getId())
            .addValue("bookName", book.getBookName())
            .addValue("bookAuthor", book.getBookAuthor());

        template.update(sql,sqlParameterSource);

    }

    public void deleteBook(Long id){
        String sql = "DELETE FROM book WHERE id = :id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", id);

        template.update(sql,sqlParameterSource);
    }

}
