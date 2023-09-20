import java.util.*;
public class BankAnonymous {
    public static void main(String[] args) {
        BankAnonymous myApp = new BankAnonymous();
        myApp.sayHello();
    }

    public void sayHello() {
        Account tom = new Account(
                1,
                123,
                0.0,
                1,
                123456,
                "брокерский"
        );

        Account kate = new Account(
                2,
                123,
                0.0,
                2,
                123457,
                "дилерский"
        );

        Account admin = new Account(
                3,
                123,
                0.0,
                3,
                123458,
                "управленческий"
        );

        List<Account> accounts = Arrays.asList(new Account[] { tom, admin, kate });
        admin.responseTypeOfAdmin(admin);
        System.out.println('\n');
        admin.printAllInformationAboutEveryone(accounts);


        Bank BANK = new Bank(123,"AmazingBank","AB",800968024,612125541,485195071,"Admin","Rostov-on-Don");

        Bank printAllInformationAboutBank = new Bank() {
            public void Info(Bank tmp_bank){
                System.out.println("---Bank Information---\n");
                System.out.println("Bank identifier = " + tmp_bank.getID() + "\n");
                System.out.println("Bank Full Name = " + tmp_bank.getNameFull() + "\n");
                System.out.println("Bank Short Name = " + tmp_bank.getNameShort() + "\n");
                System.out.println("Bank INN = " + tmp_bank.getInn() + "\n");
                System.out.println("Bank Bik = " + tmp_bank.getBik() + "\n");
                System.out.println("Bank Kor = " + tmp_bank.getKorAccount() + "\n");
                System.out.println("City of Bank = " + tmp_bank.getCity() + "\n");
            }

        };
        printAllInformationAboutBank.Info(BANK);


        Aggrement Deals = new Aggrement(){
            public void ShowDeals(){
                Map<Integer, String> states = new HashMap<Integer, String>();
                states.put(90, "RUB-DOL");
                states.put(10, "DOL-RUB");
                states.put(100, "RUB-EUR");
                states.put(50, "RUB-POUND");

                for(Map.Entry<Integer, String> item : states.entrySet()){
                    System.out.println("\n--Deals--\n");
                    System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
                }
            }
        };
        Deals.ShowDeals();

        //admin.enterDataAccount(accounts, admin);
    }
}