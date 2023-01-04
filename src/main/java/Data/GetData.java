package Data;

public class GetData {


    public enum URL {

        MASTER("https://www.hangikredi.com/"), //GetDataProperties yapısı kurulabilir farklı linkler olursa.
        TEST("cloudUrl"),
        PERSONAL_FINANCE_CREDIT("https://www.hangikredi.com/kredi/ihtiyac-kredisi"),
        CALCULATE_CREDIT("https://www.hangikredi.com/kredi/hesaplama-araclari"),
        ;

        public String value;

        URL(String value) {
            this.value = value;
        }
    }
}
