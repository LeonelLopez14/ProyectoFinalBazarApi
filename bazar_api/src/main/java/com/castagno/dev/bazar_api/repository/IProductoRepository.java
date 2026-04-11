package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
}
