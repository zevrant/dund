package com.dnd.resources.dundresourceorganizer.controller;

import com.dnd.resources.dundresourceorganizer.dto.ApiResponse;
import com.dnd.resources.dundresourceorganizer.dto.spell.SpellResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/spells")
public class SpellController {


    @PostMapping
    public ApiResponse<SpellResponse> createSpell(){
        return null;
    }
}
