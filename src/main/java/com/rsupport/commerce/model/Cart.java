package com.rsupport.commerce.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "t_cart")
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "user")
@Setter
@Getter
//public class Cart AbstractEntity<Long>{
public class Cart {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartProduct> cartProducts = new HashSet<CartProduct>();


}
