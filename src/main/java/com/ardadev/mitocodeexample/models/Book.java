package com.ardadev.mitocodeexample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, toString, equals, hashCode, etc.
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String author;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
}
