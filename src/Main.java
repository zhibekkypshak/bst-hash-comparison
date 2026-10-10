import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};

        new File("results").mkdir();

        try {
            FileWriter file = new FileWriter("results/results.csv");

            file.write("structure,n,operation,time_ns\n");

            for (int n : sizes) {

                List<Integer> numbers = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    numbers.add(i);
                }

                Collections.shuffle(numbers);

                System.out.println("\nN = " + n);

                // BST
                BST bst = new BST();

                long start = System.nanoTime();

                for (int x : numbers) {
                    bst.insert(x);
                }

                long insertTime = System.nanoTime() - start;

                start = System.nanoTime();

                for (int x : numbers) {
                    bst.search(x);
                }

                long searchTime = System.nanoTime() - start;

                start = System.nanoTime();

                for (int x : numbers) {
                    bst.delete(x);
                }

                long deleteTime = System.nanoTime() - start;

                System.out.println("BST");
                System.out.println("Insert: " + insertTime + " ns");
                System.out.println("Search: " + searchTime + " ns");
                System.out.println("Delete: " + deleteTime + " ns");

                file.write("BST," + n + ",insert," + insertTime + "\n");
                file.write("BST," + n + ",search," + searchTime + "\n");
                file.write("BST," + n + ",delete," + deleteTime + "\n");


                // Hash Table
                HashTable hashTable = new HashTable(n * 2);

                start = System.nanoTime();

                for (int x : numbers) {
                    hashTable.insert(x);
                }

                insertTime = System.nanoTime() - start;

                start = System.nanoTime();

                for (int x : numbers) {
                    hashTable.search(x);
                }

                searchTime = System.nanoTime() - start;

                start = System.nanoTime();

                for (int x : numbers) {
                    hashTable.delete(x);
                }

                deleteTime = System.nanoTime() - start;

                System.out.println("Hash Table");
                System.out.println("Insert: " + insertTime + " ns");
                System.out.println("Search: " + searchTime + " ns");
                System.out.println("Delete: " + deleteTime + " ns");

                file.write("HashTable," + n + ",insert," + insertTime + "\n");
                file.write("HashTable," + n + ",search," + searchTime + "\n");
                file.write("HashTable," + n + ",delete," + deleteTime + "\n");
            }

            file.close();

            System.out.println("\nResults saved.");

        } catch (IOException e) {
            System.out.println("Could not save results.");
        }
    }
}
