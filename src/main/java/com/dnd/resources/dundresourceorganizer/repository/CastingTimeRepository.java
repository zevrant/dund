package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.CastingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CastingTimeRepository extends JpaRepository<CastingTime, Long> {

    @Query("select castingTime from CastingTime castingTime where castingTime.number = :number " +
            "and castingTime.unit = :unit and castingTime.condition = :condition")
    Boolean castingTimeExists(@Param("number") String number, @Param("unit") String unit, @Param("condition") String condition);
}
