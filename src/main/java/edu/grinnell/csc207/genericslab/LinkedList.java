package edu.grinnell.csc207.genericslab;

public class LinkedList<T> {
    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * 
     * @param sep is the value to be added between each node
     */
    public void intersperse(T sep) {
        Node<T> curr = first;
        if (curr == null) {

        } else {
            while (curr.next != null) {
                Node<T> temp = new Node<T>(sep, curr.next);
                curr.next = temp;
                curr = temp.next;
            }
        }
    }

    /**
     * Because T can be any type, and there is no method
     * that can determine whether an object is greater than
     * or less than another object for all objects, maximum
     * can not be written.
     * 
     * @return the maximum of the list
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }

    /**
     * Because T can be any type, there is no guarantee that
     * the elements stored by the nodes can be converted to an
     * understandable String. However, all objects can be converted into
     * some type of String if they are added with the first element of the addition
     * being a string, and thus this function is still allowed. 
     * 
     * @return the String of list elements
     */
    public String toString() {
        String ret = "";
        Node<T> cur = first;
        while (cur != null) {
            ret = ret + cur.value;
            cur = cur.next;
        }
        return ret;
    }

    /**
     * Because T can be any type, and there is no method
     * that can determine whether an object is greater than
     * or less than another object for all objects, insertionSort
     * can not be written as there is way to guarantee comparisons work.
     * 
     * @return error
     */
    public String insertionSort() {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
}
