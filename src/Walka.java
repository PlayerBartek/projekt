import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Walka {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int wybor;
    static int PotionAmount = random.nextInt(3); //ogl to zmiana bo będzie wszystkiego losowo max do 2
    static int SuperPotionAmount = random.nextInt(3);
    static int PokeballAmount = random.nextInt(3);
    static int GreatballAmount = random.nextInt(3);


    public static void rozpocznij(Pokemon mojPokemon, Pokemon przeciwnik) {
        System.out.println("\n====== WALKA ======");
        System.out.println("Twój " + mojPokemon.name + " vs " + przeciwnik.name);

        Spanie();

        while (mojPokemon.isAlive() && przeciwnik.isAlive()) {
            System.out.println("\n" + mojPokemon.name + " HP: " + mojPokemon.hp + "/" + mojPokemon.maxHp);
            System.out.println(przeciwnik.name + " HP: " + przeciwnik.hp + "/" + przeciwnik.maxHp);
            System.out.println("\nCo chcesz zrobić?");

            System.out.println("1. Atakuj");
            System.out.println("2. Ekwipunek");
            System.out.println("3. Ucieknij");


            try {
                wybor = scanner.nextInt();


                switch (wybor) {
                    case 1 -> {
                        wykonajAtak(mojPokemon, przeciwnik);
                        if (!przeciwnik.isAlive()) {
                            System.out.println(przeciwnik.name + " został pokonany!");
                            return;
                        }
                    }
                    case 2 -> {
                        pokazEkwipunek(mojPokemon, przeciwnik);
                        if (!przeciwnik.isAlive()) {
                            System.out.println("Koniec walki.");
                            return;
                        }
                    }
                    case 3 -> {
                        if (random.nextInt(100) < 50) {
                            System.out.println("Udało ci się uciec!");
                            Spanie();
                            return;
                        } else {
                            System.out.println("Nie udało się uciec!");
                            Spanie();
                        }
                    }
                    default -> System.out.println("Niepoprawny wybór, tracisz turę!");
                }

            }
            catch (java.util.InputMismatchException e) {
                    System.out.println("Niepoprawny wybór, tracisz turę!");
                    wybor = 0;
                    scanner.nextLine();
            }
            // tura przeciwnika
            Atak enemyMove = przeciwnik.moves[random.nextInt(przeciwnik.moves.length)];
            przeciwnik.attack(mojPokemon, enemyMove);

            if (!mojPokemon.isAlive()) {
                System.out.println(mojPokemon.name + " został pokonany! Koniec gry!");
                System.exit(0);
            }




        }
    }

    private static void pokazEkwipunek(Pokemon mojPokemon, Pokemon przeciwnik) {
        System.out.println("\n====== EKWIPUNEK ======");
        System.out.println("1. Potion x" + PotionAmount);
        System.out.println("2. Super Potion x" + SuperPotionAmount);
        System.out.println("3. Pokeball x" + PokeballAmount);
        System.out.println("4. Greatball x" + GreatballAmount);
        //System.out.println("5. Cofnij"); bez odwrotu, nie mam weny na to

        System.out.print("Wybierz przedmiot: ");
        int wyborEkwipunku = scanner.nextInt();

        switch (wyborEkwipunku) {
            case 1 -> {
                if (PotionAmount > 0) {
                    mojPokemon.heal(20);
                    PotionAmount--;

                    Spanie();

                } else {
                    System.out.println("Nie masz już żadnych Potionów!");
                }
            }
            case 2 -> {
                if (SuperPotionAmount > 0) {
                    mojPokemon.heal(40);
                    SuperPotionAmount--;

                    Spanie();

                } else {
                    System.out.println("Nie masz już żadnych SuperPotionów!");
                }
            }
            case 3 -> {
                if (PokeballAmount > 0) {
                    PokeballAmount--;

                    System.out.println("Rzucasz Pokeballa...");
                    Spanie();
                    if (random.nextInt(100) < 10) { // 10% szans
                        System.out.println("Udało ci się złapać " + przeciwnik.name + "!");
                        przeciwnik.hp = 0;
                    } else {
                        System.out.println(przeciwnik.name + " uciekł z Pokeballa!");
                        Spanie();

                    }
                } else {
                    System.out.println("Nie masz żadnych Pokeballi!");
                }
            }
            case 4 -> {
                if (GreatballAmount > 0) {
                    GreatballAmount--;
                    System.out.println("Rzucasz Greatballa...");
                    Spanie();
                    if (random.nextInt(100) < 30) { //30% szans
                        System.out.println("Udało ci się złapać " + przeciwnik.name + "!");
                        przeciwnik.hp = 0;
                    } else {
                        System.out.println(przeciwnik.name + " uciekł z Greatballa!");

                        Spanie();

                    }
                } else {
                    System.out.println("Nie masz żadnych Greatballi!");
                }
            }
            default -> System.out.println("Niepoprawny wybór!");
        }


    }

    private static void wykonajAtak(Pokemon mojPokemon, Pokemon przeciwnik) {
        System.out.println("\n====== ATAKUJ ======");
        mojPokemon.showMoves();
        System.out.println("\nWybierz atak:");
        int ruch = scanner.nextInt() - 1;

        switch (ruch) {
            case 1 -> {

            }
        }

        if (ruch < 0 || ruch >= mojPokemon.moves.length) {
            System.out.println("Niepoprawny wybór, tracisz turę!");
        } else {
            mojPokemon.attack(przeciwnik, mojPokemon.moves[ruch]);
        }
    }
    private static void Spanie(){
        try {
            TimeUnit.SECONDS.sleep(1); //spanie
        }
        catch (InterruptedException e) {
            System.out.println("nie tykaj mnie");
        }

    }
}
