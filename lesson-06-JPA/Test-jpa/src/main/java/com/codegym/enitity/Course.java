package com.codegym.enitity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int duration;
    private String instructor;
    private String location;
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private  Category category;
}
