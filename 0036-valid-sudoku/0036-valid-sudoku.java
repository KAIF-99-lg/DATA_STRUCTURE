class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set  = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num  = board[i][j];

                if(num!='.'){
                    String rowKey = num + "in the row" + i;
                    String colKey = num + "in the col" + j;
                    String boxKey = num + "in the box" + (i / 3) + "-" + (j / 3);

                    if(!set.add(rowKey)||!set.add(colKey)||!set.add(boxKey)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}