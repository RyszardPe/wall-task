package pl.ryspie.wallTask.blocks;

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
    public String toString() {
        return "Block{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
