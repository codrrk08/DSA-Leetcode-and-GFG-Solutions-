class Solution {
    public boolean helper(char [][]m,String s,int index,int r,int c){
        if(index==s.length()-1)
        return true;
        char ch = m[r][c];
        m[r][c] = '.';
        //up
        if(r-1>=0 && m[r-1][c]!='.' && m[r-1][c]==s.charAt(index+1)){
            if(helper(m,s,index+1,r-1,c))
            return true;
        }

        //down
        if(r+1<=m.length-1 && m[r+1][c]!='.' && m[r+1][c]==s.charAt(index+1)){
            if(helper(m,s,index+1,r+1,c))
            return true;
        }

        //left
        if(c-1>=0 && m[r][c-1]!='.' && m[r][c-1]==s.charAt(index+1)){
            if(helper(m,s,index+1,r,c-1))
            return true;
        }

        //right
        if(c+1<=m[0].length-1 && m[r][c+1]!='.' && m[r][c+1]==s.charAt(index+1)){
            if(helper(m,s,index+1,r,c+1))
            return true;
        }

        m[r][c] = ch ;
        return false;
        
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j]==word.charAt(0) && helper(board,word,0,i,j))
                return true;
            }
        }
        return false;
    }
}