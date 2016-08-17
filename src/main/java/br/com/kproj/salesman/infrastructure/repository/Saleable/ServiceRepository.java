package br.com.kproj.salesman.infrastructure.repository.Saleable;


import br.com.kproj.salesman.infrastructure.entity.saleable.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ServiceRepository extends BaseSaleableRepository<ServiceEntity> {

    @Query("SELECT s FROM ServiceEntity AS s WHERE s.type = 'SERVICE' AND s.id = :id")
    Optional<ServiceEntity> getOne(@Param("id")Long id);

    @Query("SELECT s FROM ServiceEntity AS s WHERE s.type = 'SERVICE' ORDER BY s.name")
    Page<ServiceEntity> findAll(Pageable pageable);
}
