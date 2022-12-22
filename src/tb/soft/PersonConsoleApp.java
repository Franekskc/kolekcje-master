package tb.soft;

import java.util.*;

/**
 * Program: Aplikacja działająca w oknie konsoli, która umożliwia testowanie
 * operacji wykonywanych różnych kolekcjach
 * <p>
 * Autor: Franciszek Białkowski
 * Data: 22.11.2022
 */
public class PersonConsoleApp {

    Celebrity celebrity1;
    Celebrity celebrity2;
    Celebrity celebrity3;
    Celebrity celebrity4;

    private static final String GREETING_MESSAGE =
            "Program Kolekcje - wersja konsolowa\n" +
                    "Autor: Franciszek Białkowski\n" +
                    "Data: 22.11.2022\n";

    private static final String MENU =
            "    M E N U   G Ł Ó W N E  \n" +
                    "1 - HashSet   \n" +
                    "2 - TreeSet   \n" +
                    "3 - ArrayList   \n" +
                    "4 - LinkedList   \n" +
                    "5 - HashMap   \n" +
                    "6 - TreeMap   \n" +
                    "0 - Zakończ program   \n";

    private static final String CHANGE_MENU =
            "   Wybór funkcji     \n" +
                    "1 - Dodawanie elementów          \n" +
                    "2 - Usuwanie elementów       \n" +
                    "3 - Wypisywanie elementów  \n" +
                    "4 - Porównywanie elementów \n" +
                    "0 - Powrót do menu głównego\n";


    /**
     * ConsoleUserDialog to pomocnicza klasa zawierająca zestaw
     * prostych metod do realizacji dialogu z użytkownikiem
     * w oknie konsoli tekstowej.
     */
    private static final ConsoleUserDialog UI = new JOptionUserDialog();

    public PersonConsoleApp() {
    }


    public static void main(String[] args) throws PersonException {
        // Utworzenie obiektu aplikacji konsolowej
        // oraz uruchomienie głównej pętli aplikacji.
        PersonConsoleApp application = new PersonConsoleApp();
        application.runMainLoop();
    }


    /*
     *  Metoda runMainLoop wykonuje główną pętlę aplikacji.
     *  UWAGA: Ta metoda zawiera nieskończoną pętlę,
     *         w której program się zatrzymuje aż do zakończenia
     *         działania za pomocą metody System.exit(0);
     */
    public void runMainLoop() throws PersonException {
        UI.printMessage(GREETING_MESSAGE);

        celebrity1 = new Celebrity("Jeremy", "Clarkson");
        celebrity1.setBirthYear(1960);
        celebrity1.setJob("Nauczyciel");
        celebrity2 = new Celebrity("James", "May");
        celebrity2.setBirthYear(1963);
        celebrity2.setJob("Gość");
        celebrity3 = new Celebrity("Richard", "Hammond");
        celebrity3.setBirthYear(1969);
        celebrity3.setJob("Student");
        celebrity4 = new Celebrity("Jeremy", "Clarkson");
        celebrity4.setBirthYear(1960);
        celebrity4.setJob("Gość");

        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(MENU + "==>> ")) {
                case 1:
                    System.out.println("-----------HashSet-----------");
                    showHashSet();
                    break;
                case 2:
                    System.out.println("-----------TreeSet-----------");
                    showTreeSet();
                    break;
                case 3:
                    System.out.println("-----------ArrayList-----------");
                    showArrayList();
                    break;
                case 4:
                    System.out.println("-----------LinkedList-----------");
                    showLinkedList();
                    break;
                case 5:
                    System.out.println("-----------HashMap-----------");
                    showHashMap();
                    break;
                case 6:
                    System.out.println("-----------TreeMap-----------");
                    showTreeMap();
                    break;
                case 0:
                    // zakończenie działania programu
                    UI.printInfoMessage("\nProgram zakończył działanie!");
                    System.exit(0);
            } // koniec instrukcji switch
        } // koniec pętli while
    }

    private void showHashSet() {
        Set<Celebrity> celebrities = new HashSet<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    System.out.println("1 - Jeremy Clarkson, 2 - James May, 3 - Richard Hammmond");
                    System.out.println("\nDodawanie elementów 1,2,3 --> set.add(object)");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie elementu 3:");
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu null:");
                    celebrities.add(null);
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. HashSet nie zachowuje kolejności dodawania elementów\n" +
                            "2. Elementy w HashSet nie mogą się powtarzać\n" +
                            "3. HashSet może zawierać elementy null");
                    break;
                case 2:
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> set.remove(object)");
                    celebrities.remove(celebrity2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> set.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(set)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class object : set) System.out.println(object)");
                    for (Celebrity x : celebrities) System.out.println(x);
                    break;
                case 4:
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity4);
                    System.out.println("\nMetoda equals()");
                    System.out.printf("\n1.equals(4) --> %b", celebrity1.equals(celebrity2));
                    System.out.printf("\n1.equals(1) --> %b", celebrity1.equals(celebrity1));

                    System.out.println("\n\nMetoda hashCode()");
                    int counter = 1;
                    for (Celebrity x : celebrities) {
                        System.out.printf("\nWarość hashCode() dla %d - %d", counter, x.hashCode());
                        counter++;
                    }
                    System.out.println("\n\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));

                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

    private void showTreeSet() {
        Set<Celebrity> celebrities = new TreeSet<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    System.out.println("1 - Jeremy Clarkson, 2 - James May, 3 - Richard Hammmond");
                    System.out.println("\nDodawanie elementów 1,2,3 --> set.add(object)");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie elementu 3:");
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu null:");
                    try {
                        celebrities.add(null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. TreeSet zachowuje kolejność dodawania elementów\n" +
                            "2. Elementy w TreeSet nie mogą się powtarzać\n" +
                            "3. TreeSet nie może zawierać elementów null");
                    break;
                case 2:
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> set.remove(object)");
                    celebrities.remove(celebrity2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> set.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(set)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class object : set) System.out.println(object)");
                    for (Celebrity x : celebrities) System.out.println(x);
                    break;
                case 4:
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity4);
                    System.out.println("\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));


                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

    private void showArrayList() {
        List<Celebrity> celebrities = new ArrayList<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson, 2 - James May, 3 - Richard Hammmond");
                    System.out.println("\nDodawanie elementów 1,2,3 --> list.add(object)");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie elementu 3:");
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu null:");
                    try {
                        celebrities.add(null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. ArrayList zachowuje kolejność dodawania elementów\n" +
                            "2. Elementy w ArrayList mogą się powtarzać\n" +
                            "3. ArrayList może zawierać elementy null");
                    break;
                case 2:
                    celebrities.clear();
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);

                    System.out.println("\n"+celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> list.remove(object)");
                    celebrities.remove(celebrity2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> list.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.clear();
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(set)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class object : list) System.out.println(object)");
                    for (Celebrity x : celebrities) System.out.println(x);
                    break;
                case 4:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity4);
                    System.out.println("\nMetoda equals()");
                    System.out.printf("\n1.equals(4) --> %b", celebrity1.equals(celebrity2));
                    System.out.printf("\n1.equals(1) --> %b", celebrity1.equals(celebrity1));

                    System.out.println("\n\nMetoda hashCode()");
                    int counter = 1;
                    for (Celebrity x : celebrities) {
                        System.out.printf("\nWarość hashCode() dla %d - %d", counter, x.hashCode());
                        counter++;
                    }
                    System.out.println("\n\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));


                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

    private void showLinkedList() {
        List<Celebrity> celebrities = new ArrayList<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson, 2 - James May, 3 - Richard Hammmond");
                    System.out.println("\nDodawanie elementów 1,2,3 --> list.add(object)");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie elementu 3:");
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu null:");
                    try {
                        celebrities.add(null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. ArrayList zachowuje kolejność dodawania elementów\n" +
                            "2. Elementy w ArrayList mogą się powtarzać\n" +
                            "3. ArrayList może zawierać elementy null");
                    break;
                case 2:
                    celebrities.clear();
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);

                    System.out.println("\n"+celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> list.remove(object)");
                    celebrities.remove(celebrity2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> list.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.clear();
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(set)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class object : set) System.out.println(object)");
                    for (Celebrity x : celebrities) System.out.println(x);
                    break;
                case 4:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.add(celebrity1);
                    celebrities.add(celebrity2);
                    celebrities.add(celebrity3);
                    celebrities.add(celebrity4);

                    System.out.println("\n\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));

                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

    private void showHashMap() {
        Map<Integer,Celebrity> celebrities = new HashMap<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    celebrities.clear();
                    System.out.println("a - Jeremy Clarkson, b - James May, c - Richard Hammmond");
                    System.out.println("\nDodawanie elementów a,b,c --> map.put(key, value)");
                    celebrities.put(1, celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie wartości c:");
                    celebrities.put(4,celebrity3);
                    celebrities.put(5,celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu a z takim samym kluczem co element poprzedni:");
                    celebrities.put(5,celebrity1);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu o wartości null:");
                    try {
                        celebrities.put(6,null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu o kluczu null:");
                    try {
                        celebrities.put(null,null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. HashMap nie zachowuje kolejności dodawania elementów\n" +
                            "2. Wartości w HashMap mogą się powtarzać\n" +
                            "3. Gdy dodamy element o już istniejącym kluczu, to podmienimy istniejący element\n" +
                            "4. HashMap może zawierać wartości null i jeden klucz null");
                    break;
                case 2:
                    celebrities.clear();
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);

                    System.out.println("\n"+celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> map.remove(key)");
                    celebrities.remove(2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> map.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.clear();
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(map)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class key : map.keySet()) System.out.println(key + ' ' + map.get(i))");
                    for (Integer i : celebrities.keySet()){
                        System.out.println(i+ " " + celebrities.get(i));
                    }
                    break;
                case 4:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    celebrities.put(4,celebrity4);

                    System.out.println("\n\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));


                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

    private void showTreeMap() {
        Map<Integer,Celebrity> celebrities = new TreeMap<>();
        while (true) {
            UI.clearConsole();

            switch (UI.enterInt(CHANGE_MENU + "==>> ")) {
                case 1:
                    celebrities.clear();
                    System.out.println("a - Jeremy Clarkson, b - James May, c - Richard Hammmond");
                    System.out.println("\nDodawanie elementów a,b,c --> map.put(key, value)");
                    celebrities.put(1, celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nWielokrotne dodanie wartości c:");
                    celebrities.put(4,celebrity3);
                    celebrities.put(5,celebrity3);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu a z takim samym kluczem co element poprzedni:");
                    celebrities.put(5,celebrity1);
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu o wartości null:");
                    try {
                        celebrities.put(6,null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nDodanie elementu o kluczu null:");
                    try {
                        celebrities.put(null,null);
                    } catch (NullPointerException e) {
                        System.out.println(e);
                    }
                    System.out.println(celebrities);
                    System.out.println("\nWnioski: \n1. TreeMap zachowuje kolejność dodawania elementów\n" +
                            "2. Wartości w TreeMap mogą się powtarzać\n" +
                            "3. Gdy dodamy element o już istniejącym kluczu, to podmienimy istniejący element\n" +
                            "4. TreeMap może zawierać wartości null, ale nie klucze null");
                    break;
                case 2:
                    celebrities.clear();
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);

                    System.out.println("\n"+celebrities);
                    System.out.println("\nUsuwanie konkretnego elementu --> map.remove(key)");
                    celebrities.remove(2);
                    System.out.println(celebrities);
                    System.out.println("\n Usuwanie wszystkich elementów --> map.clear()");
                    celebrities.clear();
                    System.out.println(celebrities);
                    break;
                case 3:
                    celebrities.clear();
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    System.out.println("Wypisanie całej kolekcji --> System.out.println(map)");
                    System.out.println(celebrities);
                    System.out.println("\nWypisanie elementów kolekcji poprzez iterację po nich --> " +
                            "for (Class key : map.keySet()) System.out.println(key + ' ' + map.get(i))");
                    for (Integer i : celebrities.keySet()){
                        System.out.println(i+ " " + celebrities.get(i));
                    }
                    break;
                case 4:
                    celebrities.clear();
                    System.out.println("1 - Jeremy Clarkson 1960 Nauczyciel, 2 - James May 1963 Gość," +
                            "3 - Richard Hammond 1969 Student, 4 - Jeremy Clarkson 1960 Gość");
                    celebrities.put(1,celebrity1);
                    celebrities.put(2,celebrity2);
                    celebrities.put(3,celebrity3);
                    celebrities.put(4,celebrity4);

                    System.out.println("\n\nMetoda compareTo() - porównuje po roku urodzenia");
                    System.out.printf("\n1.compareTo(4) --> %d (=)", celebrity1.compareTo(celebrity4));
                    System.out.printf("\n1.compareTo(2) --> %d (<)", celebrity1.compareTo(celebrity2));
                    System.out.printf("\n3.compareTo(2) --> %d (>)", celebrity3.compareTo(celebrity2));


                    break;
                case 0:
                    return;
            }  // koniec instrukcji switch
        }
    }

}  // koniec klasy PersonConsoleApp
