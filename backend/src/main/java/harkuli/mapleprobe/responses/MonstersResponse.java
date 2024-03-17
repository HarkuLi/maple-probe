package harkuli.mapleprobe.responses;

public record MonstersResponse(Iterable<Monster> data) {
    public record Monster(int id, String name) {}
}
