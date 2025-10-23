public class ListaAtakow {

    public static Atak[] getBulbasaurMoves() {
        return new Atak[]{
                new Atak("Pchnięcie","Pchnięcia", 8, "normal"),
                new Atak("Dzikie Pnącza","Dzikich Pnączy", 10, "grass"),
                new Atak("Ostry Liść","Ostrego Liścia", 14, "grass"),
                new Atak("Pyłek snu", "Pyłku snu", 5, "grass")
        };
    }

    public static Atak[] getCharmanderMoves() {
        return new Atak[]{
                new Atak("Drapanie","Drapania", 8, "normal"),
                new Atak("Żar","Żaru", 12, "fire"),
                new Atak("Miotacz płomieni","Miotacza płomieni", 18, "fire"),
                new Atak("Ukośne Cięcie","Ukośnego Cięcia", 14, "normal")
        };
    }

    public static Atak[] getSquirtleMoves() {
        return new Atak[]{
                new Atak("Pchnięcie","Pchnięcia", 8, "normal"),
                new Atak("Wodna Broń","Wodnej Broni", 12, "water"),
                new Atak("Bąbelkowy Promień","Bąbelkowego Promieńa", 15, "water"),
                new Atak("Gryzienie","Gryzienia", 10, "normal")
        };
    }

    public static Atak[] getPikachuMoves() {
        return new Atak[]{
                new Atak("Szybki atak", "Szybkiego ataku", 10, "normal"),
                new Atak("Elektrowstrząs","Elektrowstrząsu", 14, "electric"),
                new Atak("Piorun","Pioruna", 18, "electric"),
                new Atak("Stalowy ogon","Stalowego ogona", 12, "normal")
        };
    }
}
