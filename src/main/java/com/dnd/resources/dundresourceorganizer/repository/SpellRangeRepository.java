package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.SpellRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpellRangeRepository extends JpaRepository<SpellRange, Long> {

    @Query("select range from SpellRange range where range.distance.id = :id and range.type = :rangeType")
    SpellRange findOne(@Param("id") long distanceId, @Param("rangeType") String type);
}
