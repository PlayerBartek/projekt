public class ListaAtakow {

    public static Atak[] getBulbasaurMoves() {
        return new Atak[]{
                new Atak("Pchnięcie","Pchnięcia", 8, "normalny"),
                new Atak("Dzikie Pnącza","Dzikich Pnączy", 10, "trawiasty"),
                new Atak("Ostry Liść","Ostrego Liścia", 14, "trawiasty"),
                new Atak("Pyłek snu", "Pyłku snu", 5, "trawiasty")
        };
    }

    public static Atak[] getCharmanderMoves() {
        return new Atak[]{
                new Atak("Drapanie","Drapania", 8, "normalny"),
                new Atak("Żar","Żaru", 12, "ognisty"),
                new Atak("Miotacz płomieni","Miotacza płomieni", 18, "ognisty"),
                new Atak("Ukośne Cięcie","Ukośnego Cięcia", 14, "normalny")
        };
    }

    public static Atak[] getSquirtleMoves() {
        return new Atak[]{
                new Atak("Pchnięcie","Pchnięcia", 8, "normalny"),
                new Atak("Wodna Broń","Wodnej Broni", 12, "wodny"),
                new Atak("Bąbelkowy Promień","Bąbelkowego Promieńa", 15, "wodny"),
                new Atak("Gryzienie","Gryzienia", 10, "normalny")
        };
    }

    public static Atak[] getPikachuMoves() {
        return new Atak[]{
                new Atak("Szybki atak", "Szybkiego ataku", 10, "normalny"),
                new Atak("Elektrowstrząs","Elektrowstrząsu", 14, "elektryczny"),
                new Atak("Piorun","Pioruna", 18, "elektryczny"),
                new Atak("Stalowy ogon","Stalowego ogona", 12, "normalny")
        };
    }
}
