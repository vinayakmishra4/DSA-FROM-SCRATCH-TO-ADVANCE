# Selection Sort Algorithm

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](#)
[![Language](https://img.shields.io/badge/language-Pseudocode-green.svg)](#)

---

## Overview

Selection Sort is a simple and intuitive sorting technique that works by repeatedly finding the smallest element in the unsorted portion of the list and placing it at the start. Think of it as selecting the “best candidate” step-by-step and organizing your array one element at a time.

---

## How Does It Work?

The array is split conceptually into two parts:

- **Sorted subarray** (starts empty)
- **Unsorted subarray** (everything else)

At each step:

1. Find the minimum element in the unsorted subarray.
2. Swap it with the first element of that unsorted section.
3. Grow the sorted subarray by one, shrink the unsorted subarray.
4. Repeat until fully sorted!

---

## Step-by-Step Walkthrough

1. Assume the first element is the smallest.
2. Scan the rest of the array to find the real minimum.
3. Swap this minimum with the first element.
4. Move to the next element and repeat.
5. Finish when all elements are sorted.

---

## Pseudocode

```plaintext
for i in 0 to n-2:
    min_index = i
    for j in i+1 to n-1:
        if array[j] < array[min_index]:
            min_index = j
    swap(array[i], array[min_index])
```

---

## Time Complexity

| Scenario     | Time Complexity |
|--------------|-----------------|
| Best Case    | O(n²)           |
| Average Case | O(n²)           |
| Worst Case   | O(n²)           |

*Selection Sort always scans the unsorted array fully — no shortcuts!*

---

## Space Complexity

- **O(1)** — sorts the array in place without needing extra memory.

---

## Stability & Adaptability

- ❌ **Not Stable:** Equal elements may get reordered.
- ❌ **Not Adaptive:** Doesn’t take advantage if the array is already sorted or nearly sorted.

---

## When to Use Selection Sort?

- Small arrays where simplicity beats speed.
- Memory-critical situations (because it needs no extra space).
- Learning purposes—it’s a great intro to sorting algorithms!

---

## Pros & Cons

| Advantages                 | Disadvantages                  |
|----------------------------|-------------------------------|
| Simple and easy to implement | Slow for large datasets (O(n²)) |
| Requires no extra memory     | Not stable by default          |
| Performs well on very small arrays | Doesn’t adapt to existing order |

---

## Usage

*Include example usage or instructions here.*

---

## Contributions & Support

Feel free to contribute or request features!

---

🚀 Need sample code or a visual demo? Just say the word!