package battleship;

class AreaBattle {
    char[][] area, areaShot;
    // default init area
    {area = new char[10][10];
    areaShot = new char[10][10];
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                area[i][j] = '~';
            }
        }
    }
    int diffShip[] = {5, 4, 3, 3, 2};
    String diffShipDescp[] = {"Aircraft Carrier (5 cells):",
            "Battleship (4 cells):",
            "Submarine (3 cells):",
            "Cruiser (3 cells):",
            "Destroyer (2 cells):"};

    public void addShip(int len, Coordinant begin, Coordinant end)throws Exception{
        if(begin.iVal == end.iVal){
            int min = begin.jVal< end.jVal? begin.jVal : end.jVal;
            int max = begin.jVal< end.jVal? end.jVal : begin.jVal;
            if(min + len >= 10 || min + len != max){
                throw new Exception("bad location for ship it's to small");
            }
        }
        else if(begin.jVal == end.jVal){
            int min = begin.iVal< end.iVal? begin.iVal : end.iVal;
            int max = begin.iVal< end.iVal? end.iVal : begin.iVal;
            if(min + len >= 10 || min + len != max){
                throw new Exception("bad location for ship it's to small");
            }
        }
        else if(begin.iVal != end.iVal && begin.jVal != end.jVal)
            throw new Exception("bad location no horizontal no vertical");
        System.out.println();
    }
    public void emptyLoc(Coordinant begin, Coordinant end)throws Exception{
        if(begin.iVal == end.iVal){
            int min = begin.jVal< end.jVal? begin.jVal : end.jVal;
            int max = begin.jVal< end.jVal? end.jVal : begin.jVal;
            for(int i=min; i<=max; i++){
                if(checkAround(begin.iVal, i))
                    throw  new Exception("close another");
            }
        }
        else if(begin.jVal == end.jVal){
            int min = begin.iVal< end.iVal? begin.iVal : end.iVal;
            int max = begin.iVal< end.iVal? end.iVal : begin.iVal;
            for(int i=min; i<=max; i++){
                if(checkAround(i, begin.jVal))
                    throw  new Exception("close another");
            }
        }
    }
    private boolean checkAround(int posI, int posJ){
        for(int i=posI-1; i<=posI+1; i++){
            for(int j=posJ-1; j<=posJ+1; j++){
                if(i>=0 && i<10 && j>=0 && j<10){
                    if(area[i][j] == 'O') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void setShip(Coordinant begin, Coordinant end){
        if(begin.iVal == end.iVal){
            int min = begin.jVal< end.jVal? begin.jVal : end.jVal;
            int max = begin.jVal< end.jVal? end.jVal : begin.jVal;
            for(int i=min; i<=max; i++){
                area[begin.iVal][i] = 'O';
            }
        }
        else if(begin.jVal == end.jVal){
            int min = begin.iVal< end.iVal? begin.iVal : end.iVal;
            int max = begin.iVal< end.iVal? end.iVal : begin.iVal;
            for(int i=min; i<=max; i++){
                area[i][begin.jVal] = 'O';
            }
        }
    }

    public void takeAShot(int i, int j){
        if(area[i][j] == 'O'){
            areaShot[i][j] = 'X';
            printShot();
            System.out.println("\nYou hit a ship!\n");
        }
        else{
            areaShot[i][j] = 'M';
            printShot();
            System.out.println("\nYou missed!\n");
        }
    }

    public void print(){
        System.out.print(" ");
        for (int i=1; i<=10; i++) {
            System.out.print(" " + i);
        }
        for (int i=0; i<10; i++){
            System.out.print("\n" + (char)(65+i));
            for (int j=0; j<10; j++){
                System.out.print(" " + area[i][j]);
            }
        }
        System.out.println();
    }
    public void printEmpty(){
        System.out.print(" ");
        for (int i=1; i<=10; i++) {
            System.out.print(" " + i);
        }
        for (int i=0; i<10; i++){
            System.out.print("\n" + (char)(65+i));
            for (int j=0; j<10; j++){
                System.out.print(" ~");
            }
        }
        System.out.println();
    }
    public void printShot(){
        System.out.print(" ");
        for (int i=1; i<=10; i++) {
            System.out.print(" " + i);
        }
        for (int i=0; i<10; i++){
            System.out.print("\n" + (char)(65+i));
            for (int j=0; j<10; j++){
                if(areaShot[i][j] == 'M' || areaShot[i][j] == 'X')
                    System.out.print(" " + areaShot[i][j]);
                else
                    System.out.print(" ~");
            }
        }
        System.out.println();
    }
    public void printEndGame(){
        System.out.print(" ");
        for (int i=1; i<=10; i++) {
            System.out.print(" " + i);
        }
        for (int i=0; i<10; i++){
            System.out.print("\n" + (char)(65+i));
            for (int j=0; j<10; j++){
                if(areaShot[i][j] == 'M' || areaShot[i][j] == 'X')
                    System.out.print(" " + areaShot[i][j]);
                else
                    System.out.print(" " + area[i][j]);
            }
        }
        System.out.println();
    }
}
