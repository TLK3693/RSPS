public class Bank implements BankInterfaces{
    public int ID;
    public String NameFull;
    public int NameShort;
    public int Inn;
    public int Bik;
    public int KorAccount;
    public String Account;
    public String  City;

    {
        ID = 123;
        NameFull = "";
        NameShort = 0;
        Inn = 0;
        Bik = 0;
        KorAccount = 0;
        Account = "";
        City = "";
    }

    public int getID() {
        return ID;
    }

    public String getNameFull() {
        return NameFull;
    }

    public int getNameShort() {
        return NameShort;
    }

    public int getInn() {
        return Inn;
    }

    public int getBik() {
        return Bik;
    }

    public int getKorAccount() {
        return KorAccount;
    }

    public String getAccount() {
        return Account;
    }

    public String getCity() {
        return City;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setNameFull(String nameFull) {
        NameFull = nameFull;
    }

    public void setNameShort(int nameShort) {
        NameShort = nameShort;
    }

    public void setInn(int inn) {
        Inn = inn;
    }

    public void setBik(int bik) {
        Bik = bik;
    }

    public void setKorAccount(int korAccount) {
        KorAccount = korAccount;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public void setCity(String city) {
        City = city;
    }

    //---
    public void printAllInformation(Bank tmp_bank) {
        System.out.println("---Bank Information---\n");
        System.out.println("Bank identifier = " + tmp_bank.ID + "\n");
        System.out.println("Bank Full Name = " + tmp_bank.NameFull + "\n");
        System.out.println("Bank Short Name = " + tmp_bank.NameShort + "\n");
        System.out.println("Bank INN = " + tmp_bank.Inn + "\n");
        System.out.println("Bank Bik = " + tmp_bank.Bik + "\n");
        System.out.println("Bank Kor = " + tmp_bank.KorAccount + "\n");
        System.out.println("City of Bank = " + tmp_bank.City + "\n");

    }

    @Override
    public void enterDataToBank() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterDataToBank'");
    }
}