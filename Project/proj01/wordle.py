import words
from random import choice
import display_utility as du

"""
- `secret`: a string, the secret word. All characters are uppercase. The length of the secret word is 5.
- `guess`: a string, the guessed word. All characters are uppercase. The length of the guess word is 5.
- `clues`: a list of tuples, with each tuple being a guess and the clues given by `check_word`.
"""


def check_word(secret, guess):
    """
    The `check_word` function takes a word and generates the output clue. The clue is a length-5 list containing the strings "grey", "yellow", and "green".
    """
    # What's not being marker as green or yellow is grey.
    clue = ["grey" for _ in range(5)]
    matched = [False for _ in range(5)]

    # Check for green letters
    for i in range(5):
        if secret[i] == guess[i]:
            clue[i] = "green"
            matched[i] = True

    # Check for yellow letters
    for i in range(5):
        for j in range(5):
            if guess[i] == secret[j] and not matched[j] and clue[i] != "green":
                clue[i] = "yellow"
                matched[j] = True
                break

    return clue


def known_word(clues):
    """
    The `known_word` function takes a list of clues and returns a string that indicates the position and content of the "green" letters. For example, "__ING".
    """
    known = "_____"

    for guess, clue in clues:
        for i in range(5):
            if clue[i] == "green" and known[i] == "_":
                known = known[:i] + guess[i] + known[i + 1 :]

    return known


def no_letters(clues):
    """
    The `no_letters` function takes a list of clues and returns a string that involves the letters that are not in the secret word. The output is sorted in alphabetic order and does not include a letters that is gray, but is in the word.
    """
    no_set = set()

    for guess, clue in clues:
        for i in range(5):
            if clue[i] == "grey":
                no_set.add(guess[i])

    # Remove the letters that are in the word
    for no_letter in list(no_set):
        if no_letter in yes_letters(clues):
            no_set.remove(no_letter)

    no_string = "".join(sorted(no_set))
    return no_string


def yes_letters(clues):
    """
    The `yes_letters` function takes a list of clues and returns a string that involves the letters that are in the secret word.
    """
    yes_set = set()

    for guess, clue in clues:
        for i in range(5):
            if clue[i] == "green" or clue[i] == "yellow":
                yes_set.add(guess[i])

    yes_string = "".join(sorted(yes_set))
    return yes_string


# -------------------------------------------- #
# ------------- helper functions ------------- #


def is_valid_guess(guess):
    """
    This function checks if `guess` is valid.
    The guess is valid if it is a string of length 5 and it is in the words list.
    If `guess` is not valid, the function returns False and outputs a message. Otherwise, the function returns True.
    """

    if len(guess) != 5:
        print("Invalid guess. Word must be 5 letters long.")
        return False

    if guess.lower() not in words.words:
        print("Invalid guess. The guess must be a valid word.")
        return False

    return True


def print_info(clues):
    """
    This function prints the information currently know to the user.
    """
    # Print the known letters
    print("Known:", known_word(clues))

    # Print the green or yellow letters
    print("Green/Yellow Letters:", yes_letters(clues))

    # Print the grey letters
    print("Grey Letters:", no_letters(clues))


def print_clues(clues):
    """
    This function prints the clues in color.
    """
    for guess, clue in clues:
        for i in range(5):
            if clue[i] == "grey":
                du.grey(guess[i])
            elif clue[i] == "yellow":
                du.yellow(guess[i])
            elif clue[i] == "green":
                du.green(guess[i])
        print()


def is_game_over(secret, clues, num_guesses_left):
    """
    This function checks if the game is over.
    The game is over if the user has guessed the secret word or if the user has no more guesses left.
    If the secret word is guessed, the function returns `True` and prints: "Answer: {secret}"; if there are no guesses left, the function returns `True` and print "Running out of chance. The answer is {secret}". Otherwise, the function returns `False`.
    """
    if secret == clues[-1][0]:
        print(f"Answer: {secret}")
        return True

    if num_guesses_left == 0:
        print(f"Running out of chance. The answer is {secret}")
        return True

    return False


# --------- end of helper functions ---------- #
# -------------------------------------------- #


if __name__ == "__main__":
    # Initialize the game. The secret word is randomly chosen from the words list. The user has 6 guesses
    secret = choice(words.words).upper()
    guess = ""
    clues = []
    num_guesses_left = 6

    # The game loop
    while True:
        # Print currently available information
        print_info(clues)

        guess = input("> ").upper().strip()
        if not is_valid_guess(guess):
            continue

        # Decrement the number of guesses number
        num_guesses_left -= 1

        # Check the guess
        clues.append((guess, check_word(secret, guess)))

        # Print the clues
        print_clues(clues)

        # Check if the game is over
        if is_game_over(secret, clues, num_guesses_left):
            break
