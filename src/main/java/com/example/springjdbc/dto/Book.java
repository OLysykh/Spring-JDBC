package com.example.springjdbc.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

    Long id;
    String bookName;
    String bookAuthor;
    LocalDateTime added;

}
