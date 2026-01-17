import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rapoarte {
    UniversitateService universitateService = new UniversitateService();
    public Rapoarte(UniversitateService universitateService) {
        this.universitateService = universitateService;
    }

    //LISTA STUDENTI BURISERI
    public void listeBursieri(int nr) {
        System.out.println("\nLista bursieri merit");
        List<Student> bursieriMerit = universitateService.genereazaBursieriMerit(nr);
        for (Student s : bursieriMerit) {
            System.out.println(s.getNume() + " - punctaj merit: " + s.getPunctajBursa());
        }

        System.out.println("\nLista bursieri social");
        List<Student> bursieriSocial = universitateService.genereazaBursieriSociala();
        for (Student s : bursieriSocial) {
            System.out.println(s.getNume() + " - punctaj social: " + s.getPunctajBursaSociala());
        }
    }
   //RAPOARTE CAZARE
    public void rapoarteCazare(){
        for(Camin camin : universitateService.getCamine()){
            System.out.println("\nCamin: " + camin.getNume());
            int locuriOcupate = 0;
            for(Camera camera : camin.getListaCamere()){
                locuriOcupate += camera.getStudenti().size();
            }

            int locuriTotale = camin.getCapacitate();
            int locuriLibere = locuriTotale-locuriOcupate;
            System.out.println("Locuri ocupate: " + locuriOcupate);
            System.out.println("Locuri libere: " + locuriLibere);

            System.out.println("Studenti cazati:");
            for(Camera camera : camin.getListaCamere()){
                System.out.println("  Camera " + camera.getNumar() + ":");
                for(Student s : camera.getStudenti()){
                    System.out.println("    - " + s.getNume());
                }
            }
        }
    }
    //RAPOARTE ACADEMICE
    public void distributieSpecializari(){
        System.out.println("\nDistributia mediilor pe specializari");
        HashMap<String, List<Double>> distributie = new HashMap<>();
        for(Student s : universitateService.studenti.values()){
            String program = s.getProgramStudii();
            if(!distributie.containsKey(program)){
                distributie.put(program, new ArrayList<>());
            }
            distributie.get(program).add(s.getMedieGenerala());
        }
        //afisare ordonata crescator
        for(String program : distributie.keySet()){
            List<Double> medii = distributie.get(program);
            medii.sort((a, b) -> Double.compare(a, b));
            System.out.println("Specializare: " + program);
            for (double medie : medii) {
                System.out.println("  medie: " + medie);
            }
        }
    }
    public void creditePromovate(){
        System.out.println("\nCredite promovate per student");
        for(Student s : universitateService.studenti.values()){
            System.out.println(
                    s.getNume() +
                            " | Credite promovate: " + s.getCreditePromovate() +
                            " | Status: " + s.getStatus()
            );
        }
    }
    public void topStudentiMedie(int nr){
        System.out.println("\nTop studenti dupa medie");
        List<Student> lista = new ArrayList<Student>(universitateService.studenti.values());
        lista.sort(new ComparatorMedie());
        for(int i = 0; i < Math.min(nr, lista.size()); i++){
            Student s = lista.get(i);
            System.out.println(
                    (i + 1) + ". " +
                            s.getNume() +
                            " | Medie: " + s.getMedieGenerala()
            );
        }
        }
        public void rapoarteAcademice() {
        distributieSpecializari();
        creditePromovate();
        topStudentiMedie(5);
        }
    public void rapoarteOcupareSali(){
        System.out.println("\nRapoarte ocupare sali:");
        for(Sala sala : universitateService.getSali()){
            System.out.println("\nSala: " + sala.getCodSala());
            int oreOcupate = 0;
            int oreTotale = 0;
            oreTotale = 10;
            for(AlocareOra ora : universitateService.orar){
                if(ora.getSala().equals(sala)){
                    int start = ora.getIntervalOrar().getOraStart();
                    int end = ora.getIntervalOrar().getOraEnd();
                    oreOcupate += (end - start);
                }
            }
            double gradOcupare = (double) oreOcupate / oreTotale * 100;
            System.out.println("Ore ocupate: " + oreOcupate + " / " + oreTotale + " (" + gradOcupare + "%)");
        }
    }

}
