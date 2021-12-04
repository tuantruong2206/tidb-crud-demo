package vn.tat.crud.tidb.order.application.port.out;

import vn.tat.crud.tidb.order.domain.Car;
import vn.tat.crud.tidb.order.domain.Order;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:28
 */
public interface MakeOrderRepository {
    Order makeOrderCar(Order order);
}
