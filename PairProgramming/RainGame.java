//UIUC CS125 SPRING 2016 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2016-02-23T05:36:53-0600.043405826
/**
* @author ruiqili2, xhu39
*/
/*
By the way, here's some early feedback from testing with real patients-
0. The numbers always fall vertically and don't reset back to the top if they fall past the bottom of the screen"
1. They don't like the flicker (hint:  you can use Zen.flipBuffer - see the PongGame)
2. It's possible to make the game die with an exception:
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 0
      at java.lang.String.charAt(String.java:686)
      at RainGame.main(RainGame:41)
3. It would be nice if the game got harder and more interesting.
e.g Some more visual distractions.
4. It would be useful if you could skip the easiest levels.*/
public class RainGame {
 
      public static void main(String[] args) {
            // To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
            // Your netid is the unique part of your @illinois email address
            // Do not put your name or your UIN.
            // REMEMBER TO COMMIT this file...
    	  Zen.setColor(255, 255, 255);
    	  Zen.setFont("lucida handwriting-50");
          Zen.drawText("Click to start.",50,360);
            Zen.waitForClick();
            int x=0, y=0, dx=0, dy=0, score = 0,level=0,m=0,n=0,dm=0,dn=0;
            int life = 3;
            String text = "";//the number that will slip on screen
            long startTime =System.currentTimeMillis(); //as it literal mean
            //boolean levelUp=false;
            boolean gameover = false;
            do {
            	Zen.setFont("lucida handwriting-50");
                 //Zen.setColor(252, 239, 232);//background color set
                 //Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());//fill in the color
                 Zen.drawImage("bg.jpg", 0,0);
                 //Zen.setFont("lucida handwriting-50");
                 //Zen.setColor(76, 141, 174);
                 Zen.setColor(255, 255, 255);
                 Zen.drawText("Level: "+level,0,Zen.getZenHeight() / 3-100);
                 Zen.drawText("Score: "+score,0,Zen.getZenHeight() / 3-50);
                 Zen.drawText("Life: "+life,0,Zen.getZenHeight() / 3-0);//need to be resize
                 //reset the whole game
                 if (text.length() == 0) {
                       Zen.setColor(255, 255, 255);
                       Zen.drawText("Ready?",Zen.getZenWidth() / 3,Zen.getZenHeight() / 3+90);
                       Zen.sleep(500);
                       y = 0;//monitor the location of string vertically
                       x = Zen.getZenWidth() / 2;//fix the horizontal trace right in the middle
                       dx = 0;//step size of word horizontally
                       dy = level+1;
                       text = "" + (int) (Math.random() * 999);//get a random number between 0 to 999
                       startTime = System.currentTimeMillis();
                 }//if
                
                 dm=(int)(Math.random()*5);
                 dn=(int)(Math.random()*3);
                 m+=dm;
                 n+=dn;
                 if (m >= Zen.getZenWidth()){
                       m = 0;
                 }
                 if (n >= Zen.getZenHeight()){
                       n = 0;
                 }
                 Zen.drawImage("star11.gif", m, 200);
                 Zen.drawImage("star11.gif", 250,n);
                 Zen.drawImage("star11.gif", m,n);
                 Zen.drawImage("star11.gif", n,m);
                 Zen.drawImage("star11.gif", Zen.getZenWidth()-n,m);
                 Zen.drawImage("star11.gif", n,Zen.getZenHeight()-m);
                 //Zen.flipBuffer();
                 //Zen.setColor(76, 141, 174);
                 Zen.drawText(text, x, y);
                 
                //Zen.drawText("Level: 0",Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-100);
                 //Zen.drawText("Score: "+score,Zen.getZenWidth() / 3,Zen.getZenHeight() / 3-50);
                
                 x += dx;
                 //Zen.flipBuffer();
                 //text come back from the left end before it all typed right
                 if (y >= Zen.getZenHeight()){
                       y = 0;
                 }//if
                 y += dy;
                
                 // Find out what keys the user has been pressing.
                 String user = Zen.getEditText();
                 // Reset the keyboard input to an empty string
                 // So next iteration we will only get the most recently pressed keys.
                 Zen.setEditText("");
                 for(int i=0;i < user.length();i++) {
                       char c = user.charAt(i);
                       //Zen.flipBuffer();
                       //need to enter the characters in order
                       if (c == 'x'){
                    	  gameover = true;
                    	  Zen.setFont("lucida handwriting-25");
                           Zen.flipBuffer();
                           Zen.setColor(255,255,255);
                           Zen.drawText("You choose to quit the game.", 50,360);
                       }
                       if (c == 'l'&& level <= 2){
                    	  level = 3;
                    	  life += 2;
                       }
                             if(c == text.charAt(0)){
                                  text = text.substring(1,text.length());// all except first character
                                  score += 10;//increment score 10 point for each correct input
                             }//if
                             else{
                                  life -= 1;
                                  if (life == 0){
                                        gameover = true;
                                        Zen.setFont("lucida handwriting-50");
                                        Zen.flipBuffer();
                                        Zen.setColor(255,255,255);
                                        Zen.drawText("Games Over.", 50,360);
                                        Zen.setFont("lucida handwriting-30");
                                        Zen.drawText("Double click to restart", 50,200);
                                  }//if
                                  Zen.sleep(200-level*50);
                             
                             }//else
                             if (score/(100*(level+1))>=1){
                                  //levelUp=true;
                                  Zen.drawText("Level up!",Zen.getZenWidth() / 3,Zen.getZenHeight() / 2);
                                  Zen.sleep(500);
                                  level += 1;
                                  life += 1;
                             }//if
                       }//for
                 Zen.flipBuffer();
                 }while (Zen.isRunning()&& !gameover);//while
            
            if(gameover){
            	Zen.waitForClick();
            	main(args);
            }
           
      }//main
}//class
