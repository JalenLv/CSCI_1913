# CSCI 1913, Spring 2023, Lab 1
# Student Names: Qiming Lyu
# MODIFY THIS WITH YOUR NAME!
# MODIFY THIS WITH YOUR NAME!
# MODIFY THIS WITH YOUR NAME!

# TODO: INSTRUCTIONS:
# 1. Fill in your name and your partners name at the top
# 2. Look over the general structure of the file. You'll want to know this structure for future labs.
#     * At the top you will always be required to list your name, and the name of the other student you work with in
#       the lab and any other resources you wish to disclose using.
#     * Then python functions. Each of which has a "docstring" (a """string""" on it's first line(s))
#       documenting the function, often this should list at least what the function does, it's inputs, and it's outputs.
#     * Then at the end the "main" if statement -- which is used for any personal testing you want -- and can often be
#       deleted before submission.
# 3. Look over the provided main code provided at the bottom You'll want to understand what this code uses and how you
#    could use it. Don't be afraid to edit it and "play around" with it.
# 4. Fill in the two provided functions
# 5. Write a new function for kluver_cat_name You will find Kluver's cat name on slack (Don't just ask other people. The
#      whole point of this is to make sure you know your way around the important resource that is slack!)


def digits(number):
    """This function is meant to be used in a loop like so:
    for digit in digits(1031):
      print(digit)
    # prints 1 then 3 then 0 then 1
    The code is implemented with some features we won't cover in lecture. Don't worry about how it works.
    Just focus on how to use this function.
    """

    # The above is called a "docstring" -- it's a special string always placed on the first line of a function
    # Docstrings are used to document how a function works or is meant to be used. This (documentation) is an important
    # part of programming. The format and location is very important as it allows tools to automatically extract this
    # info and show it to you as you program. You can even ask python about these, see "main" for an example.

    while number > 0:
        yield number % 10
        number = number // 10


def is_valid_isbn13(isbn):
    """This function takes a number and returns True if the number is a valid ISBN13 number.
    If given a number that is not a valid ISBN 13 number it will return False."""

    # Check if the input is an integer
    if not isinstance(isbn, int):
        return False

    # Check if the input is negative and if the input is a 13-digit number
    if (isbn < 1000000000000) or (isbn > 9999999999999):
        return False

    # `cnt` will cycle between 0 and 1, which means `(1 - cnt)` will cycle between 1 and 0.
    # So that we can avoid the overhead of `if` statement.
    cnt = 0
    odd_sum = 0
    even_sum = 0
    for digit in digits(isbn):
        odd_sum += digit * (1 - cnt)
        even_sum += digit * cnt
        cnt = (cnt + 1) % 2
    total = odd_sum + 3 * even_sum
    if total % 10 != 0:
        return False

    return True


def make_isbn13(book_number):
    """Takes a 12 (or less) digit number and returns a valid isbn13 starting with those 12 digits.
    This can be used to take a book number and create an ISBN13 to store that number."""

    # Check if the input is an integer
    if not isinstance(book_number, int):
        return -1

    # Check if the input is negative and if the input is a 12-digit number
    if (book_number < 100000000000) or (book_number > 999999999999):
        return -1

    # Similar to the one in function `is_valid_isbn13()`,
    # however `cnt` now starts with 1 to compensate the offset caused by having only 12 digits.
    cnt = 1
    odd_sum = 0
    even_sum = 0
    for digit in digits(book_number):
        odd_sum += digit * (1 - cnt)
        even_sum += digit * cnt
        cnt = (cnt + 1) % 2
    subtotal = odd_sum + 3 * even_sum
    # `last_digit` should make total, which is `subtotal + last_digit`, divisible by 10.
    last_digit = (10 - (subtotal % 10)) % 10

    ISBN13 = book_number * 10 + last_digit
    return ISBN13


# TODO write a kluver_cat_name function. Don't forget to give it a docstring!
def kluver_cat_name():
    """This function returns the name of Kluver's cat as a String with no input required."""

    return "Willow"


if __name__ == "__main__":
    # The above if statement is a weird piece of python magic.
    # It's meaning translates roughly as "if we're running this file as a program" instead of "if the file is being run
    # by other files, like the autograder or test code.
    # This code _won't_ run when we test your file. So it's a good place to put any tests or scratch code of your own.

    # In this case, you will want to start by playing around with the following loop, and making sure you understand it,
    #  and how it can be used in the program you'll need to write.
    for digit in digits(10314):
        print(digit)
    # TODO: Think about what loop this creates, what values digit takes, and in which order.

    # And as an extra: an example of why docstring formatting is important!
    help(
        digits
    )  # print the docstring (if it's correctly formatted) for the digits function
    # You can use the help function with any function, but it will only be useful if the author added a good docstring!
