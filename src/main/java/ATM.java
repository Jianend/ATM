import popj.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts = user.usernames(accounts);

        while (true) {
            System.out.println("----------");
            System.out.println("1 ��¼�˺�");
            System.out.println("2 ע���˺�");
            System.out.println("----------");

            int login = scanner.nextInt();
            switch (login) {
                case 1:
                    boolean user = user(accounts);
                    if (user == false) {
                        System.out.println("��ǰϵͳû���˺�");
                        break;
                    }
                    Account login1 = login(accounts, scanner);
                    if (login1 != null) {
                        System.out.println("��¼�ɹ�");
                        LoginSuccessful(login1, scanner, accounts);
                    } else {
                        System.out.println("��¼ʧ��");
                    }
                    break;
                case 2:
                    Account account = new Account();
                    Account enroll = enroll(account, scanner);
                    accounts.add(enroll);
                    break;


                default:
                    System.out.println("������Ч");
            }


        }
    }


    /**
     * ��¼��֤
     *
     * @param arrayList �˺ż���
     * @param scanner   �������
     * @return Boolean
     */
    static Account login(ArrayList<Account> arrayList, Scanner scanner) {

        //����
        System.out.println("�����˺�");
        String name = scanner.next();
        //��������
        System.out.println("����");
        String password = scanner.next();
        for (int i = 0; i < arrayList.size(); i++) {
            Account account = arrayList.get(i);
            if (account.getName().equals(name)) {
                if (account.getPassword().equals(password)) {
                    return account;
                }
            }
        }
        return null;

    }

    static Account enroll(Account account, Scanner scanner) {
        System.out.println("----------");
        System.out.println("��������");
        String name = scanner.next();
        account.setName(name);
        while (true) {
            System.out.println("��������");
            String password = scanner.next();
            System.out.println("ȷ������");
            String password2 = scanner.next();
            if (password2.equals(password)) {
                account.setPassword(password);
                break;
            } else {
                System.out.println("�����������벻ͬ");
            }

        }
        System.out.println("������" + account.getName() );
        return account;

    }

    static void LoginSuccessful(Account account, Scanner scanner, ArrayList<Account> accounts) {
    while (true){
        System.out.println("------");
        System.out.println("1 �˺���Ϣ");
        System.out.println("2 ת��");
        System.out.println("3 ���");
        System.out.println("4 ȡǮ");
        System.out.println("5 �˳��˺�");
        System.out.println("6 ע���˺�");
        System.out.println("------");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                System.out.println("������" + account.getName() + " ��" + account.getMoney() );
                break;
            case 2:

                System.out.println("����ת���˺�");
                String username = scanner.next();

                System.out.println("����ת�˶���Ԫ");
                double money = scanner.nextDouble();
                if (account.getMoney() < money) {
                    System.out.println("���Ǯ����");
                    break;
                }
                double transfer = Transfer(account, money, accounts,username);
                System.out.println("��ǰ���Ϊ��" + transfer);
                break;
            case 3:
                System.out.println("��������");
                double v = scanner.nextDouble();
                account.setMoney(account.getMoney() + v);
                System.out.println("��ǰ���Ϊ�� " + account.getMoney());
                break;
            case 4:
                System.out.println("����ȡ����");
                double v1 = scanner.nextDouble();
                account.setMoney(account.getMoney()-v1);
                System.out.println("��ǰ���Ϊ�� " + account.getMoney());
                break;
            case 5:
                return;
            case 6:
                accounts.remove(account);
                System.out.println("�˺���ɾ��");
                return;

        }
    }


    }

    /**
     * �ж��˺��Ƿ����
     *
     * @param accounts
     * @return
     */
    static boolean user(ArrayList<Account> accounts) {
        if (accounts.size() == 0) {
           // System.out.println("��ǰϵͳû���˺�");
            return false;
        }


        return true;
    }

    static boolean user(ArrayList<Account> accounts, String name) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getName().equals(name)) {
                System.out.println("��ǰϵͳ���д��˺�");
                return false;
            }
        }
        return true;
    }

    static double Transfer(Account account, double money, ArrayList<Account> arrayList, String username) {
        for (int i = 0; i < arrayList.size(); i++) {
            Account o = arrayList.get(i);
            if (o.getName().equals(username)) {
                account.setMoney(account.getMoney() - money);
                o.setMoney(money);
            } else {
                System.out.println("û�д���");
            }
        }
        return account.getMoney();


    }


}
