package Liste;

public class KNOTEN extends LISTENELEMENT
{
    private LISTENELEMENT nachfolger;
    private DATENELEMENT daten;

    public KNOTEN(DATENELEMENT d, LISTENELEMENT nf)     {
        daten = d;
        nachfolger = nf;
    }
    
    LISTENELEMENT NachfolgerGeben() {
        return nachfolger;
    }
    
    DATENELEMENT DatenelementGeben() {
        return daten;
    }
    
    int RestlaengeGeben() {   
        return nachfolger.RestlaengeGeben() +1;
    }
    
    KNOTEN HintenEinfuegen(DATENELEMENT dNeu)  {
        nachfolger = nachfolger.HintenEinfuegen(dNeu);
        return this;
    }
    
    LISTENELEMENT KnotenEntfernen(DATENELEMENT d)  {
        if (daten == d) {
            return nachfolger;
        }
        else {
            nachfolger = nachfolger.KnotenEntfernen(d);
            return this;
        }
    }

    DATENELEMENT EndeGeben(DATENELEMENT d)  {
        return nachfolger.EndeGeben(daten);
    }
}
