package com.company;

import com.company.models.GameHelper;

import static com.company.BoardTest.assertEquals;
import static java.util.Arrays.asList;

public class HelperTest {
    private static final GameHelper helper = new GameHelper();

    public static void main(String[] args) {
//        assertEquals(helper.moveAndMergeEquals(asList(1, 2, null, 3)), asList(1, 2, 3, null));
//        assertEquals(helper.moveAndMergeEquals(asList(2, 2, null, 3)), asList(4, 3, null, null));
//        assertEquals(helper.moveAndMergeEquals(asList(2, 2, 4, 4)), asList(4, 8, null, null));
//        assertEquals(helper.moveAndMergeEquals(asList(2, 2, 2, 3)), asList(4, 2, 3, null));
        assertEquals(helper.moveAndMergeEquals(asList(2, null, null, 2)), asList(4, null, null, null));
        assertEquals(helper.moveAndMergeEquals(asList(null, null, null, 2)), asList(2, null, null, null));
        assertEquals(helper.moveAndMergeEquals(asList(null, null, 2, 2)), asList(4, null, null, null));
        assertEquals(helper.moveAndMergeEquals(asList(null, null, null, null)), asList(null, null, null, null));
    }
}
