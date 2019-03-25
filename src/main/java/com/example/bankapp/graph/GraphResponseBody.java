package com.example.bankapp.graph;

import java.util.List;

public class GraphResponseBody {
    private String msg;
    private List<Vertex> result;
    private List<Edge> edges;

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public String getMsg() { // this will respond to a Object.msg call on the client-side.
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Vertex> getVertices() {
        return result;
    }

    public void setVertices(List<Vertex> result) {
        this.result = result;
    }
}
