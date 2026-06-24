package br.com.philance.backend.repository;

import br.com.philance.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository <Address, String>{
    boolean existsByAll(
            String zip_code, String street, String number, String complement, String neighborhood, String city, String state
    );
}