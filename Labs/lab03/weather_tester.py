from collections import OrderedDict
from weather import F_to_C, F_to_C_file, clean, average, total_rain_by_year
print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')


print('Testing F_to_C function')
print(F_to_C(float("inf")))  # inf
print(F_to_C(-float("inf"))) # -inf
print(F_to_C(123899652354))  # 68833140178.88889
print(F_to_C(-898989785423)) # -499438769697.2222
print(F_to_C(0))             # -17.77777777777778
print(F_to_C(32))            # 0.0
print('F_to_C completed')
print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')


print('Testing F_to_C_file function')

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
F_to_C_file(example)
print(example == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', -14.444444444444445), ('Min_Temperature', -22.77777777777778), ('Precipitation', 'T'), ('Snow', 'T'), ('Snow_Depth', '9.00')])])
# True (this would be a pain to compare manually -- if you get false, oyu might want to print just the function output for comparison!)

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '8.0'
od['Min_Temperature'] = '-12.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '10.0'
od['Min_Temperature'] = '-13.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '2.0'
od['Min_Temperature'] = '-1.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
F_to_C_file(example)
print(example == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', -35.99908550525835), ('Min_Temperature', -36.28486511202561), ('Precipitation', 'T'), ('Snow', 'T'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', -35.99908550525835), ('Min_Temperature', -36.28486511202561), ('Precipitation', 'T'), ('Snow', 'T'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', -35.99908550525835), ('Min_Temperature', -36.28486511202561), ('Precipitation', 'T'), ('Snow', 'T'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', -35.99908550525835), ('Min_Temperature', -36.28486511202561), ('Precipitation', 'T'), ('Snow', 'T'), ('Snow_Depth', '9.00')])])
# True (this would be a pain to compare manually -- if you get false, oyu might want to print just the function output for comparison!)

print('F_to_C_file completed')
print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')



print('Testing clean function')
example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = 'S'
od['Min_Temperature'] = 'M'
od['Precipitation'] = 'A'
od['Snow'] = 'T'
od['Snow_Depth'] = ''
example.append(od)

print(clean(example, "Snow"))                  # []
print(clean(example, "Precipitation"))         # []
print(clean(example, "Snow_Depth"))            # []
print(clean(example, "Max_Temperature"))       # []
print(clean(example, "Min_Temperature"))       # []

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '6.00'
od['Snow'] = 'A'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-02'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'M'
od['Snow'] = '1.00'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-03'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '7.00'
od['Snow'] = '6.00'
od['Snow_Depth'] = ''
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-04'
od['Max_Temperature'] = 'T'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '5.00'
od['Snow'] = '4.00'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-05'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = 'S'
od['Precipitation'] = '3.00'
od['Snow'] = '1.00'
od['Snow_Depth'] = '9.00'
example.append(od)
print(clean(example, "Snow") == [OrderedDict([('Date', '2010-01-02'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', 'M'), ('Snow', '1.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-03'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '7.00'), ('Snow', '6.00'), ('Snow_Depth', '')]), OrderedDict([('Date', '2010-01-04'), ('Max_Temperature', 'T'), ('Min_Temperature', '-9.0'), ('Precipitation', '5.00'), ('Snow', '4.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-05'), ('Max_Temperature', '6.0'), ('Min_Temperature', 'S'), ('Precipitation', '3.00'), ('Snow', '1.00'), ('Snow_Depth', '9.00')])])
print(clean(example, "Precipitation") == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '6.00'), ('Snow', 'A'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-03'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '7.00'), ('Snow', '6.00'), ('Snow_Depth', '')]), OrderedDict([('Date', '2010-01-04'), ('Max_Temperature', 'T'), ('Min_Temperature', '-9.0'), ('Precipitation', '5.00'), ('Snow', '4.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-05'), ('Max_Temperature', '6.0'), ('Min_Temperature', 'S'), ('Precipitation', '3.00'), ('Snow', '1.00'), ('Snow_Depth', '9.00')])])
print(clean(example, "Snow_Depth") == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '6.00'), ('Snow', 'A'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-02'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', 'M'), ('Snow', '1.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-04'), ('Max_Temperature', 'T'), ('Min_Temperature', '-9.0'), ('Precipitation', '5.00'), ('Snow', '4.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-05'), ('Max_Temperature', '6.0'), ('Min_Temperature', 'S'), ('Precipitation', '3.00'), ('Snow', '1.00'), ('Snow_Depth', '9.00')])])
print(clean(example, "Max_Temperature") == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '6.00'), ('Snow', 'A'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-02'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', 'M'), ('Snow', '1.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-03'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '7.00'), ('Snow', '6.00'), ('Snow_Depth', '')]), OrderedDict([('Date', '2010-01-05'), ('Max_Temperature', '6.0'), ('Min_Temperature', 'S'), ('Precipitation', '3.00'), ('Snow', '1.00'), ('Snow_Depth', '9.00')])])
print(clean(example, "Min_Temperature") == [OrderedDict([('Date', '2010-01-01'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '6.00'), ('Snow', 'A'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-02'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', 'M'), ('Snow', '1.00'), ('Snow_Depth', '9.00')]), OrderedDict([('Date', '2010-01-03'), ('Max_Temperature', '6.0'), ('Min_Temperature', '-9.0'), ('Precipitation', '7.00'), ('Snow', '6.00'), ('Snow_Depth', '')]), OrderedDict([('Date', '2010-01-04'), ('Max_Temperature', 'T'), ('Min_Temperature', '-9.0'), ('Precipitation', '5.00'), ('Snow', '4.00'), ('Snow_Depth', '9.00')])])
# True
# True
# True
# True
# True (this would be a pain to compare manually -- if you get false, oyu might want to print just the function output for comparison!)

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '6.00'
od['Snow'] = 'A'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-02'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'M'
od['Snow'] = 'M'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-03'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '7.00'
od['Snow'] = 'S'
od['Snow_Depth'] = ''
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-04'
od['Max_Temperature'] = 'T'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '5.00'
od['Snow'] = 'M'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-05'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = 'S'
od['Precipitation'] = '3.00'
od['Snow'] = ''
od['Snow_Depth'] = '9.00'
example.append(od)
print(clean(example, "Snow")) # []

print('clean completed')
print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')


print('Testing average function')
example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
print(average(example, "Snow")) # 0.0

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '8.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '10.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
print(average(example, "Snow_Depth")) # 9.0

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = ''
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = 'S'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
print(average(example, "Snow_Depth")) # 0.0
print('average completed')
print('~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~')


print('Testing total_rain_by_year function')
example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '9.0'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
answer = total_rain_by_year(example)
print(answer) # {2010: 9.0}

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-02'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '8.33'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2011-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '7.9595'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
od = OrderedDict()
od['Date'] = '2011-01-02'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = '9.765'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
print(total_rain_by_year(example)) # {2010: 8.33, 2011: 17.7245}

example = []
od = OrderedDict()
od['Date'] = '2010-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'T'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2010-01-02'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'M'
od['Snow'] = 'T'
od['Snow_Depth'] = '9.00'
example.append(od)
od = OrderedDict()
od['Date'] = '2011-01-03'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'S'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
od = OrderedDict()
od['Date'] = '2011-01-01'
od['Max_Temperature'] = '6.0'
od['Min_Temperature'] = '-9.0'
od['Precipitation'] = 'A'
od['Snow'] = 'T'
od['Snow_Depth'] = 'A'
example.append(od)
print(total_rain_by_year(example)) # {}
print('total_rain_by_year completed')



### EXPECTED OUTPUT
"""
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing F_to_C function
inf
-inf
68833140178.88889
-499438769697.2222
-17.77777777777778
0.0
F_to_C completed
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing F_to_C_file function
True
True
F_to_C_file completed
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing clean function
[]
[]
[]
[]
[]
True
True
True
True
True
[]
clean completed
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing average function
0.0
9.0
0.0
average completed
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Testing total_rain_by_year function
{2010: 9.0}
{2010: 8.33, 2011: 17.7245}
{}
total_rain_by_year completed
"""