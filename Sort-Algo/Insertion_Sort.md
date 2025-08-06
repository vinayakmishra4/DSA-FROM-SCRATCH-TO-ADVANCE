## 🧠 Insertion Sort Algorithm

### ⏱️ Time Complexity:

* **Best Case:** `O(n)` – when the array is already sorted
* **Average Case:** `O(n²)`
* **Worst Case:** `O(n²)` – when the array is sorted in reverse

### 🧮 Space Complexity:

* **O(1)** – In-place sorting (no extra space required)

### ✅ Properties:

* **Stable:** Yes
* **Adaptive:** Yes (performs better on nearly sorted data)

---

### 🛠️ Working Principle:

Insertion Sort builds the final sorted array one element at a time — similar to sorting playing cards in your hand:

1. Start with the second element.
2. Compare it with the previous elements in the sorted portion.
3. Shift larger elements one position to the right.
4. Insert the element in its correct sorted position.

---

### 📜 Pseudocode:

```plaintext
for i from 1 to n - 1:
    key = array[i]
    j = i - 1
    while j >= 0 and array[j] > key:
        array[j + 1] = array[j]
        j = j - 1
    array[j + 1] = key
```

---

### 📦 Use Cases:

* Small datasets
* Nearly sorted arrays
* Real-time systems where simplicity and stability are important

---

If you need a visual explanation or Python implementation, feel free to ask!
