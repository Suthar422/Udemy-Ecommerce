package com.udemy.ecommerce.sportcenter.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    private String name;

    //One type can have many products
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Product> products;
}
