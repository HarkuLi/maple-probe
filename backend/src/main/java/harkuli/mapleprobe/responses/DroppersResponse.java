package harkuli.mapleprobe.responses;

public record DroppersResponse(Iterable<Dropper> data) {
    public record Dropper(int id, String name, int minQuantity, int maxQuantity, int chance) {}
}
