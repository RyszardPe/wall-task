package pl.ryspie.wallTask.structure;

import pl.ryspie.wallTask.blocks.IBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
    public Optional findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List findBlocksByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return (int) blocksInWallStructure.stream()
                .flatMap(iBlock -> iBlock.toBlocksStream()).count();
    }

    @Override
    public String toString() {
        return "Wall{" +
                "blocksInWall=" + blocksInWallStructure +
                '}';
    }
}
