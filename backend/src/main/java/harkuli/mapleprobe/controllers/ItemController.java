package harkuli.mapleprobe.controllers;

import harkuli.mapleprobe.responses.DroppersResponse;
import harkuli.mapleprobe.responses.ItemsResponse;
import harkuli.mapleprobe.responses.ItemsResponse.Item;
import harkuli.mapleprobe.services.DropDataService;
import harkuli.mapleprobe.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final DropDataService dropDataService;

    @Autowired
    public ItemController(ItemService itemService, DropDataService dropDataService) {
        this.itemService = itemService;
        this.dropDataService = dropDataService;
    }

    @GetMapping("/accessories")
    public ItemsResponse getAccessories() throws IOException {
        List<Item> items = itemService.getAccessories()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/caps")
    public ItemsResponse getCaps() throws IOException {
        List<Item> items = itemService.getCaps()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/capes")
    public ItemsResponse getCapes() throws IOException {
        List<Item> items = itemService.getCapes()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/coats")
    public ItemsResponse getCoats() throws IOException {
        List<Item> items = itemService.getCoats()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/faces")
    public ItemsResponse getFaces() throws IOException {
        List<Item> items = itemService.getFaces()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/gloves")
    public ItemsResponse getGloves() throws IOException {
        List<Item> items = itemService.getGloves()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/longcoats")
    public ItemsResponse getLongCoats() throws IOException {
        List<Item> items = itemService.getLongCoats()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/pants")
    public ItemsResponse getPants() throws IOException {
        List<Item> items = itemService.getPants()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/rings")
    public ItemsResponse getRings() throws IOException {
        List<Item> items = itemService.getRings()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/shields")
    public ItemsResponse getShields() throws IOException {
        List<Item> items = itemService.getShields()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/shoes")
    public ItemsResponse getShoes() throws IOException {
        List<Item> items = itemService.getShoes()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/weapons")
    public ItemsResponse getWeapons() throws IOException {
        List<Item> items = itemService.getWeapons()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/etc")
    public ItemsResponse getEtc() throws IOException {
        List<Item> items = itemService.getEtc()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/uses")
    public ItemsResponse getUses() throws IOException {
        List<Item> items = itemService.getUses()
            .entrySet()
            .stream()
            .map(e -> new Item(e.getKey(), e.getValue()))
            .toList();

        return new ItemsResponse(items);
    }

    @GetMapping("/{id}/droppers")
    public DroppersResponse getDroppers(@PathVariable int id) {
        return new DroppersResponse(dropDataService.getDroppers(id));
    }
}
