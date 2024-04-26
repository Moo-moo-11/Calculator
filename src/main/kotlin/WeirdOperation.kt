package org.example

class WeirdOperation: AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Long {
        return try {
            (num1.toString() + num2.toString()).toLong()
        } catch (e: Exception) {
            -1
        }
    }
}