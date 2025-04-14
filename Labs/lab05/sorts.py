# Lab 5, list partners here!
# Qiming Lyu


# LAB5 has a substantial written Q&A component as well. You answer these questions by updating the
# multi-line strings below to indicate your answer. It's a bit hokey, but it works.

# Question 1: Which image file you submitted covers which analysis case?
Answer1 = """
image names are clear
"""

# Question 2: For each algorithm, explain how you see it behaving in your images.
# If the algorithm's behavior differed case-by-case say this and explain how it behaved in each case.

Answer2_insertion = """
Insertion sort does even better than merge sort when the list is already sorted or is near sorted.
It has similar performance to selection sort when the list is backwards.
The performance of insertion sort when the list is random is between selection sort and merge sort.
"""

Answer2_selection = """
Selection sort does the worst whatever the list is.
"""

Answer2_merge = """
Merge sort does the best whatever the list is.
"""


# Question 3: For each algorithm, What is the theoretical expectation. I.E. what is the expected big-O runtime behavior.
# If the algorithm's expected behavior differs case-by-case say this and explain how it is
# expected to behave case-by-case. (You should be able to find this information in the textbook.
# If not we will discuss this in class)

Answer3_insertion = """
Insertion sort has a time complexity of O(n^2) in the worst case, O(n) in the best case, and O(n^2) in the average case.
"""

Answer3_selection = """
Selection sort has a time complexity of O(n^2) in the worst case, O(n^2) in the best case, and O(n^2) in the average case.
"""

Answer3_merge = """
Merge sort has a time complexity of O(n log n) in the worst case, O(n log n) in the best case, and O(n log n) in the average case.
"""


# Question 4: For each algorithm, How did the observed behavior match the theoretical behavior? Again, if your answer
# differs case by case, say that here and explain your findings for each case.

Answer4_insertion = """
Insertion sort does even better than merge sort when the list is already sorted or is near sorted.
It is of medium performance when the list is random.
"""

Answer4_selection = """
Selection sort does the worst whatever the list is.
"""

Answer4_merge = """
Merge sort does the best whatever the list is.
"""


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = """
Yes. When the list is already sorted or is near sorted, insertion sort is faster than merge sort.
"""


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = """
Merge sort.
"""


# Selection, Insertion, and Merge sorts -- taken from ZyBooks.
# Not too different, its still the same algorithm, they just did it using less memory than I did
# (Which leads to a slightly harder to understand piece of code)


def selection_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    cnt = 0

    for i in range(len(numbers) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(numbers)):
            cnt += 1
            if numbers[j] < numbers[index_smallest]:
                index_smallest = j

        # Swap numbers[i] and numbers[index_smallest]
        temp = numbers[i]
        numbers[i] = numbers[index_smallest]
        numbers[index_smallest] = temp

    return cnt


def insertion_sort(numbers):
    """Sort the list numbers in-place. (Note, this doesn't have to be numbers)"""
    cnt = 0

    for i in range(1, len(numbers)):
        j = i
        # Insert numbers[i] into sorted part
        # stopping once numbers[i] in correct position
        # KLUVER NOTE - PLEASE READ - so this line is a bit tricky. Technically, if j > 0 then numbers would not be compared
        #               to make things easier you can assume that every time the list condition is checked one array element
        #               comparison occurs. That is -- you can ignore the short-circuit evaluatio of the logical and in this
        #               counting problem.
        cnt += 1

        while j > 0 and numbers[j] < numbers[j - 1]:
            cnt += 1

            # Swap numbers[j] and numbers[j - 1]
            temp = numbers[j]
            numbers[j] = numbers[j - 1]
            numbers[j - 1] = temp
            j = j - 1

    return cnt


def merge(numbers, i, j, k):
    """Given two sorted sub-lists create one sorted list. This is done in-place, meaning we are given one list
    and expected to modify the list to be sorted. Furthermore, this operates on "sub-lists" (a specific range of the list)
    The list named numbers may contain other types of data than just numbers
    the variables i, j, and k are all indices into the numbers list
    So so the part of the list to be sorted is from position i to k (inclusive) with i to j being one sorted list, and j+1 to k being another.
    """
    merged_size = k - i + 1  #  Size of merged partition
    merged_numbers = []  #  Temporary list for merged numbers
    for l in range(merged_size):
        merged_numbers.append(0)

    merge_pos = 0  #  Position to insert merged number

    left_pos = i  #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    cnt = 0

    #  Add smallest element from left or right partition to merged numbers
    while left_pos <= j and right_pos <= k:
        cnt += 1

        if numbers[left_pos] < numbers[right_pos]:
            merged_numbers[merge_pos] = numbers[left_pos]
            left_pos = left_pos + 1
        else:
            merged_numbers[merge_pos] = numbers[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged numbers
    while left_pos <= j:
        merged_numbers[merge_pos] = numbers[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged numbers
    while right_pos <= k:
        merged_numbers[merge_pos] = numbers[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge number back to numbers
    merge_pos = 0
    while merge_pos < merged_size:
        numbers[i + merge_pos] = merged_numbers[merge_pos]
        merge_pos = merge_pos + 1

    return cnt


def merge_sort_recursive(numbers, i, k):
    """Sort the sub-list in numbers
    from position i to k (inclusive)"""
    cnt = 0

    if i < k:
        j = (i + k) // 2  #  Find the midpoint in the partition

        #  Recursively sort left and right partitions
        # KLUVER NOTE - PLEASE READ - you should think about these two function calls as returning a count of
        #     comparisons. Naturally the comparisons done by those function-calls will count against this function-call.
        #     make sure you're not ignoring the return values on the following two lines.
        cnt += merge_sort_recursive(numbers, i, j)
        cnt += merge_sort_recursive(numbers, j + 1, k)

        #  Merge left and right partition in sorted order
        cnt += merge(numbers, i, j, k)

    return cnt


def merge_sort(numbers):
    """Sort a list of numbers
    This function is added on-top of the textbook's code to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts.
    """
    return merge_sort_recursive(numbers, 0, len(numbers) - 1)
