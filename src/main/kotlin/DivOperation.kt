package org.example

class DivOperation :AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Long = num1 / num2.toLong()
}