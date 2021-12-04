package vn.tat.crud.tidb.order.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 50, min = 3, message = "Invalid length")
    @Column(name = "description")
    private String description;

    @Min(value = 1, message = "Min is 1")
    @Column(name = "price")
    private Integer price;

    @NotNull
    @Min(value = 0, message = "Min is 0")
    @Column(name = "quantity")
    private Integer quantity;

    @Min(value = 0, message = "Min is 0")
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "unit")
    private String unit;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", insertable = false)
    private Instant updatedAt;

    @PrePersist
    public void onPrepPersist() {
        setCreatedAt(Instant.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(Instant.now());
    }
}
