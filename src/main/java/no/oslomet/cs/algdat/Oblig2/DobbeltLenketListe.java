package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> start;          // peker til den første i listen
    private Node<T> slutt;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    // Hjelpemetode | nullSjekk
    private static <T> void nullSjekk(T verdi){
        //Sjekker om verdi er null
        if (verdi == null) {
            throw new NullPointerException("Ikke tillatt med null-verdier!"); //Gir ut en feil om at det ikke er tillatt med null-verdier
        } //Slutt | if-statement
    } //SLUTT | nullSjekk


    // hjelpemetode | finnNode
    private Node<T> finnNode(int indeks){
        Node<T> os; //Representerer en node i treklassen.
        //Sjekker om indeks er mindre eller lik (antall / 2)
        if (indeks <= antall / 2){
            os = start; //Sett variabel os til start
            for (int i = 0; i < indeks; i++){//Kjører en for-løkke for tellende opp til indeks
                os = os.neste; //Setter variabel os til neste-peker
            } //Slutt | for-løkke
        } else { //Hvis indeks ikke er mindre eller lik (antall / 2)
            os = slutt; //Sett variabel os til slutt
            for (int i = antall - 1; i > indeks; i--){ //Kjører en for-løkke for tellende ned til indeks
                os = os.forrige; //Setter variabel os til forrige-peker
            } //Slutt | for-løkke
        } return os; //Returnerer funnet node
    } //SLUTT | finnNode

    public DobbeltLenketListe(){
        start = slutt = null; //Setter både start og slutt variabelene til null
        antall = 0; //Setter antall variabelen til 0
        endringer = 0; //Setter antall-endringer variabelen til 0
    }

    public DobbeltLenketListe(T[] a){
        Objects.requireNonNull(a,"Kan ikke ha null verdier");
        antall = 0;

        if (a.length>0) {
            int teller = 0;
            for (int i = 0; i < a.length; i++){
                if (a[i] != null){
                    teller = i;
                    i = a.length-1;
                    break;
                }
                teller = i;
            }

            if (a[teller] != null) {
                T verdi = a[teller];
                Node<T> node = new Node<>(verdi, null, null);
                start = node;
                slutt = node;
                antall++;

                Node<T> p = slutt;

                for (int i = teller + 1; i < a.length; i++) {
                    if (a[i] != null) {
                        p.neste = new Node<>(a[i], p, null);
                        p = p.neste;
                        antall++;
                    }
                }
                slutt = p;
            }
        }
    } //SLUTT | DobbeltLenketListe


    @Override
    public boolean leggInn(T verdi){
        Objects.requireNonNull(verdi); //Innebygd JAVA-funksjon | Sjekker at den angitte variabelen ikke er null, og kaster en tilpasset NullPointerException hvis den er det.
        if(start == null){
            Node<T> node = new Node<>(verdi,null,null);
            start = node;
            slutt = node;
            antall++;
            endringer++;
            return true;
        } else {
            Node<T> p = slutt;
            while (p.neste != null){
                p = p.neste;
            }

            p.neste = new Node<>(verdi,p,null);
            slutt = p.neste;
            antall++;
            endringer++;
            return true;
        } //Slutt | if-statement
    } //SLUTT | leggInn



    @Override
    public void leggInn(int indeks, T verdi) {
        nullSjekk(verdi); //Kjører funksjon nullsjekk av verdi

        if (indeks < 0){ throw new IndexOutOfBoundsException("Indeks " + indeks + " er negativ!"); }

        if (indeks > antall){ throw new IndexOutOfBoundsException("Indeks " + indeks + " er større enn tabellen"); }

        if (antall == 0){
            Node<T> nyNode = new Node(verdi,null,null);
            start = nyNode;
            slutt = nyNode;
        }
        else if (indeks == 0){
            Node<T> p = start;
            Node<T> nyNode = new Node<>(verdi,null,p);
            p.forrige = nyNode;
            start = nyNode;
        }
        else if (indeks == antall){
            Node<T> p = slutt;
            p.neste = new Node<>(verdi,p,null);
            slutt = p.neste;
        }
        else {
            Node<T> p = finnNode(indeks);
            Node<T> q = finnNode(indeks-1);
            Node<T> nyNode = new Node<>(verdi,p.forrige,p);
            p.forrige = nyNode;
            q.neste = nyNode;
        }
        antall++; // Oppdaterer antall - variabelen
        endringer++; // Oppdaterer endringer - variabelen
    } //SLUTT | leggInn


    @Override
    public int indeksTil(T verdi) {
        if(verdi == null) return -1;
        Node<T> curr = start;
        int i =0;
        while(i<antall){
            if(curr.verdi.equals(verdi)){
                return i;
            }
            curr = curr.neste;
            i++;
        }
        return -1;
    }


    private void kobleNode(Node<T> left, Node<T> right){
        left.neste = right; //Setter om left.neste til verdien av right
        right.forrige = left; //Setter om right.forrige til verdien av left
    } //SLUTT | kobleNode

    private void kobleFraNode(Node<T> node){
        if(node == start){ //Sjekker om node er lik som start-verdi
            if(start.neste == null){ //Sjekker om start.neste verdi er lik null
                start = null; //Sett start-variabel til null
                slutt = null; //Sett slutt-variabel til null
            } else { //Hvis start.neste verdi ikke er lik null
                start = start.neste; //Sett start-variabelen til start.neste-verdien
                start.forrige = null; //Sett start.forrige-variabelen til null
            } //Slutt | if-statement
        } else if(node == slutt){ //Sjekker om node er lik som slutt-verdi
            if(slutt.forrige == null){ //Sjekker om slutt.forrige verdi er lik null
                slutt = null; //Sett slutt-variabel til null
                start = null; //Sett start-variabel til null
            } else { //Hvis slutt.forrige verdi ikke er lik null
                slutt = slutt.forrige; //Sett slutt-variabelen til slutt.forrige-verdien
                slutt.neste = null; //Sett slutt.neste-variabelen til null
            } //Slutt | if-statement
        } else {
            kobleNode(node.forrige, node.neste); //Kjør funksjon kobleNode med verdier fra node.forrige og node.neste
        } //Slutt | if-statement
    } //SLUTT | kobleFraNode

    @Override
    public boolean fjern(T verdi) {
        if(verdi == null){ //Sjekker om verdi er lik null
            return false; //Isåfall returner false
        } //Slutt | if-statement

        //Kjører en for-løkke med verdier fra T verdi
        for (Node<T> current = start; current != null; current = current.neste){
            if(verdi.equals(current.verdi)){ //Sammenligner verdi.equals med current.verdi
                antall--; //Fjerner 1 fra antall-variabelen
                endringer++; //Legger til 1 i endringer-variabelen
                kobleFraNode(current); //Kjører funksjonen kobleFraNode med verdien current
                return true; //Returner true
            } //Slutt | if-statement
        } //Slutt | for-løkke
        return false; //Returner false
    } //SLUTT | fjern

    @Override
    public T fjern(int indeks){
        indeksKontroll(indeks, false);
        Node<T> node;
        if(indeks < (antall / 2)){
            node = start;
            for(int  i = 0; i < indeks; i++){
                node = node.neste;
            } //Slutt | for-løkke
        } else {
            node = slutt;
            for(int i = antall - 1; i > indeks; i--){
                node = node.forrige;
            }
        } //Slutt | if-statement
        kobleFraNode(node);
        antall--;//Fjerner 1 fra antall-variabelen
        endringer++; //Legger til 1 i endringer-variabelen

        return node.verdi;
    } //SLUTT | fjern

    @Override
    public void nullstill(){
        Node<T> current = start;
        Node<T> tmp;
        while (current != null){
            tmp = current.neste;
            current.forrige = null;
            current.verdi = null;
            current.neste = null;
            current = tmp;
        } //Slutt | while-løkke
        antall = 0;
        endringer++; //Legger til 1 i endringer-variabelen
        start = null;
        slutt = null;
    } //SLUTT | nullstill

    @Override
    public String toString() {
        StringJoiner s=new StringJoiner(", ","[","]");
        Node<T> current = start;
        while(current!=null){
            s.add(current.verdi.toString());
            current = current.neste;
        }
        return s.toString();
    }

    /* public String omvendtString(){
         StringBuilder s = new StringBuilder(); //Produserer en ny Stringbuilder i Stringbuilder s
         s.append('['); //Legger til start-tegn i variabelen s
         if (!tom()){ //Sjekker om string ikke er tom
             s.append(slutt.verdi); //Legg til slutt.verdi i s-variabel Stringen
             for (Node<T> os = slutt.forrige; os != null; os = os.forrige){ //For-løkke som kjører med verdier fra os-variabelen
                 s.append(", ").append(os.verdi);//Legg til ulike tegn og os.verdi i s-variabel Stringen
             } //Slutt | for-løkke
         } //Slutt | if-statement
         s.append("]");
         return s.toString(); //Returnerer s-variabel Stringen
     } //SLUTT | omvendtString
     */
    public String omvendtString() {
        StringJoiner s=new StringJoiner(", ","[","]");
        Node<T> current = slutt;
        while(current!=null){
            s.add(current.verdi.toString());
            current = current.forrige;
        }
        return s.toString();
    }




    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false);     // sjekker om lovlig indeks
        Node<T> p = finnNode(indeks);            // Bruker metoden: finnNode()
        return p.verdi;
        //throw new UnsupportedOperationException();
    }


    @Override
    public T oppdater(int indeks, T nyverdi) {
        if (indeks <0 || indeks >= antall){         // Sjekker at indeks er lovlig
            throw new IndexOutOfBoundsException("Indeks er ikke innenfor lovlig grense");
        }

        if (nyverdi == null){                       // sjekker om indeks er null
            throw new NullPointerException("Verdi kan ikke være null");
        }
        T verdi = null;
        Node<T> p = start;
        for (int i = 0; i < antall; i++){      // Lager en for-løkke som finner Noden på posisjon, indeks, og oppdaterer verdien
            if (i == indeks){                  // sjekker om indeks er funnet
                verdi = p.verdi;               // Lagrer noden sin tidligere verdi
                p.verdi = nyverdi;             // setter noden sin verdi lik ny verdi.
                endringer += 1;                // Oppdaterer antall endringer
            }
            p = p.neste;
        }
        return verdi;                           // returnerer noden sin tidligere verdi.
        // throw new UnsupportedOperationException();
    }

    private static void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");
        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }
    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall,fra,til);
        DobbeltLenketListe<T> ret = new DobbeltLenketListe<>();
        for (int i = fra; i < til; i++){
            ret.leggInn(hent(i));
        }
        return ret;
        // throw new UnsupportedOperationException();
    }
    @Override
    public int antall() {
        return antall;
    }
    @Override
    public boolean tom() {
        return antall == 0;
    }
    @Override
    // oppgave8b
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }
    //oppgave 8d
    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks,false);
        return new DobbeltLenketListeIterator(indeks);
    }
    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;
        private DobbeltLenketListeIterator() {
            denne = start;     // os starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }
        //oppgave 8c
        private DobbeltLenketListeIterator(int indeks){
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }
        @Override
        public boolean hasNext() {
            return denne != null;
        }
        // oppgave 8a
        @Override
        public T next(){
            if(endringer != iteratorendringer)
                throw new ConcurrentModificationException("Endringer er ikke oppdatert riktig");
            if(!hasNext())
                throw new NoSuchElementException("Listen har nådd siste noden");
            fjernOK = true;
            T returVerdi = denne.verdi;
            denne = denne.neste;
            return returVerdi;
        }
        @Override
        public void remove(){
            if(tom() || !fjernOK)
                throw new IllegalStateException("The list i empty");
            if(endringer!=iteratorendringer)
                throw new ConcurrentModificationException("Changes are"+
                        " not equal.");
            fjernOK = false;
            //listen har et element:
            if (start == slutt) {
                start = slutt = null;
            }
            //denne har gåt over slutt(hale):
            else if (denne==null) {
                slutt.forrige.neste = null;
                slutt = slutt.forrige;
            }
            //hvis pekeren er start(hode) eller start sin start node:
            else if (denne == start.neste) {
                denne.forrige = null;
                start = denne;
            }else if(denne==start){
                start = denne.neste;
                denne.neste.forrige=null;
                denne = null;
            }
            //ellers saa start(hode) er ingen av tilfellene over og denne peker paa et
            //tilfeldig node i midten:
            else {
                denne.forrige.forrige.neste = denne;
                denne.forrige = denne.forrige.forrige;
            }
            iteratorendringer++;
            endringer++;
            antall--;
        }
    } // class DobbeltLenketListeIterator

    public static<T> int partisjon(Liste<T> liste, int begin, int end, Comparator<? super T> c){
        int left = begin;
        int right = end;

        for (int i = begin; i < end; i++){

            if (c.compare(liste.hent(i),liste.hent(right)) < 0){
                T temp = liste.hent(left);
                liste.oppdater(left,liste.hent(i));
                liste.oppdater(i,temp);
                left++;
            }
        }
        T temp = liste.hent(left);
        liste.oppdater(left,liste.hent(right));
        liste.oppdater(right, temp);
        return left;
    }

    public static<T> void quicksort(Liste<T> liste, int fra, int til, Comparator<? super T> c){
        if (til <= fra){
            return;
        }
        int pivot = partisjon(liste,fra,til,c);
        quicksort(liste,fra,pivot-1,c);
        quicksort(liste,pivot+1,til,c);
    }

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {

        if (liste.antall() == 0 || liste.antall() == 1){
            return;
        }
        quicksort(liste,0,liste.antall()-1,c);
    }
} // class DobbeltLenketListe


