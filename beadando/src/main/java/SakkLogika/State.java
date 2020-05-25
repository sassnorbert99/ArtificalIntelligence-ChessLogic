package SakkLogika;

/**
 állapottér rep = (A, k, C , O, Pre, Post)
 A = állapotE()
 k = konstruktor
 C = célÁllapotE()
 O = szuperoperátor, az op része a State-nek
 Pre, Post része a State-nek
 immutablemegoldás
 */
public abstract class State{
    public abstract boolean isState();
    public abstract boolean isGoalState();
    public abstract int getNumberOfOperators();
    public abstract State superOperator(int i);

}
