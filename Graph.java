public class Graph {
    private boolean[][] matrix;
    private Object[] nodes;
    private int size;
    private int numNodes = 0;

    Graph(int size){
        matrix = new boolean[size][size];
        nodes = new Object[size];
        this.size = size;
    }
    
    public void addNode(Object item){
        boolean present = false;
        for (Object node : nodes) {
            if (node == item) {
                present = true;
                break;
            }
        }
        if (!present && numNodes + 1 != size) {
            nodes[numNodes] = item;
            numNodes++;
        }
    }
    public void removeNode(Object item) {
        for (int i = 0; i < size; i++) {
            if (nodes[i] == item) {
                nodes[i] = null;
                matrix[i] = new boolean[size];
                numNodes--;
                break;
            }
        }
    }
    public void addEdge(Object src, Object dst) {
        editEdge(true, src, dst);
    }
    public void removeEdge(Object src, Object dst) {
        editEdge(false, src, dst);
    }
    public Object[] toArrayEdge(Object item) {
        Object[] array = new Object[numNodes];
        int elems = 0;
        for (int i = 0; i < size; i++) {
            if (nodes[i] == item) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j]) {
                        array[elems] = nodes[j];
                        elems++;
                    }
                }
                break;
            }
        }
        return array;
    }
    public Object[] toArrayNodes() {
        Object[] array = new Object[numNodes];
        int elems = 0;
        for (Object i : nodes) {
            if (i != null) {
                array[elems] = i;
                elems++;
            }
        }
        return array;
    }
    public String toStringEdge(Object item) {
        String str = "[";
        for (int i = 0; i < size; i++) {
            if (nodes[i] == item) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j]) {
                        str += nodes[j] + ", ";
                    }
                }
                break;
            }
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        return str + "]";
    }
    public String toStringNodes() {
        String str = "[";
        for (Object i : nodes) {
            if (i != null) str += i + ", ";
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 2);
        }
        return str + "]";
    }
    private void editEdge(boolean choice, Object src, Object dst) {
        for (int i = 0; i < size; i++) {
            if (nodes[i] == src) {
                for (int j = 0; j < size; j++) {
                    if (nodes[j] == dst) {
                        matrix[i][j] = choice;
                        break;
                    }
                }
                break;
            }
        }
    }
}
