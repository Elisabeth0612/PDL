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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Co
 */
public class GrapheCourse {
    private int nbTours;
    private int[] lesVoitures;//numéro des voitures de la course
    private DefaultTableModel resultats; //tableau des résultats
    
    public GrapheCourse(int nb,int[] voit,DefaultTableModel modele){
        this.nbTours = nb;
        this.lesVoitures = voit;
        this.resultats = modele;
    }
    
    public int[] getTempsDeCourse(int numV){
        int[] temps=new int[nbTours];
    
        for(int x=0;x<nbTours;x++){
            temps[x]=0;
        }
        int n = 0;
        for(int i=0; i<resultats.getRowCount();i++){
            String sRes = (String)resultats.getValueAt(i, 1);
            if(Integer.parseInt(sRes)==numV){
                //parse du resultat
                String res = (String)resultats.getValueAt(i, 3);
                String[] res2 = res.split(":");
                int h=Integer.parseInt(res2[0]);
                int m=Integer.parseInt(res2[1]);
                int s=Integer.parseInt(res2[2]);
                int ms=Integer.parseInt(res2[3]);
                int time=ms+(s*1000)+(m*60*1000)+(h*60*60*1000);
                
                temps[n]=time;
                n++;
            }
        }
    
        return temps;
    }
    
    public void genererGraphe(String nomC){
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        for(int i=0;i<lesVoitures.length;i++){ 
            // Create a simple XY chart
            XYSeries series = new XYSeries("Voiture "+lesVoitures[i]);
            int[] temps = this.getTempsDeCourse(lesVoitures[i]);
            //1er tours
            series.add(1,temps[0]);
            for(int j=1;j<nbTours;j++){
                series.add(j+1,(temps[j]-temps[j-1]));
            }
            // Add the series to your data set
            dataset.addSeries(series);
        }
        
        // Generate the graph
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Résultat de la course "+nomC, // Title
                "tours", // x-axis Label
                "temps ms", // y-axis Label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot Orientation
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        try {
            ChartUtilities.saveChartAsJPEG(new File("./src/graphique/"+nomC+"_chart.jpg"), chart, 500, 300);
        } catch (IOException e) {
            System.err.println("Problem occurred creating chart.");
        }
    }
}
