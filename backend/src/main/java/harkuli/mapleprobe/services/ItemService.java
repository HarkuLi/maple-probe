package harkuli.mapleprobe.services;

import harkuli.mapleprobe.resources.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ItemService {
    private final Items items;

    @Autowired
    public ItemService(Items items) {
        this.items = items;
    }

    public Map<Integer, String> getAccessories() throws IOException {
        return items.getAccessories();
    }

    public Map<Integer, String> getCaps() throws IOException {
        return items.getCaps();
    }

    public Map<Integer, String> getCapes() throws IOException {
        return items.getCapes();
    }

    public Map<Integer, String> getCoats() throws IOException {
        return items.getCoats();
    }

    public Map<Integer, String> getFaces() throws IOException {
        return items.getFaces();
    }

    public Map<Integer, String> getGloves() throws IOException {
        return items.getGloves();
    }

    public Map<Integer, String> getLongCoats() throws IOException {
        return items.getLongCoats();
    }

    public Map<Integer, String> getPants() throws IOException {
        return items.getPants();
    }

    public Map<Integer, String> getRings() throws IOException {
        return items.getRings();
    }

    public Map<Integer, String> getShields() throws IOException {
        return items.getShields();
    }

    public Map<Integer, String> getShoes() throws IOException {
        return items.getShoes();
    }

    public Map<Integer, String> getWeapons() throws IOException {
        return items.getWeapons();
    }

    public Map<Integer, String> getEtc() throws IOException {
        return items.getEtc();
    }

    public Map<Integer, String> getUses() throws IOException {
        return items.getUses();
    }
}
