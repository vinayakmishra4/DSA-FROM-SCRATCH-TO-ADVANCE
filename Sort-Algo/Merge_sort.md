# 🔀 Merge Sort Algorithm 🔀

## ⏱️ Time Complexity
- Best Case: O(n log n) – even when the array is already sorted.
- Average Case: O(n log n)
- Worst Case: O(n log n)

## 🧠 Space Complexity
- O(n) – extra space required for the merge process.

**Stable:** ✅  
**Adaptive:** ❌

## ⚙️ Working Principle
- Merge Sort is a *divide-and-conquer* algorithm that breaks the problem into smaller subproblems.
- It recursively divides the array into halves, sorts each half, and then merges the sorted halves back together.

## 🪜 Steps
1. **Divide**: Split the array into two halves.
2. **Recursively Sort**: Recursively sort each half.
3. **Merge**: Merge the two sorted halves to produce a single sorted array.

## 🧾 Pseudocode
```python
mergeSort(array, left, right):
    if left < right:
        mid = (left + right) / 2
        mergeSort(array, left, mid)       # Sort left half
        mergeSort(array, mid + 1, right)  # Sort right half
        merge(array, left, mid, right)    # Merge the two halves

merge(array, left, mid, right):
    create a temporary array
    i = left, j = mid + 1, k = 0
    while i <= mid and j <= right:
        if array[i] <= array[j]:
            temp[k] = array[i]
            i++
        else:
            temp[k] = array[j]
            j++
        k++

    # Copy remaining elements
    while i <= mid:
        temp[k] = array[i]
        i++
        k++
    while j <= right:
        temp[k] = array[j]
        j++
        k++

    # Copy the sorted temp array back into the original array
    for i = 0 to k-1:
        array[left + i] = temp[i]
```

## 📌 Use Case
- Merge Sort is efficient for large datasets and when **stability** is required.
- However, it requires additional space, so it's not as space-efficient as **in-place** sorting algorithms (like **Quick Sort** or **Insertion Sort**).
- It's often used in **external sorting** when data cannot fit in memory because it handles sorting in chunks efficiently.
- Merge Sort is efficient for large datasets and when **stability** is required.
- However, it requires additional space, so it's not as space-efficient as **in-place** sorting algorithms (like **Quick Sort** or **Insertion Sort**).
- It's often used in **external sorting** when data cannot fit in memory because it handles sorting in chunks efficiently.