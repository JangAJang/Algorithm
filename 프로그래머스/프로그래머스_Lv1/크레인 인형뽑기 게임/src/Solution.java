import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] machine = makeMachine(board);
        return countDeleted(machine, moves);
    }

    private Stack<Integer>[] makeMachine(int[][] board) {
        Stack<Integer>[] machine = new Stack[board.length];
        initializeMachine(machine);
        putDollInMachine(board, machine);
        return machine;
    }

    private void initializeMachine(Stack<Integer>[] machine) {
        for(int i=0; i<machine.length; i++){
            machine[i] = new Stack<>();
        }
    }

    private void putDollInMachine(int[][] board, Stack<Integer>[] machine) {
        for (int i = board.length - 1; i >= 0; i--) {
            putDollInLineToMachine(board[i], machine);
        }
    }

    private void putNumberIfNotZero(int x, Stack<Integer> each) {
        if (x != 0) each.push(x);
    }

    private void putDollInLineToMachine(int[] board, Stack<Integer>[] machine) {
        for (int j = board.length - 1; j >= 0; j--) {
            putNumberIfNotZero(board[j], machine[j]);
        }
    }

    private int countDeleted(Stack<Integer>[] machine, int[] moves) {
        Stack<Integer> pocket = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            answer += pollFromMachine(machine, move, pocket);
        }
        return answer*2;
    }

    private int pollFromMachine(Stack<Integer>[] machine, int x, Stack<Integer> pocket){
        if(machine[x-1].isEmpty()) return 0;
        if(pocket.isEmpty()) return putDoll(pocket, machine[x-1].pop());
        else if(machine[x - 1].peek().equals(pocket.peek())) return deleteSameDoll(machine[x-1], pocket);
        return putDoll(pocket, machine[x-1].pop());
    }

    private int putDoll(Stack<Integer> pocket, int doll){
        pocket.push(doll);
        return 0;
    }

    private int deleteSameDoll(Stack<Integer> each, Stack<Integer> pocket){
        each.pop();
        pocket.pop();
        return 1;
    }
}