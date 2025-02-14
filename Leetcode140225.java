//https://leetcode.com/problems/product-of-the-last-k-numbers/?envType=daily-question&envId=2025-02-14
import java.util.*;

class ProductOfNumbers {
    private List<Integer> products;
    private int lastZeroIndex;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1); // Initial dummy value to simplify multiplication logic
        lastZeroIndex = -1; // Tracks last zero position
    }
    
    public void add(int num) {
        if (num == 0) {
            products.clear();
            products.add(1); // Reset to 1 for easier calculations
            lastZeroIndex = products.size() - 1; // Store last zero position
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = products.size();
        if (k >= size) {
            return 0; // If k exceeds valid range, return 0
        }
        if (lastZeroIndex >= size - k) {
            return 0; // If a zero is within last 'k' elements, product is 0
        }
        return products.get(size - 1) / products.get(size - 1 - k);
    }
}
