package com.backend.embedding_service.repository;
import com.backend.embedding_service.model.clauseEmbedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface clauseEmbeddingRepository extends JpaRepository<clauseEmbedding, Long> {
    @Query(value = "SELECT * FROM clause_embedding ORDER BY embedding <-> cast(:vector as vector) LIMIT :topK", nativeQuery = true)
    List<clauseEmbedding> findSimilarClauses(@Param("vector") String vector, @Param("topK") int topK);
}
