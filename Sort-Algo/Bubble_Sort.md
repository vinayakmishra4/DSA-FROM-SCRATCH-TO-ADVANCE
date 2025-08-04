# 🔄 **Bubble Sorting Algorithm** 🔄

## 📌 **Overview**
The **Bubble Sort** algorithm is a simple comparison-based sorting technique that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.

---

## 🧠 **How It Works**

Given an unsorted array, the **Bubble Sort** repeatedly compares adjacent elements and swaps them if necessary. Each pass moves the largest unsorted element to its correct position, hence the name "Bubble."

### Example:
**Input Array:**  
`[5, 2, 8, 1, 9]`

### Pass-by-Pass Breakdown:

- **Pass 1:**
  - Compare 5 and 2 → **Swap** → `[2, 5, 8, 1, 9]`
  - Compare 5 and 8 → No Swap
  - Compare 8 and 1 → **Swap** → `[2, 5, 1, 8, 9]`
  - Compare 8 and 9 → No Swap

- **Pass 2:**
  - Compare 2 and 5 → No Swap
  - Compare 5 and 1 → **Swap** → `[2, 1, 5, 8, 9]`
  - Compare 5 and 8 → No Swap

- **Pass 3:**
  - Compare 2 and 1 → **Swap** → `[1, 2, 5, 8, 9]`

At this point, the remaining elements are already sorted.

### **Final Sorted Array:**  
`[1, 2, 5, 8, 9]`

---

## 💻 **Pseudocode**

```plaintext
Procedure BubbleSort(arr, n)
    For i from 0 to n - 2 do
        For j from 0 to n - 2 - i do
            If arr[j] > arr[j + 1] then
                Swap arr[j] and arr[j + 1]
            End If
        End For
    End For
End Procedure
````

---

## ⏱️ **Time Complexity**

* **Best Case:** O(n)
  When the array is already sorted.

* **Average Case:** O(n²)
  When the array is randomly ordered.

* **Worst Case:** O(n²)
  When the array is reverse sorted.

---

## 🔄 **Pros and Cons**

### ✅ **Advantages:**

* Simple and easy to understand.
* In-place sorting (doesn’t require extra space).

### ❌ **Disadvantages:**

* Inefficient for large datasets with a time complexity of O(n²).
* Not suitable for high-performance sorting needs.

---

## 📝 **Use Cases**

Bubble Sort is typically used in scenarios where simplicity and ease of implementation are more important than performance. It’s often used in educational environments to demonstrate sorting principles.

---

## 🙏 **Thank You for Reading!** 🙏

For more algorithms and resources, feel free to check out our repository or visit the documentation.
