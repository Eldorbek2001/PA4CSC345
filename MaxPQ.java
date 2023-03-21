public class MaxPQ {
    private Patient[] pq; 
    private int size; 
    private int capacity; 
    

    public MaxPQ() {
        this(10);
    }
    

    public MaxPQ(int cap) {
        pq = new Patient[cap];
        size = 0;
        capacity = cap;
    }
    

    public void insert(Patient item) {
        if (size == capacity - 1) {
            resize(2 * capacity);
        }
        pq[++size] = item;
        swim(size); // re-heapify
    }
    
    public Patient delMax() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Patient max = pq[1];
        swap(1, size--);
        sink(1); 
        if (size > 0 && size <= capacity / 4 && capacity / 2 >= 10) {
            resize(capacity / 2);
        }
        return max;
    }
    
    public Patient getMax() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return pq[1];
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    private void swap(int i, int j) {
        Patient temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
    private void resize(int newCapacity) {
        Patient[] temp = new Patient[newCapacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
        capacity = newCapacity;
    }
    
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && pq[j].compareTo(pq[j + 1]) < 0) j++;
            if (pq[k].compareTo(pq[j]) >= 0) break;
            swap(k, j);
            k = j;
        }
    }
    
    private void swim(int k) {
        while (k > 1 && pq[k].compareTo(pq[k / 2]) > 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }
}