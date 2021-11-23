package vn.tat.crud.tidb.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product_history")
public class ProductHistory {

    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "Please enter name")
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 50, min = 3, message = "Invalid length")
    @Column(name = "description")
    private String description;

    @Min(value = 1, message = "Min is 1")
    @Column(name = "price")
    private Double price;

    @NotNull(message = "Color is not null")
    @NotEmpty(message = "Color is not empty")
    @Column(name = "color")
    private String color;

    @ManyToOne
    @NotNull
    private Product belongToProd;

    @Min(value = 0, message = "Min is 0")
    @Column(name = "quantity")
    private Integer quantity;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", insertable = false)
    private Instant updatedAt;

    public static ProductHistory packingProductHistory(Product product) {
        ProductHistory productHistory = new ProductHistory();
        productHistory.setName(product.getName());
        productHistory.setDescription(product.getDescription());
        productHistory.setPrice(product.getPrice());
        productHistory.setColor(product.getColor());
        productHistory.setBelongToProd(product);
//        productHistory.setQuantity(product.getQuantity());
        return productHistory;
    }

    @PrePersist
    public void onPrepPersist() {
        setCreatedAt(Instant.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(Instant.now());
    }
}
