package listas;

/**
 *
 * @author Camilo Camargo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Queue {

    NodeGeneral head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }

    public void enqueue(NodeGeneral newNode) {
        newNode.next = head;
        head = newNode;
    }

    public NodeGeneral dequeue() {
        NodeGeneral temp = head;
        head = head.next;
        temp = null;
        return temp;
    }

    public void printStack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        NodeGeneral temp = head;
        while (temp != null) {
            bw.write(temp.toString());
            temp = temp.next;
        }
        bw.flush();

    }
    
}
