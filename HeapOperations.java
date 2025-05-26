import java.util.PriorityQueue;
import java.util.Collections;

public class HeapOperations {

    public static void main(String[] args) {
        // Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(9);
        minHeap.add(3);

        System.out.println("Min-Heap: " + minHeap); // Output: [1, 3, 9, 5]
        System.out.println("Peek (Min): " + minHeap.peek()); // Output: 1
        System.out.println("Extract (Min): " + minHeap.poll()); // Output: 1
        System.out.println("Min-Heap after extract: " + minHeap); // Output: [3, 5, 9]

        // Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(9);
        maxHeap.add(3);

        System.out.println("Max-Heap: " + maxHeap); // Output: [9, 5, 3, 1]
        System.out.println("Peek (Max): " + maxHeap.peek()); // Output: 9
        System.out.println("Extract (Max): " + maxHeap.poll()); // Output: 9
        System.out.println("Max-Heap after extract: " + maxHeap); // Output: [5, 3, 1]
    }
}