package pl.ryspie.wallTask.structure;

import pl.ryspie.wallTask.blocks.IBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wall implements Structure {

    private final List<IBlock> blocksInWallStructure;

    public Wall() {
        this.blocksInWallStructure = new LinkedList<>();
    }


    @Override
    public void addBlockToWall(IBlock block) {
        blocksInWallStructure.add(block);
    }

    @Override
    public Optional<IBlock> findBlockByColor(String color) {
        return Optional.of(filterBlocksBy(block -> color.equals(block.getColor()))
                        .findAny())
                .orElse(null);
    }

    @Override
    public List<IBlock> findBlocksByMaterial(String material) {
        Stream<IBlock> filteredBlocksByMaterial = filterBlocksBy(block -> material.equals(block.getMaterial()));
        return filteredBlocksByMaterial.collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) (getFlattenedIBlockStreamFromNestedStructure().count());
    }

    private Stream<IBlock> filterBlocksBy(Predicate<IBlock> givenPredicate) {
        return getFlattenedIBlockStreamFromNestedStructure().filter(givenPredicate);
    }

    private Stream<IBlock> getFlattenedIBlockStreamFromNestedStructure() {
        return blocksInWallStructure.stream()
                .flatMap(IBlock::toBlocksStream);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "blocksInWall=" + blocksInWallStructure +
                '}';
    }
}
