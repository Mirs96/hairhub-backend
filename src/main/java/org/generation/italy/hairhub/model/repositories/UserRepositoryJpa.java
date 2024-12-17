package org.generation.italy.hairhub.model.repositories;

import org.generation.italy.hairhub.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {
}
