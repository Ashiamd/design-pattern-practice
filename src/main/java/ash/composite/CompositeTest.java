package ash.composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 组合模式
 * @author : Ashiamd email: ashiamd@foxmail.com
 * @date : 2021/6/1 11:14 PM
 */
public class CompositeTest {
    public static void main(String[] args) {
        Node grandmother = new Node("grandmother");
        Node son = new Node("son");
        Node daughter = new Node("daughter");
        Node grandson = new Node("grandson");
        Node granddaughter = new Node("granddaughter");
        son.add(grandson);
        daughter.add(granddaughter);
        grandmother.add(son);
        grandmother.add(daughter);

        Queue<Node> queue = new LinkedList<>();
        queue.add(grandmother);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            System.out.println(curNode);
            queue.addAll(curNode.getSubNodes());
        }
    }
}

class Node {
    private List<Node> subNodes;
    private String description;
    public Node(String description) {
        this.description = description;
        this.subNodes = new ArrayList<>();
    }
    boolean add(Node node){ return subNodes.add(node); }
    boolean remove(Node node){ return subNodes.remove(node); }
    protected List<Node> getSubNodes() { return subNodes; }
    @Override
    public String toString() {
        return description;
    }
}
