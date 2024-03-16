package harkuli.mapleprobe.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "drop_data")
public class DropData {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dropperid")
    private Integer dropperId;

    @Column(name = "itemid")
    private Integer itemId;

    @Column(name = "minimum_quantity")
    private Integer minimumQuantity;

    @Column(name = "maximum_quantity")
    private Integer maximumQuantity;

    @Column(name = "chance")
    private Integer chance;
}
