package org.example

class Calculator(private val operation: AbstractOperation) {
    fun operate(num1: Int, num2: Int): Long {
        return operation.operate(num1, num2)
    }
}