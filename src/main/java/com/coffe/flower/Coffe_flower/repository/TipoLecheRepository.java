package com.coffe.flower.Coffe_flower.repository;

import com.coffe.flower.Coffe_flower.model.TipoDeLeche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLecheRepository extends JpaRepository<TipoDeLeche, Long> {
}
