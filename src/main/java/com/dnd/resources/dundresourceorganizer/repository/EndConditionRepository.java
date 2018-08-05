package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.EndCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EndConditionRepository extends JpaRepository<EndCondition, Long> {

    @Query("select endCondition from EndCondition endCondition where endCondition.endCondition like :endCondition")
    EndCondition findOne(@Param("endCondition") String endCondition);
}
