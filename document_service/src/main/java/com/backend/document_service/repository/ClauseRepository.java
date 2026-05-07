package com.backend.document_service.repository;
import com.backend.document_service.model.Clause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClauseRepository extends JpaRepository<Clause, Long> {
}
