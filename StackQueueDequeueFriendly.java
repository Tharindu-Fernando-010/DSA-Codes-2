/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackqueue.dequeue.friendly;

import java.util.Stack;

public class StackQueueDequeueFriendly {
    private Stack<Integer> mainStack;
    private Stack<Integer> tempStack;

    public StackQueueDequeueFriendly() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }

    // Enqueue operation (costly)
    public void enqueue(int data) {
        while (!mainStack.isEmpty()) {
            tempStack.push(mainStack.pop());
        }

        mainStack.push(data);

        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
    }

    // Dequeue operation (O(1))
    public int dequeue() {
        if (mainStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return mainStack.pop();
    }

    public static void main(String[] args) {
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}

