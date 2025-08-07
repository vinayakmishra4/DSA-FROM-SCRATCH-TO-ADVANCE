## 🌀 Quick Sort Algorithm

---

### 📜 Description
Quick Sort is a **fast** and **efficient** sorting algorithm based on the **divide-and-conquer** principle. It works by selecting a **pivot**, partitioning the array, and then sorting the partitions recursively.  
It was developed by Tony Hoare in 1959 and is widely used because it typically outperforms other O(n log n) algorithms like Merge Sort in practice due to better cache performance.

---

### 💡 Basic Principle
> **Divide → Conquer → Combine**  
1. **Divide**: Pick a pivot and split the array into two parts.  
2. **Conquer**: Recursively sort both halves.  
3. **Combine**: Merging happens implicitly by recursion.  

Quick Sort's efficiency comes from partitioning the array such that each recursive call handles progressively smaller segments, reducing the problem size rapidly.

---

### ⚙ Working Principle
1. Choose a **pivot** (first, last, random, or median element).  
2. Move elements **smaller than pivot** to its left and **greater than pivot** to its right.  
3. Recursively repeat the process for each side until sorted.  

The choice of pivot is crucial — common strategies include choosing the first element, last element, a random element, or the median-of-three method to avoid worst-case scenarios.

---

### 🔄 Step-by-Step Example
**Array:** [10, 80, 30, 90, 40, 50, 70]  

1️⃣ **Choose Pivot** → 70  
2️⃣ **Partition** → [10, 30, 40, 50] | 70 | [80, 90]  
3️⃣ **Sort Left** → [10, 30, 40, 50]  
4️⃣ **Sort Right** → [80, 90]  
✅ **Final Output** → [10, 30, 40, 50, 70, 80, 90]  
🔍 **Observation:** This example uses the last element as the pivot for clarity, but in real implementations, randomized pivots can improve performance.

---

### 🖥 Pseudocode
```
quickSort(array, low, high):
    if low < high:
        pivot_index = partition(array, low, high)
        quickSort(array, low, pivot_index - 1)
        quickSort(array, pivot_index + 1, high)

partition(array, low, high):
    pivot = array[high]
    i = low - 1
    for j from low to high - 1:
        if array[j] <= pivot:
            i += 1
            swap array[i] with array[j]
    swap array[i + 1] with array[high]
    return i + 1
```

_Note: This implementation sorts the array in-place and uses Lomuto's partition scheme. Hoare's partition scheme is another variant that often performs fewer swaps._

---

### ⏱ Time Complexity

| Case         | Complexity |
|--------------|------------|
| **Best**     | O(n log n) |
| **Average**  | O(n log n) |
| **Worst**    | O(n²)      |

The average-case time complexity arises because each partition roughly halves the array size. The worst case happens when the pivot divides the array into highly unbalanced parts.

---

### 💾 Space Complexity
- **O(log n)** due to recursion stack (in-place sorting).  

Space usage comes mainly from the recursion stack; tail recursion optimization can help reduce memory usage in some implementations.

---

### 🎯 Use Cases
- Large datasets where average-case performance is important.  
- Competitive programming.  
- Databases and information retrieval systems for quick ordering of records.

---

### ✅ Advantages
- 🚀 Very fast in practice.  
- 📦 In-place sorting (low memory use).  
- 🧠 Excellent average-case efficiency.  
- ⚡ Performs exceptionally well on arrays that fit into CPU cache due to good locality of reference.

---

### ⚠ Disadvantages
- ❌ Not stable.  
- 🐌 Worst-case O(n²) without pivot optimization.  
- 🔀 Bad pivot choice hurts performance.  
- 📉 Sensitive to input order if pivot selection isn't randomized, leading to degraded performance.

---

![Quick Sort Partitioning Diagram](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif)
