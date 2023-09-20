public class AccountAnonymous {
    public int ID; // суррогатный ключ
    public int BankID; // внешний ключ для связи с моделью Bank
    public float AggrementID; // внешний ключ для связи с моделью Agreement;
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

    public int getID() {
        return ID;
    }

    public int getBankID() {
        return BankID;
    }

    public float getAggrementID() {
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


    public static void main(String[] args) {


        Bank BANK = new Bank();
        AccountAnonymous[] accounts = new AccountAnonymous[3];
        AccountAnonymous admin = new AccountAnonymous();
        admin.setAccountNumber(999);
        admin.setBankID(BANK.getID());
        admin.setTypeAccount("Управленченский");
        admin.setTypeID(3);

        // accounts.Methods(accounts, admin);

        // Account accountObject = new Account();
        // accountObject.printAllInformation(accountObject);

        // BANK.printAllInformation(BANK);

        // Account InputAccounts = new Account();

        Account AccountsAnonymousMethoud = new Account() {
            public void responseTypeOfAdmin(Account tmp_admin) {
                System.out.println("Account ID\t" + tmp_admin.getID() + "TYPE -" + tmp_admin.getTypeAccount());
            }

            public void enterDataToAccount(Account tmp_acc) {

            }

            public void printAllInformationAboutEveryone(Account[] tmp_acc) {
                for (Account a : tmp_acc) {
                    System.out.println("---Account Information---\n");
                    System.out.println("Account identifier = " + a.getID() + "\n");
                    System.out.println("Type of Account = " + a.getTypeAccount() + "\n");
                    System.out.println("Account Number = " + a.getAccountNumber() + "\n");

                    System.out.println("\n---\n" + "Bank identifier = " + a.getBankID() + "\n");

                }
            }

        };

        Account accountmanipulation = new Account() {

        };
        // accountmanipulation.enterDataToAccount();

        Bank bankmanipulation = new Bank() {
            public void enterDataToBank() {

            }
        };


    }

}