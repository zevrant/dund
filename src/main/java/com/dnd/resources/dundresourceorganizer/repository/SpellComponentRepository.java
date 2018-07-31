package com.dnd.resources.dundresourceorganizer.repository;

import com.dnd.resources.dundresourceorganizer.entity.SpellComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellComponentRepository extends JpaRepository<SpellComponent, Long> {

    @Query("select spellComponent from SpellComponent  spellComponent where spellComponent.component = :component")
    SpellComponent findByComponent(@Param("component") String component);

}
