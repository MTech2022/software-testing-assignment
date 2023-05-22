package org.graphstream.mit.assignment.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.AbstractNode;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Team Members : Sandeep M(220928012) Umadevi KS(220928007)
 */
public class PathUT {

  @Before
  public void setUp() {
    System.out.println("+-----------------------------PathUT------------------------------+");
  }

  @After
  public void afterEach() {
    System.out.println("+------------------------------------------------------------------------------+\n");
  }

  @Test
  public void emptyPathTest() {
    Path path = new Path();
    boolean isEmpty = path.empty();
    System.out.println("assert 'testAddNodesToGraph' ");
    assertTrue(isEmpty);
  }

  @Test
  public void rootPathSetRootMethodTest() {
    SingleGraph sg = new SingleGraph("SINGLE_GRAPH_ID");
    Path path = new Path();
    sg.addNode("node1");
    AbstractNode node1 = (AbstractNode) sg.getNode("node1");
    path.setRoot(node1);
    System.out.println("assert 'rootPathSetRootMethodTest' ");
    assertEquals(node1, path.getRoot());
  }

  @Test
  public void rootPathAddMethodTest() {
    SingleGraph sg = new SingleGraph("SINGLE_GRAPH_ID");
    sg.addNode("node1");
    sg.addNode("node2");
    Node node1 = sg.getNode("node1");
    Node node2 = sg.getNode("node2");
    Edge edge1 = sg.addEdge("edge_1", node1, node2, true);

    Path path = new Path();
    path.add(node1, edge1);
    System.out.println("assert 'rootPathAddMethodTest' ");
    assertEquals(node1, path.getRoot());
  }

  @Test
  public void circularPathTest() {
    SingleGraph sg = new SingleGraph("SINGLE_GRAPH_ID");
    sg.addNode("node1");
    sg.addNode("node2");
    sg.addNode("node3");

    Node node1 = sg.getNode("node1");
    Node node2 = sg.getNode("node2");
    Node node3 = sg.getNode("node3");

    Edge edge1 = sg.addEdge("edge_1", node1, node2, true);
    Edge edge2 = sg.addEdge("edge_2", node2, node3, true);
    Edge edge3 = sg.addEdge("edge_3", node3, node1, true);

    Path path = new Path();
    path.setRoot(node1);
    path.add(node1, edge1);
    path.add(node2, edge2);
    path.add(node3, edge3);

    List<Node> nodes = path.getNodePath();

    int size = path.size();
    Node lastNode = nodes.get(size - 1);
    System.out.println("assert 'circularPathTest' ");
    assertEquals(path.getRoot(), lastNode);

  }

  @Test
  public void removeLoopsTest() {
    SingleGraph sg = new SingleGraph("SINGLE_GRAPH_ID");
    Path path = new Path();

    sg.addNode("node1");
    sg.addNode("node2");
    sg.addNode("node3");

    Node node1 = sg.getNode("node1");
    Node node2 = sg.getNode("node2");
    Node node3 = sg.getNode("node3");

    Edge edge1 = sg.addEdge("edge_1", node1, node2, true);
    Edge edge2 = sg.addEdge("edge_2", node2, node3, true);
    Edge edge3 = sg.addEdge("edge_3", node3, node3, true);

    path.setRoot(node1);

    path.add(node1, edge1);
    path.add(node2, edge2);
    path.add(node3, edge3);

    path.removeLoops();
    System.out.println("assert 'removeLoopsTest' ");
    assertFalse(path.contains(edge3));

  }

}
