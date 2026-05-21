package br.com.philance.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ServiceRepository {
    @Repository
    public interface ServicoRepository extends JpaRepository<Service, Long>{}
}
