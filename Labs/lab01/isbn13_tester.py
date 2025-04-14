# If you can get this file to run and produce the correct output,
# then you shouldn't have much trouble with the autograder (With the possible exception of the third required
# function -- that one isn't tested here!)

# You should be able to run this file as-is (without any modifications) by putting it in the same folder
# as the file `isbn13.py` that you wrote for lab01

print("Starting Tests")

# This is an import statement -- it runs the file "isbn13.py" and then
#   extracts anything named globally in that file (functions, variables, etc.)
#   and makes them available in this file.
from isbn13 import *

print(is_valid_isbn13(-1))  # False

# Testing a whole run to make sure ALL of them are false -- no matter how the math is done.
print(is_valid_isbn13(-9780306406150))  # False
print(is_valid_isbn13(-9780306406151))  # False
print(is_valid_isbn13(-9780306406152))  # False
print(is_valid_isbn13(-9780306406153))  # False
print(is_valid_isbn13(-9780306406154))  # False
print(is_valid_isbn13(-9780306406155))  # False
print(is_valid_isbn13(-9780306406156))  # False
print(is_valid_isbn13(-9780306406157))  # False
print(is_valid_isbn13(-9780306406158))  # False
print(is_valid_isbn13(-9780306406159))  # False

print(is_valid_isbn13(97803064061507))  # False

print(is_valid_isbn13(978030640615007))  # False

print(is_valid_isbn13(9783161484100))  # True

print(is_valid_isbn13(9781402894626))  # True

print(is_valid_isbn13(9790194234237))  # True

print(is_valid_isbn13(9791923759236))  # True

print(is_valid_isbn13(9783361484100))  # False

print(is_valid_isbn13(9784102894626))  # False

print(is_valid_isbn13(9790194234230))  # False

print(is_valid_isbn13(7))  # False

print(make_isbn13(0))  # -1
print(make_isbn13(4))  # -1
print(make_isbn13(978316148410))  # 9783161484100
print(make_isbn13(97814028946268))  # -1
print(make_isbn13(978030640615))  # 9780306406157


"""

Expected output:

Starting Tests
False
False
False
False
False
False
False
False
False
False
False
False
False
True
True
True
True
False
False
False
False
-1
-1
9783161484100
-1
9780306406157


"""
