package harkuli.mapleprobe.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class Monsters {
    private static Map<Integer, String> names;

    @Value("classpath:data/monsters.json")
    Resource monstersResource;

    public String getName(int id) {
        if (names == null) {
            load();
        }

        if (!names.containsKey(id)) {
            return "";
        }

        return names.get(id);
    }

    private void load() {
        try {
            names = (new ObjectMapper()).readValue(
                monstersResource.getFile(),
                new TypeReference<Map<Integer, String>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
