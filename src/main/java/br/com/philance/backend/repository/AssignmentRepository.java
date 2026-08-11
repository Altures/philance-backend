package br.com.philance.backend.repository;

import br.com.philance.backend.DTO.response.assignment.AssignmentInfosDTO;
import br.com.philance.backend.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String>, JpaSpecificationExecutor<Assignment> {
    @Query(value = "SELECT * FROM assignments WHERE status = 'PENDING' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Assignment> findRandomAssignment();

    //@Query(value = "SELECT * FROM assignments WHERE id_freelancer = ?1", nativeQuery = true)
    //List<AssignmentInfosDTO> listAssignmentsByID(String id_user);
    List<Assignment> findByFreelancerId(String freelancerId);

    List<Assignment> findByCompanyId(String companyId);

}