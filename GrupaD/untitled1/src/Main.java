public class Main {

    public static void main(String[] args) {

        boolean p,q;

        p=false;
        q=false;

        boolean wyrazenie = !(p||q)==(!p&&!q);


        wyswietlTabele();


    }

    static void wyswietlTabele(){

        System.out.println("p  "+"  q  "+"  wyrazenie  ");
        System.out.println("_______________________");

        System.out.println();

        wyswietlPQ(true,true);
        wyswietlPQ(true,false);
        wyswietlPQ(false,true);
        wyswietlPQ(false,false);


    }

    static void wyswietlPQ(boolean p, boolean q){
        int lp, lq;

        if(p)lp = 1; else lp = 0;
        if(q)lq = 1; else lq = 0;

        System.out.println(lp+"    "+lq);
    }

    static void wyswietl(String napis){
        System.out.println(napis);
    }
}
