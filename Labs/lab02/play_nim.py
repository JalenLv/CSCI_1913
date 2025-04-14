# This is a PROGRAM that uses the nim code to play a game of nim
# Right now it is pretty sparse -- lots of room for improvement.
# @Author Daniel Kluver and Min Namgung
from nim import create_game_state, is_over, is_valid_move, draw_game_state, update


def play_one_game():
    game_state = create_game_state(4, 4)

    while not is_over(game_state):
        row = "a"
        takes = "a"
        while not is_valid_move(game_state, row, takes):
            draw_game_state(game_state)
            row = input("Choose a row 1 - "+str(len(game_state))+" ")
            takes = input("How many tokens to take, 1 to 3 (no more than are available) ")
            if not is_valid_move(game_state, row, takes):
                print("Invalid move")
        row = int(row) - 1
        takes = int(takes)
        game_state = update(game_state, row, takes)
    print("Game over, the last player lost!")

if __name__ == "__main__":
    play_one_game()