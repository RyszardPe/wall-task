package pl.ryspie.wallTask.structure;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
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
        return 0;
    }
}
