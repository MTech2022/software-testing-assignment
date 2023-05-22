package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007)
 */
public class GraphWithFaultsUT {

  private Graph graph;

  @Before
  public void setUp() {
    System.out.println("+-----------------------------GraphWithFaultsUT------------------------------+");
    graph = new SingleGraph("MTech_Graph");
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void testAddNodesToGraph() {
    System.out.println("assert 'testAddNodesToGraph' ");
    graph.addNode("Node1");
    //COMMENTED BELOW LINE TO TEST IF THE NODE IS NULL OR NOT.
    //graph.addNode("Node2");

    // FAULT TESTING:  NODES
    assertNotNull(graph.getNode("Node1"));   // This will pass
    assertNull(graph.getNode("Node2"));   // This will pass
    assertNotNull(graph.getNode("Node2"));// This will fail. 'Node2' is not added to graph.

  }

  @Test
  public void testAddEdgesToGraph() {
        /*Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");
        graph.addEdge("Edge1", node1, node2);*/
    System.out.println("assert 'testAddEdgesToGraph' ");
    // FAULT TESTING:  NODES WITHOUT EDGE
    assertNull(graph.getEdge("Edge1"));  // This will pass
    assertNotNull(graph.getEdge("Edge1")); // This will fail. Edge is not added to node.
  }

  @Test
  public void testRemoveNodesFromGraph() {
    graph.addNode("Node1");
    graph.addNode("Node2");
    graph.removeNode("Node1");
    System.out.println("assert 'testRemoveNodesFromGraph' ");
    // Assert that the node is successfully removed from the graph
    assertNull(graph.getNode("Node1"));
    assertNotNull(graph.getNode("Node2")); // test fault
    assertNotNull(graph.getNode("Node2"));
  }

  @Ignore
  public void testRemoveEdgesFromGraph() {
    System.out.println("assert 'testRemoveEdgesFromGraph' ");
    // Add nodes to the graph
    Node node1 = graph.addNode("Node1");
    Node node2 = graph.addNode("Node2");
    // Add an edge
  }
}