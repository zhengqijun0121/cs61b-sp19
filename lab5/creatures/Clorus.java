package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

/**
 * An implementation of a motile pacifist photosynthesizer.
 *
 * @author Josh Hug
 */
public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;

    /**
     * green color.
     */
    private int g;

    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /**
     * creates a clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     * Returns the name of this occupant.
     */
    @Override
    public String name() {
        return super.name();
    }

    /**
     * Required method that returns a color.
     */
    @Override
    public Color color() {
        return color(r, g, b);
    }

    /**
     * Called when this creature attacks C.
     */
    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    /**
     * Called when this creature moves.
     */
    @Override
    public void move() {
        energy -= 0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Called when this creature chooses stay.
     */
    @Override
    public void stay() {
        energy -= 0.01;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Called when this creature chooses replicate.
     * Must return a creature of the same type.
     */
    @Override
    public Clorus replicate() {
        energy *= 0.5;
        return new Clorus(energy);
    }

    /**
     * Clorus take exactly the following actions based on NEIGHBORS:
     * 1. If there are no empty squares, the Clorus will STAY
     * (even if there are Plips nearby they could attack since plip
     * squares do not count as empty squares).
     * 2. Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * 3. Otherwise, if the Clorus has energy greater than or equal to one,
     * it will REPLICATE to a random empty square.
     * 4. Otherwise, the Clorus will MOVE to a random empty square.
     * <p>
     * Returns an action. The creature is provided information about its
     * immediate NEIGHBORS with which to make a decision.
     */
    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> plipNeighbors = new ArrayDeque<>();

        for (Direction key : neighbors.keySet()) {
            if (neighbors.get(key).name().equals("empty")) {
                emptyNeighbors.add(key);
            } else if (neighbors.get(key).name().equals("plip")) {
                plipNeighbors.add(key);
            }
        }

        if (emptyNeighbors.isEmpty()) {  // Rule 1
            return new Action(Action.ActionType.STAY);
        } else if (plipNeighbors.size() > 0) {  // Rule 2
            return new Action(Action.ActionType.ATTACK, randomEntry(plipNeighbors));
        } else if (energy >= 1.0) {  // Rule 3
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        } else {  // Rule 4
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }
    }
}
