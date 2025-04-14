# This is a PROGRAM that uses the nim code from nim.py. It runs through a series of function calls and print statement
# that will allow you to test if your code works the way we expect
# @Author Daniel Kluver and Min Namgung

from nim import create_game_state, is_over, is_valid_move, draw_game_state, update

state = create_game_state(0, 0)
print(state)                       # []
state = create_game_state(5, 5)
print(state)                       # [1, 2, 3, 4, 5]
state = create_game_state(4, 3)
print(state)                       # [1, 2, 3, 3]
state = create_game_state(7, 9)
print(state)                       # [1, 2, 3, 4, 5, 6, 7]
state = create_game_state(1, 1)
print(state)                       # [1]
state = create_game_state(1, 3)
print(state)                       # [1]
state = create_game_state(5, 5)
print(state)                       # [1, 2, 3, 4, 5]
state = create_game_state(8, 4)
print(state)                       # [1, 2, 3, 4, 4, 4, 4, 4]
state = create_game_state(6, 1)
print(state)                       # [1, 1, 1, 1, 1, 1]
state = create_game_state(13, 9)
print(state)                       # [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]


state = [5, 4, 3, 2]
print(is_valid_move(state, '1', '2')) # True
state = [8, 7, 6, 5, 4]
print(is_valid_move(state, '5', '2')) # True
state = [4, 3]
print(is_valid_move(state, '1', '1')) # True
state = [4, 3]
print(is_valid_move(state, '3', '4')) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, '5', '4')) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "a", "a")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "a", "2")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "1", "a")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "0", "1")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "4", "3")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "1", "4")) # False
state = [5, 4, 3, 2]
print(is_valid_move(state, "3", "3")) # True


state = [3, 2, 1]
result = update(state, 2, 1)
print(state, result)                   # [3, 2, 1] [3, 2, 0]
state = [4, 3, 2, 1, 0]
result = update(state, 3, 1)
print(state, result)                   # [4, 3, 2, 1, 0] [4, 3, 2, 0, 0]
state = [9, 8, 7, 6, 5, 4, 3]
result = update(state, 6, 2)
print(state, result)                   # [9, 8, 7, 6, 5, 4, 3] [9, 8, 7, 6, 5, 4, 1]
state = [8, 7, 6, 5]
result = update(state, 0, 3)
print(state, result)                   # [8, 7, 6, 5] [5, 7, 6, 5]
state = [5, 4, 3, 2, 1]
result = update(state, 1, 1)
print(state, result)                   # [5, 4, 3, 2, 1] [5, 3, 3, 2, 1]
state = [4, 3, 2, 1]
result = update(state, 1, 2)
print(state, result)                   # [4, 3, 2, 1] [4, 1, 2, 1]

state = [5,4,3,2,1]
print("before call")
draw_game_state(state)
print("after call")
# before call
# ====================
# 1 #####
# 2 ####
# 3 ###
# 4 ##
# 5 #
# ====================
# after call

state = [5,4,3,4,1,0,0,9,1]
print("before call")
draw_game_state(state)
print("after call")
# before call
# ====================
# 1 #####
# 2 ####
# 3 ###
# 4 ####
# 5 #
# 6
# 7
# 8 #########
# 9 #
# ====================
# after call

state = [1]
print("before call")
draw_game_state(state)
print("after call")
# before call
# ====================
# 1 #
# ====================
# after call


print(is_over([0]))                 # True
print(is_over([1,4,1,3,1,0]))       # False
print(is_over([0,1,2,3,2]))         # False
print(is_over([1,2,3,4,0]))         # False
print(is_over([0,0,0,0,0,0,0,0]))   # True
print(is_over([1,2,0,2,1,3]))       # False

# EXPECTED RESULTS ALL IN ONE PLACE:
'''

[]
[1, 2, 3, 4, 5]
[1, 2, 3, 3]
[1, 2, 3, 4, 5, 6, 7]
[1]
[1]
[1, 2, 3, 4, 5]
[1, 2, 3, 4, 4, 4, 4, 4]
[1, 1, 1, 1, 1, 1]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]
True
True
True
False
False
False
False
False
False
False
False
True
[3, 2, 1] [3, 2, 0]
[4, 3, 2, 1, 0] [4, 3, 2, 0, 0]
[9, 8, 7, 6, 5, 4, 3] [9, 8, 7, 6, 5, 4, 1]
[8, 7, 6, 5] [5, 7, 6, 5]
[5, 4, 3, 2, 1] [5, 3, 3, 2, 1]
[4, 3, 2, 1] [4, 1, 2, 1]
before call
====================
1 #####
2 ####
3 ###
4 ##
5 #
====================
after call
before call
====================
1 #####
2 ####
3 ###
4 ####
5 #
6 
7 
8 #########
9 #
====================
after call
before call
====================
1 #
====================
after call
True
False
False
False
True
False

'''