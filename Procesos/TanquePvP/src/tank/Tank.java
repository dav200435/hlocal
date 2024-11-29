package tank;

import java.util.Random;

public class Tank implements Runnable {
    private static final int MAX_HEALTH = 100;
    private static final int FIELD_SIZE = 20;
    private static final int VISION_RANGE = 7;
    private static final int ATTACK_RANGE = 3;

    private String name;
    private int x;
    private int y;
    private int health;
    private Battlefield battlefield;
    private Random random;

    public Tank(String name, Battlefield battlefield) {
        this.name = name;
        this.battlefield = battlefield;
        this.health = MAX_HEALTH;
        this.random = new Random();
        this.x = random.nextInt(FIELD_SIZE);
        this.y = random.nextInt(FIELD_SIZE);
    }

    public String getName() {
        return name;
    }

    public synchronized int getHealth() {
        return health;
    }

    public synchronized void reduceHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public void run() {
        while (health > 0 && battlefield.isGameRunning()) {
            move();
            attack();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " ha sido destruido.");
        battlefield.removeTank(this);
    }

    private void move() {
        Tank target = findWeakestEnemyInRangeOfVision();

        if (target != null) {
            // Move towards the weakest target within vision range
            if (x < target.x) x++;
            else if (x > target.x) x--;

            if (y < target.y) y++;
            else if (y > target.y) y--;
        } else {
            // Move randomly if no target within vision range
            x += random.nextInt(3) - 1;
            y += random.nextInt(3) - 1;
        }

        // Ensure the tank stays within battlefield boundaries
        x = Math.max(0, Math.min(x, FIELD_SIZE - 1));
        y = Math.max(0, Math.min(y, FIELD_SIZE - 1));
    }

    private void attack() {
        Tank target = findWeakestEnemyInRange();

        if (target != null) {
            synchronized (target) {
                target.reduceHealth(10);
                System.out.println(name + " ataca a " + target.getName() + " (Salud restante: " + target.getHealth() + ")");
                if (target.getHealth() <= 0) {
                    System.out.println(target.getName() + " ha sido destruido por " + name);
                }
            }
        }
    }

    private Tank findWeakestEnemyInRangeOfVision() {
        Tank weakestEnemy = null;
        int lowestHealth = Integer.MAX_VALUE;

        for (Tank enemy : battlefield.getTanks()) {
            if (enemy != this && isInVisionRange(enemy) && enemy.getHealth() > 0) {
                synchronized (enemy) {
                    int enemyHealth = enemy.getHealth();
                    if (enemyHealth < lowestHealth) {
                        lowestHealth = enemyHealth;
                        weakestEnemy = enemy;
                    }
                }
            }
        }
        return weakestEnemy;
    }

    private Tank findWeakestEnemyInRange() {
        Tank weakestEnemy = null;
        int lowestHealth = Integer.MAX_VALUE;

        for (Tank enemy : battlefield.getTanks()) {
            if (enemy != this && isInRange(enemy) && enemy.getHealth() > 0) {
                synchronized (enemy) {
                    int enemyHealth = enemy.getHealth();
                    if (enemyHealth < lowestHealth) {
                        lowestHealth = enemyHealth;
                        weakestEnemy = enemy;
                    }
                }
            }
        }
        return weakestEnemy;
    }

    private boolean isInVisionRange(Tank enemy) {
        int distance = Math.abs(x - enemy.x) + Math.abs(y - enemy.y);
        return distance <= VISION_RANGE;
    }

    private boolean isInRange(Tank enemy) {
        int distance = Math.abs(x - enemy.x) + Math.abs(y - enemy.y);
        return distance <= ATTACK_RANGE;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
