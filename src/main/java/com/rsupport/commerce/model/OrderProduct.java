package com.rsupport.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_order_product")
@Data
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString(exclude = {"order", "product"})
public class OrderProduct {

    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @MapsId("orderId")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JsonProperty
    @JsonUnwrapped
    private Product product;

    @Column(name = "order_count")
    @JsonProperty
    private Integer orderCount;

    public OrderProduct(Order order, Product product) {
        this.id.orderId = order.getId();
        this.id.productId = product.getId();
        this.order = order;
        this.product = product;
    }

    @Embeddable
    @Data
    @EqualsAndHashCode(callSuper = false, of = { "orderId", "productId" })
    public static class Id implements Serializable {
//    public static class Id extends AbstractEntityId {

        private static final long serialVersionUID = 226636815858337409L;

        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "product_id")
        private Long productId;

    }
}
