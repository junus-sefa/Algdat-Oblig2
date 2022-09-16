[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=463196&assignment_repo_type=GroupAssignmentRepo)
# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Junus Sefa, S344055, s344055@oslomet.no
* Meron Kidane, s354594, s354594@oslomet.no
* Jon Presthus, s350188, s350188@oslomet.no
* Louis Shrestha, s354384, s354384@oslomet.no
* Abdulahi Mohammad Farah, s333746, s333746@oslomet.no
# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Oppgave 1 ble jobbet på av : Junus Sefa, Louis
* Oppgave 2 ble jobbet på av : Junus Sefa, Jon, Meron 
* Oppgave 3 ble jobbet på av : Louis, Jon
* Oppgave 4 ble jobbet på av : Jon, Meron 
* Oppgave 5 ble jobbet på av :  Junus Sefa, Louis, Abdulahi
* Oppgave 6 ble jobbet på av :  Junus Sefa, 
* Oppgave 7 ble jobbet på av :  Junus Sefa, 
* Oppgave 8 ble jobbet på av :  Meron
* Oppgave 9 ble jobbet på av :  Meron 
* Oppgave 10 ble jobbet på av : Louis

# Oppgavebeskrivelse

 <h3>Oppgave 1</h3>
Lager to metoder:  antall() og tom()

Lager en konstruktør som lager en "dobbeltlenket" liste med verdier fra tabell a. Bruker metoden requireNonNull for å gi ut feilmelding om tabellen er tom. Deretter kjører en for løkke som luker ut verdiene i tabell a som ikke er null. Lager deretter Node med alle verdier i tabell a som ikke er null, og sortert i samme rekkefølge som i tabell a. Konstruktøren tar hensyn til følgende:

- Null tabell stoppes og kaster en NullPointerException
- Konstruktøren siler ut kun verdier som ikke er null fra tabell a
- Konstruktøren tar for seg om parametertabellen er tom, om den kun har null-verdier eller om det kun er en verdi som ikke er null
- Listen blir sortert i lik rekkfølge som tabell a er listet opp som.

<h3>Oppgave 2</h3> 
I oppgave 2a toString() løses oppgaven som følger:
       - Den starter med å lage en pekerkurr fra toppnoden, etter at
      den instansierer et StringJoiner -objekt med skilletegn "," og start -tegn "[" og slutttegn "]".
      Etter det har vi en stund -sløyfe som fortsetter til curr peker på null. dvs. etter halen.
      Og for hver iterasjon legges en streng med node verdien til, og deretter peker den til neste node ved å bruke det neste attributtet.
      Og for reverseString () bruker vi den samme logikken, men motsatt måte. fra hale til null.
      
I oppgave 2b for leggeinn T-verdi har vi først en parameter som sjekker "verdi!=null" etter at den har to tilfeller. Hvis listen er tom, så sier vi at start (hode) og slutt (hale) pekere er nodeverdi. I den andre tilfellet er hvis om listen har en eller flere noder, så sier vi nyNode den neste er null og den forrige er slutten (halen), slutten den neste er nyNodee og slutten (halen) er nå nyNode.


<h3>Oppgave 3</h3>
I metoden finnNode oppretter vi en node os. Hvis indeksparameter er mindre enn eller lik halvparten av lengden
til tabellen, leter vi fra start(hodet) og oppover. Da blir node os satt lik start. Hvis
indeks er større, leter vi fra halen og nedover. Da blir node os
satt lik slutt(hale). Vi bruker en for-løkke til å lete i nodene.
I metoden hent sjekkes det først om indeks er lovlig ved  bruk av
metoden indekskontroll. Vi oppretter en Node ved bruk av finnNode metoden.
I metoden, oppdater, opprettes en hjelpe-node p som settes lik
start(hodet). Deretter bruker vi en for-løkke som kaller p sin
neste til indeks er funnet. I metoden subliste oppretter vi en DobbeltLenket liste,
etterfulgt av en for-løkke som legger inn verdier ved bruk av leggInn metoden. 

<h3>Oppgave 4</h3>
 
 indeksTil metoden tar inn en verdi og sjekker om verdien finnes i listen. hvis verdien finnes i listen blir indeksen
 til første forekomst av verdien returnert. Metoden returnerer -1 hvis verdien som blir søkt etter er null eller hvis verdien
 ikke finnes i listen. Det brukes while løkke som søker gjennom listen og returnerer indeksen av verdien hvis den finnes. Ellers
 returners -1
 
 inneholder metoden bruker indexTil metoden for å finne ut om etterspurt verdi eksisterer i listen. hvis indexTil metoden returnerer -1 returneres false,
 hvis ikke returneres true.
 
 <h3>Oppgave 5</h3>
 Lager metoden leggInn(int indeks, T verdi) som plasserer spesifikk verdi på korrekt plass i listen. Metoden tar høyde for følgende:

- Sjekker om indeks er negativ, isåfall gis det ut en IndexOutOfBoundsException
- Sjekker om indeks er større enn tabell størrelsen, isåfall gis det ut en IndexOutOfBoundsException
- Sjekker om listen er tom, og isåfall settes start og slutt til den nye verdien
- Sjekker om indeks på den nye verdien er null, isåfall settes verdien først
- Sjekker om indeks på den nye verdien er lik antall fra listen, isåfall settes den nye verdien sist i listen
- Hvis ingen av de over er tilfelle, plasseres verdien på riktig indeks i forhold til listen.

 <h3>Oppgave 6</h3>
Lager to metoder fjern(int indeks) og fjern(T verdi): hvor den ene skal finne og returnere verdien på spesifikk indeks, og hvor den andre skal slette verdien og returnere om det er vellykket eller ikke. Bruker konstruktøren kobleFraNode til å trekke ut og slette verdien med spesifikk indeks fra listen, og setter start og slutt til riktig plassering.

<h3>Oppgave 7</h3>
I oppgave 7 lager vi metoden nullstill() som skal tømme listen og nulle ut alt. Bruker en while-løkke som finner alle verdier som ikke er null. Lagrer deretter en variabel "mellomtid" med neste indeks, som gjør at metoden får kjørt gjennom alle verdier i listen. Nuller deretter ut variabel forrige, verdi og neste. Og sånn kjører den til alle verdier som ikke er null i listen er gått igjennom. Setter til slutt variabel start og slutt til null ettersom alt er nullstilt.
  

<h3>Oppgave 8</h3> 
I Oppgave 8 har vi fulgt etter instruksjonen vi har fått fra oppgaven. 

<h3>Oppgave 9</h3>
I oppgave 9 Metoden starter med å kontrollere om listen er tom eller ikke, og om iteratorendringer er lik endringer.
I fjerningsmetoden sletter vi noden (denne) ved å ta hensyn til følgende:
  - når "dette" har passert slutteknuten(haleknuten).
  - når listen har et element, sletter den noden.
  - når "dette" er den neste noden av start(hode) , så blir selve hodet slettet (det er til venstre for dette).
  - når start(hode) == "dette", slettes start(hode) og naboens start blir det nye start.
  - når dette peker på en tilfeldig node i midten, blir noden bak "dette" slettet.

<h3>Oppgave 10</h3>
Oppgave 10 løses med quicksort. Først oppretter vi en metode,
partisjon, som tar inn følgende argumenter: liste, fra, til og
en Comparator c. Oppretter en left og right peker. Deretter bruker
vi en for-løkke til å iterere igjennom listen. Hvis det blir funnet
en verdi mindre enn verdien til right, bytter left-peker og peker i
for-løkken posisjon. I dette tilfellet, økes left-peker med 1. Deretter
bytter right-verdi med left-verdi, og left returneres. Vi
Lager en rekursiv funksjon quicksort. Quicksort metoden kaller metoden
partisjon. I sorter-metoden sjekker vi først om listen er tom eller har
én verdi. Deretter kaller vi metoden quicksort.
