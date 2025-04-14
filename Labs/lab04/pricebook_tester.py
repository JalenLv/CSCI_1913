from pricebook import *
import time

empty = []
pb1 = [
    (100.0, "Apple Juice"),
    (91.8, "Jorts"),
    (99.2, "Lingonberry jam"),
    (92.7, "Pepperoni"),
]
pb2 = [
    (88.7, "Red Paint"),
    (65.2, "Newman's Own Salad Dressing"),
    (73.5, "Chewy Granola Bars"),
    (95.6, "Dinosaur Bones (plastic)"),
]
pb3 = [
    (90.0, "Ingredients"),
    (91.9, "Dot matrix Printer"),
    (97.6, "Perfect Parchment Paper"),
    (93.3, "Island Scent Candle"),
]
pb4 = [
    (95.4, "Carton Milk"),
    (68.2, "Kinder Egg"),
    (96.3, "Naan"),
    (84.7, "The best bread I could find"),
]
pb5 = [
    (77.0, "Law books"),
    (86.2, "Alternator for car"),
    (73.4, "Barn (small)"),
    (78.1, "Raddish"),
]

print("\nTesting is_sorted():\n")
print(is_sorted(empty))  # True
print(is_sorted(pb1))  # True
print(is_sorted(pb2))  # False
new_test = [
    (62.4, "Apple Juice"),
    (42.8, "Apple Pie"),
    (23.6, "Apples"),
    (41.1, "Apple Butter"),
    (89.8, "Apple Sauce"),
]
print(is_sorted(new_test))  # False
new_test2 = [
    (62.4, "Lingonberry jam"),
    (42.8, "Basketball"),
    (23.6, "Golf"),
    (41.1, "Table Tennis"),
    (89.8, "Chess"),
]
print(is_sorted(new_test2))  # False
new_test3 = [
    (92.7, "Green Pepper"),
    (99.2, "Potato"),
    (91.8, "Perfect Parchment Paper"),
    (100.0, "Tofu"),
]
print(is_sorted(pb5))  # False

print("\nTesting price_average():\n")
print(price_average(empty))  # 0.0
print(price_average(pb1))  # 95.925
print(price_average(pb2))  # 80.75
print(price_average(pb3))  # 93.2
print(price_average(pb4))  # 86.15
print(price_average(pb5))  # 78.675

print("\nTesting unsorted_get():\n")

print(unsorted_get(empty, "Madhava Grünspan"))  # None
print(unsorted_get(pb1, "Lingonberry jam"))  # 99.2
print(unsorted_get(pb2, "The best bread I could find"))  # None
print(unsorted_get(pb3, "Dot matrix Printer"))  # 91.9
print(unsorted_get(pb4, 4))  # None
print(unsorted_get(pb5, "Law books"))  # 77.0
print(unsorted_get(pb1, "Pepperoni"))  # 92.7

print("\nTesting unsorted_put():\n")
empty = []
unsorted_put(empty, "Speaker", 92.3)
print(empty)  # [(92.3, 'Speaker')]
unsorted_put(empty, "Speaker", 93.3)
print(empty)  # [(93.3, 'Speaker')]
unsorted_put(empty, "socks", 88.8)
print(empty)  # [(93.3, 'Speaker'), (88.8, 'socks)]
for x in pb1:
    unsorted_put(empty, x[1], x[0])
print(empty)
# [(93.3, 'Speaker'), (88.8, 'socks'), (100.0, "Apple Juice"), (91.8, "Jorts"), (99.2, "Lingonberry jam"), (92.7, "Pepperoni")]

empty = []

print("\nTesting sorted_get():\n")
print(sorted_get(empty, "Matrix"))  # None
print(sorted_get(pb1, "Apple Juice"))  # 100.0
print(sorted_get(pb1, "Jorts"))  # 91.8
print(sorted_get(pb1, "Charger"))  # None
print(sorted_get(pb1, "Pepperoni"))  # 92.7

print("\nBig sorted_get test:\n")
big = []
for i in range(0, 10000):
    big.append((i, str(i)))
s = time.time()
sorted_get(big, "10000")
e = time.time()
print(e - s < 0.0002)
# True

print("\nTesting sorted_put():\n")
empty = []
sorted_put(empty, "Rib Eyes", 86.2)
print(empty)  # [(86.2, 'Rib Eyes')]
sorted_put(empty, "Yogurt", 81.5)
print(empty)  # [(86.2, 'Rib Eyes'), (81.5, 'Yogurt')]
sorted_put(empty, "Yogurt", 87.5)
print(empty)  # [(86.2, 'Rib Eyes'), (87.5, 'Yogurt')]
sorted_put(empty, "Rice", 65.1)
# [(86.2, 'Rib Eyes'), (65.1, 'Rice'), (87.5, 'Yogurt')]
print(empty)
sorted_put(empty, "Tuna", 93.5)
# [(86.2, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]
print(empty)
sorted_put(empty, "Rib Eyes", 89.6)
# [(89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]
print(empty)
for x in pb1:
    sorted_put(empty, x[1], x[0])
print(empty)
# [(100.0, 'Apple Juice'), (91.8, 'Jorts'), (99.2, 'Lingonberry jam'), (92.7, 'Pepperoni'), (89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]

"""



Testing is_sorted():

True
True
False
False
False
False

Testing price_average():

0.0
95.925
80.75
93.2
86.15
78.675

Testing unsorted_get():

None
99.2
None
91.9
None
77.0
92.7

Testing unsorted_put():

[(92.3, 'Speaker')]
[(93.3, 'Speaker')]
[(93.3, 'Speaker'), (88.8, 'socks')]
[(93.3, 'Speaker'), (88.8, 'socks'), (100.0, 'Apple Juice'), (91.8, 'Jorts'), (99.2, 'Lingonberry jam'), (92.7, 'Pepperoni')]

Testing sorted_get():

None
100.0
91.8
None
92.7

Big sorted_get test:

True

Testing sorted_put():

[(86.2, 'Rib Eyes')]
[(86.2, 'Rib Eyes'), (81.5, 'Yogurt')]
[(86.2, 'Rib Eyes'), (87.5, 'Yogurt')]
[(86.2, 'Rib Eyes'), (65.1, 'Rice'), (87.5, 'Yogurt')]
[(86.2, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]
[(89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]
[(100.0, 'Apple Juice'), (91.8, 'Jorts'), (99.2, 'Lingonberry jam'), (92.7, 'Pepperoni'), (89.6, 'Rib Eyes'), (65.1, 'Rice'), (93.5, 'Tuna'), (87.5, 'Yogurt')]


"""
