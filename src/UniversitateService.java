import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniversitateService {
    public HashMap<String, Student> studenti = new HashMap<>();
    public HashMap<String, Profesor> profesori = new HashMap<>();
    public ArrayList<Curs> cursuri = new ArrayList<>();
    public ArrayList<Sala> sali = new ArrayList<>();
    public ArrayList<Camin> camine = new ArrayList<>();
    public ArrayList<AlocareOra> orar = new ArrayList<>();
    public ArrayList<CerereCazare> cereriCazare = new ArrayList<>();
    public void adaugaStudent(Student s) {
        studenti.put(s.getId(), s);
    }
    public List<Sala> getSali(){
        return sali;
    }
    public List<Camin> getCamine(){
        return camine;
    }
    public void adaugaOra(AlocareOra a) throws SuprapunereOrarException{
            for(AlocareOra existenta : orar){
                //acelasi profesor
                if(existenta.getProfesor().equals(a.getProfesor()) && existenta.getIntervalOrar().suprapunere(a.getIntervalOrar())){
                    throw new SuprapunereOrarException("Profesorul are deja un curs in acest interval orar!");

                }
                //aceeasi sala
                if(existenta.getSala().equals(a.getSala()) && existenta.getIntervalOrar().suprapunere(a.getIntervalOrar())){
                    throw new SuprapunereOrarException("Sala este ocupata in acest interval!");
                }
                //cursuri suprapuse ale studentului
                if(existenta.getCurs().getTip().equals("Obligatoriu") && a.getCurs().getTip().equals("Obligatoriu") &&
                existenta.getIntervalOrar().suprapunere(a.getIntervalOrar())){
                    throw new SuprapunereOrarException("Studentii au doua cursuri obligatorii suprapuse!");
                }

            }
            orar.add(a);
    }

    public void afiseazaOrarStudenti(int anStudiu){
        System.out.println("Orar studenti - anul " + anStudiu);
        for(AlocareOra a : orar){
            if(a.getCurs().getanStudiu() == anStudiu){
                System.out.println(
                        a.getIntervalOrar().getZi() + " " +
                                a.getIntervalOrar().getOraStart() + "-" +
                                a.getIntervalOrar().getOraEnd() + " | " +
                                a.getCurs().getDenumire() + " | " +
                                a.getProfesor().getNume() + " | " +
                                a.getSala().getCodSala()
                );
            }
        }
    }
    public void afiseazaOrarProfesor(Profesor profesor){
        System.out.println("Orar profesor " + profesor.getNume());
        for(AlocareOra a : orar){
            if(a.getProfesor().equals(profesor)){
                System.out.println(
                        a.getIntervalOrar().getZi() + " " +
                                a.getIntervalOrar().getOraStart() + "-" +
                                a.getIntervalOrar().getOraEnd() + " | " +
                                a.getCurs().getDenumire() + " | " +
                                a.getSala().getCodSala()
                );
            }
        }
    }
    public void afiseazaOrarSala(Sala sala){
        System.out.println("Rezervari sala " + sala.getCodSala());
        for(AlocareOra a : orar){
            if(a.getSala().equals(sala)){
                System.out.println(
                        a.getIntervalOrar().getZi() + " " +
                                a.getIntervalOrar().getOraStart() + "-" +
                                a.getIntervalOrar().getOraEnd() + " | " +
                                a.getCurs().getDenumire() + " | " +
                                a.getProfesor().getNume()
                );
            }
        }
    }
    public List<Student> genereazaBursieriMerit(int nr){
        List<Student> lista = new ArrayList<>(studenti.values());
        for(Student s : lista) {
            s.calculeazaPunctaj();
        }
            lista.sort(new ComparatorPunctajBursa());
            return lista.subList(0, Math.min(nr, lista.size()));

    }
    public List<Student> genereazaBursieriSociala(){
        List<Student> lista = new ArrayList<>();
        for(Student s : studenti.values()){
            s.calculeazaPunctajSociala();
            if(s.getPunctajBursaSociala() > 0){
                lista.add(s);
            }
        }
        lista.sort((a, b) -> Double.compare(b.getPunctajBursaSociala(), a.getPunctajBursaSociala()));
        return lista;
    }
    public void inregistreazaCerereCazare(Student student, Camin preferintaCamin,
                                          double distantaDomiciliu, double venit){
        CerereCazare cerere = new CerereCazare(student, preferintaCamin, distantaDomiciliu, venit);
        cereriCazare.add(cerere);
    }
    public void repartizareCamine(){
        for(Camin camin : camine){
            List<CerereCazare> cereriCamin = new ArrayList<>();
            for(CerereCazare c : cereriCazare){
                if(c.getPreferintaCamin().equals(camin)) {
                    cereriCamin.add(c);
                }
            }
            //sortare descresctaor dupa punctaj
            cereriCamin.sort((a, b) -> Double.compare(
                    b.getStudent().calculeazaPunctajCamin(b.getDistantaDomiciliu(), b.getVenit()),
                    a.getStudent().calculeazaPunctajCamin(a.getDistantaDomiciliu(), a.getVenit()))
            );
            //alocare locuri pana la capacitate
            int locuriRamase = camin.getCapacitate();
            for(CerereCazare c : cereriCamin){
                if(locuriRamase <= 0)
                    break;
                camin.cazeazaStudent(c.getStudent());
                locuriRamase--;
            }
        }

    }
}
