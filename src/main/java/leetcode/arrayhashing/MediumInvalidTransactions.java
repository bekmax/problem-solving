package leetcode.arrayhashing;

import java.util.*;

/**
 * N1169. Invalid Transactions
 * A transaction is possibly invalid if:
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * You are given an array of strings transaction where transactions[i] consists of comma-separated values
 * representing the name, time (in minutes), amount, and city of the transaction.
 * Return a list of transactions that are possibly invalid. You may return the answer in any order.
 */
public class MediumInvalidTransactions {
    public static void main(String[] args) {
        String[] transactions = {"alice,120,800,mtv", "alice,50,100,beijing"};

        System.out.println(invalidTransactions(transactions));
    }

    public static List<String> invalidTransactions(String[] transactions) {
        if (transactions == null || transactions.length == 0){
            return new ArrayList<>();
        }
        List<Transaction> transactionList = new ArrayList<>();
        for (String s : transactions) {
            String[] split = s.split(",");
            transactionList.add(new Transaction(
                    split[0],
                    Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]),
                    split[3]));
        }

        List<String> result = new ArrayList<>();
        for (Transaction t : transactionList) {
            if (!isTransactionValid(t, transactionList)) {
                result.add(t.toString());
            }
        }

        return result;
    }

    private static boolean isTransactionValid(Transaction transaction, List<Transaction> transactions) {
        if (transaction.amount > 1000) {
            return false;
        }
        for (Transaction t : transactions) {
            if (transaction.name.equals(t.name) && !transaction.city.equals(t.city)) {
                if (Math.abs(transaction.time - t.time) <= 60) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;
        boolean valid;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.valid = true;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}
