package com.crudRPG.crudRPG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensMagicosRepository extends JpaRepository<ItensMagicosRepository, String> {
}
