package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MultiGraphUT {

  private MultiGraph graph = new MultiGraph("MTECH_MULTI_GRAPH");

  @Before
  public void setUp() {
    System.out.println("+-----------------------------MultiGraphUT------------------------------+");
    Node n1 = graph.addNode("node1");
    Node n2 = graph.addNode("node2");
    graph.addEdge("n1-n2", n1, n2);
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void testEdgeAddition() {
    MultiGraph multiGraph = new MultiGraph("MTECH_MULTI_GRAPH");
    Node root = multiGraph.addNode("root");
    Node leftNode = multiGraph.addNode("leftNode");

    Edge RL = multiGraph.addEdge("root-left", "root", "leftNode");
    System.out.println("assert 'testEdgeAddition' ");
    assertEquals(1, multiGraph.getEdgeCount());
    assertEquals(root, multiGraph.getNode("root"));// id returns the correct node
    assertFalse(RL.isDirected());// is undirected graph
    assertEquals(root, RL.getNode0());// left and right node of the edge RL
    assertEquals(leftNode, RL.getNode1());
    assertEquals(root, RL.getSourceNode());// source and target of the edge RL
    assertEquals(leftNode, RL.getTargetNode());
  }

  @Test
  public void testEdgeRemoval() {
    MultiGraph multiGraph = new MultiGraph("MTECH_MULTI_GRAPH");
    multiGraph.addNode("root");
    multiGraph.addNode("leftNode");
    multiGraph.addNode("rightNode");

    multiGraph.addEdge("root-left", "root", "leftNode");
    multiGraph.addEdge("root-right", "root", "rightNode");
    multiGraph.removeEdge("root-left");
    System.out.println("assert 'testEdgeRemoval' ");
    assertEquals(1, multiGraph.getEdgeCount());
  }

  @Test
  public void testAddNode() {
    MultiGraph multiGraph = new MultiGraph("MTECH_MULTI_GRAPH");
    multiGraph.addNode("root");
    multiGraph.addNode("leftNode");
    multiGraph.addNode("rightNode");
    System.out.println("assert 'testAddNode' ");
    assertEquals(3, multiGraph.getNodeCount());
  }

  @Test
  public void testRemoveNode() {
    MultiGraph multiGraph = new MultiGraph("MTECH_MULTI_GRAPH");
    multiGraph.addNode("root");
    multiGraph.addNode("leftNode");
    multiGraph.addNode("rightNode");
    multiGraph.addEdge("root-right", "root", "rightNode");
    multiGraph.addEdge("left-right", "leftNode", "rightNode");
    multiGraph.removeNode("root");
    System.out.println("assert 'testRemoveNode' ");
    assertEquals(2, multiGraph.getNodeCount());
    assertEquals(1, multiGraph.getEdgeCount());

  }

  @Test
  public void testMultiEdgeAdition() {
    MultiGraph multiGraph = new MultiGraph("MTECH_MULTI_GRAPH");
    multiGraph.addNode("leftNode");
    multiGraph.addNode("rightNode");
    multiGraph.addEdge("Edge1", "leftNode", "rightNode");
    multiGraph.addEdge("Edge2", "leftNode", "rightNode");
    assertEquals(2, multiGraph.getEdgeCount());
  }

  @Test
  public void testMultiGraphBasics() {
    assertNotNull(graph);
    assertEquals("MTECH_MULTI_GRAPH", graph.getId());
  }

  @Test
  public void testMultiGraphNodes() {

    Node n1 = graph.getNode("node1");
    Node n2 = graph.getNode("node2");

    assertNotNull(n1);
    assertNotNull(n2);

    assertEquals("node1", n1.getId());
    assertEquals("node2", n2.getId());
  }

  @Test
  public void testMultiGraphEdgesBasics() {
    Edge e1 = graph.getEdge("n1-n2");

    assertNotNull(e1);
    assertEquals("n1-n2", e1.getId());

  }

  @Test
  public void testMultiGraphEdges1() {
    Node n1 = graph.getNode("node1");
    Node n2 = graph.getNode("node2");
    Edge e1 = graph.getEdge("n1-n2");

    assertEquals(n1.getEdgeBetween(n2), e1);
    assertEquals(n2.getEdgeBetween(n1), e1);
    assertEquals(n1.getEdgeBetween(n2), n2.getEdgeBetween(n1));
  }
}