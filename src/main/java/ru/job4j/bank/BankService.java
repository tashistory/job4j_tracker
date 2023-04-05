package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, ""), new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (passport.equals(user.getPassport())) {
            if (users.get(findByPassport(passport)).isEmpty()
                    || !users.get(findByPassport(passport)).contains(account)) {
                users.get(findByPassport(passport)).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        if (findByRequisite(srcPassport, srcRequisite) == null
                || findByRequisite(destPassport, destRequisite) == null) {
            return false;
        }
        if (findByRequisite(srcPassport, srcRequisite).getBalance() >= amount) {
            double amountDest = findByRequisite(destPassport, destRequisite).getBalance();
            double amountSrc = findByRequisite(srcPassport, srcRequisite).getBalance();
            findByRequisite(srcPassport, srcRequisite).setBalance(amountSrc - amount);
            findByRequisite(destPassport, destRequisite).setBalance(amountDest + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}