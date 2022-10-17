package pl.ryspie.wallTask;

import pl.ryspie.wallTask.blocks.Block;
import pl.ryspie.wallTask.blocks.CompositeBlock;

public class Main {
    public static void main(String[] args) {
        Block block1 = new Block("yellow", "plastic");
        Block block2 = new Block("black", "plastic");
        CompositeBlock compositeBlock = new CompositeBlock("blue", "brick");
        CompositeBlock compositeBlock2 = new CompositeBlock("green", "stone");

        compositeBlock.addBlocks(block1);
        compositeBlock2.addBlocks(compositeBlock);

        System.out.println(block1);
        System.out.println(block2);
        System.out.println(compositeBlock);
        System.out.println(compositeBlock2);


    }
}