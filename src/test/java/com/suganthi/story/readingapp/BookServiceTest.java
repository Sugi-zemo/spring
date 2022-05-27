
package com.suganthi.story.readingapp;


import com.suganthi.story.readingapp.dao.BookRepository;
import com.suganthi.story.readingapp.entity.Book;
import com.suganthi.story.readingapp.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {


    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;


    @Test
     void findAll() {
        when(bookRepository.findAll()).thenReturn(
                Stream.of(
                        new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")
                ).collect(Collectors.toList()));

       assertEquals(2, bookRepository.findAll().size());

    }

    /*@Test
    public void deleteById() {
        int id = 1;
        bookRepository.deleteById(id);
        assert(bookRepository, times(1)).deleteById(id);
    }

     */

    @Test
    void searchBy(){
        String keyword="crows";
        when(bookRepository.findBystoryNameContainsAllIgnoreCase(keyword)).
                thenReturn(Stream.of(new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")).collect(Collectors.toList()));
        assertEquals(2,bookService.searchBy(keyword).size());
    }

}
