package vn.tat.crud.tidb.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.tat.crud.tidb.domain.model.Product;
import vn.tat.crud.tidb.dto.EntityMapper;
import vn.tat.crud.tidb.dto.ProductDTO;

/**
 * Mapper for the entity Product and its DTO
 */
@Mapper(componentModel = "spring", uses ={})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "quantity", target = "quantity")
    ProductDTO toDto(Product product);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "quantity", target = "quantity")
    Product toEntity(ProductDTO productDTO);

}
