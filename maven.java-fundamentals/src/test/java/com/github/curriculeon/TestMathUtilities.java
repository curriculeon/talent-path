package com.github.curriculeon;

import com.github.curriculeon.mathutilities.TestAddition;
import com.github.curriculeon.mathutilities.TestSubtraction;
import com.github.curriculeon.mathutilities.TestDivision;
import com.github.curriculeon.mathutilities.TestMultiplication;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Leon Hunter on 6/14/17.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestAddition.class,
        TestSubtraction.class,
        TestDivision.class,
        TestMultiplication.class
})
public class TestMathUtilities {
}