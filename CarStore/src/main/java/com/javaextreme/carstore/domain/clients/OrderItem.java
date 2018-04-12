package com.javaextreme.carstore.domain.clients;

import com.javaextreme.carstore.domain.vehicles.Product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Product product;
    @Min(1)
    @Max(value = 99, message = "You cannot have over 99 items")
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;

    public OrderItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(getId(), orderItem.getId()) &&
                Objects.equals(getProduct(), orderItem.getProduct()) &&
                Objects.equals(getQuantity(), orderItem.getQuantity()) &&
                Objects.equals(getPrice(), orderItem.getPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getProduct(), getQuantity(), getPrice());
    }
}
