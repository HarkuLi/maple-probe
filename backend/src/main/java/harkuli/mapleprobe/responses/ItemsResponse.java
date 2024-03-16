package harkuli.mapleprobe.responses;

public record ItemsResponse(Iterable<Item> data) {
    public record Item(int id, String name) {}
}
