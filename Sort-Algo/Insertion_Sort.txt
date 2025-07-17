Insertion Sort Algorithm

Time Complexity:
Best Case: O(n) – when array is already sorted
Average Case: O(n^2)
Worst Case: O(n^2)

Space Complexity: O(1) – In-place sorting

Stable: ✅
Adaptive: ✅

Working Principle:
- Builds the final sorted array one item at a time.
- Like sorting playing cards in your hands.

Steps:
1. Assume the first element is sorted.
2. Pick the next element and compare it with the sorted part.
3. Shift elements of the sorted part to the right to make space.
4. Insert the current element in the correct position.

Pseudocode:
```
for i from 1 to n - 1:
    key = array[i]
    j = i - 1
    while j >= 0 and array[j] > key:
        array[j + 1] = array[j]
        j = j - 1
    array[j + 1] = key
```

Use Case:
- Efficient for small data sets and nearly sorted arrays.
