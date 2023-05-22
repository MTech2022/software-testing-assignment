package org.graphstream.mit.assignment.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007) This class holds all the test classes. It acts as primary
 * Class for all Tests AdjancyListGraphUT.class file is unit test class GraphModificationUT.class file is unit test
 * class GraphNodeEdgeUT.class file is unit test class GraphUT.class file is unit test class GraphWithFaultsUT.class
 * file is unit test class MultiGraphNodeEdgeUT.class file is unit test class PathTestUT.class file is unit test class
 * SingleGraphUT.class file is unit test class TestSuite.class file contains the suite to execute as test suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SingleGraphUT.class,
    GraphModificationUT.class,
    GraphNodeEdgeUT.class,
    GraphUT.class,
    GraphWithFaultsUT.class,
    GraphNodeEdgeUT.class,
    AdjancyListGraphUT.class,
    MultiGraphNodeEdgeUT.class,
    PathTestUT.class,
    MultiGraphUT.class,
    PathUT.class
})
public class TestSuite {

  @Before
  public void setUp() {
    System.out.println("+***************** [TEST_SUITE] ****************************************+");
  }

  @After
  public void afterEach() {
    System.out.println("+**************************************************************************+");
  }

  // no tests to run in this class
}
