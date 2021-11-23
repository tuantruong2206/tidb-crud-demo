package vn.tat.crud.tidb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tat.crud.tidb.domain.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIdIn(List<Long> ids);
}
