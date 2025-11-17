package com.coffe.flower.Coffe_flower.repository;

import com.coffe.flower.Coffe_flower.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {
}
