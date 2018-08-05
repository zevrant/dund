package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DurationRepository extends JpaRepository<Duration, Long> {

    @Query("select duration from Duration duration where duration.amount = :amount " +
            "and duration.condition = :condition and duration.type = :durationType and duration.subType = :subType")
    Duration findOne(@Param("amount") int amount, @Param("condition") String condition,
                     @Param("durationType") String type, @Param("subType") String subType);
}
