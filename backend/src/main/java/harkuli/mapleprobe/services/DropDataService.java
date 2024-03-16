package harkuli.mapleprobe.services;

import harkuli.mapleprobe.entities.DropData;
import harkuli.mapleprobe.repositories.DropDataRepository;
import harkuli.mapleprobe.resources.Monsters;
import harkuli.mapleprobe.responses.DroppersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DropDataService {
    private final DropDataRepository dropDataRepository;
    private final Monsters monsters;

    @Autowired
    public DropDataService(
        DropDataRepository dropDataRepository,
        Monsters monsters
    ) {
        this.dropDataRepository = dropDataRepository;
        this.monsters = monsters;
    }

    public List<DroppersResponse.Dropper> getDroppers(int itemId) {
        return dropDataRepository.findByItemId(itemId)
            .stream()
            .map(dropData -> new DroppersResponse.Dropper(
                dropData.getDropperId(),
                monsters.getName(dropData.getDropperId()),
                dropData.getMinimumQuantity(),
                dropData.getMaximumQuantity(),
                dropData.getChance()
            ))
            .toList();
    }
}
