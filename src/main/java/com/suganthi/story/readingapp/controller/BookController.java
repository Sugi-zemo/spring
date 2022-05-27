package com.suganthi.story.readingapp.controller;


import com.suganthi.story.readingapp.entity.Book;
import com.suganthi.story.readingapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    public BookController(BookService thebookService) {
        bookService = thebookService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        // get employees from db
        List<Book> theBooks = bookService.findAll();

        // add to the spring model
        theModel.addAttribute("books", theBooks);

        return "list-books";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        // delete the employee
        bookService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/books/list";

    }

    @GetMapping("/show")
     public String showStory(@RequestParam("bookId") int theId){


        switch (theId){
            case 1: return "1";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
        }
     return null;
    }

    @GetMapping("/search")
    public String search(@RequestParam("storyName") String theStoryName,
                         Model theModel) {

        // check names, if both are empty then just give list of all employees

        if (theStoryName.trim().isEmpty() ) {
            return "redirect:/books/list";
        }
        else {
            // else, search by first name and last name
            List<Book> theBooks =
                    bookService.searchBy(theStoryName);

            // add to the spring model
            theModel.addAttribute("books", theBooks);

            // send to list-employees
            return "list-books";
        }

    }


}