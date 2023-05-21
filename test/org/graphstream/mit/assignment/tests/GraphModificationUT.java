package org.graphstream.mit.assignment.tests;

import org.graphstream.graph.ElementNotFoundException;
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
 * Create a new SingleGraph instance for each test case
 * Add nodes to the graph and Assert that the nodes
 * Add an edge between the nodes & Assert that the edge
 */
public class GraphModificationUT {
    private Graph graph;

    @Before
    public void setUp() {
        System.out.println("+-----------------------------GraphModificationUT------------------------------+");
        graph = new SingleGraph("MTech_Graph");
    }

    @After
    public void afterEach(){
        System.out.println("+------------------------------------------------------------------------------+\n");
    }

    @Test
    public void testAddNodesToGraph() {
        System.out.println("Assert 'SingleGraph' instance");
        Assert.assertNotNull(graph.getNode("Node1"));
        Assert.assertNotNull(graph.getNode("Node2"));
    }

    @Test
    public void testAddEdgesToGraph() {
        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");

        graph.addEdge("Edge1", node1, node2);
        System.out.println("Assert 'Edge' from 'SingleGraph' instance");
        Assert.assertNotNull(graph.getEdge("Edge1"));
    }

    @Test
    public void testRemoveNodesFromGraph() {
        // Node1 does not exist. hence this will be ERROR : org.graphstream.graph.ElementNotFoundException: Node "Node1"
        System.out.println("ERROR : org.graphstream.graph.ElementNotFoundException: Node 'Node1'");
        graph.removeNode("Node1");
        System.out.println("Assert 'Node1' is null  from 'SingleGraph' instance");
        Assert.assertNull(graph.getNode("Node1"));
        System.out.println("Assert 'Node2' is not null  from 'SingleGraph' instance");
        Assert.assertNotNull(graph.getNode("Node2"));
    }

    @Test(expected = ElementNotFoundException.class)
    public void testRemoveNodesFromGraphException() {
        // Node1 does not exist. hence this will be ERROR : org.graphstream.graph.ElementNotFoundException: Node "Node1"
        System.out.println("ERROR : org.graphstream.graph.ElementNotFoundException: Node 'Node1'");
        graph.removeNode("Node1");
        System.out.println("Assert 'Node1' is null  from 'SingleGraph' instance");
        Assert.assertNull(graph.getNode("Node1"));
        System.out.println("Assert 'Node2' is not null  from 'SingleGraph' instance");
        Assert.assertNotNull(graph.getNode("Node2"));
    }

    @Test
    public void testRemoveEdgesFromGraph() {
        Node node1 = graph.addNode("Node1");
        Node node2 = graph.addNode("Node2");

        graph.addEdge("Edge1", node1, node2);
        graph.removeEdge("Edge1");
        System.out.println("Assert 'Edge' from 'SingleGraph' instance");
        Assert.assertNull(graph.getEdge("Edge1"));
    }

}




