# SISTEM DE MANAGEMENT UNIVERSITAR (ERP UNIVERSITATE)

Acest proiect reprezintă un sistem complex de gestiune academică implementat în Java. Aplicația este concepută pentru a administra entitățile principale dintr-o universitate, precum studenții, cadrele didactice, cursurile și resursele logistice (săli și cămine).

## OBIECTIVE PRINCIPALE
* Gestionarea bazei de date pentru studenți și profesori.
* Monitorizarea cursurilor și a procesului de evaluare prin note și credite.
* Automatizarea procesului de acordare a burselor de merit și sociale.
* Repartizarea studenților în cămine și administrarea rezervărilor pentru sălile de curs.

## STRUCTURA PROIECTULUI
Codul este organizat modular pentru a respecta principiile programării orientate pe obiect:

* **Persoana (Clasă Abstractă)**: Reprezintă entitatea de bază pentru Student și Profesor, asigurând moștenirea atributelor comune.
* **Gestiune Orar (AlocareOra și IntervalOrar)**: 
    * **IntervalOrar**: Definește fereastra temporală și verifică suprapunerile de timp prin metoda suprapunere().
    * **AlocareOra**: Corelează un curs cu un profesor, o sală și un interval specific.
* **Sistem de Cazare (Camin și Camera)**: 
    * **Camin**: Gestionează o listă de camere și procesul de cazare până la atingerea capacității maxime.
    * **Camera**: Monitorizează locurile libere și studenții alocați pe fiecare unitate.
* **Interfețe**: Proiectul utilizează interfețe precum Evaluabil și Cautabil pentru a asigura un design flexibil și respectarea contractelor de implementare (ex: calculul punctajului sau căutarea după ID).

## ANALIZĂ ȘI RAPORTARE
Clasa Rapoarte extrage statistici avansate din sistem, oferind o imagine clară asupra performanței academice și utilizării resurselor:

* **Ierarhii Academice**: Generarea topurilor după medie și distribuția mediilor pe specializări folosind HashMap și sortări dinamice.
* **Monitorizarea Burselor**: Afișarea listelor cu bursieri de merit și sociali, bazate pe punctajele calculate anterior.
* **Statistici Logistice**: 
    * **Cazare**: Calculul gradului de ocupare pe fiecare cămin și listarea studenților pe camere.
    * **Ocupare Săli**: Determinarea procentuală a gradului de utilizare a fiecărei săli în funcție de intervalele orare rezervate.

## DETALII DE IMPLEMENTARE: UNIVERSITATE SERVICE
Clasa UniversitateService este motorul central al aplicației, utilizând HashMap pentru acces rapid la date și ArrayList pentru gestionarea fluxurilor dinamice.

### 1. Validarea Orarului și Gestiunea Conflictelor
Metoda adaugaOra previne erorile de planificare prin aruncarea excepției SuprapunereOrarException în următoarele cazuri:
* Profesorul are deja un alt curs programat în același interval.
* Sala de curs este deja ocupată de o altă activitate.
* Studenții din același an au două cursuri obligatorii suprapuse.

### 2. Algoritmi de Alocare
* **Bursieri**: Sistemul sortează automat listele folosind ComparatorPunctajBursa pentru ierarhii de merit.
* **Repartizare Cămin**: Metoda repartizareCamine() analizează cererile, sortează studenții după prioritate și îi alocă automat în camerele disponibile.

## CUM SE RULEAZĂ
1. Importă proiectul în IntelliJ IDEA.
2. Rulează clasa Main.java pentru a vizualiza simularea datelor și rapoartele generate.

---
**Proiect Anul 2 - Programare Orientată pe Obiect**
**Facultatea de Automatică și Calculatoare**
