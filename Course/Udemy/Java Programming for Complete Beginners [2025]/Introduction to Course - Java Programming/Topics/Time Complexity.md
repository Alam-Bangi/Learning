> **"Time complexity is a way to measure how the running time of an algorithm grows as the input size increases. Instead of measuring the actual time in seconds, which depends on the computer, we measure how the number of operations changes with the input size using Big O notation."**

Then explain **why it matters**:

> **"It helps us compare different algorithms and choose one that scales better for large inputs."**

### Example 1: Linear Search – O(n)

Suppose you have an array:

```text
[10, 20, 30, 40, 50]
```

If you're searching for `50`, you may have to check every element.

```text
n = 5 → up to 5 comparisons
n = 100 → up to 100 comparisons
n = 1,000,000 → up to 1,000,000 comparisons
```

So the work grows **linearly** with the input size.

> **Time Complexity = O(n)**

---

### Example 2: Binary Search – O(log n)

Binary search works on a sorted array.

Instead of checking every element, it repeatedly cuts the search space in half.

```text
1,000 elements → about 10 steps
1,000,000 elements → about 20 steps
```

Even though the input grows a lot, the number of steps increases very slowly.

> **Time Complexity = O(log n)**

---

### Explain Big O in one sentence

> **"Big O notation describes the worst-case growth rate of an algorithm as the input size increases."**

---

### Common Time Complexities

| Complexity | Meaning           | Example                     |
| ---------- | ----------------- | --------------------------- |
| O(1)       | Constant time     | Access an array element     |
| O(log n)   | Logarithmic       | Binary Search               |
| O(n)       | Linear            | Linear Search               |
| O(n log n) | Efficient sorting | Merge Sort, Heap Sort       |
| O(n²)      | Nested loops      | Bubble Sort                 |
| O(2ⁿ)      | Exponential       | Recursive subset generation |

---

### Interview Answer (1-minute version)

> **"Time complexity tells us how the running time of an algorithm grows as the input size increases. Instead of measuring time in seconds, we use Big O notation to estimate the number of operations. For example, in linear search, we may need to check every element, so the time complexity is O(n). In binary search, we eliminate half the search space at each step, so the complexity is O(log n). Time complexity helps us compare algorithms and choose the one that performs better for large datasets."**

This explanation is concise, technically accurate, and appropriate for interviews at companies ranging from startups to major tech firms.
