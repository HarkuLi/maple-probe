package harkuli.mapleprobe.controllers;

import harkuli.mapleprobe.responses.ItemsResponse;
import harkuli.mapleprobe.responses.ItemsResponse.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @GetMapping("/accessories")
    public ItemsResponse accessories() {
        List<Item> items = Arrays.asList(
            new Item(1122040, "Bronze Maple Necklace"),
            new Item(1122041, "Sealed Mind of Maple Necklace"),
            new Item(1122046, "Silver Maple Necklace")
        );

        return new ItemsResponse(items);
    }
}
