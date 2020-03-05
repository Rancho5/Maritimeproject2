package com.att;

import com.att.node.Node;

public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(!(obj instanceof Edge))
            return false;
        Edge objEdge = (Edge)obj;
        return (objEdge.from == this.from) && (objEdge.to == this.to);
    }
}
