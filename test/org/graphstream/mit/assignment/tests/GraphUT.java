package org.graphstream.mit.assignment.tests;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Team Members : Sandeep M(220928012)
 *                Umadevi KS(220928007)
 *
 */
public class GraphUT {
    private Graph graph;

    @Before
    public void setUp() {
        System.out.println("+-----------------------------GraphUT------------------------------+");
        graph = new SingleGraph("MTech_Graph");
    }

    @After
    public void afterEach(){
        System.out.println("+------------------------------------------------------------------------------+\n");
    }
    @Test
    public void testAddNodesToGraph() {
        graph.addNode("Node1");
        graph.addNode("Node2");
        System.out.println("Assert 'testAddNodesToGraph' ");
        Assert.assertNotNull(graph.getNode("Node1"));
        Assert.assertNull(graph.getNode("Node2")); // test fault
        Assert.assertNull(graph.getNode("Node2"));

    }

    @Test
    public void testAddEdgesToGraph() {
        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");

        graph.addEdge("Edge1", node1, node2);
        System.out.println("Assert 'testAddEdgesToGraph' ");
        Assert.assertNotNull(graph.getEdge("Edge1"));
        Assert.assertNull(graph.getEdge("Edge1")); // test fault
        Assert.assertNull(graph.getEdge("Edge1"));
    }

    @Test
    public void testRemoveNodesFromGraph() {
        graph.addNode("Node1");
        graph.addNode("Node2");
        graph.removeNode("Node1");
        System.out.println("Assert 'testRemoveNodesFromGraph' ");
        Assert.assertNull(graph.getNode("Node1"));
        Assert.assertNotNull(graph.getNode("Node2"));
        Assert.assertNotNull(graph.getNode("Node1"));
    }

    @Test
    public void testRemoveEdgesFromGraph() {
        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");

        graph.addEdge("Edge1", node1, node2);
        graph.removeEdge("Edge1");
        System.out.println("Assert 'testRemoveEdgesFromGraph' ");
        Assert.assertNull(graph.getEdge("Edge1"));
        Assert.assertNotNull(graph.getEdge("Edge2"));
        Assert.assertNull(graph.getEdge("Edge1"));
    }

    @Test
    public void testGraphStructureAfterModifications() {
        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");

        graph.addEdge("Edge1", node1, node2);
        graph.removeNode("Node1");
        System.out.println("Assert 'testGraphStructureAfterModifications' ");
        Assert.assertNull(graph.getNode("Node1"));
        Assert.assertNotNull(graph.getNode("Node2"));
        Assert.assertNull(graph.getEdge("Edge1"));
    }
}
