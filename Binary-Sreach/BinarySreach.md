<h1 align="center">🔍 Binary Search</h1>

> ⚡ *Binary Search is a fast way to find an element in a sorted list by halving the search space at each step.*  

---

## 📘 Definition
Binary Search, also known as **half-interval search** or **logarithmic search**, is an efficient algorithm to find the position of a target element within a **sorted array**.  
It operates in **`O(log n)`** time complexity, making it far superior to linear search for large datasets.

---

## ⚙️ Basic Principles
- Based on the principle of **Divide and Conquer**.  
- At each step, the array is split into halves.  
- The algorithm decides which half to continue searching in.  

> ℹ️ **Note:** Binary Search works **only on sorted data**. Using it on unsorted data leads to wrong results.

---

## ⚡ Working Principle
1. Start with the entire sorted array.  
2. Compare the target with the **middle element**.  
3. If equal → element found.  
4. If smaller → search left half.  
5. If larger → search right half.  
6. Repeat until the element is found or the search space becomes empty.  

---

## 💻 Pseudocode
```pseudo
function binarySearch(arr, target):
    low = 0
    high = length(arr) - 1
    
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        else if arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1
```

---

## 📊 Complexity Analysis

| Case          | Time Complexity | Explanation                                  |
|---------------|-----------------|----------------------------------------------|
| **Best** ✅    | O(1)            | Target is the middle element on the first try |
| **Average** ⭐ | O(log n)        | Array size halves each step                  |
| **Worst** ❌   | O(log n)        | Target not found or at extremes              |

---

## 📚 Real Life Examples
> Imagine searching for a word in a **dictionary** 📖:  
> - You don’t check word by word.  
> - Instead, you open the book roughly in the middle.  
> - If the word is alphabetically earlier, you flip left.  
> - If later, you flip right.  
> - Repeat until found.  
> ✅ This is Binary Search in real life.

Another example is the **“Guess the Number”** game (1–100). Each time you guess the middle of the range, reducing possibilities by half.

---

## 🛠️ Working of Algorithm
Example:  
`arr = [2, 5, 8, 12, 16, 23, 38, 56, 72, 91]`  
Target = `23`

1. **low=0, high=9 → mid=4 → arr[4]=16** → 23 > 16 → search right half.  
2. **low=5, high=9 → mid=7 → arr[7]=56** → 23 < 56 → search left half.  
3. **low=5, high=6 → mid=5 → arr[5]=23** → ✅ found at index 5.  

---

## 🔄 Flowchart (ASCII)

```
Start
  |
  v
Set low = 0, high = n-1
  |
  v
Is low <= high ?
  |        \
 Yes        No
  |          \
  v           v
mid = (low + high) // 2     --->  Element not found ❌
  |
  v
Is arr[mid] == target ?
  |        \
 Yes        No
  |          \
  v           v
Return mid ✅   Is arr[mid] > target ?
                |        \
               Yes        No
                |          \
                v           v
          high = mid - 1   low = mid + 1
                |
                v
          Go back to "Is low <= high ?"
```

---

## 🌟 Features
- Works only on **sorted arrays** 📘  
- Time complexity: `O(log n)` ⭐  
- Space complexity: `O(1)`  
- Efficient for **large datasets** ✅  
- Can be implemented **iteratively** or **recursively**  
- Not a **stable algorithm** ❌  

---

## 📌 Usage
- Searching in **databases**  
- Python’s `bisect` module  
- Square root finding, rotated array problems  
- Phonebooks 📞 and dictionaries 📖  
- Debugging tools like **git bisect**  
- Game/AI optimizations 🎮  

---

## ✅ Advantages
- Much faster than linear search on large datasets  
- **Logarithmic comparisons** instead of linear  
- Easy and efficient implementation  

### 🔎 Linear vs Binary Search

| Feature              | Linear Search | Binary Search |
|-----------------------|---------------|---------------|
| Data Requirement     | Unsorted OK   | Must be sorted |
| Time Complexity      | O(n)          | O(log n)      |
| Efficiency           | Low           | High          |
| Ease of Understanding| Very Easy     | Moderate      |

---

## ❌ Disadvantages
- Requires **sorted data**  
- Sorting adds overhead for dynamic datasets  
- Slightly more complex than linear search  
- Less intuitive for beginners  
- Maintaining sorted order can be costly  

---