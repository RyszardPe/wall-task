package pl.ryspie.wallTask;

import pl.ryspie.wallTask.blocks.Block;
import pl.ryspie.wallTask.blocks.CompositeBlock;
import pl.ryspie.wallTask.structure.Structure;
import pl.ryspie.wallTask.structure.Wall;

public class Main {
    public static void main(String[] args) {
        // CREATE STRUCTURE
        Structure structure = new Wall();
        //ADD ALL TYPE BLOCKS To STRUCTURE
        Block block1 = new Block("yellow", "plastic");
        Block block2 = new Block("black", "plastic");
        CompositeBlock compositeBlock = new CompositeBlock("blue", "brick");
        CompositeBlock compositeBlock2 = new CompositeBlock("green", "stone");
        Block block3 = new Block("red", "plastic");

        compositeBlock.addBlock(block1);
        compositeBlock2.addBlock(compositeBlock);


        System.out.println(block1);
        System.out.println(block2);
        System.out.println("------------Show Composite Block-----------");
        System.out.println(compositeBlock);
        System.out.println(compositeBlock2);
        System.out.println("------------Show only nested blocks-----------");
        System.out.println(compositeBlock.getBlocks());
        System.out.println(compositeBlock2.getBlocks());
        System.out.println("------------Add block and Show Wall Structure-----------");
        structure.addBlockToWall(block1);
        structure.addBlockToWall(block2);
        structure.addBlockToWall(compositeBlock);
        structure.addBlockToWall(compositeBlock2);
        structure.addBlockToWall(block3);
        System.out.println(structure);


    }
}