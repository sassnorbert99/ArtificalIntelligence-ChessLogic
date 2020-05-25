/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mestint;
import SakkLogika.*;

/**
 *
 * @author Norbert
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        State k = new ChessState();
        ((ChessState)k).printTable();
        //l.printTable();



        //State b = k.superOperator(0);
        //if(b!=null){System.out.println("");}
        Node s = new Node(k, null);
        NodeWithApplicableOp S = new NodeWithApplicableOp(s);
        GraphSearcher backtrack = new BackTrack();
        NodeWithApplicableOp sol= backtrack.search(S, 15);

        if(sol!=null){
            System.out.println("van megoldás");
        }else{
            System.out.println("nincs megoldás");
        }

    }

}


// immutable or mutable?
//mutable -> klónt kell írni
//immutable -> az op nem bool(új állapotot ad vissza)

