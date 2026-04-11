package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.dto.VentaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<VentaDTO,Long> {
}
