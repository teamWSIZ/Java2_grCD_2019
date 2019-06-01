public class Main {
    @FunctionalInterface
    private interface wyrazenieLogiczne{
        boolean wyrazenie(boolean p, boolean q);
    }


    public static void main(String[] args) {

        System.out.println("----------Koniunkcja-----------");
        wyswietlTabele(true,true, (p,q)->p&&q);
        System.out.println("_______________________________");


        System.out.println("----------Alternatywa----------");
        wyswietlTabele(true,true, (p,q)->p||q);
        System.out.println("_______________________________");

        System.out.println("----------I Prawo de Morgana----------");
        wyswietlTabele(true,true, (p,q)->!(p||q)==(!p&&!q));
        System.out.println("_______________________________");

        System.out.println("----------II Prawo de Morgana----------");
        wyswietlTabele(true,true, (p,q)->!(p&&q)==(!p||!q));
        System.out.println("_______________________________");


    }

    static void wyswietlTabele(boolean p, boolean q, wyrazenieLogiczne wyrazenie){

        System.out.println("p  "+"  q  "+"  wyrazenie  ");
        System.out.println("_______________________");

        System.out.println();

        wyswietlPQ(true,true, wyrazenie);
        wyswietlPQ(true,false, wyrazenie);
        wyswietlPQ(false,true, wyrazenie);
        wyswietlPQ(false,false, wyrazenie);

    }

    static void wyswietlPQ(boolean p, boolean q, wyrazenieLogiczne wyrazenie){
        int lp, lq;

        if(p)lp = 1; else lp = 0;
        if(q)lq = 1; else lq = 0;

        System.out.println(lp+"    "+lq+"    "+wyrazenie.wyrazenie(p,q));
    }
}
