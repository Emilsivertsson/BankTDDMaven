package org.CodeForPizza;

/**
 * @author Emil
 */
public class Account {
    //initiate variables
    int balance;

    int accountNumber;

    //initiate constructor
    public Account(int initalCash, int accountNumber) {
        if(initalCash < 0) {
            throw new IllegalArgumentException("You can't have a negative balance");
        } else {
            this.balance = initalCash;
        }
        if(String.valueOf(accountNumber).length() != 9) {
            throw new IllegalArgumentException("You can't have an account number that is not 9 digits long");
        }
        else if (accountNumber < 0) {
            throw new IllegalArgumentException("You can't have a negative account number");
        } else {
            this.accountNumber = accountNumber;
        }

    }

    /**
     *
     * @param cash takes the amout of cash to deposit
     * @return returns the new balance
     */
    public int deposit(int cash) {

        if (cash == 0) {
            return balance;
        }
        else if (cash > 0) {
            balance += cash;
        }

        return balance;

    }

    /**
     *
     * @param cash takes the amout of cash to withdraw
     * @return returns the new balance
     */
    public int withdraw(int cash) {
        if ( balance < cash) {
            throw new IllegalArgumentException("You can't withdraw more than you have");
        }
        else if (cash == 0) {
            throw new IllegalArgumentException("You can't withdraw 0");
        }
        else if (cash > 0) {
            balance -= cash;
        }

        return balance;
    }

    /**
     *
     * @return returns the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     *
     * @return returns the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }
}