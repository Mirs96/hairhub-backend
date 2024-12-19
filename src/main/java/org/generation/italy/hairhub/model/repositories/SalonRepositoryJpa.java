package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Salon;
import org.generation.italy.hairhub.model.entities.Treatment;
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
    JOIN a.treatment serv
    WHERE (:type IS NULL OR serv.type = :type)
    GROUP BY s
    ORDER BY AVG(r.rating) DESC
    LIMIT :num
    """)
    List<Salon> getSalonsByOptionalServiceType(@Param("type") Integer type,@Param("num") int num);

    @Query("""
    SELECT s
    FROM Salon s
    WHERE (:toSearch IS NULL OR :toSearch = ''
           OR LOWER(s.name) LIKE LOWER(CONCAT('%', :toSearch, '%'))
           OR LOWER(s.city) LIKE LOWER(CONCAT('%', :toSearch, '%'))
           OR LOWER(s.cap) LIKE LOWER(CONCAT('%', :toSearch, '%'))
           OR LOWER(s.address) LIKE LOWER(CONCAT('%', :toSearch, '%')))
  """
    )
    List<Salon> searchByNameOrAddress(@Param("toSearch") String searchString);

    @Query("SELECT s FROM Salon s WHERE :treatmentId = ANY (SELECT t.id FROM s.treatments t)")
    List<Salon> findByTreatmentId(@Param("treatmentId") long treatmentId);
}
