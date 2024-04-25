package org.example

fun main() {

    println("----- 계산기 동작을 시작합니다. -----")

    while (!wantToEndCalculator) {

        println("_〆(･_･｡) 계산기 동작을 선택하세요.")
        println("1. 더하기, 2. 빼기, 3. 곱하기, 4. 몫 구하기, 5. 나머지 구하기, 6. 이상한 더하기, 7. 종료")

        getInitialInput()

        // 종료를 선택하지 않았을때만 동작
        if (operator != "7") {

            if (operator == "6") {
                println("암산왕: \"숫자 2개를 입력해주면 더해줄게요. 너무 큰 숫자는 제가 못 알아봐요 ㅜ_ㅜ\"")
            } else {
                println("[주의] 숫자는 -2147483648 ~ 2147483647 사이의 정수만 입력가능합니다.")
            }

            getFirstNumbInput()

            getSecondNumbInput()

            operateAndPrint()

        }

    }

    println("계산기를 종료합니다.")

}

var wantToEndCalculator = false

var operator = "1"

var firstNumb = 0
var secondNumb = 0

fun getInitialInput() {

    var validInitialInput = false


    while (!validInitialInput) {

        val operatorInput = readln()

        if (operatorInput in listOf("1", "2", "3", "4", "5", "6")) {
            operator = operatorInput
            validInitialInput = true
        } else if (operatorInput == "7") {
            operator = operatorInput
            validInitialInput = true
            wantToEndCalculator = true
        } else {
            println("잘못 입력하셨습니다. 다시 입력해주세요.")
        }
    }

}

fun getFirstNumbInput() {

    var validFirstNumb = false

    println("첫 번째 숫자를 입력해주세요")

    while (!validFirstNumb) {

        val firstNumbInputString = readln()

        if ((Regex("^0+[0-9]+") matches firstNumbInputString ||
            Regex("^-0+[0-9]*") matches firstNumbInputString) && operator == "6") {
            println("그거 숫자 맞아요? 다시 입력해주세요")
        } else if (Regex("^0+[0-9]+") matches firstNumbInputString ||
            Regex("^-0+[0-9]*") matches firstNumbInputString) {
            println("잘못 입력하셨습니다. 다시 입력해주세요.")
        } else {

            val firstNumbInput = firstNumbInputString.toIntOrNull()

            if (firstNumbInput == null && operator == "6") {
                println("그거 숫자 맞아요? 다시 입력해주세요")
            } else if (firstNumbInput == null) {
                println("잘못 입력하셨습니다. 다시 입력해주세요.")
             }else if (firstNumbInput < 0 && operator == "6") {
                println("(〃´o｀)=3 앞에 붙은 짝대기는 뭐에요? 그런거 몰라요. 다른 숫자 주세요")
            } else {
                firstNumb = firstNumbInput
                validFirstNumb = true
            }

        }

    }
}

fun getSecondNumbInput() {

    var validSecondNumb = false

    println("두 번째 숫자를 입력해주세요")

    while (!validSecondNumb) {

        val secondNumbInputString = readln()

        if ((Regex("^0+[0-9]+") matches secondNumbInputString ||
            Regex("^-0+[0-9]*") matches secondNumbInputString) && operator == "6") {
            println("그거 숫자 맞아요? 다시 입력해주세요")
        } else if (Regex("^0+[0-9]+") matches secondNumbInputString ||
            Regex("^-0+[0-9]*") matches secondNumbInputString) {
            println("잘못 입력하셨습니다. 다시 입력해주세요.")
        } else {
            val secondNumbInput = secondNumbInputString.toIntOrNull()

            if (secondNumbInput == null && operator == "6") {
                println("그거 숫자 맞아요? 다시 입력해주세요")
            } else if (secondNumbInput == null) {
                println("잘못 입력하셨습니다. 다시 입력해주세요.")
            } else if (secondNumbInput < 0 && operator == "6") {
                println("(〃´o｀)=3 앞에 붙은 짝대기는 뭐에요? 그런거 몰라요. 다른 숫자 주세요")
            } else if (secondNumbInput == 0 && (operator == "4" || operator == "5")){
                println("0으로는 나눌 수 없습니다. 다시 입력해주세요.")
            } else {
                secondNumb = secondNumbInput
                validSecondNumb = true
            }
        }
    }

}

fun operateAndPrint() {

    when (operator) {
        "1" -> println("""
            |${firstNumb}과(와) ${secondNumb}을(를) 더한 값은 ${Calculator(AddOperation()).operate(firstNumb, secondNumb)}입니다.
            |_______________________________________________________________________________________________________
            """.trimMargin()
        )

        "2" -> println("""
            |${firstNumb}에서 ${secondNumb}을(를) 뺀 값은 ${Calculator(MinusOperation()).operate(firstNumb, secondNumb)}입니다.
            |_______________________________________________________________________________________________________
            """.trimMargin()
        )

        "3" -> println("""
            |${firstNumb}과(와) ${secondNumb}을(를) 곱한 값은 ${Calculator(MultiplyOperation()).operate(firstNumb, secondNumb)}입니다.
            |_______________________________________________________________________________________________________
            """.trimMargin()
        )

        "4" -> println("""
            |${firstNumb}을(를) ${secondNumb}으로 나눈 몫은 ${Calculator(DivOperation()).operate(firstNumb, secondNumb)}입니다.
            |_______________________________________________________________________________________________________
            """.trimMargin()
        )

        "5" -> println("""
            |${firstNumb}을(를) ${secondNumb}으로 나눈 나머지는 ${Calculator(RemOperation()).operate(firstNumb, secondNumb)}입니다.
            |_______________________________________________________________________________________________________
            """.trimMargin()
        )

        "6" -> if (Calculator(WeirdOperation()).operate(firstNumb, secondNumb) == -1L) {
            println("""
                |${firstNumb}이랑 ${secondNumb}을 더하면 아휴 뭐 이리 길어요 (@^_^)=@
                |_______________________________________________________________________________________________________
                """.trimMargin()
            )
        } else if (firstNumb == 0){
            println("""
                |${firstNumb}이랑 ${secondNumb}을 더하면 0${Calculator(WeirdOperation()).operate(firstNumb, secondNumb)} 아닐까염 뿌우 ^_^
                |_______________________________________________________________________________________________________
                """.trimMargin()
            )
        } else {
            println("""
                |${firstNumb}이랑 ${secondNumb}을 더하면 ${Calculator(WeirdOperation()).operate(firstNumb, secondNumb)} 아닐까염 뿌우 ^_^
                |_______________________________________________________________________________________________________
                """.trimMargin()
            )
        }
    }

}