package Liste;

public interface DATENELEMENT
{
    void InformationAusgeben();
    boolean SchluesselIstGleich(int i);
    boolean IstGleich(DATENELEMENT d);
    boolean IstGroesser(DATENELEMENT d);
    int getNumber();
}
