package com.bpf.gobang.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.bpf.gobang.entity.Checkerboard;
import com.bpf.gobang.frame.CheckerboardFrame;
import com.bpf.gobang.frame.MenuFrame;
import com.bpf.gobang.function.TimerFunction;

public class MenuMouseListener extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		//判断光标在哪个按钮上
		//点击战绩按钮
		if(e.getX() >= 85 && e.getX() <= 215 && e.getY() >= 20 && e.getY() <= 120) {
		}
		//点击规则按钮
		if(e.getX() >= 315 && e.getX() <= 455 && e.getY() >= 30 && e.getY() <= 120) {
//			menu.setCURRENT_BUTTON("rules");
		}
		
		if(e.getX() >= 167 && e.getX() <= 367) {
			//点击联机模式按钮
			if(e.getY() >= 250 && e.getY() <= 305) {
//				menu.setCURRENT_BUTTON("play_online");
			}
			//点击人机对弈按钮
			else if(e.getY() >= 360 && e.getY() <= 415){
//				menu.setCURRENT_BUTTON("player_vs_computer");
			}
			//点击双人对弈按钮
			else if(e.getY() >= 470 && e.getY() <= 525){
				//将计时器线程运行标志位打开
				Checkerboard.getCheckerboard().setTimerRun(true);
				//创建并开启计时器线程
				Thread timer = new Thread(new TimerFunction());
				timer.start();
				
				//点击此按钮关闭菜单窗体，打开棋盘窗体
				MenuFrame.getMenuFrame().dispose();
				CheckerboardFrame.getCheckerboardFrame().setVisible(true);
			}
			//点击关于按钮
			else if(e.getY() >= 580 && e.getY() <= 635){
//				menu.setCURRENT_BUTTON("about");
			}
		}
	}
	
}
