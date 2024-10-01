package org.alvarowau.ejerciciopracticoherencia.repository;

import org.alvarowau.ejerciciopracticoherencia.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnginerrRepository extends JpaRepository<Engineer,Long> {
}
