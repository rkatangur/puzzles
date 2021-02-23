package org.examples.collections;

public class Graph<T> {

  private final int MAX_VERTS = 20;

  private Vertex<T>[] vertexList;
  private int[][] adjMat;
  private int numOfVerts;

  public Graph() {
    vertexList = new Vertex[MAX_VERTS];
    adjMat = new int[MAX_VERTS][MAX_VERTS];
    numOfVerts = 0;
  }

  public void addVertex(T value) {
    vertexList[numOfVerts++] = new Vertex<T>(value, false);
  }

  public void addEdge(int start, int end) {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
  }

  public void displayVertex(int v) {
    System.out.print(vertexList[v].value);
  }

  public void dfs(int vIndex) {
    Stack<Integer> dfsStack = new Stack<>();
    displayVertex(vIndex);
    vertexList[vIndex].wasVisisted = true;
    dfsStack.push(vIndex);
    while (!dfsStack.isEmpty()) {
      int unvisitedVIndex = getAdjUnvisitedVertex(dfsStack.peek());
      if (unvisitedVIndex == -1) {
        dfsStack.pop();
      } else {
        displayVertex(unvisitedVIndex);
        vertexList[unvisitedVIndex].wasVisisted = true;
        dfsStack.push(unvisitedVIndex);
      }
    }
  }

  public void bfs(int vIndex) {
    Queue<Integer> bfsQueue = new Queue<Integer>();
    bfsQueue.add(vIndex);

    displayVertex(vIndex);
    vertexList[vIndex].wasVisisted = true;

    int v2 = 0;
    while (!bfsQueue.isEmpty()) {
      int v1 = bfsQueue.remove();
      while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
        vertexList[v2].wasVisisted = true;
        displayVertex(v2);
        bfsQueue.add(v2);
      }
    }

  }

  private int getAdjUnvisitedVertex(int vIndex) {
    for (int j = 0; j < numOfVerts; j++) {
      if (adjMat[vIndex][j] == 1) {
        System.out.println(vertexList[j].wasVisisted);
        if(!vertexList[j].wasVisisted)
          return j;
      }
    }
    return -1;
  }

  public void mst(int vIndex) {
    Stack<Integer> dfsStack = new Stack<>();
    // displayVertex(vIndex);
    vertexList[vIndex].wasVisisted = true;
    dfsStack.push(vIndex);

    while (!dfsStack.isEmpty()) {
      int currentIndex = dfsStack.peek();
      int unvisitedVIndex = getAdjUnvisitedVertex(currentIndex);
      if (unvisitedVIndex == -1) {
        dfsStack.pop();
      } else {
        displayVertex(currentIndex);
        displayVertex(unvisitedVIndex);
        System.out.print(" ");
        vertexList[unvisitedVIndex].wasVisisted = true;
        dfsStack.push(unvisitedVIndex);
      }
    }

  }

  public static class Vertex<T> {
    private T value;
    private boolean wasVisisted;

    public Vertex(T value, boolean wasVisisted) {
      this.value = value;
      this.wasVisisted = wasVisisted;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public boolean isWasVisisted() {
      return wasVisisted;
    }

    public void setWasVisisted(boolean wasVisisted) {
      this.wasVisisted = wasVisisted;
    }

  }

  public static void main(String[] args) {
     dfsTest();
     System.out.println();
    // bfsTest();
    mstTest();
  }

  private static void mstTest() {
    Graph<Character> charGraph = new Graph<>();
    charGraph.addVertex('A');
    charGraph.addVertex('B');
    charGraph.addVertex('C');
    charGraph.addVertex('D');
    charGraph.addVertex('E');

    charGraph.addEdge(0, 1); // AB
    charGraph.addEdge(0, 2); // AC
    charGraph.addEdge(0, 3); // AD
    charGraph.addEdge(0, 4); // AE
    charGraph.addEdge(1, 2); // BC
    charGraph.addEdge(1, 3); // BD
    charGraph.addEdge(1, 4); // BE
    charGraph.addEdge(2, 3); // CD
    charGraph.addEdge(2, 4); // CE
    charGraph.addEdge(3, 4); // DE

    charGraph.mst(0);
  }

  private static void bfsTest() {

  }

  private static void dfsTest() {
    Graph<Character> charGraph = new Graph<>();
    charGraph.addVertex('A');
    charGraph.addVertex('B');
    charGraph.addVertex('C');
    charGraph.addVertex('D');
    charGraph.addVertex('E');


    charGraph.addEdge(0, 1); // AB
    charGraph.addEdge(1, 2); // BC
    charGraph.addEdge(1, 3); // BD
    charGraph.addEdge(0, 3);// AD
    charGraph.addEdge(3, 4);// DE

    // A - [0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], AB, AD
    // B - [1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], AB, BC
    // C - [0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], BC
    // D - [1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], AD, DE
    // E - [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], DE

    charGraph.dfs(0);
  }



}
