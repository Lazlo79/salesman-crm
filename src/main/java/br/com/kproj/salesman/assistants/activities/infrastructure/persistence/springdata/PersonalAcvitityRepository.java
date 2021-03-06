package br.com.kproj.salesman.assistants.activities.infrastructure.persistence.springdata;


import br.com.kproj.salesman.infrastructure.entity.UserEntity;
import br.com.kproj.salesman.infrastructure.entity.activities.PersonalActivityEntity;
import br.com.kproj.salesman.infrastructure.repository.BaseRepositoryLegacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonalAcvitityRepository extends BaseRepositoryLegacy<PersonalActivityEntity, Long> {

    @Query("SELECT pa FROM PersonalActivityEntity AS pa WHERE pa.id = :id")
    Optional<PersonalActivityEntity> getOne(@Param("id") Long id);

    @Query("SELECT pa FROM PersonalActivityEntity AS pa WHERE pa.owner = :owner")
    Page<PersonalActivityEntity> findAll(@Param("owner") UserEntity entity, Pageable pageable);
}
