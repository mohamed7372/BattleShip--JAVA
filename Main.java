package battleship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AreaBattle battle = new AreaBattle();
        battle.print();
        System.out.println("\nEnter the coordinates of the " + battle.diffShipDescp[0] + "\n");
        int i = 0;
        while(i<battle.diffShip.length){
            boolean tr = setShip(battle.diffShip[i]-1, battle);
            if(tr) {
                battle.print();
                i++;
                if(i<battle.diffShip.length)
                    System.out.println("\nEnter the coordinates of the " + battle.diffShipDescp[i] + "\n");
            }
        }
        // start game
        gameStart(battle);
    }
    public static boolean setShip(int len, AreaBattle battle){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        //
        try {
            battle.addShip(len,new Coordinant(s[0].substring(0,1),s[0].substring(1)),
                    new Coordinant(s[1].substring(0,1),s[1].substring(1)));
            battle.emptyLoc(new Coordinant(s[0].substring(0,1),s[0].substring(1)),
                    new Coordinant(s[1].substring(0,1),s[1].substring(1)));
            battle.setShip(new Coordinant(s[0].substring(0,1),s[0].substring(1)),
                    new Coordinant(s[1].substring(0,1),s[1].substring(1)));
        }catch (Exception e){
            switch (e.toString()){
                case "java.lang.Exception: bad location for ship it's to small":
                    System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
                    break;
                case "java.lang.Exception: bad location no horizontal no vertical":
                    System.out.println("\nError! Wrong ship location! Try again:\n");
                    break;
                case "java.lang.Exception: close another":
                    System.out.println("Error! You placed it too close to another one. Try again:\n");
                    break;
            }
            return false;
        }
        return true;
    }
    public static void gameStart(AreaBattle battle){
        System.out.println("\nThe game starts!\n");
        battle.print();
        System.out.println("\nTake a shot!\n");
        Scanner sc = new Scanner(System.in);
        while(true){
            String inputShot = sc.nextLine();
            Coordinant c = null;
            try {
                c = new Coordinant(inputShot.substring(0, 1), inputShot.substring(1));
            } catch (Exception e) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                continue;
            }
            // if input correct
            battle.takeAShot(c.iVal, c.jVal);
            break;
        }
    }
}

