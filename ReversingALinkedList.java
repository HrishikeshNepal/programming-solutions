class Scratch {
    public static void main(String args[]) {
        Node node = new Node(5, new Node(4, new Node(3, new Node(2, new Node(1, null)))));
        Node node1 = node;
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        node1 = reverseHeadNode(node1);
        System.out.println();
        while(node1 != null){
            System.out.print(node1.data + " ");
            node1 = node1.next;
        }
    }

    static class Node {
        int data;
        Node next;
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static Node reverseHeadNode(Node head){
        Node previous = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }



//    @Test
//    public void testReverseHeadNode_NullNode(){
//        Node node = null;
//        Node reversed = reverseHeadNode(node);
//        Assert.assertTrue(reversed.equals(null));
//    }

//    @Test
//    public void testReverseHeadNode_NullNode(){
//        Node node = null;
//        Node reversed = reverseHeadNode(node);
//        Assert.assertTrue(reversed.equals(null));
//    }
}

/*
on this lis 5 -> 4 -> 3 -> 2 -> 1 -> null
you have head node data: 5, pointer -> (4.data, 4.pointer)
you are going to write a while loop on above list until node != null
inside the loop you are going to exchange the pointers:currentNode = (5, 5.pointer)
let say initially previousNode is null and nextNode is null
Now you are going to exchange pointers because it's a linked list you just need to switch the directions of arrows.
now do: nextNode = currentNode.pointer (which will be (4, 4.pointer))
        currentNode.pointer = previousNode; (5 is pointing to null)
        previousNode = current (5 is set to previousNode)
        currentNode = nextNode (4 is set to Current)

        After first step what hapens is null <- 5 -> 4 -> 3 -> 2 -> 1 -> null
 */
