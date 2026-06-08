package br.com.philance.backend.Repository;

import br.com.philance.backend.model.CancelationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelationHistoryRepository extends JpaRepository<CancelationHistory, Long> { }