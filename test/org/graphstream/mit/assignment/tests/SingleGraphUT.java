package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007) This class tests the SingleGraph instance created
 */
public class SingleGraphUT {

  private SingleGraph graph = new SingleGraph("SINGLE_GRAPH_ID");

  @Before
  public void beforeEach() {
    System.out.println("-----------------------------SingleGraphUT-----------------------------------");
    Node n1 = graph.addNode("node1");
    Node n2 = graph.addNode("node2");
    graph.addEdge("n1-n2", n1, n2);
  }

  @After
  public void afterEach() {
    System.out.println("------------------------------------------------------------------------------\n");
  }

  @Test
  public void testEdgeAddition() {
    Graph singleGraph = new SingleGraph("single-graph");

    Node root = singleGraph.addNode("root");

    Node leftNode = singleGraph.addNode("leftNode");
    Edge RL = singleGraph.addEdge("root-left", "root", "leftNode");
    System.out.println("Assert 'testEdgeAddition' ");
    assertEquals(1, singleGraph.getEdgeCount());
    assertEquals(root, singleGraph.getNode("root"));
    assertFalse(RL.isDirected());
    assertEquals(root, RL.getNode0());
    assertEquals(leftNode, RL.getNode1());
    assertEquals(root, RL.getSourceNode());
    assertEquals(leftNode, RL.getTargetNode());
  }

  @Test
  public void testEdgeRemoval() {
    Graph singleGraph = new MultiGraph("single-graph");
    singleGraph.addNode("root");
    singleGraph.addNode("leftNode");
    singleGraph.addNode("rightNode");

    singleGraph.addEdge("root-left", "root", "leftNode");
    singleGraph.addEdge("root-right", "root", "rightNode");
    singleGraph.removeEdge("root-left");
    System.out.println("Assert 'testEdgeRemoval' ");
    assertEquals(1, singleGraph.getEdgeCount());
  }

  @Test
  public void testAddNode() {
    Graph singleGraph = new SingleGraph("single-graph");
    singleGraph.addNode("root");
    singleGraph.addNode("leftNode");
    singleGraph.addNode("rightNode");
    System.out.println("Assert 'testAddNode' ");
    assertEquals(singleGraph.getNodeCount(), 3);
  }

  @Test
  public void testRemoveNode() {
    Graph singleGraph = new SingleGraph("single-graph");
    singleGraph.addNode("root");
    singleGraph.addNode("leftNode");
    singleGraph.addNode("rightNode");
    singleGraph.addEdge("root-right", "root", "rightNode");
    singleGraph.addEdge("left-right", "leftNode", "rightNode");
    singleGraph.removeNode("root");
    System.out.println("Assert 'testRemoveNode' ");
    assertEquals(2, singleGraph.getNodeCount());
    assertEquals(1, singleGraph.getEdgeCount());

  }

  @Test
  public void testSingleGraphBasics() {
    System.out.println("Assert 'testSingleGraphBasics' ");
    assertNotNull(graph);
    assertEquals("SINGLE_GRAPH_ID", graph.getId());
  }

  @Test
  public void testSingleGraphEdgesBasics() {
    Edge e1 = graph.getEdge("n1-n2");
    System.out.println("Assert 'testSingleGraphEdgesBasics' ");
    assertNotNull(e1);
    assertEquals("n1-n2", e1.getId());
  }

  @Test
  public void testSingleGraphNodes() {

    Node n1 = graph.getNode("node1");
    Node n2 = graph.getNode("node2");
    System.out.println("Assert 'testSingleGraphNodes' ");
    assertNotNull(n1);
    assertNotNull(n2);
    assertEquals("node1", n1.getId());
    assertEquals("node2", n2.getId());
  }

  @Test
  public void singleGraphEdgeTest() {
    SingleGraph sg = new SingleGraph("first", false, false, 1, 0);
    sg.addNode("node_1");
    sg.addNode("node_2");
    Node node1 = sg.getNode("node_1");
    Node node2 = sg.getNode("node_2");

    Edge edge = sg.addEdge("edge_1", node1, node2, true);
    System.out.println("Assert 'singleGraphEdgeTest' ");
    assertEquals(node1, edge.getSourceNode());
    assertEquals(node2, edge.getTargetNode());
  }

  @Test
  public void testSingleGraphEdges1() {
    Node n1 = graph.getNode("node1");
    Node n2 = graph.getNode("node2");
    Edge e1 = graph.getEdge("n1-n2");
    System.out.println("Assert 'testSingleGraphEdges1' ");
    assertEquals(n1.getEdgeBetween(n2), e1);
    assertEquals(n2.getEdgeBetween(n1), e1);
    assertEquals(n1.getEdgeBetween(n2), n2.getEdgeBetween(n1));
  }

  @Test
  public void singleGraphNotConnectedNodeTest() {
    SingleGraph sg = new SingleGraph("first", false, false, 3, 2);
    sg.addNode("node_1");
    sg.addNode("node_2");
    sg.addNode("node_3");

    Node node1 = sg.getNode("node_1");

    Node node2 = sg.getNode("node_2");
    Node node3 = sg.getNode("node_3");

    sg.addEdge("edge_1", node1, node2, true);
    System.out.println("Assert 'singleGraphNotConnectedNodeTest' ");
    assertEquals(0, node3.getDegree());
  }

  @Test
  public void singleGraphLoopTest() {
    SingleGraph sg = new SingleGraph("first", false, false, 1, 0);
    sg.addNode("node_1");
    Node node1 = sg.getNode("node_1");
    sg.addEdge("edge_1", node1, node1, true);
    Edge edge = sg.getEdge("edge_1");
    System.out.println("Assert 'singleGraphLoopTest' ");
    assertEquals(node1, edge.getTargetNode());
  }


  @Test
  public void singleGraphNodeDegreeTest() {
    SingleGraph sg = new SingleGraph("first", false, false, 3, 2);
    sg.addNode("node_1");
    sg.addNode("node_2");
    sg.addNode("node_3");
    Node node1 = sg.getNode("node_1");
    Node node2 = sg.getNode("node_2");
    Node node3 = sg.getNode("node_3");
    sg.addEdge("edge_1", node1, node2, true);
    sg.addEdge("edge_2", node1, node3, true);
    System.out.println("Assert 'singleGraphNodeDegreeTest' ");
    assertEquals(2, node1.getDegree());
  }

  @Test
  public void singleGraphNotMultiTest() {
    SingleGraph sg = new SingleGraph("first", false, false, 3, 2);
    sg.addNode("node_1");
    sg.addNode("node_2");
    Node node1 = sg.getNode("node_1");
    Node node2 = sg.getNode("node_2");
    sg.addEdge("edge_1", node1, node2, false);
    sg.addEdge("edge_2", node2, node1, false);
    Edge edge1 = sg.getEdge("edge_1");
    Edge edge2 = sg.getEdge("edge_2");
    System.out.println("Assert 'singleGraphNotMultiTest' ");
    assertFalse(2 == node1.getDegree());
    assertNull(edge1);
    assertNull(edge2);
  }
}