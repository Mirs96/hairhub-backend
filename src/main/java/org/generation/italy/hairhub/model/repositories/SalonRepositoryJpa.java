package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepositoryJpa extends JpaRepository<Salon, Long> {
    //review appoint barbiere salon
    @Query("""
    SELECT s
    FROM Review r
    JOIN r.appointment a
    JOIN a.barber b
    JOIN b.salon s
    LEFT JOIN a.treatment serv
    WHERE (:type IS NULL OR serv.type = :type)
    GROUP BY s
    ORDER BY AVG(r.rating) DESC
    LIMIT 5
    """)
    List<Salon> getSalonsByOptionalServiceType(@Param("type") Integer type);
}
