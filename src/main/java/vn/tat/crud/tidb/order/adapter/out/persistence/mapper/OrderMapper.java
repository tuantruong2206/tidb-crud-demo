package vn.tat.crud.tidb.order.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tat.crud.tidb.order.adapter.out.persistence.OrderJpaEntity;
import vn.tat.crud.tidb.order.domain.Order;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 12:38
 */

/**
 * Mapper for the entity Order and its OrderJpa Entity
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "order.id", target = "id"),
            @Mapping(source = "order.description", target = "description"),
            @Mapping(source = "order.quantity", target = "quantity"),
            @Mapping(source = "order.unit", target = "unit"),
            @Mapping(source = "order.price", target = "price"),
            @Mapping(source = "order.amount", target = "amount")
    })
    Order toDomainEntity(OrderJpaEntity order);

    @Mappings({
            @Mapping(source = "order.id", target = "id"),
            @Mapping(source = "order.description", target = "description"),
            @Mapping(source = "order.quantity", target = "quantity"),
            @Mapping(source = "order.unit", target = "unit"),
            @Mapping(source = "order.price", target = "price"),
            @Mapping(source = "order.amount", target = "amount")
    })
    OrderJpaEntity toJpaEntity(Order order);
}
