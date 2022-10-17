package pl.ryspie.wallTask.blocks;

import java.util.LinkedList;
import java.util.List;

public class CompositeBlock extends Block implements ICompositeBlock {

    private final List<IBlock> nestedBlocks = new LinkedList<>();

    public CompositeBlock(String color, String material) {
        super(color, material);
    }

    @Override
    public List getBlocks() {
        return nestedBlocks;
    }

    public void addBlocks(IBlock block1) {
        nestedBlocks.add(block1);
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
