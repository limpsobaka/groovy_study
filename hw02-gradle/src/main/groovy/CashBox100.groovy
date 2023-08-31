class CashBox100 {
    Integer cashBox = 0

    void plus(Integer input) {
        cashBox += input
    }

    void minus(Integer input) {
        cashBox -= input
    }

    Integer cashBoxContent() {
        return cashBox
    }
}
