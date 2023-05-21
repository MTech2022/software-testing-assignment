package org.graphstream.mit.assignment.tests;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Team Members : Sandeep M(220928012)
 *                Umadevi KS(220928007)
 * This class is used to test the node and edge
 */
public class MultiGraphNodeEdgeUT {
    private Graph graph;

    @Before
    public void setUp() {
        System.out.println("+-----------------------------MultiGraphNodeEdgeUT------------------------------+");
        graph = new MultiGraph("MTECH_MULTI_GRAPH");
    }

    @After
    public void afterEach(){
        System.out.println("+------------------------------------------------------------------------------+\n");
    }

    @Test
    public void testCreateNewGraph() {
        assertNotNull(graph);
        assertEquals("MTECH_MULTI_GRAPH", graph.getId());
    }

    @Test
    public void testCreateNewGraphFailure() {
        System.out.println("assert 'MultiGraphNodeEdgeUT' instance");
        assertNotNull(graph);
        System.out.println("assert 'MultiGraphNodeEdgeUT' instance id is 'MTECH_GRAPH' : FAILURE ");
        assertEquals("MTECH_GRAPH", graph.getId()); //Read graph with wrong graph ID
    }

    @Test
    public void testAddNodesToGraph() {
        graph.addNode("NODE_A");
        graph.addNode("NODE_B");

        System.out.println("assert 'MultiGraphNodeEdgeUT' instance has nodes");
        assertNotNull(graph.getNode("NODE_A"));
        assertNotNull(graph.getNode("NODE_B"));
    }

    @Test
    public void testAddEdgesToGraph() {
        graph.addNode("NODE_A");
        graph.addNode("NODE_B");

        //Edge between the nodes
        graph.addEdge("Edge1", "NODE_A", "NODE_B");

        System.out.println("assert 'MultiGraphNodeEdgeUT' instance has nodes and edge");
        assertTrue(graph.getNode("NODE_A").hasEdgeToward("NODE_B"));
        assertTrue(graph.getNode("NODE_B").hasEdgeToward("NODE_A"));
    }

    @Test
    public void testRemoveNodesFromGraph() {
        graph.addNode("NODE_A");
        graph.addNode("NODE_B");
        System.out.println("assert 'MultiGraphNodeEdgeUT' instance has nodes");
        assertNotNull(graph.getNode("NODE_A"));
        assertNotNull(graph.getNode("NODE_B"));
    }

    @Test
    public void testRemoveNodesFromGraphWIthFault() {
        graph.addNode("NODE_A");
        graph.addNode("NODE_B");
        assertNotNull(graph.getNode("NODE_A"));

        graph.removeNode("NODE_A");

        //Assert that the node is removed from the graph
        System.out.println("assert 'MultiGraphNodeEdgeUT' instance has nodes and edge : FAILURE, NODE_A is removed ");
        assertNotNull(graph.getNode("NODE_A"));
        assertNotNull(graph.getNode("NODE_B"));
    }

    @Test
    public void testRemoveEdgesFromGraph() {
        //Nodes in the graph
        graph.addNode("NODE_A");
        graph.addNode("NODE_B");

        //Add an edge between the nodes
        graph.addEdge("Edge1", "NODE_A", "NODE_B");

        graph.removeEdge("Edge1");

        System.out.println("assert 'MultiGraphNodeEdgeUT' instance has nodes without edge");
        assertFalse(graph.getNode("NODE_A").hasEdgeToward("NODE_B"));
        assertFalse(graph.getNode("NODE_B").hasEdgeToward("NODE_A"));
    }
}
