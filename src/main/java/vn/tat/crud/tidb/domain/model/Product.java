package vn.tat.crud.tidb.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @NotNull
    @Min(value = 0, message = "Min is 0")
    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "belongToProd", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JsonIgnore
    private Set<ProductHistory> hvHistory = new HashSet<>();

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
