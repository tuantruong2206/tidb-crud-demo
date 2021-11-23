package vn.tat.crud.tidb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.tat.crud.tidb.controller.rest.vm.ProductCriteria;
import vn.tat.crud.tidb.domain.model.Product;
import vn.tat.crud.tidb.dto.ProductDTO;
import vn.tat.crud.tidb.dto.ProductFullDTO;

public interface ProductService {

    ProductDTO updateProduct(ProductDTO product);

    ProductFullDTO getProductById(Long productId);

    void deleteProduct(Long id);

    ProductDTO save(ProductDTO productDTO);

    Product save(Product product);

    Page<Product> findByCriteria(ProductCriteria productCriteria, Pageable pageable);

//    public void doProductOrder(BasketDTO basketDTO);
}
