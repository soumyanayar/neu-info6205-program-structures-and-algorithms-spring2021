package Assignment_03;

public class DoubleLinkedList {
    DLinkListNode head;

    // Adds a new node with value 'value' to the head of the doubly linked list
    public void addToHead(int value) {
        DLinkListNode newNode = new DLinkListNode(value);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Adds a new node with value 'value' to the tail of the doubly linked list
    void addToTail(int value) {
        DLinkListNode newNode = new DLinkListNode(value);
        DLinkListNode last = head;
        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null)
            last = last.next;

        last.next = newNode;
        newNode.prev = last;
    }

    // Prints the nodes of the linkedlist in both forward and backward directions
    public void printList() {
        DLinkListNode tail = null;
        System.out.println("Traversal in forward Direction");
        DLinkListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            tail = current;
            current = current.next;
        }
        System.out.println("NULL");
        System.out.println("Traversal in backward Direction");
        while (tail != null) {
            System.out.print(tail.val + "->");
            tail = tail.prev;
        }
        System.out.println("NULL");
    }

    // Returns the size of the doubly linked list;
    public int size() {
        int sizeOfTheList = 0;
        DLinkListNode current = head;
        while (current != null) {
            ++sizeOfTheList;
            current = current.next;
        }
        return sizeOfTheList;
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addToHead(5);
        doubleLinkedList.addToHead(4);
        doubleLinkedList.addToHead(3);
        doubleLinkedList.addToHead(2);
        doubleLinkedList.addToHead(1);
        doubleLinkedList.printList();

        System.out.println();

        doubleLinkedList.addToTail(6);
        doubleLinkedList.addToTail(7);
        doubleLinkedList.addToTail(8);
        doubleLinkedList.addToTail(9);
        doubleLinkedList.printList();
        System.out.println("The size of the double linked list is " + doubleLinkedList.size());
    }
}
