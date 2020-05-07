# camelCaseStringConversion
A method created using TDD (Test Driven Development) that transform a camel case string in a list of words.

Peer-graded Assignment: Camel Case String Conversion

The aim of this assignment is to created a method that gets a camel case string and transform it in a list of words.
Some input and output examples:
input                 output
name                  name
Name                  name
fullName              full, name
FullName              full, name
SSN                   ssn
SSNumber              ss, number
citizenSSNumber       citizen, ss, number
getFirst10            get, first, 10
10Number              invalid string (it cannot start with numbers)
full#Name             invalid string (it canoot have special characters, only letters and digit are allowed)

This is part of the TDD (Test Driven Development) course by Coursera (https://www.coursera.org/learn/tdd-desenvolvimento-de-software-guiado-por-testes/)
