package com.rsupport.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "t_order")
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = {"cart, product"})
@Setter
@Getter
//public class CartProduct extends AbstractEntity<CartProduct.Id>{
public class CartProduct {

    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @MapsId("cartId")
    private Cart cart;

//    ### Serialize without unwrapped annotation ###
//    {
//        "age" : 12,
//            "name" : {
//                  "first" : "Tom",
//                "last" : "Sawyer"
//    }
//    }
//
//### Deserialize with unwrapped annotation ###
//    Parent{age=13, name=Name{first='Huckleberry', last='Finn'}}
    @ManyToOne
    @MapsId("productId")
    @JsonProperty
    @JsonUnwrapped
    private Product product;

    @Column(name = "buy_count")
    @JsonProperty
    private Integer buyCount;

    public CartProduct(Cart cart, Product product) {
        this.id.cartId = cart.getId();
        this.id.productId = product.getId();
        this.cart = cart;
        this.product = product;
    }

    @Embeddable
    @Data
    @EqualsAndHashCode(callSuper = false, of = { "cartId", "productId" })
    public static class Id implements Serializable{

//        public static class Id extends AbstractEntityId {

        private static final long serialVersionUID = 340765999204142798L;

        @Column(name = "cart_id")
        private Long cartId;

        @Column(name = "product_id")
        private Long productId;

    }
}
