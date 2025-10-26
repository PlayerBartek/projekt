import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean poprawnyWybor = false;
        int wybor = 0;
        Pokemon mojPokemon;

        System.out.println("=== Witaj w świecie Pokémon! ===\n");

        System.out.println("Wybierz swojego Pokémona:");
        System.out.println("1. Bulbasaur (Trawa)");
        System.out.println("2. Charmander (Ogień)");
        System.out.println("3. Squirtle (Woda)");
        System.out.println("4. Pikachu (Elektryczny)");

        while (!poprawnyWybor) {
            try {
                wybor = scanner.nextInt();

                    switch (wybor) {
                        case 1:
                            mojPokemon = new Bulbasaur();
                            poprawnyWybor = true;
                            break;
                        case 2:
                            mojPokemon = new Charmander();
                            poprawnyWybor = true;
                            break;
                        case 3:
                            mojPokemon = new Squirtle();
                            poprawnyWybor = true;
                            break;
                        case 4:
                            mojPokemon = new Pikachu();
                            poprawnyWybor = true;
                            break;
                        default:
                            System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                            mojPokemon = new Charmander(); //to przemyślane rozwiązanie ok?

                    }
                    if (poprawnyWybor) {
                        // losowy przeciwnik
                        Pokemon[] przeciwnicy = {new Bulbasaur(), new Charmander(), new Squirtle(), new Pikachu()};
                        Pokemon przeciwnik = przeciwnicy[random.nextInt(przeciwnicy.length)];


                        System.out.println("\nNa drodze pojawił się dziki " + przeciwnik.name + "!");
                        Spanie();
                        Walka.rozpocznij(mojPokemon, przeciwnik);
                    }
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                wybor = 0;
                scanner.nextLine();
            }
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
