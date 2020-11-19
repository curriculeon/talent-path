package com.github.curriculeon;

import com.github.curriculeon.christmas.ChristmasTreeImpl;
import com.github.curriculeon.christmas.ChristmasTreeInterface;
import com.github.curriculeon.christmas.LivingRoom;
import com.github.curriculeon.christmas.RedwoodChristmasTree;
import org.junit.Assert;
import org.junit.Test;

public class LivingRoomTest {
    @Test
    public void basicChristmas() {
        // given
        LivingRoom livingRoom = new LivingRoom();
        ChristmasTreeInterface tree = new ChristmasTreeImpl();
        Assert.assertFalse(livingRoom.containsTree(tree));

        // when
        livingRoom.insertChristmasTree(tree);

        // then
        Assert.assertTrue(livingRoom.containsTree(tree));
    }

    @Test
    public void christmas2020() {
        // given
        LivingRoom livingRoom = new LivingRoom();
        ChristmasTreeInterface tree = new ChristmasTreeImpl();
        ChristmasTreeInterface giantTree = new RedwoodChristmasTree(tree);
        ChristmasTreeInterface colossalTree = new RedwoodChristmasTree(giantTree);
        ChristmasTreeInterface ginormousTree = new RedwoodChristmasTree(colossalTree);
        Assert.assertFalse(livingRoom.containsTree(ginormousTree));
        livingRoom.insertChristmasTree(ginormousTree);

        // when
        ginormousTree.occupySpace();

        // then
        Assert.assertTrue(livingRoom.containsTree(ginormousTree));
    }
}
