package org.example

fun main() {

    println("계산기 동작을 시작합니다.")

    var wantToEndCalculator = false

    while(!wantToEndCalculator) {

        println("동작을 선택하세요.")
        println("1. 더하기, 2. 빼기, 3. 곱하기, 4. 몫 구하기, 5. 나머지 구하기, 6. 종료")

        var validInitialInput = false
        var operator = "1"

        while(!validInitialInput) {
            val operatorInput = readln()

            if (operatorInput == "1"|| operatorInput == "2"|| operatorInput == "3" || operatorInput == "4" || operatorInput == "5") {
                operator = operatorInput
                validInitialInput = true
            } else if (operatorInput == "6") {
                operator = operatorInput
                validInitialInput = true
                wantToEndCalculator = true
            } else {
                println("잘못 입력하셨습니다. 다시 입력해주세요.")
            }
        }

        if (operator != "6") {

            println("숫자는 -2147483648 ~ 2147483647 사이의 정수만 입력가능합니다.")

            var validFirstNumb = false
            var firstNumb = 0

            println("첫 번째 숫자를 입력해주세요")

            while (!validFirstNumb) {

                val firstNumbInput = readln().toIntOrNull()

                if (firstNumbInput == null) {
                    println("잘못 입력하셨습니다. 다시 입력해주세요.")
                } else {
                    firstNumb = firstNumbInput
                    validFirstNumb = true
                }
            }

            var validSecondNumb = false
            var secondNumb = 0

            println("두 번째 숫자를 입력해주세요")

            while (!validSecondNumb) {

                val secondNumbInput = readln().toIntOrNull()

                if (secondNumbInput == null) {
                    println("잘못 입력하셨습니다. 다시 입력해주세요.")
                } else if (secondNumbInput == 0 && (operator == "4" || operator == "5")) {
                    println("0으로는 나눌 수 없습니다. 다시 입력해주세요.")
                } else {
                    secondNumb = secondNumbInput
                    validSecondNumb = true
                }
            }

            when (operator) {
                "1" -> println("${firstNumb}과(와) ${secondNumb}을(를) 더한 값은 ${Calculator(AddOperation()).operate(firstNumb,secondNumb)}입니다.")
                "2" -> println("${firstNumb}에서 ${secondNumb}을(를) 뺀 값은 ${Calculator(MinusOperation()).operate(firstNumb,secondNumb)}입니다.")
                "3" -> println("${firstNumb}과(와) ${secondNumb}을(를) 곱한 값은 ${Calculator(MultiplyOperation()).operate(firstNumb,secondNumb)}입니다.")
                "4" -> println("${firstNumb}을(를) ${secondNumb}으로 나눈 몫은 ${Calculator(DivOperation()).operate(firstNumb,secondNumb)}입니다.")
                "5" -> println("${firstNumb}을(를) ${secondNumb}으로 나눈 나머지는 ${Calculator(RemOperation()).operate(firstNumb,secondNumb)}입니다.")
            }

        }

    }

    println("계산기를 종료합니다.")
}