# 🚀 Selection Sort Algorithm

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](#)  
[![Language](https://img.shields.io/badge/language-Pseudocode-green.svg)](#)

---

## ✨ Overview

Selection Sort is a **simple and intuitive** sorting technique that repeatedly picks the **smallest element** from the unsorted part and places it at the beginning. Imagine selecting the “best candidate” step-by-step, organizing your array **one element at a time**.

---

## 🔍 How Does It Work?

The array is conceptually divided into two parts:

- 🟢 **Sorted subarray** (starts empty)
- 🔴 **Unsorted subarray** (everything else)

At each step:

1. 🔎 Find the minimum element in the unsorted subarray.
2. 🔄 Swap it with the first element of the unsorted section.
3. ➡️ Grow the sorted subarray by one and shrink the unsorted.
4. 🔁 Repeat until fully sorted!

---

## 📝 Step-by-Step Walkthrough

1. Assume the first element is the smallest.
2. Scan the rest of the array to find the real minimum.
3. Swap this minimum with the first element.
4. Move to the next element and repeat.
5. Finish when all elements are sorted.

---

## 💻 Pseudocode

```plaintext
for i in 0 to n-2:
    min_index = i
    for j in i+1 to n-1:
        if array[j] < array[min_index]:
            min_index = j
    swap(array[i], array[min_index])
```

---

## ⏳ Time Complexity

| Scenario     | Time Complexity |
|--------------|-----------------|
| Best Case    | O(n²)           |
| Average Case | O(n²)           |
| Worst Case   | O(n²)           |

> *Selection Sort always scans the unsorted array fully — no shortcuts!*

---

## 🧠 Space Complexity

- **O(1)** — sorts the array **in place** with no extra memory.

---

## ⚠️ Stability & Adaptability

| Feature       | Status                   |
|---------------|--------------------------|
| Stability     | ❌ Not Stable — equal elements may reorder |
| Adaptability  | ❌ Not Adaptive — no benefit from partially sorted arrays |

---

## 🎯 When to Use Selection Sort?

- Small arrays where **simplicity beats speed**.
- Memory-critical situations (needs **no extra space**).
- Learning purposes — a **great intro** to sorting algorithms!

---

## 👍 Pros & 👎 Cons

| 👍 Advantages                   | 👎 Disadvantages                  |
|--------------------------------|---------------------------------|
| Simple and easy to implement    | Slow for large datasets (O(n²)) |
| Requires no extra memory        | Not stable by default            |
| Performs well on very small arrays | Doesn’t adapt to existing order |

---

## 💡 Usage

Here’s a simple example in Python:

```python
def selection_sort(arr):
    n = len(arr)
    for i in range(n-1):
        min_index = i
        for j in range(i+1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]

# Example usage
numbers = [64, 25, 12, 22, 11]
selection_sort(numbers)
print("Sorted array:", numbers)
```

---

## 🤝 Contributions & Support

Feel free to contribute or request features!

---

✨ Need more examples or a visual demo? Just say the word!