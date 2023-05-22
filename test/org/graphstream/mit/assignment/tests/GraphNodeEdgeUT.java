package org.graphstream.mit.assignment.tests;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007) This class is used to test the node and edge
 */
public class GraphNodeEdgeUT {

  private Graph graph;

  @Before
  public void setUp() {
    System.out.println("+-----------------------------GraphNodeEdgeUT--------------------------------+");
    graph = new SingleGraph("MTECH_GRAPH");
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void testCreateNewGraph() {
    System.out.println("Assert 'SingleGraph' instance");
    Assert.assertNotNull(graph);
    System.out.println("Assert 'SingleGraph' instance has 'MTECH_GRAPH' id ");
    Assert.assertEquals("MTECH_GRAPH", graph.getId());
  }

  @Test
  public void testAddNodesToGraph() {
    graph.addNode("Node1");
    graph.addNode("Node2");

    System.out.println("Assert 'SingleGraph' instance has nodes Node1, Node2");
    Assert.assertNotNull(graph.getNode("Node1"));
    Assert.assertNotNull(graph.getNode("Node2"));
  }

  @Test
  public void testAddEdgesToGraph() {
    graph.addNode("Node1");
    graph.addNode("Node2");

    //Edge between the nodes
    graph.addEdge("Edge1", "Node1", "Node2");

    System.out.println("Assert 'SingleGraph' instance has nodes has edge");
    Assert.assertTrue(graph.getNode("Node1").hasEdgeToward("Node2"));
    Assert.assertTrue(graph.getNode("Node2").hasEdgeToward("Node1"));
  }

  @Test
  public void testRemoveNodesFromGraph() {
    graph.addNode("Node1");
    graph.addNode("Node2");

    graph.removeNode("Node1");

    System.out.println("Assert 'SingleGraph' instance has no Node1");
    Assert.assertNull(graph.getNode("Node1"));

    System.out.println("Assert 'SingleGraph' instance has Node2");
    Assert.assertNotNull(graph.getNode("Node2"));
  }

  @Test
  public void testRemoveEdgesFromGraph() {
    graph.addNode("Node1");
    graph.addNode("Node2");

    graph.addEdge("Edge1", "Node1", "Node2");
    graph.removeEdge("Edge1");

    System.out.println("Assert 'SingleGraph' instance has nodes has no edges");
    Assert.assertFalse(graph.getNode("Node1").hasEdgeToward("Node2"));
    Assert.assertFalse(graph.getNode("Node2").hasEdgeToward("Node1"));
  }
}
