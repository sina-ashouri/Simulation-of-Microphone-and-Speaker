package main;
import shapes.*;
public class MicThread implements Runnable{

	private Microphone mic;
	private Thread t;
	private int Freq;
	
	public  MicThread(Microphone ph) {
		this.mic = ph;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(Circle.Allcircles.size() > 0){
				Freq = 0;
				for(int i = 0 ; i < Circle.Allcircles.size() ; i++){
					// bord e microphone
					if(mic.getCenter().getdistance(Circle.Allcircles.get(i).getCenter()) < 200)
					Freq = (int)(Circle.Allcircles.get(i).Frequency);
				}
				mic.setfreq(Freq);
				Mainwindow.mainPanel.repaint();
			}
				try {
					t.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
