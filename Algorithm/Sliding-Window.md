## 📌 What is Sliding Window?

The **Sliding Window Algorithm** is an optimization technique used to efficiently process a **range of contiguous elements** in arrays or strings.

Instead of recalculating results for every window from scratch, it:

* Maintains a **window**
* **Slides** it forward
* Updates results using previous computations

---

## 🧠 Intuition

Think of a **window of size `k`** moving across the array:

```
[2, 1, 5, 1, 3, 2]
 └───┘
    └───┘
       └───┘
          └───┘
```

👉 Instead of recomputing each window:

* Remove left element ❌
* Add right element ✅

---

## 🧾 Example

### 🔍 Problem

Find the **maximum sum of a subarray of size `k`**

**Input**

```
Array = [2, 1, 5, 1, 3, 2]
k = 3
```

### ⚙️ Execution

| Window    | Operation | Sum |
| --------- | --------- | --- |
| [2, 1, 5] | Initial   | 8   |
| [1, 5, 1] | -2 +1     | 7   |
| [5, 1, 3] | -1 +3     | 9   |
| [1, 3, 2] | -5 +2     | 6   |

### ✅ Output

```
Maximum Sum = 9
```

---

## 🎯 Use Cases

### 📦 Fixed Window Size

* Maximum/Minimum sum of subarray
* Average of subarrays
* Count of valid windows

### 🔄 Variable Window Size

* Longest substring without repeating characters
* Smallest subarray with given sum
* Longest substring with `k` unique characters

### 🔤 String Problems

* Anagram detection
* Pattern matching
* Frequency-based problems

---

## ⚙️ Core Features

* ✅ Works on **contiguous data**
* ✅ Uses **two pointers**
* ✅ Eliminates nested loops
* ✅ Improves complexity → **O(n)**
* ✅ Memory efficient

---

## 🧩 Types of Sliding Window

### 1️⃣ Fixed Size Window

Window size remains constant

**Flow:**

1. Build initial window
2. Slide window
3. Update result

---

### 2️⃣ Variable Size Window

Window expands and shrinks dynamically

**Flow:**

1. Expand using `right`
2. Shrink using `left`
3. Maintain condition
4. Update result

---

## 🧮 Algorithm

### 🔹 Fixed Window Approach

1. Initialize sum of first `k` elements
2. Slide window one step at a time
3. Update sum:

   * Add new element
   * Remove old element
4. Track max/min

---

### 🔹 Variable Window Approach

1. Initialize `left = 0`
2. Iterate `right` pointer
3. Expand window
4. Shrink when condition fails
5. Update answer

---

## 💻 Pseudocode

### 🟦 Fixed Window

```id="fixed-window"
function maxSum(arr, k):
    window_sum = 0
    max_sum = 0

    for i = 0 to k-1:
        window_sum += arr[i]

    max_sum = window_sum

    for i = k to n-1:
        window_sum += arr[i]
        window_sum -= arr[i-k]
        max_sum = max(max_sum, window_sum)

    return max_sum
```

---

### 🟩 Variable Window

```id="variable-window"
function slidingWindow(arr):
    left = 0
    result = 0

    for right = 0 to n-1:
        include arr[right]

        while condition not satisfied:
            remove arr[left]
            left += 1

        update result

    return result
```

---

## ⚖️ Complexity Analysis

| Approach       | Time Complexity | Space Complexity |
| -------------- | --------------- | ---------------- |
| Brute Force    | O(n²) / O(n*k)  | O(1)             |
| Sliding Window | O(n)            | O(1)             |

---

## ✅ Advantages

* 🚀 Reduces time complexity
* 🔁 Avoids redundant calculations
* 📈 Efficient for large inputs
* 🧩 Easy for fixed-size problems
* 🧠 Common in interviews

---

## ❌ Disadvantages

* ⚠️ Only works on contiguous data
* 🧠 Variable window logic can be tricky
* ❌ Not applicable to all problems
* ⚙️ Requires careful condition handling

---

## 🧠 When to Use?

Use Sliding Window when:

* Problem involves **subarrays / substrings**
* You see keywords like:

  * "maximum/minimum subarray"
  * "longest/shortest substring"
  * "contiguous segment"
* Brute force involves nested loops

---

## 🏁 Summary

The **Sliding Window Algorithm** is a powerful optimization technique that:

* Converts **nested loops → single loop**
* Works best on **continuous data**
* Is essential for **coding interviews and competitive programming**

---

✨ *Master this technique, and a huge class of problems becomes easy!*
