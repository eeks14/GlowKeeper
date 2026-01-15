package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author deekshyarai
 */
public class Queue {
    private String items[];
    private int front, rear, capacity;

    public Queue(int size) {
        capacity = size;
        items = new String[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

   public void enQueue(String element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear++;
            items[rear] = element;
        }
    }

    public String deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            String element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            return element;
        }
    }
    
    public List<String> getAllElements() {
        List<String> elements = new ArrayList<>();
        if (isEmpty()) {
            return elements;
        }
        for (int i = front; i <= rear; i++) {
            elements.add(items[i]);
        }
        return elements;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

