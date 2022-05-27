package com.suganthi.story.readingapp;

import com.suganthi.story.readingapp.controller.BookController;
import com.suganthi.story.readingapp.dao.BookRepository;
import com.suganthi.story.readingapp.entity.Book;
import com.suganthi.story.readingapp.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {


    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;



    @Test
    public void listBooks() throws Exception {

        when(bookService.findAll()).thenReturn(
                Stream.of(
                        new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")
                ).collect(Collectors.toList()));

        Assertions.assertEquals(2, bookService.findAll().size());

    }

    @Test
    public void delete() {
        int id = 1;
        bookService.deleteById(id);
        verify(bookService, times(1)).deleteById(id);
    }

    @Test
    public void search(){
        String keyword="crows";
        when(bookService.searchBy(keyword)).
                thenReturn(Stream.of(new Book("The Butterflies","Drama"),
                        new Book("The Kingdom","Horror")).collect(Collectors.toList()));
        assertEquals(2,bookService.searchBy(keyword).size());
    }





}
