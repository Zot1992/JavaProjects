public class Graph {
    private int maxN=3; //количесво вершин в нашем графе
    private int [][] mas; //матрица смежности которая показывает связь между вершинами
    Vertex [] vertexList; //список вершин
    private int curN; //счетчик вершин

    public Graph(){ //конструктор, который отвечает за инициализацию
        vertexList=new Vertex[maxN];
        mas=new int [maxN][maxN];
        curN=0;
    }

    public void addVertex(char name){
        vertexList[curN++]=new Vertex(name);
    }
    public void addEdge(int start, int end, int val){ //метод, который создает ребра
        mas[start][end]=1;
        mas[end][start]=val;
    }
}
