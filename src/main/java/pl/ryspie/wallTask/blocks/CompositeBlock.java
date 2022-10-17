package pl.ryspie.wallTask.blocks;

import java.util.LinkedList;
import java.util.List;

public class CompositeBlock extends Block implements ICompositeBlock {

    private final List<IBlock> nestedBlocks = new LinkedList<>();

    public CompositeBlock(String color, String material) {
        super(color, material);
    }

    @Override
    public List<IBlock> getBlocks() {
        return nestedBlocks;
    }

    @Override
    public void addBlock(IBlock block) {
        nestedBlocks.add(block);
    }

    @Override
    public String toString() {
        return "CompositeBlock[" +
                "color='" + getColor() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ']' +
                " , nestedBlocks=" + nestedBlocks +
                '}';
    }
}
