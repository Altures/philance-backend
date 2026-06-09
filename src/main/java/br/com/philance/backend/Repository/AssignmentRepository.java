package br.com.philance.backend.Repository;

import br.com.philance.backend.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
    @Query(value = "SELECT * FROM assignments ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Assignment> findRandomAssignment();
}