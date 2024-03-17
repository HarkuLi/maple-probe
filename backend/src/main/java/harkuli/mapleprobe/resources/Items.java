package harkuli.mapleprobe.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class Items {
    private static Map<Integer, String> accessories;
    private static Map<Integer, String> capes;
    private static Map<Integer, String> caps;
    private static Map<Integer, String> coats;
    private static Map<Integer, String> etc;
    private static Map<Integer, String> faces;
    private static Map<Integer, String> gloves;
    private static Map<Integer, String> longCoats;
    private static Map<Integer, String> pants;
    private static Map<Integer, String> rings;
    private static Map<Integer, String> shields;
    private static Map<Integer, String> shoes;
    private static Map<Integer, String> uses;
    private static Map<Integer, String> weapons;

    @Value("classpath:data/accessories.json")
    Resource accessoriesResource;

    @Value("classpath:data/capes.json")
    Resource capesResource;

    @Value("classpath:data/caps.json")
    Resource capsResource;

    @Value("classpath:data/coats.json")
    Resource coatsResource;

    @Value("classpath:data/etc.json")
    Resource etcResource;

    @Value("classpath:data/faces.json")
    Resource facesResource;

    @Value("classpath:data/gloves.json")
    Resource glovesResource;

    @Value("classpath:data/longcoats.json")
    Resource longCoatsResource;

    @Value("classpath:data/pants.json")
    Resource pantsResource;

    @Value("classpath:data/rings.json")
    Resource ringsResource;

    @Value("classpath:data/shields.json")
    Resource shieldsResource;

    @Value("classpath:data/shoes.json")
    Resource shoesResource;

    @Value("classpath:data/uses.json")
    Resource usesResource;

    @Value("classpath:data/weapons.json")
    Resource weaponsResource;

    public Map<Integer, String> getAccessories() throws IOException {
        if (accessories == null) {
            loadAccessories();
        }

        return accessories;
    }

    private void loadAccessories() throws IOException {
        accessories = (new ObjectMapper()).readValue(
            accessoriesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getCapes() throws IOException {
        if (capes == null) {
            loadCapes();
        }

        return capes;
    }

    private void loadCapes() throws IOException {
        capes = (new ObjectMapper()).readValue(
            capesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getCaps() throws IOException {
        if (caps == null) {
            loadCaps();
        }

        return caps;
    }

    private void loadCaps() throws IOException {
        caps = (new ObjectMapper()).readValue(
            capsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getCoats() throws IOException {
        if (coats == null) {
            loadCoats();
        }

        return coats;
    }

    private void loadCoats() throws IOException {
        coats = (new ObjectMapper()).readValue(
            coatsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getEtc() throws IOException {
        if (etc == null) {
            loadEtc();
        }

        return etc;
    }

    private void loadEtc() throws IOException {
        etc = (new ObjectMapper()).readValue(
            etcResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getFaces() throws IOException {
        if (faces == null) {
            loadFaces();
        }

        return faces;
    }

    private void loadFaces() throws IOException {
        faces = (new ObjectMapper()).readValue(
            facesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getGloves() throws IOException {
        if (gloves == null) {
            loadGloves();
        }

        return gloves;
    }

    private void loadGloves() throws IOException {
        gloves = (new ObjectMapper()).readValue(
            glovesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getLongCoats() throws IOException {
        if (longCoats == null) {
            loadLongCoats();
        }

        return longCoats;
    }

    private void loadLongCoats() throws IOException {
        longCoats = (new ObjectMapper()).readValue(
            longCoatsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getPants() throws IOException {
        if (pants == null) {
            loadPants();
        }

        return pants;
    }

    private void loadPants() throws IOException {
        pants = (new ObjectMapper()).readValue(
            pantsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getRings() throws IOException {
        if (rings == null) {
            loadRings();
        }

        return rings;
    }

    private void loadRings() throws IOException {
        rings = (new ObjectMapper()).readValue(
            ringsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getShields() throws IOException {
        if (shields == null) {
            loadShields();
        }

        return shields;
    }

    private void loadShields() throws IOException {
        shields = (new ObjectMapper()).readValue(
            shieldsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getShoes() throws IOException {
        if (shoes == null) {
            loadShoes();
        }

        return shoes;
    }

    private void loadShoes() throws IOException {
        shoes = (new ObjectMapper()).readValue(
            shoesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getUses() throws IOException {
        if (uses == null) {
            loadUses();
        }

        return uses;
    }

    private void loadUses() throws IOException {
        uses = (new ObjectMapper()).readValue(
            usesResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public Map<Integer, String> getWeapons() throws IOException {
        if (weapons == null) {
            loadWeapons();
        }

        return weapons;
    }

    private void loadWeapons() throws IOException {
        weapons = (new ObjectMapper()).readValue(
            weaponsResource.getFile(),
            new TypeReference<Map<Integer, String>>() {}
        );
    }

    public String getName(int id) {
        try {
            if (getAccessories().containsKey(id)) {
                return getAccessories().get(id);
            }

            if (getCapes().containsKey(id)) {
                return getCapes().get(id);
            }

            if (getCaps().containsKey(id)) {
                return getCaps().get(id);
            }

            if (getCoats().containsKey(id)) {
                return getCoats().get(id);
            }

            if (getEtc().containsKey(id)) {
                return getEtc().get(id);
            }

            if (getGloves().containsKey(id)) {
                return getGloves().get(id);
            }

            if (getLongCoats().containsKey(id)) {
                return getLongCoats().get(id);
            }

            if (getPants().containsKey(id)) {
                return getPants().get(id);
            }

            if (getRings().containsKey(id)) {
                return getRings().get(id);
            }

            if (getShields().containsKey(id)) {
                return getShields().get(id);
            }

            if (getShoes().containsKey(id)) {
                return getShoes().get(id);
            }

            if (getUses().containsKey(id)) {
                return getUses().get(id);
            }

            if (getWeapons().containsKey(id)) {
                return getWeapons().get(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "";
    }
}
