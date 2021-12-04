package vn.tat.crud.tidb.order.application.port.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.tat.crud.tidb.order.adapter.in.dto.mapper.CarMapper;
import vn.tat.crud.tidb.order.application.port.in.MakeOrderUserCase;
import vn.tat.crud.tidb.order.application.port.out.MakeOrderRepository;
import vn.tat.crud.tidb.order.domain.Car;
import vn.tat.crud.tidb.order.domain.Order;

import javax.transaction.Transactional;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:29
 */
@Service
@RequiredArgsConstructor
@Transactional
public class MakeOrderService implements MakeOrderUserCase {

    private final CarMapper carMapper;

    private final MakeOrderRepository orderPersistence;


    @Override
    public Order makeOrderCar(Car car) {
        Order order = new Order();
        order.orderCar(car);
        return orderPersistence.makeOrderCar(order);
    }
}
