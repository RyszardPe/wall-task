package pl.ryspie.wallTask;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.ryspie.wallTask.blocks.Block;
import pl.ryspie.wallTask.blocks.CompositeBlock;
import pl.ryspie.wallTask.structure.Wall;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
    private static final Block BLOCK_1 = new Block("yellow", "brick");
    private static final Block BLOCK_2 = new Block("black", "clay");
    private static final CompositeBlock COMPOSITE_BLOCK_1 = new CompositeBlock("blue", "brick");
    private static final Block BLOCK_3 = new Block("black", "brick");
    private static final CompositeBlock COMPOSITE_BLOCK_2 = new CompositeBlock("green", "clay");
    private static final CompositeBlock COMPOSITE_BLOCK_3 = new CompositeBlock("purple", "clay");
    private static final Block BLOCK_4 = new Block("red", "stone");


    private Wall emptyWall = new Wall();
    private Wall filledWall;

    @BeforeAll
    static void setUpClass() {
        COMPOSITE_BLOCK_1.addBlock(BLOCK_4);
        COMPOSITE_BLOCK_1.addBlock(COMPOSITE_BLOCK_2);

        COMPOSITE_BLOCK_2.addBlock(BLOCK_3);
    }

    @BeforeEach
    void setUp() {


        filledWall = new Wall();
        filledWall.addBlockToWall(BLOCK_1);
        filledWall.addBlockToWall(BLOCK_2);
        filledWall.addBlockToWall(COMPOSITE_BLOCK_1);
        filledWall.addBlockToWall(COMPOSITE_BLOCK_3);
    }

    @Test
    void shouldBeAbleToInstantiateClass() {
        assertThat(filledWall, notNullValue());
    }


    @Test
    void shouldReturn0WhenStructureIsEmpty() {
        assertThat(emptyWall.count(), is(equalTo(0)));
    }

    @Test
    void shouldReturnEmptyOptionalWhenNotFoundByColor() {
        assertThat(filledWall.findBlockByColor("abstract color"), is(Optional.empty()));
    }

    @Test
    void shouldReturnEmptyCollectionWhenNotFoundByMaterial() {
        assertThat(filledWall.findBlocksByMaterial("abstract material"), is(empty()));
    }

    @Test
    void shouldFindOptionalOfBlockWhenFoundByColor() {
        assertThat(filledWall.findBlockByColor("black"), is(Optional.of(BLOCK_2)));
    }

    @Test
    void shouldFindCollectionOfBlocksWhenFoundByMaterial() {
        assertThat(filledWall.findBlocksByMaterial("brick"), is(List.of(BLOCK_1, BLOCK_3)));
    }

    @Test
    void shouldFindOptionalOfCompositeBlockByColor() {
        assertThat(filledWall.findBlockByColor("blue"), is(Optional.of(COMPOSITE_BLOCK_1)));
    }

    @Test
    void shouldFindListOfCompositeBlocksByMaterial() {
        assertThat(filledWall.findBlocksByMaterial("clay"), is(List.of(COMPOSITE_BLOCK_2, COMPOSITE_BLOCK_3)));
    }

        @Test
    void shouldFindOptionalOfBlockByColorInNestedStructure() {
        assertThat(filledWall.findBlockByColor("red"), is(Optional.of(BLOCK_4)));
    }

    @Test
    void shouldFindListOfBlocksByMaterialInNestedStructure() {
        assertThat(filledWall.findBlocksByMaterial("clay"), is(List.of(BLOCK_2, COMPOSITE_BLOCK_2, COMPOSITE_BLOCK_3)));
    }

    @Test
    void shouldReturnValueEqualToAddedBlocksIncludingNestedStructures() {
        assertThat(filledWall.count(), is(7));
    }

}