

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
        if (multiplier > 1.0) System.out.println("To było super efektywne!");
        else if (multiplier < 1.0) System.out.println("To nie było zbyt efektywne...");
        System.out.println(opponent.name + " otrzymał " + damage + " obrażeń. (" + opponent.hp + "/" + opponent.maxHp + ")");
    }

    protected double typeMultiplier(String attackType, String targetType) {
        if (attackType.equals("fire") && targetType.equals("grass")) return 2.0;
        if (attackType.equals("water") && targetType.equals("fire")) return 2.0;
        if (attackType.equals("grass") && targetType.equals("water")) return 2.0;
        if (attackType.equals("electric") && targetType.equals("water")) return 2.0;
        if (attackType.equals("fire") && targetType.equals("water")) return 0.5;
        if (attackType.equals("water") && targetType.equals("grass")) return 0.5;
        if (attackType.equals("grass") && targetType.equals("fire")) return 0.5;
        if (attackType.equals("electric") && targetType.equals("grass")) return 0.5;

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
}
