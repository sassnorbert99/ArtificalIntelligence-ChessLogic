package SakkLogika;



public class Node extends AbstractNode {
    State starting;
    int depth;
    Node parent;
    public Node(State s, Node p){
        starting = s;
        parent = p;
        if(p!=null){
            depth = p.getDepth() + 1;
        }else{
            depth = 0;
        }
    }
    @Override
    public State getState() {return starting;}
    @Override
    public int getDepth() { return depth;}
    @Override
    public Node getParent() { return parent; }
    @Override
    public boolean isTerminal(){ return starting.isGoalState(); }
//lombock

    @Override
    public AbstractNode createChildNode(int index) {
        State newState = starting.superOperator(index);
        return new Node(newState, this);
    }
}
