package vue_defaut;




import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Chronometre implements ActionListener 
{
	protected JLabel viewTime;  // composant permettant l'affichage du temps ecoule
	protected int timeCount;	// variable permettant de memoriser le temps ecoule
        protected int ms;//milliseconde
        protected int s=0;//secondes
        protected int m=0;//minutes
        protected int h=0;//heures
protected Timer timer;		// objet javax.swing.Timer

	
	// construit un timer avec le temps et le delay donne
	public Chronometre (JLabel label)
	{	
		
		this.timeCount = 0;
		this.viewTime = label;
		this.timer = new Timer (1, this);
                
	}
	
	
	// lance le compteur de temps 
	public void startChrono ()
	{	this.timer.start ();
	}
	
	// stop le compteur de temps 
	public void stopChrono()
	{	this.timer.stop ();
	}
	
	// permet de recuperer le temps deja ecoule
	public String getTemps ()
	{	
            return ""+this.h+":"+this.m+":"+this.s+":"+this.timeCount;
	}
	
	// permet de connaitre l'etat d'activite du timer (lance ou non)
	public boolean isActif ()
	{	return ( this.timer.isRunning () );
	}
	
	public void actionPerformed (ActionEvent e)
	{	// Cas d'un evenement genere par le bouton
            if(timeCount>999){
                timeCount=0;
                s++;
                if(s > 59){
                    s=0;
                    m++;
                    if(m > 59){
                        m=0;
                        h++;
                    }
                }
            }
            else{
                timeCount++;
            }
            //this.timeCount++;
            this.viewTime.setText (""+this.h+":"+this.m+":"+this.s+":"+this.timeCount);
            
	}
        
        public void demarrerArreter(){
            if(isActif()){
                stopChrono();
            }
            else{
                startChrono();
            }
        }
}