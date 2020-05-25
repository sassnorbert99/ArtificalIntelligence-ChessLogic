package SakkLogika;


public class BackTrack implements GraphSearcher {
    @Override
    public NodeWithApplicableOp search(NodeWithApplicableOp s, int maxDepth){
        //innen kezdjük a keresést
        System.out.println("s.getDepth(): " + s.getDepth());
        System.out.println("maxDepth: " + maxDepth);
        if (s.getDepth() >= maxDepth) {
            return null;
        }
        System.out.println("lépés1");
        NodeWithApplicableOp act = s;
        if (act.isTerminal()) {
            return act;
        }
        System.out.println("lépés2");
        if (!act.hasNext()) {
            return null;
        }
        System.out.println("lépés3");
        Node act2 = s.getParent();

        while(act2!=null){
            State s1,s2;
            s1 = s.getState();
            s2 = act2.getState();
            //System.out.println(s1);

            if(s1.equals(s2))return null;

            act2 = act2.getParent();
            System.out.println(s2);
        }






        System.out.println("lépés4");

        while (act.hasNext()) {
            System.out.println("lépés5");
            int index = act.next();
            System.out.println("index: " + index);
            NodeWithApplicableOp next = (NodeWithApplicableOp)act.createChildNode(index);
            NodeWithApplicableOp solution = search(next, maxDepth);
            if (solution != null) {
                return solution;
            }
            System.out.println("lépés6");

        }
        return null;
    }
}
