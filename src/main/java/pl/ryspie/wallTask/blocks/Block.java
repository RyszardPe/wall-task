package pl.ryspie.wallTask.blocks;

import java.util.stream.Stream;

public class Block implements IBlock {

    private final String color;
    private final String material;

    public Block(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public Stream<IBlock> toBlocksStream() {
        return Stream.of(this);
    }

    @Override
    public String toString() {
        return "Block{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
