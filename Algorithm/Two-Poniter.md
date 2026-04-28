
# 🚀 Two Pointer Approach

> A powerful and efficient technique to solve array and string problems with optimal performance.

---

## 📖 What is the Two Pointer Approach?

The **Two Pointer Approach** is an algorithmic strategy where **two indices (pointers)** traverse a data structure (typically an array or string) to solve problems efficiently.

🔁 These pointers can:
- Move **toward each other** (e.g., start ↔ end)
- Move in the **same direction** (e.g., slow & fast pointers)

✨ Best suited for:
- Sorted arrays
- Pair-based problems
- Linear-time optimizations

---

## 🧠 Core Idea

```text
Start → ← End
  ↑       ↑
 left   right
````

* Initialize two pointers
* Evaluate a condition
* Move pointers strategically
* Stop when condition is met or pointers cross

---

## ⚙️ Step-by-Step Algorithm

1. 🔹 Initialize pointers:

   * `left = 0`
   * `right = n - 1` *(or both at start depending on problem)*

2. 🔹 Process condition:

   * Example: `arr[left] + arr[right]`

3. 🔹 Adjust pointers:

   * If result is too small → move `left++`
   * If result is too large → move `right--`

4. 🔹 Repeat until:

   * Condition is satisfied ✅
   * Or pointers cross ❌

---

## 💻 Pseudocode

```pseudo
function twoPointer(arr, target):
    left = 0
    right = length(arr) - 1

    while left < right:
        current = arr[left] + arr[right]

        if current == target:
            return (left, right)

        else if current < target:
            left = left + 1

        else:
            right = right - 1

    return -1
```

---

## ⚡ Complexity

| Type     | Complexity |
| -------- | ---------- |
| ⏱ Time   | O(n)       |
| 🧠 Space | O(1)       |

---

## ✅ Advantages

✔️ Improves performance (O(n²) → **O(n)**)
✔️ Easy to implement and understand
✔️ Memory efficient (no extra space needed)
✔️ Ideal for **sorted data**

---

## ❌ Disadvantages

❗ Requires sorted input in most cases
❗ Not suitable for all problem types
❗ Can be tricky in complex variations
❗ Less flexible than hashing techniques

---

## 🧩 Common Problem Patterns

| Problem Type           | Example Use          |
| ---------------------- | -------------------- |
| 🔢 Pair Sum            | Two numbers = target |
| 🔁 Palindrome Check    | Compare characters   |
| 🚰 Container Problem   | Max water area       |
| 🔄 Remove Duplicates   | Sorted arrays        |
| 🔗 Merge Sorted Arrays | Two inputs           |

---

## 🛠 Variations

### 1. Opposite Direction

* Left at start, right at end
* Used in **pair sum, container problems**

### 2. Same Direction (Fast & Slow)

* Both pointers move forward
* Used in:

  * Cycle detection
  * Removing duplicates

---

## 🎯 Pro Tips

💡 Always check if the array is **sorted**
💡 Try visualizing pointer movement
💡 Use dry runs to understand transitions
💡 Combine with other techniques if needed

---

## 📌 Example Visualization

```text
Array: [1, 2, 3, 4, 6]
Target: 6

Step 1: 1 + 6 = 7 → too big → move right ←
Step 2: 1 + 4 = 5 → too small → move left →
Step 3: 2 + 4 = 6 ✅ Found!
```

---

## 🚀 Ready to Practice?

Try implementing:

* 🔹 Two Sum (sorted array)
* 🔹 Valid Palindrome
* 🔹 Container With Most Water

---