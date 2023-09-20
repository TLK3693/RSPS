import java.util.List;

import java.util.Scanner;

public class Account implements AccountInterface {
    public int ID; // суррогатный ключ
    public int BankID; // внешний ключ для связи с моделью Bank
    public double AggrementID; // внешний ключ для связи с моделью Agreement;
    public int TypeID; // тип счета (брокерский, дилерский, управления).
    public int AccountNumber; // номер инвестиционного счета.
    public String TypeAccount; //  TypeAccount – тип счета (брокерский, дилерский, управления).

    {
        ID = 0;
        BankID = 0;
        AggrementID = (float) 0.0;
        TypeID = 0;
        AccountNumber = 0;
        TypeAccount = "";
    }


    Account(){}
    Account(int ID, int BankID,double AggrementID, int TypeID, int AccountNumber, String TypeAccount ){
        this.ID = ID;
        this.BankID = BankID;
        this.AggrementID = AggrementID;
        this.TypeID = TypeID;
        this.AccountNumber = AccountNumber;
        this.TypeAccount = TypeAccount;
    }

    public int getID() {
        return ID;
    }

    public int getBankID() {
        return BankID;
    }

    public double getAggrementID() {
        return AggrementID;
    }

    public int getTypeID() {
        return TypeID;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public String getTypeAccount() {
        return TypeAccount;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setBankID(int bankID) {
        BankID = bankID;
    }

    public void setAggrementID(float aggrementID) {
        AggrementID = aggrementID;
    }

    public void setTypeID(int typeID) {
        TypeID = typeID;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public void setTypeAccount(String typeAccount) {
        TypeAccount = typeAccount;
    }

    public void responseTypeOfAdmin(Account admin) {
        System.out.println("---Admin Information---\n");
        System.out.println("Account identifier = " + admin.getID() + "\n");
        System.out.println("Type of Account = " + admin.getTypeAccount() + "\n");
        System.out.println("Account Number = " + admin.getAccountNumber() + "\n");

        System.out.println("\n---\n" + "Bank identifier = " + admin.getBankID() + "\n");

    }

    public void printAllInformationAboutEveryone(List<Account> accounts) {
        for (int index = 0;  index < accounts.size(); index++) {
            System.out.println("---Account Information---\n");
            System.out.println("Account identifier = " + accounts.get(index).getID() + "\n");
            System.out.println("Type of Account = " + accounts.get(index).getTypeAccount() + "\n");
            System.out.println("Account Number = " + accounts.get(index).getAccountNumber() + "\n");

            System.out.println("\n---\n" + "Bank identifier = " + accounts.get(index).getBankID() + "\n");

        }
    }

    public void enterDataAccount(List<Account> tmp_accounts, Account tmp_one_acc) {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println("---Enter Information to about user---\n");
            System.out.println("Account identifier, type of Account and Account Number" + '\n');

            tmp_one_acc.setID(myObj.nextInt());
            tmp_one_acc.setTypeAccount(myObj.nextLine());
            tmp_one_acc.setAccountNumber(myObj.nextInt());
            tmp_accounts.add(tmp_one_acc.getID(), tmp_one_acc);
            printAllInformationAboutEveryone(tmp_accounts);
        }
    }

}