package br.com.philance.backend.repository;

import br.com.philance.backend.model.CancelationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelationHistoryRepository extends JpaRepository<CancelationHistory, String> { }