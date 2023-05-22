package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.graphstream.graph.Edge;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007) This class is used to test the node and edge
 */
public class PathTestUT {

  Path path;
  private SingleGraph graph;

  @Before
  public void setUp() throws Exception {
    System.out.println("+-----------------------------PathTestUT------------------------------+");
    path = new Path();

    graph = new SingleGraph("MTECH_GRAPH");
    Node rootNode = graph.addNode("NODE_FOR_PATH");
    path.setRoot(rootNode);
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void getRoot() {
    assertNotNull(path.getRoot());
  }

  @Test
  public void contains() {
    Node rootNode = graph.getNode("NODE_FOR_PATH");
    boolean isNodePresent = path.contains(rootNode);
    System.out.println("assert 'PathTestUT' contains root node");
    assertTrue(isNodePresent);
  }

  @Test(expected = IdAlreadyInUseException.class)
  public void containsAlreadyExistsError() {
    Node rootNode = graph.addNode("NODE_FOR_PATH");
    boolean isNodePresent = path.contains(rootNode);
    System.out.println("assert 'PathTestUT' contains root node and duplicate fails\n expected exception");
    assertTrue(isNodePresent);
  }

  @Test
  public void testContains() {
    graph.addNode("NODE_FOR_PATH_A");
    Edge edge = graph.addEdge("EDGE_A", "NODE_FOR_PATH", "NODE_FOR_PATH_A");
    boolean isEdgePresent = path.contains(edge);
    assertFalse(isEdgePresent);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add() {
    System.out.println("assert 'PathTestUT' IllegalArgumentException exception");
    Node node = graph.addNode("NODE_FOR_PATH_A");
    Edge edge = graph.addEdge("EDGE_A", "NODE_FOR_PATH", "NODE_FOR_PATH_A");
    path.add(node, edge);
    int edgeCount = path.getEdgeCount();
    assertEquals(1, edgeCount);
  }

  @Test
  public void getACopy() {
    Path aCopy = path.getACopy();
    boolean node_for_path = aCopy.contains(graph.getNode("NODE_FOR_PATH"));
    System.out.println("assert 'PathTestUT' duplicate path contains the node copied");
    assertTrue(node_for_path);
  }

  @Test
  public void getNodeCount() {
    int nodeCount = path.getNodeCount();
    System.out.println("assert 'PathTestUT' nodeCount");
    assertEquals(1, nodeCount);
  }

  @Test
  public void getEdgeCount() {
    int edgeCount = path.getEdgeCount();
    System.out.println("assert 'PathTestUT' edgeCount");
    assertEquals(0, edgeCount);
  }

}