package org.example

class WeirdOperation: AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Long {
        try {
            return (num1.toString() + num2.toString()).toLong()
        } catch (e: Exception) {
            return -1
        }
    }
}