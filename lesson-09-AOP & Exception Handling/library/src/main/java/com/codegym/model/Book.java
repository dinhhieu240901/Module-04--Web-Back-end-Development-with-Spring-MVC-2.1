package com.codegym.model;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String author;
    @Column(name = "name_book")
    @NotBlank
    private String nameBook;


    @Min(0)
    private Integer quantity;
    @Column(name = "year_of_release")
    @NotNull
    @Min(1)
    private Integer yearOfRelease;
    @OneToMany(mappedBy="book")
    private Set<Code> codes;
    public Book() {
    }

    public Book(Long id, String author, String nameBook, Integer quantity, Integer yearOfRelease, Set<Code> codes) {
        this.id = id;
        this.author = author;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.yearOfRelease = yearOfRelease;
        this.codes = codes;
    }

    public Book(Long id, String author, String nameBook, Integer quantity, Integer yearOfRelease) {
        this.id = id;
        this.author = author;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.yearOfRelease = yearOfRelease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getQuantity() {
        if(quantity==null){
            quantity=0;
        }
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }
}
