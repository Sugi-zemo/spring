package com.suganthi.story.readingapp.service;


import java.util.List;

import com.suganthi.story.readingapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suganthi.story.readingapp.dao.BookRepository;


@Service
public class BookServiceImpl implements BookService {

    private BookRepository thebookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        thebookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return thebookRepository.findAll();
    }


    @Override
    public void deleteById(int theId) {
        thebookRepository.deleteById(theId);
    }

    @Override
    public List<Book> searchBy(String theStoryName) {

        return thebookRepository.
                findBystoryNameContainsAllIgnoreCase(
                        theStoryName);
    }

}






