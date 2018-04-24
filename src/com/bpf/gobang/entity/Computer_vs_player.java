package com.bpf.gobang.entity;

public class Computer_vs_player {
	private static Computer_vs_player computer_vs_player = null;
	
	private Computer_vs_player() {
		init();
	}
	
	//提供一个全局的静态方法
    public static Computer_vs_player getComputer_vs_player(){
        if(computer_vs_player == null){
            synchronized(Computer_vs_player.class){
                if(computer_vs_player == null){
                	computer_vs_player = new Computer_vs_player();
                }
            }
        }
        return computer_vs_player;
    }
    
    //玩家落子点获胜组合
  	private boolean[][][] playerTable = new boolean[19][19][1020];  
  	//机器人落子点获胜组合
  	private boolean[][][] robotTable = new boolean[19][19][1020]; 
  	//所有能赢的情况
  	private int[][] win = new int[2][1020];
  	//玩家与电脑得分
  	private int[][][] scores = new int[2][19][19];
  	
	public boolean[][][] getPlayerTable() {
		return playerTable;
	}

	public void setPlayerTable(boolean[][][] playerTable) {
		this.playerTable = playerTable;
	}

	public boolean[][][] getRobotTable() {
		return robotTable;
	}

	public void setRobotTable(boolean[][][] robotTable) {
		this.robotTable = robotTable;
	}

	public int[][] getWin() {
		return win;
	}

	public void setWin(int[][] win) {
		this.win = win;
	}
	
	public int[][][] getScores() {
		return scores;
	}

	public void setScores(int[][][] scores) {
		this.scores = scores;
	}

	public void init() {
		initWinCombination();
	}
	
	public void initWinCombination() {
		//遍历所有的五连子可能情况的权值  
        //横 
		int icount = 0;
        for(int i=0; i<19; i++)  
            for(int j=0;j<15;j++){  
                for(int k=0;k<5;k++){  
                    playerTable[j+k][i][icount] = true;  
                    robotTable[j+k][i][icount] = true;  
                }  
                icount++;  
            }  
        //竖  
        for(int i=0;i<19;i++)  
            for(int j=0;j<15;j++){  
                for(int k=0;k<5;k++){  
                    playerTable[i][j+k][icount] = true;  
                    robotTable[i][j+k][icount] = true;  
                }  
                icount++;  
            }  
        //右斜  
        for(int i=0;i<15;i++)  
            for(int j=0;j<15;j++){  
                for(int k=0;k<5;k++){  
                    playerTable[j+k][i+k][icount] = true;  
                    robotTable[j+k][i+k][icount] = true;  
                }  
                icount++;  
            }  
        //左斜  
        for(int i=0;i<15;i++)  
            for(int j=18;j>=4;j--){  
                for(int k=0;k<5;k++){  
                    playerTable[j-k][i+k][icount] = true;  
                    robotTable[j-k][i+k][icount] = true;  
                }  
                icount++;  
            }  
	}
}