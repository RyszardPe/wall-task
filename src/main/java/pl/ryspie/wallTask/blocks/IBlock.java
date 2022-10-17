package pl.ryspie.wallTask.blocks;

import pl.ryspie.wallTask.structure.Structure;

import java.util.stream.Stream;

public interface IBlock {
    String getColor();
    String getMaterial();

    Stream<IBlock> toBlocksStream();
}
