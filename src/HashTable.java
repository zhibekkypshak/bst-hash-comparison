import java.util.LinkedList;

public class HashTable {

    private final LinkedList<Integer>[] table;
    private final int size;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }

    public void insert(int key) {
        int index = hash(key);

        if (!table[index].contains(key)) {
            table[index].add(key);
        }
    }

    public boolean search(int key) {
        int index = hash(key);

        return table[index].contains(key);
    }

    public void delete(int key) {
        int index = hash(key);

        table[index].remove(Integer.valueOf(key));
    }
}