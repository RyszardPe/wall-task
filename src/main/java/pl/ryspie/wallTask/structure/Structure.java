package pl.ryspie.wallTask.structure;

import pl.ryspie.wallTask.blocks.IBlock;

import java.util.List;
import java.util.Optional;

public interface Structure {
    //Dodaje element typu Iblock do struktury
    void addBlockToWall(IBlock block);

    // zwraca dowolny element o podanym kolorze
    Optional<IBlock> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<IBlock> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}
