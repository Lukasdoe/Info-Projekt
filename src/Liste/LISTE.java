package Liste;

public class LISTE
{
    private LISTENELEMENT anfang;

    public LISTE()
    {
        anfang = new ABSCHLUSS();
    }
    
    public int LaengeGeben() {       
        return anfang.RestlaengeGeben();
    }
    
    public void VorneEinfuegen(DATENELEMENT dNeu) {
        anfang = new KNOTEN(dNeu, anfang);
    }
    
    public void HintenEinfuegen(DATENELEMENT dNeu)  {
        anfang = anfang.HintenEinfuegen(dNeu);
    }
    
    public DATENELEMENT VorneEntfernen()  {
        DATENELEMENT d = anfang.DatenelementGeben();
        anfang = anfang.NachfolgerGeben();
        return d;   
    }
    
    public void KnotenEntfernen(DATENELEMENT d)  {
        anfang = anfang.KnotenEntfernen(d);       
    }
    
    public DATENELEMENT EndeEntfernen()  {
        DATENELEMENT d = anfang.EndeGeben(null);
        anfang = anfang.KnotenEntfernen(d);
        return d;
    }
}
