package com.castagno.dev.bazar_api.repository;

import com.castagno.dev.bazar_api.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

    // Ventas de un día específico (para calcular sumatoria y cantidad)
    List<Venta> findByFechaVenta(LocalDate fechaVenta);

    // Venta con el total más alto
    @Query("SELECT v FROM Venta v ORDER BY v.total DESC LIMIT 1")
    Optional<Venta> findVentaConMayorTotal();
}
