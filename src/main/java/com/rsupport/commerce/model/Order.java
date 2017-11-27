package com.rsupport.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "t_order")
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "orderProducts")
@Setter
@Getter
//public class Order extends AbstractEntity<Long> {
public class Order {

    @Id
    @GeneratedValue
    @JsonProperty("orderId")
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 12)
    @JsonProperty
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "pay_method", length = 12)
    @JsonProperty
    private PayMethod payMethod;

    @Column(name = "order_price")
    @JsonProperty
    private Double orderPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty
    private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    protected User user;

    @Column(name = "recipient_name", length = 30)
    @JsonProperty
    private String recipientName;

    @Column(name = "delivery_address", length = 255)
    @JsonProperty
    private String deliveryAddress;

    @Column(name = "recipient_tel", length = 15)
    @JsonProperty
    private String recipientTel;

    @JsonProperty("orderDate")
    public Long getOrderDateTimestamp() {
        return this.orderDate.getTime();
    }
}
