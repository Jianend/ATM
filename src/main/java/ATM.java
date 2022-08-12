import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("----------");
            System.out.println("1 登录账号");
            System.out.println("2 注册账号");
            System.out.println("----------");

            int login = scanner.nextInt();
            switch (login) {
                case 1:
                    boolean user = user(accounts);
                    if (user == false) {
                        System.out.println("当前系统没有账号");
                        break;
                    }
                    Account login1 = login(accounts, scanner);
                    if (login1 != null) {
                        System.out.println("登录成功");
                        LoginSuccessful(login1, scanner, accounts);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 2:
                    Account account = new Account();
                    Account enroll = enroll(account, scanner);
                    accounts.add(enroll);
                    break;


                default:
                    System.out.println("输入无效");
            }


        }
    }


    /**
     * 登录验证
     *
     * @param arrayList 账号集合
     * @param scanner   输入对象
     * @return Boolean
     */
    static Account login(ArrayList<Account> arrayList, Scanner scanner) {

        //卡号
        System.out.println("输入卡号");
        int CardNumber = scanner.nextInt();
        //输入密码
        System.out.println("密码");
        String password = scanner.next();
        for (int i = 0; i < arrayList.size(); i++) {
            Account account = arrayList.get(i);
            if (account.getCardNumber() == CardNumber) {
                if (account.getPassword().equals(password)) {
                    return account;
                }
            }
        }
        return null;

    }

    static Account enroll(Account account, Scanner scanner) {
        System.out.println("----------");
        System.out.println("输入名称");
        String name = scanner.next();
        account.setName(name);
        while (true) {
            System.out.println("输入密码");
            String password = scanner.next();
            System.out.println("确认密码");
            String password2 = scanner.next();
            if (password2.equals(password)) {
                account.setPassword(password);
                break;
            } else {
                System.out.println("两次密码输入不同");
            }

        }
        int CardNumber = (int) ((Math.random() * (10 * 8) + 1) + 100000);
        account.setCardNumber(CardNumber);
        System.out.println("姓名：" + account.getName() + " 卡号为 : " + account.getCardNumber());
        return account;

    }

    static void LoginSuccessful(Account account, Scanner scanner, ArrayList<Account> accounts) {
    while (true){
        System.out.println("------");
        System.out.println("1 账号信息");
        System.out.println("2 转账");
        System.out.println("3 存款");
        System.out.println("4 取钱");
        System.out.println("5 退出账号");
        System.out.println("6 注销账号");
        System.out.println("------");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("姓名：" + account.getName() + " 余额：" + account.getMoney() + " 卡号：" + account.getCardNumber());
                break;
            case 2:

                System.out.println("输入转账卡号");
                int getCardNumber = scanner.nextInt();

                System.out.println("输入转账多少元");
                double money = scanner.nextDouble();
                if (account.getMoney() < money) {
                    System.out.println("你的钱不够");
                    break;
                }
                double transfer = Transfer(account, money, accounts, getCardNumber);
                System.out.println("当前余额为：" + transfer);
                break;
            case 3:
                System.out.println("输入存款金额");
                double v = scanner.nextDouble();
                account.setMoney(account.getMoney() + v);
                System.out.println("当前余额为： " + account.getMoney());
                break;
            case 4:
                System.out.println("输入取款金额");
                double v1 = scanner.nextDouble();
                account.setMoney(account.getMoney()-v1);
                System.out.println("当前余额为： " + account.getMoney());
                break;
            case 5:
                return;
            case 6:
                accounts.remove(account);
                System.out.println("账号已删除");
                return;

        }
    }


    }

    /**
     * 判断账号是否存在
     *
     * @param accounts
     * @return
     */
    static boolean user(ArrayList<Account> accounts) {
        if (accounts.size() == 0) {
           // System.out.println("当前系统没有账号");
            return false;
        }


        return true;
    }

    static boolean user(ArrayList<Account> accounts, String name) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getName().equals(name)) {
                System.out.println("当前系统已有次账号");
                return false;
            }
        }
        return true;
    }

    static double Transfer(Account account, double money, ArrayList<Account> arrayList, int getCardNumber) {
        for (int i = 0; i < arrayList.size(); i++) {
            Account o = arrayList.get(i);
            if (o.getCardNumber() != getCardNumber) {
                System.out.println("卡号无效");
            } else {
                account.setMoney(account.getMoney() - money);
                o.setMoney(money);
            }
        }
        return account.getMoney();


    }


}
