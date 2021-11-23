package vn.tat.crud.tidb.controller.rest.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCriteria {
    private Long startDate;
    private Long endDate;
    private String name;
    private String color;
}
