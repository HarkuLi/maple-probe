package harkuli.mapleprobe.responses;

public record DropsResponse(Iterable<Drop> data) {
    public record Drop(int id, String name, int minQuantity, int maxQuantity, int chance) {}
}
