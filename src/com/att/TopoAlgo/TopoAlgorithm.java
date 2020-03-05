package com.att.TopoAlgo;

import com.att.Edge;
import com.att.node.Node;

import java.util.List;

public interface TopoAlgorithm {
    List<Edge> geneEdges(List<Node> nodes);
}
