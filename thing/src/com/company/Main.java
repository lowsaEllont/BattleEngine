//I should probably use switch statements for some of these but idk.
package com.company;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Game Flow Variables:
        Scanner sc = new Scanner(System.in);
        int turnNumber = 1;
        int command;
        //Both of these need to be initialized:
        boolean phase = true;
        boolean victory = false;

        //Player Variables:
        int [] playerStats = {12, 6, 3, 4};
        String playerName = "Warrior";
        int playerDamage;

        //Enemy Variables:
        int [] enemyStats = {8, 6, 1, 3};
        String enemyName = "Slime";
        int enemyDamage;

        //Displays what Enemy the Player is fighting:
        System.out.println(enemyName+" approaches!");

        //Main Battle Loop:
        while (playerStats[0] >= 0 || enemyStats[0] >= 0)
        {
            //Player Phase:
            if (phase == true)
            {
                System.out.println("====Player Phase====");
                System.out.println(playerName+" enter a command:");
                command = sc.nextInt();

                //Switch Statement for the command the player inputs:
                switch(command)
                {
                    //1) Attack
                    //If the Player enters the Attack Command:
                    case 1:
                        //Player Damage is the Player's Attack minus the Enemy's Defence
                        //This value is then subtracted from the Enemy's HP.
                        playerDamage = playerStats[1] - enemyStats[3];
                        enemyStats[0] -= playerDamage;
                        System.out.println(playerName+" attacks!");
                        System.out.println(enemyName+" takes "+playerDamage+" damage.");
                        //If the Enemy's HP is less than or equal to zero, then the battle
                        //instantly ends, else the battle continues.
                        if (enemyStats[0] <= 0)
                        {
                            System.out.println(enemyName+" has 0 HP left.");
                            break;
                        } else {
                            System.out.println(enemyName + " has " + enemyStats[0] + " HP left.");
                            phase = false;
                            break;
                        }

                    default:
                        System.out.println("You cannot enter that.");
                }
            }

            //Enemy Phase:
            if (phase == false)
            {
                System.out.println("====Enemy Phase====");
                //Enemy Damage is the Enemy's Attack minus the Player's Defence
                //This value is then subtracted from the Player's HP.
                enemyDamage = enemyStats[1] - playerStats[3];
                playerStats[0] -= enemyDamage;
                System.out.println(enemyName+" attacks!");
                System.out.println(playerName+" takes "+enemyDamage+" damage.");
                System.out.println(playerName+" has "+playerStats[0]+" HP left.");
                phase = true;
            }

            if (playerStats[0] <= 0)
            {
                victory = false;
                break;
            }

            if (enemyStats[0] <= 0)
            {
                victory = true;
                break;
            }
        }

        //Victory Statement:
        if (victory == true)
        {
            System.out.println("====Victory! ====");
            System.out.println(playerName+" wins!");
            System.out.println("Gained 5 EXP.");
        } else {
            System.out.println("====Game Over====");
        }
    }
}
