package org.javaexercises.lojaservice.repository;

import org.javaexercises.lojaservice.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {
}
