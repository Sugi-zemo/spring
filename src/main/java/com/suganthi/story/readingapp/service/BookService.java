package com.suganthi.story.readingapp.service;

import com.suganthi.story.readingapp.entity.Book;

import java.util.List;

public interface BookService {



        public List<Book> findAll();


        public void deleteById(int theId);


        List<Book> searchBy(String theStoryName);
}
