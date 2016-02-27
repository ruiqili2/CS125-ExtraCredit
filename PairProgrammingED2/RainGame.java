//UIUC CS125 SPRING 2016 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2016-02-23T05:36:53-0600.043405826
/**
 * @author ruiqili2, xhu39
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0,level=0;
		int life = 3;
		String text = "";//the number that will slip on screen
		long startTime =System.currentTimeMillis(); //as it literal mean
		//boolean levelUp=false;
		boolean gameover = false;
		Zen.setFont("lucida handwriting-50");
		
		while (Zen.isRunning()&& !gameover) {
			Zen.setColor(252, 239, 232);//background color set
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());//fill in the color
			
			Zen.setFont("lucida handwriting-50");
			Zen.setColor(76, 141, 174);
			Zen.drawText("Level: "+level,Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-100);
			Zen.drawText("Score: "+score,Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-50);
			Zen.drawText("Life: "+life,0,Zen.getZenHeight() / 3-100);//need to be resize
			//reset the whole game
			if (text.length() == 0) {
				Zen.setColor(76, 141, 174);
				Zen.drawText("Ready?",Zen.getZenWidth() / 3,Zen.getZenHeight() / 3+90);
				Zen.sleep(1500);
				
				x = 0;//monitor the location of string vertically
				y = Zen.getZenHeight() / 2;//fix the horizontal trace right in the middle
				dx = level+1;//step size of word horizontally
				dy = 0;
				text = "" + (int) (Math.random() * 999);//get a random number between 0 to 999
				//long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				//score += 3000 / elapsed;//why 3000? why put it here?
			}

			//Zen.setColor(76, 141, 174);
			Zen.drawText(text, x, y);
			
			//Zen.drawText("Level: 0",Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-100);
			//Zen.drawText("Score: "+score,Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-50);
			
			x += dx;
			//text come back from the left end before it all typed right
			if (x >= Zen.getZenWidth()){
				x = 0;
			}
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {//1
				char c = user.charAt(i);
				int feedback = 1+(int) (Math.random() * 5);
				//need to enter the characters in order
					if(c == text.charAt(0)){
						text = text.substring(1,text.length());// all except first character
						score += 10;//increment score 10 point for each correct input
						if (feedback==1){
							Zen.setColor(0, 224, 121);
							Zen.setFont("lucida handwriting-65");
							Zen.drawText("Good job!", 120,360);
							Zen.sleep(300);
						}
						if (feedback==2){
							Zen.setColor(0, 224, 121);
							Zen.setFont("lucida handwriting-65");
							Zen.drawText("Excellent!",120,360);
							Zen.sleep(300);
						}
						if (feedback==3){
							Zen.setColor(0, 224, 121);
							Zen.setFont("lucida handwriting-65");
							Zen.drawText("Thanks god!", 80,360);
							Zen.sleep(300);
						}
						if (feedback==4){
							Zen.setColor(0, 224, 121);
							Zen.setFont("lucida handwriting-65");
							Zen.drawText("Keep going!", 120,360);
							Zen.sleep(300);
						}
						if (feedback==5){
							Zen.setColor(0, 224, 121);
							Zen.setFont("lucida handwriting-65");
							Zen.drawText("You can do it!", 50,360);
							Zen.sleep(300);
						}
					}
					else{
						Zen.setColor(242, 12, 0);
						Zen.setFont("lucida handwriting-65");
						Zen.drawText("Oops!Try again!", 30,360);
						Zen.sleep(300);
						life -= 1;
						if (life == 0){
							gameover = true;
						}
					}
					Zen.sleep(100-level*50);
					
				//Zen.sleep(100-level*50);// sleep for 100 milliseconds also control the speed
			}
			//fix the cycle bug
			if (score/(100*(level+1))>=1){
				//levelUp=true;
				Zen.drawText("Level up!",Zen.getZenWidth() / 3,Zen.getZenHeight() / 2);
				Zen.sleep(500);
				level += 1;
				life += 1;
			}
			

			/*while (levelUp){
				Zen.drawText("Level up!",Zen.getZenWidth() / 3,Zen.getZenHeight() / 2);
				Zen.sleep(500);
				levelUp=false;
			}*///Cyclebug
			//Zen.drawText("Level up!",Zen.getZenWidth() / 3,Zen.getZenHeight() / 2);
			//Zen.sleep(100);
		}
	}

}
