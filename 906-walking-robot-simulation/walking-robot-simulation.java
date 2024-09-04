class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int pair[] = new int[]{0,0};
        int dir = +2;
        HashSet<String> hs = new HashSet<>();
        for(int p[]:obstacles){
            hs.add(p[0]+","+p[1]);
        }
        int maxD = 0;
        for(int i = 0;i<commands.length;i++){
            if(commands[i]==-1){
                if(dir==2){
                    dir=1;
                }
                else if(dir==-2){
                    dir=-1;
                }
                else if(dir==-1){
                    dir = 2;
                }
                else
                dir = -2;
            }
            else if(commands[i]==-2){
                if(dir==2){
                    dir=-1;
                }
                else if(dir==-2){
                    dir=1;
                }
                else if(dir==-1){
                    dir =-2;
                }
                else
                dir = 2;
            }
            else{
                if(dir==-1){
                    for(int j = 0;j<commands[i];j++){
                        int newX = pair[0]-1;
                        // int newY = pair[1];
                        if(hs.contains(newX+","+pair[1]))
                        break;
                        pair[0] = newX;
                        maxD = Math.max(maxD,pair[0]*pair[0]+pair[1]*pair[1]);

                    }
                }
                else if(dir==1){
                    for(int j = 0;j<commands[i];j++){
                        int newX = pair[0]+1;
                        if(hs.contains(newX+","+pair[1]))
                        break;
                        pair[0] = newX;
                        maxD = Math.max(maxD,pair[0]*pair[0]+pair[1]*pair[1]);

                    }
                }
                else if(dir==-2){
                    for(int j = 0;j<commands[i];j++){
                        int newY = pair[1]-1;
                        if(hs.contains(pair[0]+","+newY))
                        break;
                        pair[1] = newY;
                        maxD = Math.max(maxD,pair[0]*pair[0]+pair[1]*pair[1]);

                    }
                }
                else{
                    for(int j = 0;j<commands[i];j++){
                        int newY = pair[1]+1;
                        if(hs.contains(pair[0]+","+newY))
                        break;
                        pair[1] = newY;
                        maxD = Math.max(maxD,pair[0]*pair[0]+pair[1]*pair[1]);
                    }
                }
            }
        }
        System.out.println(pair[0]+" "+pair[1]);
        return maxD;

        
    }
}