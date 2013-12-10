/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author Coralie GENDRIER - Corinne BECHEPOIS - Elisabeth RECULE - M1 MIAGE
 * grpe 1A
 */
public class GrapheCourse {

    private int nbTours;
    private int[] lesVoitures;//numéro des voitures de la course
    private DefaultTableModel resultats; //tableau des résultats
    private JFreeChart chart;

    public GrapheCourse(int nb, int[] voit, DefaultTableModel modele) {
        this.nbTours = nb;
        this.lesVoitures = voit;
        this.resultats = modele;
    }

    public int[] getTempsDeCourse(int numV) {
        int[] temps = new int[nbTours];
        int precedent=0;

        for (int x = 0; x < nbTours; x++) {
            temps[x] = 0;
        }
        int n = 0;
        for (int i = 0; i < resultats.getRowCount(); i++) {
            String sRes = (String) resultats.getValueAt(i, 1);
            if (Integer.parseInt(sRes) == numV) {
                    //parse du resultat
                    String res = (String) resultats.getValueAt(i, 3);
                    
                    String[] res2 = res.split(":");
                    int h = Integer.parseInt(res2[0]);
                    int m = Integer.parseInt(res2[1]);
                    int s = Integer.parseInt(res2[2]);
                    int ms = Integer.parseInt(res2[3]);
                    int time = ms + (s * 1000) + (m * 60 * 1000) + (h * 60 * 60 * 1000);
                    //si c'est un top in, on note le temps au tour et on garde ce temps pour calculer le temps passé dans le stand
                    if(((String) resultats.getValueAt(i, 5)).compareTo("TOP IN")==0){
                        precedent = time;
                        temps[n] = time;
                        n++;
                    }
                    //si c'est un top out, on garde le temps passé dans le stand
                    if(((String) resultats.getValueAt(i, 5)).compareTo("TOP OUT")==0){
                        precedent = time-precedent;
                    }
                    if(((String) resultats.getValueAt(i, 5)).compareTo("TOP TOUR")==0){
                        //si le precedent top etait out, on enleve le temps passé dans le stand
                        if(precedent!=0){
                            temps[n] = time-precedent;
                            n++;
                            precedent = 0;
                        }
                        else{
                            temps[n] = time;
                            n++;
                        }
                        
                    }
                
            }
        }

        return temps;
    }

    public void genererGraphe(String nomC) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < lesVoitures.length; i++) {
            // Create a simple XY chart
            XYSeries series = new XYSeries("Voiture " + lesVoitures[i]);
            int[] temps = this.getTempsDeCourse(lesVoitures[i]);
            //1er tours
            series.add(1, temps[0]);
            for (int j = 1; j < nbTours; j++) {
                if(temps[j]!=0){
                    series.add(j+1, (temps[j] - temps[j - 1]));}
                else{series.add(j+1,0);}
            }
            // Add the series to your data set
            dataset.addSeries(series);
        }

        // Generate the graph
        chart = ChartFactory.createXYLineChart(
                "Résultat de la course " + nomC, // Title
                "tours", // x-axis Label
                "temps ms", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

    }

    public ChartPanel getPanelChart() {
        ChartPanel cPanel = new ChartPanel(chart);
        return cPanel;
    }
    
    
			
    
}
