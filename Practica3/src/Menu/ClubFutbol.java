package Menu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import Objects.Davanter;
import Objects.Defensa;
import Objects.Entrenador;
import Objects.MembrePlantilla;
import Objects.Migcampista;
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

    public static void main(String[] args) {
        ClubFutbol clubTarrega = new ClubFutbol();
        clubTarrega.gestioClubFutbol();

    }

    public ClubFutbol() {

    }

    public void gestioClubFutbol() {

        String niei = "x461";
        String nie1 = "x462";
        String nie2 = "x4612";
        socis.put(niei, new Soci("x461", "Nazar ", "Yakovyna",
                LocalDate.parse("2020-01-08"), 642753900, "soci1@gmail.com", 1000));
        socis.put(nie1, new Soci("x461", "Clara ", "Portillo",
                LocalDate.parse("2020-01-08"), 642753900, "soci1@gmail.com", 3000));
        socis.put(nie2, new Soci("x461", "Fermin ", "Costa",
                LocalDate.parse("2020-01-08"), 642753900, "soci1@gmail.com", 1000));

        membresPlantilla.put("x12312", new Davanter("nie", "Nazar", "yakovyna", LocalDate.parse("2020-01-08"), 641,
                "email@gmail.com", 1900, "x3123123", true, 33, 3));

        System.out.println(membresPlantilla.get("x12312").toString());

        membresPlantilla.put("x123", new Defensa("nie", "Nazar", "yakovyna", LocalDate.parse("2020-01-08"), 641,
                "email@gmail.com", 1900, "x3123123", true, 33, 3));
        membresPlantilla.put("x123123", new Davanter("nie", "Nazar", "yakovyna", LocalDate.parse("2020-01-08"), 641,
                "email@gmail.com", 1900, "x3123123", true, 33, 3));

        System.out.println(membresPlantilla.get("x123").toString());

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

                    break;
                case '2':

                    gestioSocis();

                    break;
                case '3':

                    gestioPlantilla();

                    break;
                case '4':

                    mostrarDadesEconomiques();

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

                    break;
                case '2':

                    baixaSoci();

                    break;
                case '3':

                    modificarSoci();

                    break;
                case '4':

                    mostrarSocis();

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

                    break;
                case '2':

                    ordenarPerLocalitat();

                    break;
                case '3':

                    ordenadrPerQuota();

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
        System.out.println("Fica el nie per modificar");
        sc.nextLine();
        String nie = sc.nextLine();

        try {
            System.out.println(socis.get(nie).toString());

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
                        socis.get(nie).setNom(nom);

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        socis.get(nie).setCognom(cognom);

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        socis.get(nie).setTelefon(telefon);

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        socis.get(nie).setEmail(email);

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        socis.get(nie).setQuotaAnual(quotaAnual);

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
            System.out.println("aquet nie no existeix");
        }

    }

    private void baixaSoci() {

        System.out.println("Fica el nie que vols eliminar");

        sc.nextLine();
        String nie = sc.nextLine();
        try {
            System.out.println("esta eliminat el " + socis.get(nie).toString());
            socis.remove(nie);
        } catch (NullPointerException e) {
            System.out.println("Aquet nie no existeix");
        }

    }

    public void gestioPlantilla() {

        do {
            System.out.println("**************Club Futbol*****************");
            System.out.println("1. Gestio de entrenadors");
            System.out.println("2. Gestio de preparadors fisics");
            System.out.println("3. Gestio de porters");
            System.out.println("4. Gestio de defenses");
            System.out.println("5. Gestio de migcampistes");
            System.out.println("6. Gestio de davanters");
            System.out.println("7. Mostrar els treballadors");

            System.out.println("8. Sortir");

            String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    gestioEntrenadors();
                    break;
                case '2':
                    gestioPreparadorsFisics();
                    break;
                case '3':
                    gestioPorters();
                    break;
                case '4':
                    gestioDefenses();
                    break;
                case '5':
                    gestioMigcampistes();
                    break;
                case '6':
                    gestioDavanters();
                    break;
                case '7':
                    mostrarTreballadorsOrdenatsPerClasse();
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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarDavanter();
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

        System.out.println("Fica el nie per modificar");
        sc.nextLine();
        String nie = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(nie).toString());

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
                        membresPlantilla.get(nie).setNom(nom);

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(nie).setCognom(cognom);

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(nie).setTelefon(telefon);

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(nie).setEmail(email);

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(nie).setTelefon(quotaAnual);

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(nie).setNSS(nss);

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
            System.out.println("aquet nie no existeix");
        }

    }

    private void baixaTreballador() {
        System.out.println("Fica el nie per donar baixa");

        sc.nextLine();
        String nie = sc.nextLine();
        try {
            System.out.println("esta eliminat el " + socis.get(nie).toString());
            socis.remove(nie);
        } catch (NullPointerException e) {
            System.out.println("Aquet nie no existeix");
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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarMigCampista();
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
        System.out.println("Fica el nie per modificar");
        sc.nextLine();
        String nie = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(nie).toString());

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
                        membresPlantilla.get(nie).setNom(nom);

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(nie).setCognom(cognom);

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(nie).setTelefon(telefon);

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(nie).setEmail(email);

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(nie).setSouBase(quotaAnual);

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(nie).setNSS(nss);

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
            System.out.println("aquet nie no existeix");
        }

    }

    private void altaMigCampista() {

        sc.nextLine();
        System.out.println("Fica el nie:");

        String nie = sc.nextLine();
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
        System.out.println("Fica els balons recuperats:");
        int balonsRecuperats = sc.nextInt();
        System.out.println("Fica asistencies gol:");
        int asistenciesGol = sc.nextInt();
     

        System.out.println("Es titular Si o No");
        boolean titular = false;
        String opcio = sc.nextLine();
        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        }

        membresPlantilla.put(nie,new Migcampista(nie, nom, cognom,  LocalDate.parse(data), telefon, correu,  salari, NSS, titular, balonsRecuperats, asistenciesGol));

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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarDefensa();
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
    }

    private void modificarDefensa() {
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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarPorters();
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
    }

    private void modificarPorters() {
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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarPreparadorsFisics();
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
        System.out.println("Fica el nie:");

        String nie = sc.nextLine();
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


        membresPlantilla.put(nie,new PreparadorFisic(nie, nom, cognom,  LocalDate.parse(data), telefon, correu, salari, NSS,  LocalDate.parse(dataFitx)));
    }

    private void modificarPreparadorsFisics() {

        System.out.println("Fica el nie per modificar");
        sc.nextLine();
        String nie = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(nie).toString());

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
                        membresPlantilla.get(nie).setNom(nom);

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(nie).setCognom(cognom);

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(nie).setTelefon(telefon);

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(nie).setEmail(email);

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(nie).setSouBase(quotaAnual);

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(nie).setNSS(nss);

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
            System.out.println("aquet nie no existeix");
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
                    break;
                case '2':
                    baixaTreballador();
                    break;
                case '3':
                    modificarEntrenadors();
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
        System.out.println("Fica el nie:");

        String nie = sc.nextLine();
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

        membresPlantilla.put(nie,
                new Entrenador(nie, nom, cognom, LocalDate.parse(data), telefon, correu, salari, NSS));
        
    }

    private void modificarEntrenadors() {

        System.out.println("Fica el nie per modificar");
        sc.nextLine();
        String nie = sc.nextLine();

        try {
            System.out.println(membresPlantilla.get(nie).toString());

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
                        membresPlantilla.get(nie).setNom(nom);

                        break;
                    case '2':

                        System.out.println("Fica el cognom:");
                        sc.nextLine();
                        String cognom = sc.nextLine();
                        membresPlantilla.get(nie).setCognom(cognom);

                        break;
                    case '3':

                        System.out.println("Fica el telefon:");
                        sc.nextLine();
                        int telefon = sc.nextInt();
                        membresPlantilla.get(nie).setTelefon(telefon);

                        break;
                    case '4':

                        System.out.println("Fica el Email:");
                        sc.nextLine();
                        String email = sc.nextLine();
                        membresPlantilla.get(nie).setEmail(email);

                        break;
                    case '5':

                        System.out.println("Fica la QuotaAnual:");
                        sc.nextLine();
                        int quotaAnual = sc.nextInt();
                        membresPlantilla.get(nie).setSouBase(quotaAnual);

                        break;
                    case '6':

                        System.out.println("Fica el NSS:");
                        sc.nextLine();
                        String nss = sc.nextLine();
                        membresPlantilla.get(nie).setNSS(nss);

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
            System.out.println("aquet nie no existeix");
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
        System.out.println("Fica el nie:");

        String nie = sc.nextLine();
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

        socis.put(nie, new Soci(nie, nom, cognom, LocalDate.parse(data), telefon, correu, quotaAnual));

    }

    public void altaDavanter() {

        sc.nextLine();
        System.out.println("Fica el nie:");

        String nie = sc.nextLine();
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
        System.out.println("Es titular Si o No");
        boolean titular = false;
        String opcio = sc.nextLine();
        if (opcio.equals("Si") || opcio.equals("si")) {
            titular = true;
        }
        System.out.println("Fica els balons recuperats:");
        int balonsRecuperats = sc.nextInt();
        System.out.println("Fica els atacs aturats:");
        int atacsAturats = sc.nextInt();

        membresPlantilla.put(nie, new Davanter(nie, nom, cognom, LocalDate.parse(data), telefon,
                correu, salari, NSS, titular, balonsRecuperats, atacsAturats));

    }

}
