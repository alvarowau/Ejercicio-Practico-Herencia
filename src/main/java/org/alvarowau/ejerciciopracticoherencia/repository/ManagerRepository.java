package org.alvarowau.ejerciciopracticoherencia.repository;

import org.alvarowau.ejerciciopracticoherencia.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
