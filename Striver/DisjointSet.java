import java.util.ArrayList;

public class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
        
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp); // path compresision i.e. store the parent of the node so in futre call if any one ask can directly get the parent
        return parent.get(node);
    }

    public void unioinByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;
        
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_u, ulp_v);
            rank.set(ulp_v, rank.get(ulp_v) + 1);
        }
    }



        public static void main(String[] args) {
            DisjointSet ds = new DisjointSet(7);
            ds.unioinByRank(1, 2);
            ds.unioinByRank(2, 3);
            ds.unioinByRank(4, 5);
            ds.unioinByRank(6, 7);
            ds.unioinByRank(5, 6);
    
            if(ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else {        
                System.out.println("Not same");
            }
    
            //  this will make union of 3 and 7, i.e. they will join to the same parent
            ds.unioinByRank(3, 7);

            if(ds.findUPar(3) == ds.findUPar(7)) {
                System.out.println("Same");
            } else {        
                System.out.println("Not same");
            }
    
        }
        
    

}
/**
 * InnerDisjointSet
 */
