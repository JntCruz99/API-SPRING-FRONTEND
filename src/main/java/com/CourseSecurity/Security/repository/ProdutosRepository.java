package com.CourseSecurity.Security.repository;

import com.CourseSecurity.Security.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, UUID> {

}
