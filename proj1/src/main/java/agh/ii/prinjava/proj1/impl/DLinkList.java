package agh.ii.prinjava.proj1.impl;


/**
 * A collection derived from interface List<E>. It's an implementation of list using doubly linked elements :
 * <ul>
 *     <li>Each element points to the next</li>
 *     <li>Each element also points to the previous</li>
 * </ul>
 * Therefore, even tough it seems to use more space than a simple list, the cost for operations in the list is reduced.<br>
 * Here, each node contains a data part that stores actual data and a second part that stores pointer to the next
 * or previous node in the list.
 * @param <E> the type of Object contained in the Doubly Linked List.
 */
public class DLinkList<E> {
    // ...
    private Node<E> firstOfList = null; // points to the first Element of the List

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        public Node(T elem, Node<T> next, Node<T> prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Add a given Node at the beginning of the Doubly Linked List.<br>
     * We place the new Node just before the head of the list and set a previous node to the old head of the list.
     * Thus, the old head of the list is not the first one anymore.<br><br>
     * @param elem the Node that will be added at the first position of the list.
     */
    public void addFirst(E elem) {
        if (firstOfList == null) {
            firstOfList = new Node<>(elem, null, null);
        }
        else {
            Node<E> node = new Node<>(elem, firstOfList, null);
            firstOfList.prev = node;
            firstOfList = node;
        }
    }

    /**
     * Add a given Node to the end of the Doubly Linked List.<br>
     * We set the information of the new Last node, after what we can define the Node given as the last of the List.<br><br>
     * @param elem the Node that will be added at the last position of the list.
     */
    public void addLast(E elem) {
        if (firstOfList == null) {
            firstOfList = new Node<>(elem, null, null);
        }
        else {
            Node<E> node = firstOfList;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(elem, null, node);
        }
    }

    /**
     * Removes the first element of the Doubly Linked List and set the second element as the new first one.<br><br>
     * @return the element which was at the first position in the list.
     */
    public E removeFirst() {
        if (firstOfList != null) {
            if (firstOfList.next == null) {
                E elem = firstOfList.elem;
                firstOfList = null;
                return elem;
            }
            Node<E> node = firstOfList;
            firstOfList = firstOfList.next;
            firstOfList.prev = null;
            return node.elem;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("List is empty...");
        }
    }

    /**
     * Removes the last element in the Doubly Linked List and set the penultimate element as the new last one.<br><br>
     * @return the element which was at the last position in the list.
     */
    public E removeLast() {
        if (firstOfList != null) {
            Node<E> node = firstOfList;
            Node<E> previousNode = firstOfList;
            while (node.next != null) {
                previousNode = node;
                node = node.next;
            }
            if (firstOfList == node) {
                E elem = firstOfList.elem;
                firstOfList = null;
                return elem;
            }
            previousNode.next = null;
            return node.elem;
        }
        else {
            throw new ArrayIndexOutOfBoundsException("List is empty...");
        }
    }


    /**
     * Search for the element at a given position. The element is returned without being deleted.
     * The function act as a spectator, it just looks for element.<br><br>
     * @param index the position in the list where we need to retrieve the element.
     * @return the element looked for.
     */
    public E peek(int index) {
        // If the index given is smaller than the size of the list we need to throw an Exception.
        if (getSize() < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            Node<E> node = firstOfList;
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            return node.elem;
        }
    }

    /**
     * Function that goes throughout the entire list and count the number of elements it possesses.<br><br>
     * @return the size of the list.
     */
    public int getSize() {
        int counter = 0;
        Node<E> node = firstOfList;
        while (node.next != null) {
            counter++;
            node = node.next;
        }
        return ++counter;
    }

    /**
     * Prints the element that composes the list. The function prints the element in the same order that they are
     * in the list.<br><br>
     * @return the String that needs to be printed.
     */
    @Override
    public String toString() {
        Node<E> indexNode = firstOfList;
        // StringBuilder is more safe to use inside a While loop
        // Instead of using sum with += we just append at the end of the string.
        StringBuilder s = new StringBuilder("null");
        while (indexNode != null) {
            s.append("-->").append(indexNode.elem);
            indexNode = indexNode.next;
        }

        s.append("--> null");
        return s.toString();
    }
}
