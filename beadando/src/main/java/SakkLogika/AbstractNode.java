package SakkLogika;

abstract class AbstractNode{
    public abstract State getState();
    public abstract int getDepth();
    public abstract Node getParent();
    public abstract boolean isTerminal();
    public abstract AbstractNode createChildNode(int index);

}
