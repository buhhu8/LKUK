package org.lk.repository.jpa;

import org.lk.model.domain.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPaymentRepository
        extends CrudRepository<PaymentEntity, Integer> {

    Optional<PaymentEntity> findById(Integer id);


}
