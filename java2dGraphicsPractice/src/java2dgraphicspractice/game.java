package java2dgraphicspractice;

import java.util.logging.Level;
import java.util.logging.Logger;
import java2dgraphicspractice.display;

public class game implements Runnable{
    
    private display display; 
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    public game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    private void init(){
        display = new display(title, width, height);
    }
    
    private void tick(){
        
    }
    
    private void render(){
         
    }
    
    public void run(){
        System.out.println("ran");
        init();
        
        while(running){
            tick();
            render();
        }
        
        stop();
    }
    
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread();
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
