package harkuli.mapleprobe.services;

import harkuli.mapleprobe.entities.DropData;
import harkuli.mapleprobe.repositories.DropDataRepository;
import harkuli.mapleprobe.resources.Items;
import harkuli.mapleprobe.resources.Monsters;
import harkuli.mapleprobe.responses.DroppersResponse;
import harkuli.mapleprobe.responses.DropsResponse;
import harkuli.mapleprobe.responses.MonstersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DropDataService {
    private final DropDataRepository dropDataRepository;
    private final Monsters monsters;
    private final Items items;

    @Autowired
    public DropDataService(
        DropDataRepository dropDataRepository,
        Monsters monsters,
        Items items
    ) {
        this.dropDataRepository = dropDataRepository;
        this.monsters = monsters;
        this.items = items;
    }

    public List<DroppersResponse.Dropper> getDroppers(int itemId) {
        return dropDataRepository.findByItemId(itemId)
            .stream()
            .filter(dropData -> dropData.getChance() != 0)
            .map(dropData -> new DroppersResponse.Dropper(
                dropData.getDropperId(),
                monsters.getName(dropData.getDropperId()),
                dropData.getMinimumQuantity(),
                dropData.getMaximumQuantity(),
                dropData.getChance()
            ))
            .toList();
    }

    public List<DropsResponse.Drop> getDrops(int monsterId) {
        return dropDataRepository.findByDropperId(monsterId)
            .stream()
            .filter(dropData -> dropData.getItemId() != 0 && dropData.getChance() != 0)
            .map(dropData -> new DropsResponse.Drop(
                dropData.getItemId(),
                items.getName(dropData.getItemId()),
                dropData.getMinimumQuantity(),
                dropData.getMaximumQuantity(),
                dropData.getChance()
            ))
            .toList();
    }
}
