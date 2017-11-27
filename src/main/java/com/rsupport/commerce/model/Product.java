package com.rsupport.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_product")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Setter
@Getter
//public class Product AbstractEntity<Long> {
public class Product {
    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @Column(length = 10)
    @JsonProperty
    private String color;

    @Column(length = 30)
    @JsonProperty
    private String name;

    @Column(length = 30)
    @JsonProperty
    private String description;

    private Double price;

    @Column(length = 100)
    @JsonProperty
    private String imageFileName;

}
