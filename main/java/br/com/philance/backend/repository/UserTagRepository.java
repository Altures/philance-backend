package br.com.philance.backend.repository;

import br.com.philance.backend.model.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository <UserTag, String>{};
