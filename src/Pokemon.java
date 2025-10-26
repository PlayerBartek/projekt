import java.util.concurrent.TimeUnit;

public abstract class Pokemon implements Interfejs {
    protected String name;
    protected String type;
    protected int level;
    protected int hp;
    protected int maxHp;

    protected Atak[] moves;

    public Pokemon(String name, String type, int level, int hp, Atak[] moves) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.moves = moves;
    }

    @Override
    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) hp = maxHp;
        System.out.println(name + " został uleczony o " + amount + " HP. (" + hp + "/" + maxHp + ")");
    }

    @Override
    public void attack(Pokemon opponent, Atak move) {
        double multiplier = typeMultiplier(move.type, opponent.type);
        int damage = (int) (move.power * multiplier);
        opponent.hp -= damage;
        if (opponent.hp < 0) opponent.hp = 0;

        System.out.println(name + " użył " + move.odmianaPolska + "!");

        Spanie();

        if (multiplier > 1.0){
            System.out.println("To było super efektywne!");

            Spanie();

        }else if (multiplier < 1.0){
            System.out.println("To nie było zbyt efektywne...");

            Spanie();

        }

        System.out.println(opponent.name + " otrzymał " + damage + " obrażeń. (" + opponent.hp + "/" + opponent.maxHp + ")");
        Spanie();
    }

    protected double typeMultiplier(String attackType, String targetType) {
        if (attackType.equals("ognisty") && targetType.equals("trawiasty")) return 2.0;
        if (attackType.equals("wodny") && targetType.equals("ognisty")) return 2.0;
        if (attackType.equals("trawiasty") && targetType.equals("wodny")) return 2.0;
        if (attackType.equals("elektryczny") && targetType.equals("wodny")) return 2.0;
        if (attackType.equals("ognisty") && targetType.equals("wodny")) return 0.5;
        if (attackType.equals("wodny") && targetType.equals("trawiasty")) return 0.5;
        if (attackType.equals("trawiasty") && targetType.equals("ognisty")) return 0.5;
        if (attackType.equals("elektryczny") && targetType.equals("trawiasty")) return 0.5;

        return 1.0;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public void showMoves() {
        for (int i = 0; i < moves.length; i++) {
            System.out.println((i + 1) + ". " + moves[i].name + " (" + moves[i].type + ") ");
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
