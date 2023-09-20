//import java.util.ArrayList;
public class Bank implements BankInterface{
    public int ID;
    public String NameFull;
    public String NameShort;
    public int Inn;
    public int Bik;
    public double KorAccount;
    public String Account;
    public String City;

    {
        ID = 123;
        NameFull = "AmazingBank";
        NameShort = "AB";
        Inn = 800968024;
        Bik = 612125541;
        KorAccount = 485195071;
        Account = "Admin";
        City = "Rostov-on-Don";
    }

    Bank(){}
    Bank(int ID, String NameFull,String NameShort, int Inn, int Bik, double KorAccount, String Account,String City ){
        this.ID = ID;
        this.NameFull = NameFull;
        this.NameShort = NameShort;
        this.Inn = Inn;
        this.Bik = Bik;
        this.KorAccount = KorAccount;
        this.Account = Account;
        this.City = City;
    }

    public int getID() {
        return ID;
    }

    public String getNameFull() {
        return NameFull;
    }

    public String getNameShort() {
        return NameShort;
    }

    public int getInn() {
        return Inn;
    }

    public int getBik() {
        return Bik;
    }

    public double getKorAccount() {
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

    public void setNameShort(String nameShort) {
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
    
    @Override
    public void Info(Bank tmp_bank) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Info'");
    }
}
