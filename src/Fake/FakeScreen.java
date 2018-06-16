package Fake;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class FakeScreen {

    public static void Shutdown() throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process exec = rt.exec("shutdown -r -t 0");
        System.exit(0);
    }


    public static void Count() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
        int num = 20; 
        while (true) {
            if (num > 0) {
                System.out.println(num);
                PlaySound();
                TimeUnit.MILLISECONDS.sleep(1000);
                num -= 1;
            }
            if(num == 0)
            {
                Shutdown();
            }
        }
        
    }
    
   
    public static void PlaySound() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        File sound = new File("src\\Sound\\beep-07.wav"); 
        AudioInputStream audio = AudioSystem.getAudioInputStream(sound); 
        Clip clip = AudioSystem.getClip();
        clip.open(audio); 
        clip.start(); 
    }
    
    
    public void show() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        URL url = this.getClass().getResource("/Image/1111.png"); 
        Icon icon = new ImageIcon(url); 
        JLabel label = new JLabel(icon); 
        JWindow win = new JWindow();
        win.add(label);
        win.pack();
        win.setLocationRelativeTo(null);
        win.setBackground(new Color(0,0,0,0));
        win.setVisible(true);
        Count();
    }
    
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException 
    {
        FakeScreen call = new FakeScreen();
        call.show();
    }
    
}
