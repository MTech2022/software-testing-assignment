package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.AdjacencyListGraph;
import org.graphstream.util.cumulative.GraphSpells;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007) This class tests the SingleGraph instance created
 */

public class AdjancyListGraphUT {

  @Before
  public void beforeEach() {
    System.out.println("+-----------------------------AdjancyListGraphUT------------------------------+");
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void testCreateAdjancyListGraphInstance() {
    GraphSpells graphSpells = new GraphSpells();
    Graph g = new AdjacencyListGraph("g");

    g.addSink(graphSpells);

    g.addNode("A");
    g.addNode("B");
    g.addNode("C");
    g.stepBegins(1);
    g.getNode("A").setAttribute("test1", 100);
    g.addEdge("AB", "A", "B");
    g.addEdge("AC", "A", "C");
    g.stepBegins(2);
    g.addEdge("CB", "C", "B");
    g.removeNode("A");
    g.stepBegins(3);
    g.addNode("A");
    g.addEdge("AB", "A", "B");
    g.stepBegins(4);
    g.removeNode("C");
    g.stepBegins(5);

    //System.out.println(graphSpells);

    System.out.println("Assert 'AdjacencyListGraph' instance");
    assertNotNull(g);
    System.out.println("Assert 'AdjacencyListGraph' is loop");
    assertFalse(g.getEdge("AB").isLoop());

    System.out.println("Assert 'AdjacencyListGraph' contains the node 'A' and 'AB' ");
    assertNotNull(g.getNode("A"));
    assertNotNull(g.getEdge("AB"));
  }

  @Test
  public void testCreateAdjancyListGraphInstanceWithFault() {
    Graph g = new AdjacencyListGraph("g");

    g.addNode("A");
    g.addNode("B");
    g.addNode("C");
    g.stepBegins(1);

    assertNotNull(g);

    g.getNode("A").setAttribute("test1", 100);
    g.addEdge("ABEdge", "A", "A");
    System.out.println("Assert 'AdjacencyListGraph' contains the edge 'ABEdge'");
    assertTrue(g.getEdge("ABEdge").getId().equalsIgnoreCase("ABEdge"));

    System.out.println("Assert 'AdjacencyListGraph' passing 'null' id for the edge");
    //Adding another edge will fail bcs of assert before Id assignment
    g.addEdge(null, "A", "A");

  }
}