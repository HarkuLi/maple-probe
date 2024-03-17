package harkuli.mapleprobe.repositories;

import harkuli.mapleprobe.entities.DropData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DropDataRepository extends JpaRepository<DropData, Long> {
    List<DropData> findByItemId(Integer itemId);
    List<DropData> findByDropperId(Integer dropperId);
}
