package com.crudRPG.crudRPG.repository;

import com.crudRPG.crudRPG.entities.ItensMagicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensMagicosRepository extends JpaRepository<ItensMagicos, Long> {


}
