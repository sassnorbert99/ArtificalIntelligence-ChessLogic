package SakkLogika;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//GOF2: használj HAS-A kapcsolatot ha lehet
public class NodeWithApplicableOp extends AbstractNode implements Iterator<Integer> {
    Node act;
    List<Integer> supOpIndex = new ArrayList<Integer>();
    int actIndex = 0;
    public NodeWithApplicableOp(Node act){
        if (act != null) {
            this.act = act;
            State s = act.getState();
            for (int i = 0; i < s.getNumberOfOperators(); i++) {
                if(s.superOperator(i) != null){
                    supOpIndex.add(i);
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return actIndex < supOpIndex.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer next() {
        int oldIndex = actIndex;
        actIndex++;
        return supOpIndex.get(oldIndex); //To change body of generated methods, choose Tools | Templates.
    }

    //todo: remove

    @Override
    public State getState() {
        return act.getState();
    }

    @Override
    public int getDepth() {
        return act.getDepth();
    }

    @Override
    public Node getParent() {
        return act.getParent();
    }

    @Override
    public boolean isTerminal() {
        return act.isTerminal();
    }

    @Override
    public AbstractNode createChildNode(int index) {
        Node newNode = (Node)act.createChildNode(index);
        return new NodeWithApplicableOp(newNode);
    }

}
