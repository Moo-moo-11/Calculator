package org.example

class RemOperation :AbstractOperation() {
    override fun operate(num1: Int, num2: Int): Long = num1 % num2.toLong()
}