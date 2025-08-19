package Entities;

import enums.AccountType;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    public static final BigDecimal interest_rate = new BigDecimal(4);
    public static final BigDecimal minimum_balance = new BigDecimal(0);

    public CurrentAccount(String accountNo, String customerId, BigDecimal initialBalance){
    }

    public CurrentAccount(String accountNo, String customerId, AccountType type, BigDecimal balance) {
        super(accountNo, customerId, type, balance);
    }

    @Override
    public BigDecimal getInterest_rate(){
        return interest_rate;
    }
    @Override
    public BigDecimal getMinimum_balance(){
        return minimum_balance;
    }
    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNo='" + getAccountNo() + '\'' +
                ", customerId='" + getCustomerId() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }

}
