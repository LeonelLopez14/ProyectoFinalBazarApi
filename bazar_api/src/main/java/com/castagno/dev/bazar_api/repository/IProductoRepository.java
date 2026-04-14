package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {

    // Productos con stock bajo (cantidad_disponible < 5)
    List<Producto> findByCantidadDisponibleLessThan(double cantidad);

    // Productos que pertenecen a una venta específica
    @Query("SELECT p FROM Producto p WHERE p.venta.codigo_venta = :codigo_venta")
    List<Producto> findByVentaId(@Param("codigo_venta") Long codigo_venta);

}
