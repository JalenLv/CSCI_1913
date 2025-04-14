from wordle import check_word, is_valid_guess, print_clues, is_game_over
from random import choice, sample
import words


def filter_word_list(words, clues):
    """
    This function takes a list of words and the clue list and returns a new word list containing only the words in the input word list which could be the secret word.
    This is done by iterating through the word list; if a word can generate an identical clue list with `clues` using `check_word()` function.
    """
    return [
        word
        for word in words
        if all(check_word(word.upper(), guess) == clue for guess, clue in clues)
    ]


# -------------------------------------------- #
# ------------- helper functions ------------- #


def print_possible_words(words):
    """
    This function prints the number of possible words and randomly print 5 words from the list (will not print repeated words). If the number of possible words is less than 5, print all the words.
    """
    print(f"{len(words)} words possible:")

    for word in sample(words, min(5, len(words))):
        print(word)


# --------- end of helper functions ---------- #
# -------------------------------------------- #


if __name__ == "__main__":
    # Initialize the game. The secret word is randomly chosen from the words list. The user has 6 guesses
    secret = choice(words.words).upper()
    guess = ""
    clues = []
    possible_words = words.words.copy()
    num_guesses_left = 6

    # The game loop
    while True:
        guess = input("> ").upper().strip()
        if not is_valid_guess(guess):
            continue

        # Decrement the number of guesses number
        num_guesses_left -= 1

        # Check the guess
        clues.append((guess, check_word(secret, guess)))

        # Print the clues
        print_clues(clues)

        # Update `possible_words` and print possible words
        possible_words = filter_word_list(possible_words, clues)
        print_possible_words(possible_words)

        # Check if the game is over
        if is_game_over(secret, clues, num_guesses_left):
            break
