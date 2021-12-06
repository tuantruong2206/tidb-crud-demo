package vn.tat.crud.tidb.order.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/3/21 13:33
 */
@Data
@RequiredArgsConstructor
public class Order {

    private Long id;
    private String description;
    private Integer quantity;
    private String unit;
    private Integer price;
    private Integer amount;

    public void orderCar(Car car) {
        car.doNote("this is in Order Business ...");
        description = String.format(" order car %s", car.toString());
        quantity = 10;
        unit = "num of cars";
        price = 1000;
        amount = price * quantity;

    }
}
