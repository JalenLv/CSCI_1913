#
# Tests for required functions on lab 5
# Daniel Kluver 2025
#
# Each test has a comment showing what output is expected.
# Note -- the merge tests are intentionally duplicated. A common error leads in counting for this function leads to
#         results that change under repeated testing.

from sorts import *

print(insertion_sort([1, 2, 3, 4, 5]))                # 4
print(insertion_sort([5, 4, 3, 2, 1]))                # 14
print(insertion_sort([1, 5, 3, 4, 2]))                # 9
print(insertion_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4])) # 34

print(selection_sort([1, 2, 3, 4, 5]))                # 10
print(selection_sort([5, 4, 3, 2, 1]))                # 10
print(selection_sort([1, 5, 3, 4, 2]))                # 10
print(selection_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4])) # 45

print(merge_sort([1, 2, 3, 4, 5]))                    # 7
print(merge_sort([5, 4, 3, 2, 1]))                    # 5
print(merge_sort([1, 5, 3, 4, 2]))                    # 8
print(merge_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4]))     # 23

print(merge([1,2,3,4,5,6,7,8], 0, 4, 7))              # 5
print(merge([1,2,3,4,5,6,7,8], 0, 4, 7))              # 5
print(merge([9,1,5,3,6,-2], 1, 2, 4))                 # 3
print(merge([9,1,5,3,6,-2], 1, 2, 4))                 # 3
print(merge([2, 5, 6, 7, 9, 0, 1, 3, 4, 8], 0, 4, 9)) # 9
print(merge([2, 5, 6, 7, 9, 0, 1, 3, 4, 8], 0, 4, 9)) # 9
print(merge([1, 5, 6, 7, 8, 0, 2, 3, 4, 9], 0, 4, 9)) # 9
print(merge([1, 5, 6, 7, 8, 0, 2, 3, 4, 9], 0, 4, 9)) # 9

# check that all questions are answered
not_answered = '''
Replace With Answer
'''

import sorts
print(sorts.Answer1 != not_answered)                  # True
print(sorts.Answer2_insertion != not_answered)        # True
print(sorts.Answer2_selection != not_answered)        # True
print(sorts.Answer2_merge != not_answered)            # True
print(sorts.Answer3_insertion != not_answered)        # True
print(sorts.Answer3_selection != not_answered)        # True
print(sorts.Answer3_merge != not_answered)            # True
print(sorts.Answer4_insertion != not_answered)        # True
print(sorts.Answer4_selection != not_answered)        # True
print(sorts.Answer4_merge != not_answered)            # True
print(sorts.Answer6 != not_answered)                  # True
print(sorts.Answer5 != not_answered)                  # True



'''
Expected output:


4
14
9
34
10
10
10
45
7
5
8
23
5
5
3
3
9
9
9
9
True
True
True
True
True
True
True
True
True
True
True
True


'''
