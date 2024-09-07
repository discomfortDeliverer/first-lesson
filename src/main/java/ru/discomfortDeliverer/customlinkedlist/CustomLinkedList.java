package ru.discomfortDeliverer.customlinkedlist;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T object) {
        Node<T> node = new Node<>(object);

        if(head == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public T get(int index){
        return findNodeByIndex(index).data;
    }

    public T remove(int index) {
        Node<T> nodeToRemove = findNodeByIndex(index);

        // Удаляем head
        if(nodeToRemove.prev == null) {
            head = nodeToRemove.next;
            if(head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if(nodeToRemove.next == null) { // Удаляем tail
            tail = nodeToRemove.prev;
            tail.next = null;
        } else { // Удаляем элемент из середины
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        nodeToRemove.next = null;
        nodeToRemove.prev = null;

        size--;
        return nodeToRemove.data;
    }

    public boolean contains(T object) {
        if(size == 0) return false;

        Node<T> currentNode = head;
        int i=0;
        while (i < size){
            if (currentNode.data == null && object == null) return true;
            if(currentNode.data.equals(object)) return true;
            currentNode = currentNode.next;
            i++;
        }
        return false;
    }

    public void addAll(List<T> list) {
        for (T object : list) {
            Node<T> node = new Node<>(object);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
        }
    }

    public void addAll(CustomLinkedList<T> list) {
        tail.next = list.head;
        list.head.prev = tail;
        tail = list.tail;
    }

    private Node<T> findNodeByIndex(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        Node<T> currentNode = head;
        int i=0;
        while (i != index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

    public int size(){
        return size;
    }

    public void printList(){
        Node<T> currentNode = head;
        int i=0;
        while (currentNode != null) {
            System.out.println(i + ") " + currentNode.data);
            currentNode = currentNode.next;
            i++;
        }
    }
}
