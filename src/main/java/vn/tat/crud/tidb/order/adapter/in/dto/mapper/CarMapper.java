package vn.tat.crud.tidb.order.adapter.in.dto.mapper;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:59
 */

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import vn.tat.crud.tidb.order.adapter.in.dto.CarDTO;
import vn.tat.crud.tidb.order.domain.Car;

/**
 * Mapper for the entity Car and its DTO
 */
@Mapper(componentModel = "spring", uses = {})
public interface CarMapper {

    @Mappings({
            @Mapping(source = "car.branchName", target = "branchName"),
            @Mapping(source = "car.seats", target = "seats"),
            @Mapping(source = "car.note", target = "note")
    })
    CarDTO toDto(Car car);

    @Mappings({
            @Mapping(source = "carDto.branchName", target = "branchName"),
            @Mapping(source = "carDto.seats", target = "seats")
    })
    Car toDomainEntity(CarDTO carDto);



}
