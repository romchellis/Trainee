package ex.training;

public class MyIntArray {
    private static final int MINIMUM_CAPACITY = 20;

    private int capacity;
    private int size;
    private int[] data;

    MyIntArray() {
        this(0, 0);
    }

    MyIntArray(int size) {
        this(size, 0);
    }

    MyIntArray(int size, int defaultValue) {
        capacity = Math.max(size, MINIMUM_CAPACITY);
        this.size = capacity;
        data = new int[capacity];

        for (int i = 0; i < size; i++) {
            data[i] = defaultValue;
        }
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int val) {
        data[i] = val;
    }

    /**
     * Push new element in the end of array
     *
     * @param value value that will be pushed
     */
    public void pushBack(int value) {
        if (size == capacity) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    /**
     * Remove last element from array
     */
    void popBack() {
        if (size < 0) {
            return;
        }
        if (capacity / 4 >= size && capacity / 2 > MINIMUM_CAPACITY) {
            decreaseCapacity();
        }
        --size;
    }

    /**
     * Get array size
     *
     * @return size
     */
    int getSize() {
        return size;
    }

    /**
     * Get current capacity
     *
     * @return capacity
     */
    int getCapacity() {
        return capacity;
    }

    /**
     * Double capacity
     */
    void increaseCapacity() {
        capacity *= 2;
        reallocateArray();
    }

    /**
     * Half capacity
     * <p>
     * Capacity should be at least 2 * MINIMUM_CAPACITY
     */
    void decreaseCapacity() {
        capacity /= 2;
        reallocateArray();
    }

    /**
     * Allocate new array with capacity size and delete old
     * <p>
     * Sould be called only when capacity changed
     * <p>
     * Capacity must be valid
     */
    void reallocateArray() {
        int[] newData = new int[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
