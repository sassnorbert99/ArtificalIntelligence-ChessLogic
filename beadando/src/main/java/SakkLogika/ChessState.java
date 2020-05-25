package SakkLogika;


public class ChessState extends State {
    char[][] table = new char[8][8];
    final char BISHOP = 'b';
    final char PAWN = 'p';
    final char EMPTY = '.';

    final int NUM_OF_FIGURES = 7;
    Pos bishopPos;



    public ChessState(){
        bishopPos = new Pos(0,0);
        clearTable();
        setBishop(new Pos(7,0));
        table[3][2] = PAWN;
        table[5][2] = PAWN;
        table[1][4] = PAWN;
        table[5][4] = PAWN;
        table[2][5] = PAWN;
        table[4][5] = PAWN;


    }

    public void printTable(){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(String.format(" %s", table[i][j]));
            }
            System.out.println();
        }
    }



    private void setBishop(Pos newPosition){
        table[bishopPos.x][bishopPos.y] = EMPTY;
        bishopPos.x = newPosition.x;
        bishopPos.y = newPosition.y;
        table[bishopPos.x][bishopPos.y] = BISHOP;
    }



    @Override
    public boolean isState() {
        int sum = 0;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] != EMPTY) {
                    sum++;
                }

            }
        }
        return sum == NUM_OF_FIGURES;
    }

    public void clearTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = EMPTY;
            }
        }
    }

    @Override
    public boolean isGoalState() {
        return table[0][7] == BISHOP;

    }

    @Override
    public int getNumberOfOperators() {
        return 4*7;
    }

    @Override
    public State superOperator(int i) {
       return move(i/7, i % 7 + 1);
    }
    private State move(int direction, int length){
        if (!preMove(direction, length)) {
            return null;
        }
        ChessState next = new ChessState();
        next.setBishop(getStep(bishopPos, direction, length));

        if (next.isState()) {
            return next;
        }
        return null;
    }

    private Pos getStep(Pos currentPos, int direction, int length){
        Pos dirVector = getDirection(direction, length);
        return new Pos(currentPos.x + dirVector.x * length, currentPos.y + dirVector.y * length);
    }



    private boolean preMove(int direction, int length) {

        Pos step = getStep(bishopPos , direction, length);
        return step.x <= 7 && step.x >= 0 && step.y >= 0 && step.y <= 7 && lineOfSightFree(direction, length);
    }

    private Pos getDirection(int direction, int length){
        switch (direction){
            case 0:return new Pos(1, 1);
            case 1:return new Pos(-1, 1);
            case 2:return new Pos(1, -1);
            case 3:return new Pos(-1, -1);
        }
        return null;
    }

    private boolean lineOfSightFree(int direction, int length){
        Pos dirVector = getDirection(direction, length);
        int px = bishopPos.x;
        int py = bishopPos.y;
        for (int i = 1; i <= length; i++) {
            if (table[px + dirVector.x * i][py + dirVector.y * i] == PAWN) return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return String.format("%s;%s", bishopPos.y, bishopPos.x);
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof ChessState)) return false;
        ChessState other = (ChessState)o;
        return this.bishopPos.x == other.bishopPos.x && this.bishopPos.y == other.bishopPos.y;
    }

    @Override
    public int hashCode() {
        return (bishopPos.x + 100) * (bishopPos.y + 200);

    }

}
