class ATM {
    final var cashBox100 = new CashBox100()
    final var cashBox200 = new CashBox200()
    final var cashBox500 = new CashBox500()

    void runATM() {
        def input = ''
        def menu = {
            println('Menu:\n' +
                    '1. Cash in\n' +
                    '2. Get cash\n' +
                    '3. Cash summ in ATM\n' +
                    '4. Exit')
            input = System.in.newReader().readLine()
        }
        def run = true
        while (run == true) {
            menu()
            switch (input) {
                case '1' -> cashIn()
                case '2' -> getCash()
                case '3' -> println("Cash summ in ATM: ${cashInATM()} rub")
                case '4' -> run = false
                default -> println('Incorrect input\n' +
                        '-----------------------------\n\n')
            }
        }
    }

    private Integer cashInATM() {
        return cashBox500.cashBoxContent() * 500 + cashBox200.cashBoxContent() * 200 + cashBox100.cashBoxContent() * 100
    }

    private void getCash() {
        def input
        var cash500 = 0
        var cash200 = 0
        var cash100 = 0
        var requestedRemain = 0
        def getCashMenu = {
            println('Write cash (int)')
            input = System.in.newReader().readLine()
            if (isValidCashInInput(input)) {
                requestedRemain = Integer.parseInt(input)
                if (requestedRemain.intdiv(500) > 0) {
                    cash500 = getCash500(requestedRemain)
                    requestedRemain -= cash500 * 500
                }
                if (requestedRemain.intdiv(200) > 0) {
                    cash200 = getCash200(requestedRemain)
                    requestedRemain -= cash200 * 200
                }
                if (requestedRemain.intdiv(100) > 0) {
                    cash100 = getCash100(requestedRemain)
                    requestedRemain -= cash100 * 100
                }
            }
        }
        getCashMenu()
        println("Give cash:\n" +
                "500 rub = ${cash500}\n" +
                "200 rub = ${cash200}\n" +
                "100 rub = ${cash100}\n" +
                "Not enough cash = ${requestedRemain}")
    }

    private Integer getCash500(Integer remain) {
        Integer remainingCash = remain.intdiv(500)
        if (cashBox500.cashBoxContent() >= remainingCash) {
            cashBox500 - remainingCash
            return remainingCash
        } else {
            var availibleCash = cashBox500.cashBoxContent()
            cashBox500 - availibleCash
            return availibleCash
        }
    }

    private Integer getCash200(Integer remain) {
        Integer remainingCash = remain.intdiv(200)
        if (cashBox200.cashBoxContent() >= remainingCash) {
            cashBox200 - remainingCash
            return remainingCash
        } else {
            var availibleCash = cashBox200.cashBoxContent()
            cashBox200 - availibleCash
            return availibleCash
        }
    }

    private Integer getCash100(Integer remain) {
        Integer remainingCash = remain.intdiv(100)
        if (cashBox100.cashBoxContent() >= remainingCash) {
            cashBox100 - remainingCash
            return remainingCash
        } else {
            var availibleCash = cashBox100.cashBoxContent()
            cashBox100 - availibleCash
            return availibleCash
        }
    }

    private void cashIn() {
        def input
        def cashInMenu = {
            println('Write cash count (int)')
            println('500 rub:')
            input = System.in.newReader().readLine()
            if (isValidCashInInput(input)) cashBox500 + Integer.parseInt(input)
            else println('Incorrect input')
            println('200 rub:')
            input = System.in.newReader().readLine()
            if (isValidCashInInput(input)) cashBox200 + Integer.parseInt(input)
            else println('Incorrect input')
            println('100 rub:')
            input = System.in.newReader().readLine()
            if (isValidCashInInput(input)) cashBox100 + Integer.parseInt(input)
            else println('Incorrect input')
        }
        cashInMenu()
    }

    private static boolean isValidCashInInput(String input) {
        input.isInteger()
    }
}
