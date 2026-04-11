package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.dto.ProductoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoDTO,Long> {
}
