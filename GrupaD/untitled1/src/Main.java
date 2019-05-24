public class Main {

    public static void main(String[] args) {

        boolean p,q;

        p=false;
        q=false;

        boolean wyrazenie = !(p||q)==(!p&&!q);


        if(wyrazenie){
            wyswietl("Wyrażenie jest prawdziwe");
        }else{
            wyswietl("Nie jest prawdziwe");
        }


    }

    static void wyswietl(String napis){
        System.out.println(napis);
    }
}
