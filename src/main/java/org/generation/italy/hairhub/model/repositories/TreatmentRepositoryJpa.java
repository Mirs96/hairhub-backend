package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepositoryJpa extends JpaRepository<Treatment, Long> {
}
