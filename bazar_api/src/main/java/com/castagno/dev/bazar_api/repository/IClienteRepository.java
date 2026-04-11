package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteDTO, Long> {
}
