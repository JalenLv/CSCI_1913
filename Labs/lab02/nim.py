# Name: Qiming Lyu


def create_game_state(size, token_max):
    """
    This function returns a newly created list of integers representing the number of tokens in each row.
    The list should be like [1, 2, 3, ...] all the way up until it hits `token_max`.
    """

    return [min(i, token_max) for i in range(1, size + 1)]


def is_valid_move(game_state, row, takes):
    """
    This function validates the user's raw input. It will test:
        - Whether `row` and `takes` can be converted to integers.
        - Whether `row` is out-of-range.
        - Whether `takes` is between 1 and 3.
        - Whether `takes` exceeds the number of tokens in `row`, which is `game_state[row - 1]`.
    """

    # Whether `row` and `takes` can be converted to integers.
    if (not row.isdigit()) or (not takes.isdigit()):
        return False

    ROW = int(row)
    TAKES = int(takes)

    # Whether `row` is out-of-range.
    if not (1 <= ROW <= len(game_state)):
        return False

    # Whether `takes` is between 1 and 3.
    MIN_TAKES = 1
    MAX_TAKES = 3
    if not (MIN_TAKES <= TAKES <= MAX_TAKES):
        return False

    # Whether `takes` exceeds the number of tokens in `row`, which is `game_state[row - 1]`.
    if TAKES > game_state[ROW - 1]:
        return False

    return True


def update(game_state, row, takes):
    """
    This function updates `game_state`.
    """

    return [
        game_state[i] if (i != row) else (game_state[i] - takes)
        for i in range(len(game_state))
    ]


def draw_game_state(game_state):
    """
    This function draws the interface of the game according to `game_state`.
    For example, if given the list `[5, 2, 3, 1]`, the following should be printed:
        ====================
        1 #####
        2 ##
        3 ###
        4 #
        ====================
    """

    print("====================")

    for i in range(len(game_state)):
        print(i + 1, "#" * game_state[i])

    print("====================")


def is_over(game_state):
    """
    This function checks whether the game is over. If every token in `game_state` is 0, the game's over. Otherwise, it's not.
    """

    for token in game_state:
        if token != 0:
            return False

    return True
