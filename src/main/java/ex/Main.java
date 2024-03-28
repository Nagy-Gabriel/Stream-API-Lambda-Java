package ex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file = new File("src//main//resources/Angajat.json");
            if (!file.exists()) {
                file.createNewFile();
            }
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Angajat> citire(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Angajat> listaAngajati = new ArrayList<>();

        try {
            listaAngajati = mapper.readValue(new File("src//main//resources/Angajat.json"), new TypeReference<List<Angajat>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAngajati;
    }


    public static void main(String[] args) throws IOException {
        List<Angajat> angajati = new ArrayList<>();

//        angajati.add(new Angajat("Gabriel", "programator", LocalDate.now(), 2600.00f));
//        angajati.add(new Angajat("Alex", "sef", LocalDate.now(), 5000.00f));
//        angajati.add(new Angajat("Mihai", "director", LocalDate.now(), 6500.00f));
//        angajati.add(new Angajat("Popescu", "curatenie", LocalDate.now(), 1700.00f));
//
//        scriere(angajati);

        List<Angajat> listaAngajati = new ArrayList<Angajat>(citire("src\\main\\resources\\Angajat.json"));


        System.out.println("Afisarea tuturor angajatilor");
        listaAngajati.forEach(System.out::println);

        System.out.println("");

        System.out.println("Afisare angajati cu salariu peste 2500 RON");

        listaAngajati.stream()
                .filter(a -> a.getSalariu() > 2500)
                .forEach(System.out::println);

        System.out.println(" ");
        System.out.println("Angajatii din luna aprilie, a anului trecut care au functie de conducere");

        List<Angajat> angajatiConducereAprilie = conducereAprilie(listaAngajati);
        angajatiConducereAprilie.forEach(System.out::println);
        System.out.println(" ");

        System.out.println("Afisarea angajatilor fara functie de conducere");
        listaAngajati.stream()
                .filter(a -> !a.getPost().contains("director") && !a.getPost().contains("sef"))
                .sorted((a, b) -> Float.compare(b.getSalariu(), a.getSalariu()))
                .forEach(System.out::println);

        System.out.println(" ");

        System.out.println("Numele angajatilor scrise cu majuscule");
        numeAngajati(listaAngajati).forEach(System.out::println);
        ;
        System.out.println(" ");

        System.out.println("Afisarea salariilor mai mici de 3000 RON");

        listaAngajati.stream()
                .filter(a->a.getSalariu() < 3000)
                .map(Angajat::getSalariu)
                .forEach(System.out::println);
        System.out.println(" ");

        System.out.println("Afisarea datelor primului angajat al firmei");

        Optional<Angajat> primulAngajat = listaAngajati.stream().min(Comparator.comparing(Angajat::getData_angajarii));
        primulAngajat.ifPresentOrElse(System.out::println, () -> System.out.println("Nu există angajați în firmă."));

        System.out.println(" ");

        System.out.println("Afisare statistici referitoare la salariile angajatilor: ");
        DoubleSummaryStatistics statisticiSalarii = listaAngajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu));
        System.out.println("Salariul mediu: " + statisticiSalarii.getAverage());
        System.out.println("Salariul minim: " + statisticiSalarii.getMin());
        System.out.println("Salariul maxim: " + statisticiSalarii.getMax());

        System.out.println("Verificare daca exista cel putin un Ion anagajat in firma: ");

        boolean existaIon = listaAngajati.stream().anyMatch(angajat -> angajat.getNume().equalsIgnoreCase("Ion"));
        if (existaIon) {
            System.out.println("Firma are cel puțin un Ion angajat.");
        } else {
            System.out.println("Firma nu are nici un Ion angajat.");
        }

        System.out.println(" ");

        System.out.println("Afisarea numarului de persoane care s-au angajat in vara anului trecut");
        long numarAngajatiVaraAnulPrecedent = listaAngajati.stream()
                .filter(angajat -> angajat.getData_angajarii().getMonthValue() >= Month.JUNE.getValue() &&
                        angajat.getData_angajarii().getMonthValue() <= Month.AUGUST.getValue() &&
                        angajat.getData_angajarii().getYear() == LocalDate.now().minusYears(1).getYear())
                .count();
        System.out.println("Numărul de angajați din vara anului precedent: " + numarAngajatiVaraAnulPrecedent);
    }

    public static List<Angajat> conducereAprilie(List<Angajat> listaAngajati) {
        int anulTrecut = LocalDate.now().getYear() - 1;
        return listaAngajati.stream()
                .filter(a -> (a.getPost().contains("director") || a.getPost().contains("sef")) &&
                        a.getData_angajarii().getMonthValue() == 4 &&  a.getData_angajarii().getYear() == anulTrecut)
                .collect(Collectors.toList());
    }

    public static List<String> numeAngajati(List<Angajat> listaAngajati) {
        return listaAngajati.stream()
                .map(Angajat::getNume)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}

