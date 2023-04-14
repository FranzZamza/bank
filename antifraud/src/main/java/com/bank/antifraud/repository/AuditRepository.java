package com.bank.antifraud.repository;

import com.bank.antifraud.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, Long> {
    @Query(value = "SELECT * " +
            "FROM anti_fraud.audit " +
            "WHERE CAST(json_extract_path_text(CAST(entity_json as JSON), 'id') as INTEGER) = :id " +
            "AND operation_type = 'CREATE' " +
            "LIMIT 1", nativeQuery = true)
    AuditEntity findByEntityId(@Param("id") Long id);
}
