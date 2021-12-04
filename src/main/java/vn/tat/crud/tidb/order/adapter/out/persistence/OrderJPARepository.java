package vn.tat.crud.tidb.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 12/4/21 10:27
 */
@Repository
public interface OrderJPARepository extends JpaRepository<OrderJpaEntity, Long> {
}
