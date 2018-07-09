package Graph;

public class GRAPH_MATRIX
{

    private int anzahlKnoten;
    private KNOTEN[] knoten;
    private int[][] matrix;

    public GRAPH_MATRIX(int maxKnoten)
    {
        anzahlKnoten = 0;
        knoten = new KNOTEN[maxKnoten];
        matrix = new int[maxKnoten][maxKnoten];

    }

    public void KnotenEinfuegen(String bezeichner)  {
        if ((anzahlKnoten < knoten.length) && 
        (KnotenNummerGeben(bezeichner) == -1))  {
            knoten[anzahlKnoten] = new KNOTEN(bezeichner);
            matrix[anzahlKnoten][anzahlKnoten] = 0;

            for (int i = 0; i<anzahlKnoten; i++) {
                matrix[i][anzahlKnoten] = -1;
                matrix[anzahlKnoten][i] = -1;
            }
            anzahlKnoten++;
        }
    }

    public void KanteEinfuegen(String von, String nach, int gewicht)  {
        int vonNummer = KnotenNummerGeben(von);
        int nachNummer = KnotenNummerGeben(nach);

        if ((vonNummer > -1) && (nachNummer > -1) && 
        (vonNummer != nachNummer)) {
            matrix[vonNummer][nachNummer] = gewicht;
            matrix[nachNummer][vonNummer] = gewicht;
        }
    }

    public int KnotenNummerGeben(String bezeichner)  {
        int erg = -1;
        for (int i = 0; (i<anzahlKnoten) && (erg == -1); i++)  {
            if (knoten[i].BezeichnungGeben().equals(bezeichner)) {
                erg = i;
            }
        }
        return erg;
    }

    public String KnotenBezeichnerGeben(int knotenNummer)  {
        if ((knotenNummer >= 0) && (knotenNummer < knoten.length)) {
            return knoten[knotenNummer].BezeichnungGeben();
        } 
        else
            return "";
    }
    
    public void Ausgeben() {
        int breite = 5;
        System.out.print(("      ").substring(0, breite-1));
        for (int k = 0; k<anzahlKnoten; k++) {
            System.out.print(knoten[k].BezFormatGeben(breite));
        }
        System.out.println();
        for (int i = 0; i < anzahlKnoten; i++) {
            System.out.print(knoten[i].BezFormatGeben(breite));
            for (int j = 0; j < anzahlKnoten; j++) {
                System.out.print((matrix[i][j] + "      ").substring(0, breite-1));
            }
            System.out.println();
        }
    }
}