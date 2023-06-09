package org.CodeForPizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account sup;


    @Test
    @DisplayName("should return 100 if balance is 100")
    void constructorIfBalanceIs100() {
        // Arrange
        int balance = 100;
        int accountNumber = 123456789;
        int expected = 100;

        // Act
        sup = new Account(balance, accountNumber);
        int result = sup.getBalance();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("should throw exception if Init-balance is negative")
    void constructorIfInititBalanceIsNegative() {
        // Arrange
        int accountNumber = 123456789;


        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Account(-100, accountNumber);
        });
    }


    @Test
    @DisplayName("should return 123456789 if account number is 123456789")
    void constructorIfAccountNrIs123456789() {
        // Arrange
        int balance = 100;
        int accountNumber = 123456789;
        int expected = 123456789;

        // Act
        sup = new Account(balance, accountNumber);
        int result = sup.getAccountNumber();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("should throw exception if account number is negative")
    void constructorIfAccountNrIsNegative() {
        // Arrange
        int accountNumber = -13456789;

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Account(100, accountNumber);
        });
    }

    @Test
    @DisplayName("should throw exception if account number is not 9 digits")
    void constructorIfAccountNrIsNot9digits() {
        // Arrange
        int value = 1234567890;

        // act and assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Account(100, value);
        });
    }


    @Test
    @DisplayName("Should return 200 if deposit 100")
    void depositIfAdd100() {
        // Arrange
        sup = new Account(100, 123456789);
        int value = 100;
        int expected = 200;

        // Act
        int result = sup.deposit(value);

        // Assert
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Should return Balance if deposit is 0 or less")
    void depositIfZero() {
        // Arrange
        sup = new Account(100, 123456789);
        int value = 0;

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            sup.deposit(value);
        });
    }


    @Test
    @DisplayName("Should return 0 if withdraw 100")
    void withdraw100() {
        // Arrange
        sup = new Account(100, 123456789);
        int value = 100;
        int expected = 0;

        // Act
        int result = sup.withdraw(value);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should throw exception if withdraw is 0 or less")
    void withdrawIfNegativNumber() {
        // Arrange
        sup = new Account(100, 123456789);
        int value = -100;

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            sup.withdraw(value);
        });
    }

    @Test
    @DisplayName("Should throw exception if withdraw is more then balance")
    void withdrawIfOverdrawnAccount() {
        // Arrange
        sup = new Account(100, 123456789);
        int value = 200;

        // act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            sup.withdraw(value);
        });
    }

    @ParameterizedTest
    @DisplayName("should pass if balance is same as Initial balance")
    //Just to try out parameterized test
    @CsvSource({"100,100", "0,0", "300,300"})
    void rightBalance(int value, int expected) {
        // Arrange
        sup = new Account(value, 123456789);

        // Act
        int result = sup.getBalance();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should pass if if balance is 100")
    void getBalanceIs() {
        // Arrange
        sup = new Account(100, 123456789);
        int expected = 100;

        // Act
        int result = sup.getBalance();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should pass if balance is not 100")
    void getBalanceIsNot100() {
        // Arrange
        sup = new Account(100, 123456789);
        int expected = 200;

        // Act
        int result = sup.getBalance();

        // Assert
        assertNotEquals(expected, result);
    }


    @Test
    @DisplayName("Should pass if account number is 123456789")
    void getAccountNumber123456789() {
        // Arrange
        sup = new Account(100, 123456789);
        int expected = 123456789;
        // Act
        int result = sup.getAccountNumber();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Should pass if account number is not 123456789")
    void getAccountNumberNot123456789() {
        // Arrange
        sup = new Account(100, 123456789);
        int expected = 1234789;
        // Act
        int result = sup.getAccountNumber();

        // Assert
        assertNotEquals(expected, result);
    }
}
