public static void main(String[] args) {
    UniversitateService universitate = new  UniversitateService();
    Rapoarte rapoarte = new Rapoarte(universitate);
    Student s1 = new Student("Ana Popescu", "S1", "ana@mail.com",
            "Informatica", 2, 9.30, 1200);

    Student s2 = new Student("Mihai Ionescu", "S2", "mihai@mail.com",
            "Informatica", 2, 8.70, 1500);

    Student s3 = new Student("Elena Marin", "S3", "elena@mail.com",
            "Informatica", 2, 7.50, 900);

    Student s4 = new Student("Paul Radu", "S4", "paul@mail.com",
            "Calculatoare", 3, 9.80, 2000);

    Student s5 = new Student("Ioana Dima", "S5", "ioana@mail.com",
            "Calculatoare", 3, 6.40, 800);

    Student s6 = new Student("Alex Tudor", "S6", "alex@mail.com",
            "Automatica", 1, 8.20, 1100);

    Profesor prof1 = new Profesor("Ion Popescu", "P1", "popescu@uni.ro", "Informatica", "Lector");

    Curs curs1 = new Curs("C101", "Matematica", 6, "Obligatoriu", prof1, 1);
    Curs curs2 = new Curs("C102", "Fizica", 5, "Obligatoriu", prof1, 1);

    Sala sala1 = new Sala("A101", 50, "Sala curs");
    Sala sala2 = new Sala("B201", 30, "Laborator");

    IntervalOrar io1 = new IntervalOrar("Luni", 8, 10);
    IntervalOrar io2 = new IntervalOrar("Luni", 10, 12);

    AlocareOra aloc1 = new AlocareOra(curs1, prof1, sala1, io1);
    AlocareOra aloc2 = new AlocareOra(curs2, prof1, sala2, io2);

    universitate.getSali().add(sala1);
    universitate.getSali().add(sala2);

    universitate.orar.add(aloc1);
    universitate.orar.add(aloc2);

    s1.adaugaNotaFinala(curs1, 10);
    s1.adaugaNotaFinala(curs2, 9);

    s2.adaugaNotaFinala(curs1, 9);
    s2.adaugaNotaFinala(curs2, 8);

    s3.adaugaNotaFinala(curs1, 7);
    s3.adaugaNotaFinala(curs2, 6);

    s4.adaugaNotaFinala(curs1, 5);
    s4.adaugaNotaFinala(curs2, 3);

    s5.adaugaNotaFinala(curs1, 7);
    s5.adaugaNotaFinala(curs2, 8);

    s6.adaugaNotaFinala(curs1, 10);
    s6.adaugaNotaFinala(curs2, 9);

    universitate.adaugaStudent(s1);
    universitate.adaugaStudent(s2);
    universitate.adaugaStudent(s3);
    universitate.adaugaStudent(s4);
    universitate.adaugaStudent(s5);
    universitate.adaugaStudent(s6);

    //TEST BURSE
    System.out.println("\nBURSE");
    rapoarte.listeBursieri(3);

    //RAPOARTE CAZARE
    System.out.println("\nCAMIN");
    Camin caminA = new Camin("Camin A", 5);

    Camera c1 = new Camera(101, 2);
    Camera c2 = new Camera(102, 2);
    Camera c3 = new Camera(103, 2);
    caminA.adaugaCacmera(c1);
    caminA.adaugaCacmera(c2);
    caminA.adaugaCacmera(c3);
    universitate.camine.add(caminA);

    universitate.inregistreazaCerereCazare(s1, caminA, 300, 1200);
    universitate.inregistreazaCerereCazare(s2, caminA, 150, 1500);
    universitate.inregistreazaCerereCazare(s3, caminA, 500, 900);
    universitate.inregistreazaCerereCazare(s4, caminA, 400, 2000);
    universitate.inregistreazaCerereCazare(s5, caminA, 600, 800);
    universitate.inregistreazaCerereCazare(s6, caminA, 250, 1100);
    universitate.repartizareCamine();

    System.out.println("\nRAPOARTE CAZARE");
    rapoarte.rapoarteCazare();

    //RAPOARTE ACADEMICE
    System.out.println("\nRAPOARTE ACADEMICE");
    rapoarte.rapoarteAcademice();

    //RAPOARTE OCUPARE SALI
    rapoarte.rapoarteOcupareSali();
}