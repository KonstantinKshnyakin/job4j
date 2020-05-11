package ru.job4j.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        Optional<List<Account>> accounts = Optional.empty();
        if (user.isPresent()) {
            accounts = Optional.of(users.get(user.get()));
        }
        if (accounts.isPresent() && !accounts.get().contains(account)) {
            accounts.get().add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<List<Account>> accounts = Optional.empty();
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
             accounts = Optional.of(users.get(user.get()));
        }
        if (accounts.isPresent()) {
            return accounts.get().stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return rsl;
    }
}
