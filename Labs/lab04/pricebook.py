# Name: Qiming Lyu


def is_sorted(pricebook):
    """
    This function takes a pricebook (I.E. a list of tuples) and returns either `True` or `False` to indicate if the list is sorted.
    """
    for i in range(1, len(pricebook) - 1):
        if not (pricebook[i - 1][1] < pricebook[i][1] < pricebook[i + 1][1]):
            return False

    return True


def price_average(pricebook):
    """
    This function takes a pricebook and returns the average price of all products in the pricebook.
    """
    sum = 0.0
    for product in pricebook:
        sum += product[0]

    if len(pricebook) == 0:
        return 0.0
    else:
        return sum / len(pricebook)


def unsorted_get(pricebook, name):
    """
    This function takes an unsorted pricebook and a product's name. If the product is in the pricebook, the function returns its price. Otherwise, it returns `None`.
    """
    for product in pricebook:
        if product[1] == name:
            return product[0]

    return None


def unsorted_put(pricebook, name, price):
    """
    This function replicates the behavior of the dictionary assignment statement: `dict[key] = values`.
    """
    is_found = False
    for i in range(len(pricebook)):
        if pricebook[i][1] == name:
            pricebook[i] = (price, name)
            is_found = True

    if not is_found:
        pricebook.append((price, name))


def sorted_get(pricebook, name):
    """
    This function replicates the behavior of the `dict.get(key)` method using binary search.
    """
    left = 0
    right = len(pricebook) - 1
    while left <= right:
        mid = (left + right) // 2
        if pricebook[mid][1] == name:
            return pricebook[mid][0]
        elif pricebook[mid][1] < name:
            left = mid + 1
        else:
            right = mid - 1

    return None


def sorted_put(pricebook, name, price):
    """
    This function replicates the behavior of the dictionary assignment statement: `dict[key] = values`.
    """
    if len(pricebook) == 0:
        pricebook.append((price, name))
        return

    left = 0
    right = len(pricebook) - 1
    mid = None
    while left <= right:
        mid = (left + right) // 2
        if pricebook[mid][1] == name:
            pricebook[mid] = (price, name)
            return
        elif pricebook[mid][1] < name:
            left = mid + 1
        else:
            right = mid - 1

    if name > pricebook[mid][1]:
        pricebook.insert(mid + 1, (price, name))
    else:
        pricebook.insert(mid, (price, name))
