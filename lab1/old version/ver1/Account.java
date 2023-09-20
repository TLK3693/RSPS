public class Account implements AccountInterfaces {
    public int ID; // суррогатный ключ
    public int BankID; // внешний ключ для связи с моделью Bank
    public float AggrementID; // внешний ключ для связи с моделью Agreement;
    public int TypeID; // тип счета (брокерский, дилерский, управления).
    public int AccountNumber; //  номер инвестиционного счета.
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

    //----
    public void printAllInformationAboutEveryone(Account[] tmp_acc);

    public void enterDataToAccount();

    public void responseTypeOfAdmin(AccountAnonymous admin) {
    }

}