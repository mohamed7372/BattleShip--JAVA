package battleship;

class Coordinant {
    String i;
    String j;
    int iVal;
    int jVal;

    public Coordinant(String i, String j)throws Exception{
        this.i = i;
        this.j = j;
        if(i.matches("[^A-J]") || Integer.parseInt(j)<1 ||
                Integer.parseInt(j)>10) {
            throw new Exception("Error: out of bounds");
        }
        else
            convertToValue();
    }
    private void convertToValue(){
        iVal = (int)i.charAt(0) -65;
        jVal = Integer.valueOf(j)-1;
    }
}
