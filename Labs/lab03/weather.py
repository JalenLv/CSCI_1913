# Template file for Lab03 -- weather. By Peter Wang and Daniel Kluver
# Additions made by: Qiming Lyu

# Import Statements
import csv  # imported for DictReader
import math  # imported for

# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.


def load(filename):
    """
    load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file
    """
    reader = csv.DictReader(open(filename), dialect="excel", skipinitialspace=True)
    return list(reader)


# provided function
def min_min_temp(file_list):
    """
    The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp


# Put your functions below this.
def F_to_C(F):
    """
    Converts a temperature in Fahrenheit to Celsius
    """
    return (F - 32) * 5 / 9


def F_to_C_file(file_list):
    """
    Converts all temperature data in the file from Fahrenheit to Celsius. This function modifies the input list, changing the date type from string to float.
    """
    for row in file_list:
        row["Max_Temperature"] = F_to_C(float(row["Max_Temperature"]))
        row["Min_Temperature"] = F_to_C(float(row["Min_Temperature"]))


def clean(file_list, col):
    """
    The clean function will process the file and return a new list containing only “clean” rows
    of the data. That is, any row of data in which the specified column contains a special value
    (defined by our data source as “T”, “M”, “S”, “A”, or blank (“”) should be removed.
    """
    new_file_list = []
    special_value = ["T", "M", "S", "A", ""]
    for row in file_list:
        if row[col] not in special_value:
            new_file_list.append(row)

    return new_file_list


def average(file_list, col):
    """
    Returns a mathematical average of the provided column.
    """
    new_file_list = clean(file_list, col)

    sum = 0.0
    for row in new_file_list:
        sum += float(row[col])

    if len(new_file_list) == 0:
        return 0.0
    else:
        return sum / len(new_file_list)


def total_rain_by_year(file_list):
    """
    Returns a dictionary with the year as the key and the total rain for that year as values.
    """
    new_file_list = clean(file_list, "Precipitation")

    total_rain = {}
    for row in new_file_list:
        year = int(row["Date"][:4])
        if year not in total_rain:
            total_rain[year] = float(row["Precipitation"])
        else:
            total_rain[year] += float(row["Precipitation"])

    return total_rain


if __name__ == "__main__":
    # This code block shows how you could use this file to produce a complete report.
    local_file = load("original.csv")
    print(len(local_file), "rows loaded")
    F_to_C_file(local_file)
    print("The lowest observed temperature was", min_min_temp(local_file))
    print("The average high temperature was", average(local_file, "Max_Temperature"))
    total_rain = total_rain_by_year(local_file)
    print("Rain by year:", total_rain)
