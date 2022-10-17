package pl.ryspie.wallTask.blocks;

import java.util.List;

public interface ICompositeBlock extends IBlock {
  List<IBlock> getBlocks();

  void addBlock(IBlock block);
}
