package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DistanceRepository extends JpaRepository<Distance, Long> {

    @Query("select distance from Distance distance where distance.amount = :amount and distance.type = :type")
    Distance findOne(@Param("amount") int amount, @Param("type") String type);
}
