package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Модель для банковской системы.
  * В классе реализованны следующие действия.
 * 1. Регистрирует пользователя.
 * 2. Удаляет пользователя из системы.
 * 3. Добавляет пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводит деньги с одного банковского счета на другой счет.
 * @author Semyon
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод приниает на вход принимает пользовтаеля, создаёт ему пустой массив счетов и добавляет в карту.
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя. На вход принимает номер паспорта.
     * @param passport номер паспорта
     * @return возвращает true если пользователь существует.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет счета пользавателю. На вход принимает номер паспорта и номер счёта.
     * В методе присутсвуют проверки существования пользователя и одинаковых номеров счетов.
     * @param passport номер паспорта
     * @param account номер счёта
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * метод реализует поиск пользователя по номеру паспорта. На вход принимает номер паспорта.
     * Если пользователь не найден, возвращается null.
     * @param passport номер паспорта
     * @return пользователь
     */
    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск номер счёта у пользователя. На вход принимает номер паспорта и номер счёта.
     * В методе реализована проверка на наличие пользователя и номера счёта.
     * @param passport номер паспорта
     * @param requisite номер счёта
     * @return состояние счёта
     */
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

    /**
     * Метод осуществляет баковскую транзакцию мкжду пользователями. Метод принимает на себя номера паспортов
     * и номера счетов участников транзакции. Метод реализует предварительную проверку состояния счёта инициатора
     * денежного перевода. Метод возвращает булеве значение завершения транзакции
     * @param srcPassport номер паспорта инициатора транзакции
     * @param srcRequisite номер счёта инициатора транзакции
     * @param destPassport номер паспорта получателя денежного превода
     * @param destRequisite номер счёта получателя денежного превода
     * @param amount
     * @return результат выполнения транзакции
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src == null || dest == null || src.getBalance() < amount) {
            return false;
        }
        src.setBalance(src.getBalance() - amount);
        dest.setBalance(dest.getBalance() + amount);
        return true;
    }

    /**
     * Метод реализует получение состояние счетов пользовтеля. Метод принимает пользователя.
     * @param user пользователь
     * @return массив счетов
     */

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}