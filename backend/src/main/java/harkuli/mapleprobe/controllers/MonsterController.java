package harkuli.mapleprobe.controllers;

import harkuli.mapleprobe.responses.MonstersResponse;
import harkuli.mapleprobe.responses.MonstersResponse.Monster;
import harkuli.mapleprobe.services.DropDataService;
import harkuli.mapleprobe.services.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/monsters")
public class MonsterController {
    private final MonsterService monsterService;
    private final DropDataService dropDataService;

    @Autowired
    public MonsterController(MonsterService monsterService, DropDataService dropDataService) {
        this.monsterService = monsterService;
        this.dropDataService = dropDataService;
    }

    @GetMapping("")
    public MonstersResponse getMonsters() {
        List<Monster> monsters = monsterService.getAll()
            .entrySet()
            .stream()
            .map(e -> new Monster(e.getKey(), e.getValue()))
            .toList();

        return new MonstersResponse(monsters);
    }
}
