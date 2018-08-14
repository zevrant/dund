package com.dnd.resources.dundresourceorganizer;

import com.dnd.resources.dundresourceorganizer.dto.spellImport.*;
import com.dnd.resources.dundresourceorganizer.entity.*;
import com.dnd.resources.dundresourceorganizer.repository.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class Importer {

    @Autowired
    private SpellRepository spellRepository;

    @Autowired
    private SpellComponentRepository spellComponentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CastingTimeRepository castingTimeRepository;

    @Autowired
    private CharacterClassRepository characterClassRepository;

    @Autowired
    private DistanceRepository distanceRepository;

    @Autowired
    private DurationRepository durationRepository;

    @Autowired
    private EndConditionRepository endConditionRepository;

    @Autowired
    private SpellRangeRepository spellRangeRepository;

    @Autowired
    private SubclassRepository subclassRepository;

    Logger logger = LoggerFactory.getLogger(DundResourceOrganizerApplication.class);


//    private @ResponseBody String importSpellSchools() throws Exception{
////        String[] schools = {"Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation"};
////        SpellSchool spellSchool;
////        for(String school : schools){
////            spellSchool = new SpellSchool(school, null);
////            spellSchoolRepository.save(spellSchool);
////        }
////        spellSchoolRepository.flush();
////        importJson();
////        return "trd";
////    }

//    @RequestMapping("/test")
//    @Transactional(rollbackOn = Throwable.class)
    public void importJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        String json = restTemplate.getForObject("https://lithdoran.github.io/fiveetools/data/spells.json", String.class, new Object());
        SpellListDTO spells = objectMapper.readValue(new URL("https://lithdoran.github.io/fiveetools/data/spells.json"), new TypeReference<SpellListDTO>(){});

        spells.getSpells().forEach(this::mapToEntities);
    }

    private void mapToEntities(SpellDTO spellDTO){
        Spell spell = new Spell();
        spell.setName(spellDTO.getName());
        spell.setLevel((short) spellDTO.getLevel());
        spell.setSchool(spellDTO.getSchool());
        spell.setCastingTime(mapCastTime(spell, spellDTO.getTime().get(0)));
        spell.setRange(mapRange(spellDTO.getRange()));
        spell.setComponents(mapComponents(spellDTO.getComponents()));
        spell.setDuration(mapDurationType(spellDTO.getDuration().get(0)));
        spell.setClasses(mapClasses(spellDTO.getClasses()));
        spell.setSource(spellDTO.getSource());
        spell.setDescription(mapEntries(spellDTO.getEntries()));
        if(spellDTO.getMeta() != null) {
            spell.setRitual(spellDTO.getMeta().getRitual());
            spell.setTechnomagic(spellDTO.getMeta().isTechnomagic());
        }
        castingTimeRepository.saveAndFlush(spell.getCastingTime());

        logger.error("SpellResponse: {} End Condition: {}", spell.getName(), spell.getDuration().getEnds());
        spellRepository.save(spell);
    }

    private String mapEntries(List<EntryDTO> entries) {
        StringBuilder stringBuilder = new StringBuilder();
        entries.forEach(entryDTO -> {
            if(entryDTO.getEntry() == null) {
                entryDTO.getEntries().forEach(eachEntry -> {
                    stringBuilder.append(eachEntry);
                });
            } else {
                stringBuilder.append(entryDTO.getEntry());
            }
        });
        return stringBuilder.toString();
    }

    private List<CharacterClass> mapClasses(ClassesListDTO classes) {

        List<CharacterClass> classList = new ArrayList<>();
        classes.getFromClassList().forEach(classDTO -> {
            CharacterClass characterClass = new CharacterClass();
            characterClass.setName(classDTO.getName());
            characterClass.setSource(classDTO.getSource());
            classList.add(characterClass);
        });
        return characterClassRepository.saveAll(classList);
    }

    private List<Subclass> mapSubClasses(CharacterClass characterClass, List<SubclassDTO> subclasses) {
        if(subclasses == null){
            return  new ArrayList<>();
        }
        List<Subclass> subclassList = new ArrayList<>(subclasses.size());
        subclasses.forEach(subclassDTO -> {
            Subclass subclass = new Subclass();
            subclass.setSubclassName(subclassDTO.getSubclass().getName());
            subclass.setSource(subclassDTO.getSubclass().getSource());
            subclass.setSubSubClass(subclass.getSubSubClass());
            subclassList.add(subclass);

        });
        return subclassRepository.saveAll(subclassList);
    }

    private Duration mapDurationType(DurationTypeDTO durationDTO) {
        Duration duration = new Duration();
        duration.setCondition(durationDTO.getCondition());
        duration.setConcentration(durationDTO.isConcentration());
        duration.setType(durationDTO.getType());
        duration.setEnds(mapEndCondition(durationDTO.getEnds()));
        Duration dbDuration = durationRepository.findOne(duration.getAmount(), duration.getCondition(), duration.getType(), duration.getSubType());
        if(dbDuration == null) {
            return durationRepository.saveAndFlush(mapDuration(duration, durationDTO.getDuration()));
        }else {
            return durationRepository.saveAndFlush(dbDuration);
        }
    }

    private List<EndCondition> mapEndCondition(List<String> ends) {
        if(ends == null){
            return Collections.emptyList();
        }
        List<EndCondition> endConditions = new ArrayList<>();
        ends.forEach(end -> {
            EndCondition endCondition = new EndCondition();
            endCondition.setEndCondition(end);
            EndCondition dbCondition = endConditionRepository.findOne(endCondition.getEndCondition());
            if(dbCondition == null) {
                endCondition = endConditionRepository.saveAndFlush(endCondition);
            }else {
                endCondition = dbCondition;
            }
            endConditions.add(endCondition);
        });
        return endConditions;
    }

    private Duration mapDuration(Duration duration, DurationDTO durationDTO) {
        if(durationDTO != null) {
            duration.setAmount(durationDTO.getAmount());
            duration.setSubType(durationDTO.getType());
        }
        return duration;
    }

    private List<SpellComponent> mapComponents(ComponentDTO components) {
        List<SpellComponent> spellComponents = new ArrayList<>();
        SpellComponent component = new SpellComponent();
        component.setComponent(components.getM());
        if(component.getComponent() != null && spellComponentRepository.findByComponent(component.getComponent()) == null) {
            spellComponents.add(component);
        }
        SpellComponent component2 = new SpellComponent();
        component2.setComponent((components.isV())? "V" : null);

        if(component2.getComponent() != null && spellComponentRepository.findByComponent(component2.getComponent()) == null){
            spellComponents.add(component2);
        }
        SpellComponent component3 = new SpellComponent();
        component3.setComponent((components.isS())? "S" : null);
        if(component3.getComponent() != null && spellComponentRepository.findByComponent(component3.getComponent()) == null){
            spellComponents.add(component3);
        }
        return spellComponentRepository.saveAll(spellComponents);
    }

    private SpellRange mapRange(RangeDTO range) {
        SpellRange spellRange = new SpellRange();
        spellRange.setDistance(mapDistance(range.getDistance()));
        spellRange.setType(range.getType());
        SpellRange dbRange = null;
        if(spellRange.getDistance() != null) {
            Distance distance = distanceRepository.findOne(spellRange.getDistance().getAmount(), spellRange.getDistance().getType());
            dbRange = spellRangeRepository.findOne(distance.getId(), spellRange.getType());
        }
//        if(distance != null) {

        if(dbRange == null){
            return spellRangeRepository.save(spellRange);
        }
//        }

        return dbRange;
    }

    private Distance mapDistance(DistanceDTO distanceDTO) {
        if(distanceDTO == null){
            return null;
        }
        Distance distance = new Distance();
        distance.setAmount(distanceDTO.getAmount());
        distance.setType(distanceDTO.getType());
        Distance dbDistance = distanceRepository.findOne(distance.getAmount(), distance.getType());
        if(dbDistance == null) {
            distance = distanceRepository.save(distance);
            return distance;
        }
        return dbDistance;
    }

    private CastingTime mapCastTime(Spell spell, TimeDTO time) {
        CastingTime castingTime = new CastingTime();
        castingTime.setNumber(time.getNumber());
        castingTime.setUnit(time.getUnit());
        castingTime.setCondition(time.getCondition());
        Boolean exists = castingTimeRepository.castingTimeExists(castingTime.getNumber(), castingTime.getUnit(), castingTime.getCondition());
        if(!ObjectUtils.defaultIfNull(exists, true)) {
            castingTime = castingTimeRepository.saveAndFlush(castingTime);
        }
        return castingTime;
    }
}
