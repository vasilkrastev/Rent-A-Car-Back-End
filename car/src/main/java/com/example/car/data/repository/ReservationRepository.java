package com.example.car.data.repository;

import com.example.car.data.entity.CarEntity;
import com.example.car.data.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
