package com.wildcodeschool.rest_quest.repository;

import com.wildcodeschool.rest_quest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleContainsOrDescriptionContains(String title, String description);

}
