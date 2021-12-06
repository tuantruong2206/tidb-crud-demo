package vn.tat.crud.tidb.order.adapter.in;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.tat.crud.tidb.domain.model.Product;
import vn.tat.crud.tidb.dto.JsonResponse;
import vn.tat.crud.tidb.order.adapter.in.dto.CarDTO;
import vn.tat.crud.tidb.order.adapter.in.dto.mapper.CarMapper;
import vn.tat.crud.tidb.order.application.port.in.MakeOrderUserCase;
import vn.tat.crud.tidb.order.domain.Car;
import vn.tat.crud.tidb.util.HeaderUtil;
import vn.tat.crud.tidb.validation.ProductValidator;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/3/21 13:41
 */
@RestController
@RequestMapping(path = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MakeOrderController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MakeOrderUserCase makeOrderService;

    private final CarMapper carMapper;

    @PostMapping()
    public ResponseEntity<CarDTO> createNewProduct(@Valid @RequestBody CarDTO carDTO, BindingResult bindingResult) throws URISyntaxException {
        ProductValidator.validate(bindingResult);
        log.info("REST request to update Car: {}", carDTO);
        Car car = makeOrderService.makeOrderCar(this.carMapper.toDomainEntity(carDTO));
        return ResponseEntity.created(new URI("")).body(this.carMapper.toDto(car));
        /*product = this.productService.save(product);
        return ResponseEntity.created(new URI("/inventory/product/" + product.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, product.getId().toString()))
                .body(new JsonResponse<>(product));*/
    }


}
