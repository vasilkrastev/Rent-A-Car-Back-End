package com.example.car.data.repository;

import com.example.car.data.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<CarEntity, Long> {
}
