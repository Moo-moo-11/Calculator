package org.example

class MultiplyOperation :AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Long = num1.toLong() * num2
}