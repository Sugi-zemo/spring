package com.suganthi.story.readingapp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@Entity
@Table(name = "story")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "story_name")
    private String storyName;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "story_type")
    private String storyType;



    //many books can belong to one author
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String storyName, String storyType) {
        this.storyName = storyName;
        this.storyType = storyType;

    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", storyName='" + storyName + '\'' +
                ", storyType='" + storyType + '\'' +
                ", author=" + author +
                '}';
    }
}
