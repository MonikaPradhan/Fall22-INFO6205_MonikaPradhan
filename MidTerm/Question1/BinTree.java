package MidTerm.Question1;

public class BinTree <T> {
        public Node<T> root;

        public BinTree() {
        }

        public void populateNextRight(){
            Node start=root;

            while(start!=null) {
                Node cur = start;

                while(cur!=null){
                    if(cur.right!=null){
                        cur.right.nextLeft=cur.left;
                    }

                    if(cur.left!=null) {
                        if(cur.nextLeft!=null) {
                            cur.left.nextLeft=cur.nextLeft.right;
                        }
                    }

                    cur=cur.nextLeft;
                }

                start=start.right;
            }


            return;
        }



}


