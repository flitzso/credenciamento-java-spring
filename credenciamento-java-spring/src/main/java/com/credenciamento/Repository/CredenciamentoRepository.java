package com.credenciamento.Repository;

import com.credenciamento.Entity.Credenciamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredenciamentoRepository extends JpaRepository<Credenciamento, Integer> {
    // JpaRepository já fornece métodos básicos como save, findAll, findById, deleteById etc.
}
