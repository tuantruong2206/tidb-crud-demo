package vn.tat.crud.tidb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull(message = "Please enter id")
    private Long id;

    private String name;
    @Min(value = 10, message = "Min value is 10")
    private Double price;

    @NotEmpty
    @NotNull
    private String color;

    private String description;

    @NotNull
    @Min(value = 0, message = "Min is 0")
    private Integer quantity;

    public ProductDTO(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
