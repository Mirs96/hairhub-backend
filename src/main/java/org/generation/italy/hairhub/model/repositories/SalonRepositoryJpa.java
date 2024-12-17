package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepositoryJpa extends JpaRepository<Salon, Long>{
    //passare da: review -> appuntamenti -> barbiere -> salone
    @Query("""
            SELECT s
            FROM Review r
            JOIN r.appointment a
            JOIN a.barber b
            JOIN b.salon s
            GROUP BY s
            ORDER BY AVG(r.rating) DESC
            """)
    List<Salon> getSalonsByRating();

    @Query("""
            SELECT s
            FROM Review r
            JOIN r.appointment a
            JOIN a.service serv
            JOIN a.barber b
            JOIN b.salon s
            WHERE serv.type = :type
            GROUP BY s
            ORDER BY AVG(r.rating) DESC
            """)
    List<Salon> getSalonsByServiceType(@Param("type")int type);
}
