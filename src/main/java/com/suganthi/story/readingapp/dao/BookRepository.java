package com.suganthi.story.readingapp.dao;

import com.suganthi.story.readingapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findBystoryNameContainsAllIgnoreCase(
            String theStoryName);
}
