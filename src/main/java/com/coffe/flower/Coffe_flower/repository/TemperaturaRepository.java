package com.coffe.flower.Coffe_flower.repository;

import com.coffe.flower.Coffe_flower.model.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Long> {
}

