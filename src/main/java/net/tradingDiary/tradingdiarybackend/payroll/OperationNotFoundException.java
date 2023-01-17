package net.tradingDiary.tradingdiarybackend.payroll;

public class OperationNotFoundException extends RuntimeException {

    public OperationNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
