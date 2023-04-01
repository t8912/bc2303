package week4.ds;

//public class SingleLinkedList {

  
//}

/* Linked list Node*/
public class Node {
  int data;
  private Node next; // next is storing the reference of the node
  Node(int d) {
      data = d;
      next = null;
  }
  public Node getNext() {
      return this.next;
  }
  public void setNext(Node next) {
      this.next = next;
  }
}
// Demonstrate deletion in singly linked list
class LinkedList {
  Node head; // head of list
  /* Given a key, deletes the first
     occurrence of key in
   * linked list */
  void deleteNode(int key) {
      // Store head node
      Node temp = head;
      Node prev = null;
      // If head node itself holds the key to be deleted
      if (temp != null && temp.data == key) {
          head = temp.getNext(); // Changed head
          return;
      }
      // Search for the key to be deleted, keep track of
      // the previous node as we need to change temp.next
      while (temp != null && temp.data != key) {
          prev = temp;
          temp = temp.getNext();
      }
      // If key was not present in linked list
      if (temp == null)
          return;
      // Unlink the node from linked list
      prev.setNext(temp.getNext());
  }
  /* Inserts a new Node at front of the list. */
  public void push(int new_data)
  {
      Node new_node = new Node(new_data);
      new_node.setNext(head);
      this.head = new_node;
  }
  /* This function prints contents of linked list starting
     from the given node */
  public void printList()
  {
      Node tnode = head;
      while (tnode != null) {
          System.out.print(tnode.data + " ");
          tnode = tnode.getNext();
      }
  }
  /* Driver program to test above functions.*/
  public static void main(String[] args) {
      LinkedList llist = new LinkedList();
      llist.push(7);
      llist.push(1);
      llist.push(3);
      llist.push(2);
      System.out.println("\nCreated Linked list is:");
      llist.printList(); // 2 3 1 7
      llist.deleteNode(1); // Delete node with data 1
      Node node = llist.getNext().getNext();
      
      System.out.println(
          "\nLinked List after Deletion of 1:");
      llist.printList(); // 2 3 7
  }
}
