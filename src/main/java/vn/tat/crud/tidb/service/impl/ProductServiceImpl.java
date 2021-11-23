package vn.tat.crud.tidb.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tat.crud.tidb.controller.rest.vm.ProductCriteria;
import vn.tat.crud.tidb.domain.model.Product;
import vn.tat.crud.tidb.domain.repository.ProductRepository;
import vn.tat.crud.tidb.dto.ProductDTO;
import vn.tat.crud.tidb.dto.ProductFullDTO;
import vn.tat.crud.tidb.dto.mapper.ProductMapper;
import vn.tat.crud.tidb.service.ProductService;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO product) {
        return null;
    }

    @Override
    public ProductFullDTO getProductById(Long productId) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = this.productRepository.getOne(productDTO.getId());
        product.setPrice(productDTO.getPrice());
        product = this.productRepository.save(product);
        return this.productMapper.toDto(product);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Page<Product> findByCriteria(ProductCriteria productCriteria, Pageable pageable) {
        return null;
    }
}
