package harkuli.mapleprobe.services;

import harkuli.mapleprobe.resources.Monsters;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MonsterService {
    private final Monsters monsters;

    public MonsterService(Monsters monsters) {
        this.monsters = monsters;
    }

    public Map<Integer, String> getAll() {
        return monsters.getAll();
    }
}
