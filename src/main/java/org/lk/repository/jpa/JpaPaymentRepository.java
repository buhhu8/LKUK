package org.lk.repository.jpa;

import org.lk.model.domain.PaymentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPaymentRepository
        extends CrudRepository<PaymentEntity, Integer> {

    Optional<PaymentEntity> findById(Integer id);

    @Query( value =  "select * from payment where user_id = :userId",
            nativeQuery = true
    )

    List<PaymentEntity> findAllByUserId(@Param("userId") Integer userId);

    @Query(value = "select * from payment where user_id = :userId AND paymentdate = :date",
            nativeQuery = true
    )
    Optional<PaymentEntity> findByUserIdAndDate(@Param("userId") Integer userId, @Param("date") Date date);
}
