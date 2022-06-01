package Menu;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import Objects.Davanter;
import Objects.Defensa;
import Objects.Entrenador;
import Objects.Jugador;
import Objects.MembrePlantilla;
import Objects.Migcampista;
import Objects.Porter;
import Objects.PreparadorFisic;
import Objects.Soci;

public class ClubFutbol {

    private String nom = "clubTarrega";
    private String Cif = "x1231123";
    private String adreça = "AVDA tarrega";
    private int telefon = 642525252;
    private String email = "nazar@gmail.com";
    private String web = "www.google.es";

    private boolean sortir = false;
    static Scanner sc = new Scanner(System.in);

    private HashMap<String, MembrePlantilla> membresPlantilla = new HashMap<>();
    private HashMap<String, Soci> socis = new HashMap<>();
    static File file = new File("src\\file\\Dades.dat");

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        ClubFutbol clubTarrega = new ClubFutbol();

        if (file.isFile()) {
            clubTarrega.llegirArxiu();
        }


        clubTarrega.gestioClubFutbol();

    }

    public ClubFutbol() {

    }

    public void gestioClubFutbol() throws IOException {

        // socis.put("x461", new Soci("x461", "Nazar ", "Yakovyna",
        // LocalDate.parse("2020-01-08"), 642753900, "soci1@gmail.com", 1000));

        // membresPlantilla.put("x312313", new PreparadorFisic("x32131",
        // "preparadorFisic", "preparadorFisic", LocalDate.parse("2020-01-08"), 64324,
        // "Corrreu", 3123, "D3213123", LocalDate.parse("2020-01-08")));
        // membresPlantilla.put("x3123133",new Porter("x3123133", "Porter", "Porter",
        // LocalDate.parse("2020-01-08"), 213123, "Correu@gmail.com", 3333, "d333",
        // true, 33, 33));
        // membresPlantilla.put("x213123",new Migcampista("x213123", "migcampista",
        // "migcampista", LocalDate.parse("2020-01-08"), 123123, "email@gmail.com", 333,
        // "S3123", false, 33, 55));

        // membresPlantilla.put("x435123",new Entrenador("x34421", "Entrenador",
        // "entrenador", LocalDate.parse("2020-01-08"), 321312213, "email@gmail.com",
        // 3333, "d233213", 66));

        // membresPlantilla.put("x461", new Davanter("dni", "Nazar", "yakovyna",
        // LocalDate.parse("2020-01-08"), 641,
        // "email@gmail.com", 1900, "x3123123", true, 33, 3));

        // membresPlantilla.put("x123", new Defensa("dni", "Nazar", "yakovyna",
        // LocalDate.parse("2020-01-08"), 641,
        // "email@gmail.com", 1900, "x3123123", true, 33, 3));

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Consultar les dades del club");
            System.out.println("2. Gestionar els socis");
            System.out.println("3. Gestionar la plantilla");
            System.out.println("4. Visualitzar les dades econòmiques");
            System.out.println("5. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':

                    System.out.println(toString());
                    sortir = false;
                    break;
                case '2':

                    gestioSocis();
                    sortir = false;

                    break;
                case '3':

                    gestioPlantilla();
                    sortir = false;

                    break;
                case '4':

                    mostrarDadesEconomiques();
                    sortir = false;
                    break;
                case '5':
                    guardarArxiu();
                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    public void gestioSocis() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta de un soci");
            System.out.println("2. Baixa de un soci");
            System.out.println("3. Modificar un soci");
            System.out.println("4. Mostrar tots els socis ordenats");
            System.out.println("5. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':

                    altaSoci();
                    sortir = false;

                    break;
                case '2':

                    baixaSoci();
                    sortir = false;

                    break;
                case '3':

                    modificarSoci();
                    sortir = false;

                    break;
                case '4':

                    mostrarSocis();
                    sortir = false;

                    break;
                case '5':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void mostrarSocis() {
        System.out.println("Com vols ordenar els socis");

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Per Cognoms i Nom");
            System.out.println("2. Per Localitat");
            System.out.println("3. Per Quota");
            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':

                    ordenarPerCognomsNom();
                    sortir = false;

                    break;
                case '2':

                    ordenarPerLocalitat();
                    sortir = false;

                    break;
                case '3':

                    ordenadrPerQuota();
                    sortir = false;

                    break;

                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);

    }

    private void ordenadrPerQuota() {
        ArrayList<Soci> socisList = new ArrayList<Soci>();

        for (Soci sc : socis.values()) {
            socisList.add(sc);
        }

        Collections.sort(socisList, new Comparator<Soci>() {
            public int compare(Soci v1, Soci v2) {
                return v1.getQuotaAnual() - v2.getQuotaAnual();
            }
        });

        for (Soci sc : socisList) {

            System.out.println(sc);
        }
    }

    private void ordenarPerLocalitat() {

        ArrayList<Soci> socisList = new ArrayList<Soci>();

        for (Soci sc : socis.values()) {

            socisList.add(sc);

        }

        Collections.sort(socisList, new Comparator<Soci>() {
            public int compare(Soci v1, Soci v2) {
                return v1.getNumLocalitat() - v2.getNumLocalitat();

            }
        });

        for (Soci sc : socisList) {

            System.out.println(sc);
        }
    }

    private void ordenarPerCognomsNom() {

        ArrayList<Soci> socisList = new ArrayList<Soci>();

        for (Soci sc : socis.values()) {

            socisList.add(sc);

        }

        Collections.sort(socisList, new Comparator<Soci>() {
            public int compare(Soci v1, Soci v2) {
                int result = v1.getCognom().compareTo(v2.getCognom());
                if (result == 0) {
                    return v1.getNom().compareTo(v2.getNom());
                }
                return result;
            }
        });

        for (Soci sc : socisList) {

            System.out.println(sc);
        }
    }

    private void modificarSoci() {
        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(socis.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        socis.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        socis.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        socis.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        socis.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        socis.get(dni).setQuotaAnual(quotaAnual);
                        sortir = false;

                        break;

                    case '6':

                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    private void baixaSoci() {

        System.out.println("Fica el dni que vols eliminar");

        sc.nextLine();
        String dni = sc.nextLine();
        try {
            System.out.println("esta eliminat el " + socis.get(dni).toString());
            socis.remove(dni);
        } catch (NullPointerException e) {
            System.out.println("Aquet dni no existeix");
        }

    }

    public void gestioPlantilla() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Gestio de entrenadors");
            System.out.println("2. Gestio de preparadors fisics--");
            System.out.println("3. Gestio de porters--");
            System.out.println("4. Gestio de defenses--");
            System.out.println("5. Gestio de migcampistes--");
            System.out.println("6. Gestio de davanters--");
            System.out.println("7. Mostrar els treballadors");

            System.out.println("8. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    gestioEntrenadors();
                    sortir = false;

                    break;
                case '2':
                    gestioPreparadorsFisics();
                    sortir = false;

                    break;
                case '3':
                    gestioPorters();
                    sortir = false;

                    break;
                case '4':
                    gestioDefenses();
                    sortir = false;

                    break;
                case '5':
                    gestioMigcampistes();
                    sortir = false;

                    break;
                case '6':
                    gestioDavanters();
                    sortir = false;

                    break;
                case '7':
                    mostrarTreballadorsOrdenatsPerClasse();
                    sortir = false;

                    break;
                case '8':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void mostrarTreballadorsOrdenatsPerClasse() {
        ArrayList<MembrePlantilla> membresPlantillaList = new ArrayList<MembrePlantilla>();

        for (MembrePlantilla mp : membresPlantilla.values()) {
            membresPlantillaList.add(mp);
        }

        Collections.sort(membresPlantillaList, new Comparator<MembrePlantilla>() {
            public int compare(MembrePlantilla v1, MembrePlantilla v2) {
                int result = v1.getClass().getSimpleName().compareTo(v2.getClass().getSimpleName());
                return result;
            }
        });

        for (MembrePlantilla mp : membresPlantillaList) {

            System.out.println(mp);
        }
    }

    private void gestioDavanters() {
        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta Davanter");
            System.out.println("2. Baixa Davanter");
            System.out.println("3. Modificar Davanter");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaDavanter();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarDavanter();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);

    }

    private void modificarDavanter() {

        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Gols Marcats");
                System.out.println("8. Balons Recuperats");
                System.out.println("9. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;
                    case '7':

                        System.out.println("Gols Marcats:");
                        sc.nextLine();
                        int golsMarcats = sc.nextInt();
                        membresPlantilla.get(dni).setGolsFets(golsMarcats);
                        sortir = false;

                        break;
                    case '8':

                        System.out.println("Balons Recuperats:");
                        sc.nextLine();
                        int balonsRecuperats = sc.nextInt();
                        membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
                        sortir = false;

                        break;

                    case '9':

                        System.out.println("sortir");
                        membresPlantilla.get(dni).calcularSalari();
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }

            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    private void baixaTreballador() {
        System.out.println("Fica el dni per donar baixa");

        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println("esta eliminat el " + membresPlantilla.get(dni).toString());
            membresPlantilla.remove(dni);
        } catch (NullPointerException e) {
            System.out.println("Aquet dni no existeix");
        }

    }

    private void gestioMigcampistes() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta MigCampista");
            System.out.println("2. Baixa MigCampista");
            System.out.println("3. Modificar MigCampista");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaMigCampista();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarMigCampista();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);

    }

    private void modificarMigCampista() {
        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Balons recuperats:");
                System.out.println("8. Assistencies Gol:");
                System.out.println("9. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;
                    case '7':

                        System.out.println("Fica els balons recuperats:");
                        sc.nextLine();
                        int balonsRecuperats = sc.nextInt();
                        membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
                        ;
                        sortir = false;

                        break;
                    case '8':

                        System.out.println("Fica assistencies gol:");
                        sc.nextLine();
                        int asistenciesGol = sc.nextInt();
                        membresPlantilla.get(dni).setAsistenciesGol(asistenciesGol);
                        sortir = false;

                        break;

                    case '9':
                        membresPlantilla.get(dni).calcularSalari();
                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    private void altaMigCampista() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        sc.nextLine();
        String NSS = sc.nextLine();
        System.out.println("Fica els balons recuperats:");
        int balonsRecuperats = sc.nextInt();
        System.out.println("Fica asistencies gol:");
        int asistenciesGol = sc.nextInt();

        System.out.println("Es titular Si o No");
        sc.nextLine();
        boolean titular = false;
        String opcio = sc.nextLine();

        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        }

        membresPlantilla.put(dni, new Migcampista(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS,
                titular, balonsRecuperats, asistenciesGol));

    }

    private void gestioDefenses() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta Defensa");
            System.out.println("2. Baixa Defensa");
            System.out.println("3. Modificar Defensa");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaDefensa();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarDefensa();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void altaDefensa() {
        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        sc.nextLine();
        String NSS = sc.nextLine();
        System.out.println("Fica els balons recuperats");
        int balonsRecuperats = sc.nextInt();
        System.out.println("Fica atacs aturats");
        int atacsAturats = sc.nextInt();

        System.out.println("Es titular Si o No");
        sc.nextLine();
        boolean titular = false;
        String opcio = sc.nextLine();

        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        }

        membresPlantilla.put(dni, new Defensa(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS,
                titular, balonsRecuperats, atacsAturats));
    }

    private void modificarDefensa() {
        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Balons recuperats:");
                System.out.println("8. Atacs aturats:");
                System.out.println("9. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;
                    case '7':

                        System.out.println("Fica els balons recuperats:");
                        sc.nextLine();
                        int balonsRecuperats = sc.nextInt();
                        membresPlantilla.get(dni).setBalonsRecuperats(balonsRecuperats);
                        ;
                        sortir = false;

                        break;
                    case '8':

                        System.out.println("Fica atacs aturats:");
                        sc.nextLine();
                        int atacsAturats = sc.nextInt();
                        membresPlantilla.get(dni).setAtacsAturats(atacsAturats);
                        sortir = false;

                        break;

                    case '9':
                        membresPlantilla.get(dni).calcularSalari();
                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }
    }

    private void gestioPorters() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta Porters");
            System.out.println("2. Baixa Porters");
            System.out.println("3. Modificar Porters");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaPorters();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarPorters();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void altaPorters() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        sc.nextLine();
        String NSS = sc.nextLine();
        System.out.println("Es titular Si o No");
        boolean titular = false;
        String opcio = sc.nextLine();
        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        } else {
            titular = false;
        }
        System.out.println("Fica els Gols Aturats:");
        int golsAturats = sc.nextInt();
        System.out.println("Fica els Gols Rebuts:");
        int golsRebuts = sc.nextInt();

        membresPlantilla.put(dni, new Porter(dni, nom, cognom, LocalDate.parse(data), telefon,
                correu, salari, NSS, titular, golsAturats, golsRebuts));
    }

    private void modificarPorters() {

        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Balons recuperats:");
                System.out.println("8. Atacs aturats:");
                System.out.println("9. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;
                    case '7':

                        System.out.println("Fica Gols Aturats:");
                        sc.nextLine();
                        int golsAturats = sc.nextInt();
                        membresPlantilla.get(dni).setGolsAturats(golsAturats);

                        sortir = false;

                        break;
                    case '8':

                        System.out.println("Fica Gols Rebuts:");
                        sc.nextLine();
                        int golsRebuts = sc.nextInt();
                        membresPlantilla.get(dni).setGolsRebuts(golsRebuts);
                        sortir = false;

                        break;

                    case '9':
                        membresPlantilla.get(dni).calcularSalari();
                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    private void gestioPreparadorsFisics() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta Preparadors Fisics");
            System.out.println("2. Baixa Preparadors Fisics");
            System.out.println("3. Modificar Preparadors Fisics");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaPreparadorsFisics();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarPreparadorsFisics();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void altaPreparadorsFisics() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        String NSS = sc.nextLine();

        System.out.println("Fica el dia de fitxa:");
        String dataFitx = sc.nextLine();

        membresPlantilla.put(dni, new PreparadorFisic(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari,
                NSS, LocalDate.parse(dataFitx)));
    }

    private void modificarPreparadorsFisics() {

        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;

                    case '7':
                        membresPlantilla.get(dni).calcularSalari();
                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    private void gestioEntrenadors() {
        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Alta Entrenadors");
            System.out.println("2. Baixa Entrenadors");
            System.out.println("3. Modificar Entrenadors");

            System.out.println("4. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    altaEntrenadors();
                    sortir = false;

                    break;
                case '2':
                    baixaTreballador();
                    sortir = false;

                    break;
                case '3':
                    modificarEntrenadors();
                    sortir = false;

                    break;
                case '4':

                    System.out.println("sortir");
                    sortir = true;
                    break;
                default:
                    System.out.println("Opcio no valida");
            }
        } while (!sortir);
    }

    private void altaEntrenadors() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        sc.nextLine();
        String NSS = sc.nextLine();
        System.out.println("Fica el numero De Trofeus:");
        int numtrofeus = sc.nextInt();

        membresPlantilla.put(dni,
                new Entrenador(dni, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS, numtrofeus));

    }

    private void modificarEntrenadors() {

        System.out.println("Fica el dni per modificar");
        sc.nextLine();
        String dni = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(dni).toString());

            do {
                System.out.println("**************Club Futbol*****************");
                System.out.println("1. Modificar Nom");
                System.out.println("2. Modificar Cognom");
                System.out.println("3. Modificar Telefon");
                System.out.println("4. Modificar Email");
                System.out.println("5. Modificar Quaota Anual");
                System.out.println("6. Modificar NSS");
                System.out.println("7. Sortir");

                String sa = sc.next();
                char opcio = sa.charAt(0);

                switch (opcio) {
                    case '1':

                        System.out.println("Fica el nom:");
                        sc.nextLine();
                        String nom = sc.nextLine();
                        membresPlantilla.get(dni).setNom(nom);
                        sortir = false;

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(dni).setCognom(cognom);
                        sortir = false;

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(dni).setTelefon(telefon);
                        sortir = false;

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(dni).setEmail(email);
                        sortir = false;

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(dni).setSouBase(quotaAnual);
                        sortir = false;

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(dni).setNSS(nss);
                        sortir = false;

                        break;

                    case '7':

                        System.out.println("sortir");
                        sortir = true;
                        break;
                    default:
                        System.out.println("Opcio no valida");
                }
            } while (!sortir);

        } catch (Exception e) {
            System.out.println("aquet dni no existeix");
        }

    }

    @Override
    public String toString() {
        return "ClubFutbol [Cif=" + Cif + ", adreça=" + adreça + ", email=" + email + ", nom=" + nom + ", telefon="
                + telefon + ", web=" + web + "]";
    }

    public void mostrarDadesEconomiques() {

        System.out.println("Dades economiquues");

        int presupostSocis = 0;
        int presupostMembresPlantilla = 0;

        for (Soci sc : socis.values()) {

            presupostSocis = presupostSocis + sc.getQuotaAnual();
        }

        for (MembrePlantilla mp : membresPlantilla.values()) {

            presupostMembresPlantilla = presupostMembresPlantilla + mp.getSalari();
        }

        System.out.println("Ingresos brut " + presupostSocis);
        System.out.println("Salari global " + presupostMembresPlantilla);

        System.out.println("Ingresos net " + (presupostSocis - presupostMembresPlantilla));

    }

    public void mostrarMembresPlantilla() {

        for (MembrePlantilla MP : membresPlantilla.values()) {

            System.out.println(MP);
        }
    }

    public void altaSoci() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Ficala quota:");
        int quotaAnual = sc.nextInt();

        socis.put(dni, new Soci(dni, nom, cognom, LocalDate.parse(data), telefon, correu, quotaAnual));

    }

    public void altaDavanter() {

        sc.nextLine();
        System.out.println("Fica el dni:");

        String dni = sc.nextLine();
        System.out.println("Fica el nom:");
        String nom = sc.nextLine();
        System.out.println("Fica el cognom:");
        String cognom = sc.nextLine();
        System.out.println("Fica la data naix (0000-00-00):");
        String data = sc.nextLine();
        System.out.println("Fica el telefon:");
        int telefon = sc.nextInt();
        sc.nextLine();
        System.out.println("Fica el correu:");
        String correu = sc.nextLine();
        System.out.println("Fica el salari:");
        int salari = sc.nextInt();
        System.out.println("Fica el NSS:");
        sc.nextLine();
        String NSS = sc.nextLine();
        System.out.println("Es titular Si o No");
        boolean titular = false;
        String opcio = sc.nextLine();
        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        } else {
            titular = false;
        }
        System.out.println("Fica els balons recuperats:");
        int balonsRecuperats = sc.nextInt();
        System.out.println("Fica els atacs aturats:");
        int atacsAturats = sc.nextInt();

        membresPlantilla.put(dni, new Davanter(dni, nom, cognom, LocalDate.parse(data), telefon,
                correu, salari, NSS, titular, balonsRecuperats, atacsAturats));
    }

    public void llegirArxiu() throws IOException, ClassNotFoundException {

        FileInputStream flujoFichero = new FileInputStream(file);
        try (ObjectInputStream deserializador = new ObjectInputStream(flujoFichero)) {
            this.socis = (HashMap<String, Soci>) deserializador.readObject();
            this.membresPlantilla = (HashMap<String, MembrePlantilla>) deserializador.readObject();
            MembrePlantilla.setNumeroEmpleats(deserializador.readInt());
            Jugador.setDorsals(deserializador.readInt());
            Soci.setNumLocalitats(deserializador.readInt());
            Soci.setNumSocis(deserializador.readInt());
           

            // System.out.println(Soci.getNumSocis());
            // System.out.println(Soci.getNumLocalitats());
            // System.out.println(Jugador.getDorsals());
            // System.out.println(MembrePlantilla.getNumeroEmpleats());
        }
    }

    public void guardarArxiu() throws IOException {
        FileOutputStream flujoFichero1 = new FileOutputStream(file);
        ObjectOutputStream serializador = new ObjectOutputStream(flujoFichero1);

        serializador.writeObject(socis);
        serializador.writeObject(membresPlantilla);
        serializador.writeInt(MembrePlantilla.getNumeroEmpleats());
        serializador.writeInt(Jugador.getDorsals());
        serializador.writeInt(Soci.getNumLocalitats());
        serializador.writeInt(Soci.getNumSocis());


        // System.out.println(Soci.getNumSocis());
        // System.out.println(Soci.getNumLocalitats());
        // System.out.println(Jugador.getDorsals());
        // System.out.println(MembrePlantilla.getNumeroEmpleats());
        serializador.flush();
        serializador.close();

    }

}

// cridar el calcular salari cada vegada al modificar el objecte