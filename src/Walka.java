import java.util.Scanner;
import java.util.Random;

public class Walka {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int wybor;
    static int PotionAmount = 2; //zawsze 2 na start

    public static void rozpocznij(Pokemon mojPokemon, Pokemon przeciwnik) {
        System.out.println("\n====== WALKA ======");
        System.out.println("Twój " + mojPokemon.name + " vs " + przeciwnik.name);

        while (mojPokemon.isAlive() && przeciwnik.isAlive()) {
            System.out.println("\n" + mojPokemon.name + " HP: " + mojPokemon.hp + "/" + mojPokemon.maxHp);
            System.out.println(przeciwnik.name + " HP: " + przeciwnik.hp + "/" + przeciwnik.maxHp);
            System.out.println("\nCo chcesz zrobić?");
            if (PotionAmount > 0) {
                System.out.println("1. Atakuj");
                System.out.println("2. Użyj potion'a " + "(pozostało potion'ów -> " + PotionAmount + ")" );
                System.out.println("3. Ucieknij");
            }else {
                System.out.println("1. Atakuj");
                System.out.println("2. Ucieknij");
            }
            try {
                wybor = scanner.nextInt();

                if (PotionAmount > 0) {

                    if (wybor == 3) {
                        if (random.nextInt(100) < 50) {
                            System.out.println("Udało ci się uciec!");
                            return;
                        } else {
                            System.out.println("Nie udało się uciec!");
                        }
                    } else if (wybor == 2 && (PotionAmount > 0)) {
                        mojPokemon.heal(20);
                        PotionAmount = PotionAmount - 1;
                    } else if (wybor == 1) {
                        System.out.println("\nWybierz atak:");
                        mojPokemon.showMoves();
                        int ruch = scanner.nextInt() - 1;
                        if (ruch < 0 || ruch >= mojPokemon.moves.length) {
                            System.out.println("Niepoprawny wybór, tracisz turę!");
                        } else {
                            mojPokemon.attack(przeciwnik, mojPokemon.moves[ruch]);
                        }
                        if (!przeciwnik.isAlive()) {
                            System.out.println(przeciwnik.name + " został pokonany!");
                            return;
                        }
                    }

                } else {
                    if (wybor == 2) {
                        if (random.nextInt(100) < 50) {
                            System.out.println("Udało ci się uciec!");
                            return;
                        } else {
                            System.out.println("Nie udało się uciec!");
                        }
                    } else if (wybor == 1) {
                        System.out.println("\nWybierz atak:");
                        mojPokemon.showMoves();
                        int ruch = scanner.nextInt() - 1;
                        if (ruch < 0 || ruch >= mojPokemon.moves.length) {
                            System.out.println("Niepoprawny wybór, tracisz turę!");
                        } else {
                            mojPokemon.attack(przeciwnik, mojPokemon.moves[ruch]);
                        }

                        if (!przeciwnik.isAlive()) {
                            System.out.println(przeciwnik.name + " został pokonany!");
                            return;
                        }
                    }
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
}
