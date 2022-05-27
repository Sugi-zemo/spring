
package com.suganthi.story.readingapp;

import com.suganthi.story.readingapp.dao.BookRepository;
import com.suganthi.story.readingapp.entity.Book;
import com.suganthi.story.readingapp.service.BookService;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.ui.Model;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookServiceTest {


    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Mock
    private Model model;

    @Test
    public void findAll() {
        when(bookRepository.findAll()).thenReturn(
                Stream.of(
                        new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")
                ).collect(Collectors.toList()));

       Assertions.assertEquals(2, bookRepository.findAll().size());

    }

    @Test
    public void deleteById() {
        int id = 1;
        bookRepository.deleteById(id);
        verify(bookRepository, times(1)).deleteById(id);
    }

    @Test
    public void searchBy(){
        String keyword="crows";
        when(bookRepository.findBystoryNameContainsAllIgnoreCase(keyword)).
                thenReturn(Stream.of(new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")).collect(Collectors.toList()));
        assertEquals(2,bookService.searchBy(keyword).size());
    }

}
