package vn.tat.crud.tidb.order.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vn.tat.crud.tidb.order.adapter.out.persistence.mapper.OrderMapper;
import vn.tat.crud.tidb.order.application.port.out.MakeOrderRepository;
import vn.tat.crud.tidb.order.domain.Order;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:28
 */
@Component
@RequiredArgsConstructor
public class OrderPersistence implements MakeOrderRepository {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final OrderJPARepository orderJPARepository;

    private final OrderMapper orderMapper;

    @Override
    public Order makeOrderCar(Order order) {
        OrderJpaEntity resultOrder = orderJPARepository.save(orderMapper.toJpaEntity(order));
        return orderMapper.toDomainEntity(resultOrder);
    }
}
