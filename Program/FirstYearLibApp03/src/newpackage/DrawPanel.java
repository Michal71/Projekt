package newpackage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2E0405E4-589B-7A9B-D16D-5DBAD596D70E]
// </editor-fold> 

/**
 * @author Makuta
 */
public class DrawPanel {
    static int i;
    //obiekty przechowujące czas i dystans w chwili uderzenia w ziemię
    static double v;
    static double d;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2DD34CE-0711-EAA7-8542-B0D710735ACA]
    // </editor-fold> 
    DrawPanel() {

    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2453E06C-54A0-10AA-1594-12A310B9398D]
    // </editor-fold> 
    private static JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Krzywa balistyczna", "Odległość[m]",
                "Wysokość[m]", dataset, PlotOrientation.VERTICAL,
                true, false, false);
        chart.setBackgroundPaint(Color.lightGray);


        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        Shape sh = renderer.getSeriesShape(1);
        renderer.setSeriesShape(2, sh);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesLinesVisible(2, false);
        //plot.setAxisOffset(new RectangleInsets(5.0,5.0,5.0, 5.0));
        return chart;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.82EDF1A1-9549-9C8C-C876-21A36EE79E64]
    // </editor-fold> 
    static XYDataset createDataset() {
        int k = 250;
        //prędkość początkowa w poziomie
        double speed1 = (Dane.speed * Math.cos(Dane.angle / 180 * Math.PI));
        //prędkość początkowa w pionie
        double speed2 = (Dane.speed * Math.sin(Dane.angle / 180 * Math.PI));
        //przyspieszenie poziome
        double acc1 = 0;
        //przyspieszenie pionowe
        double acc2 = 0;


        XYSeries s1 = new XYSeries("Krzywa");
        double step = Dane.time / (double) (k);
        double distance = -speed1 * step;
        double height = Dane.height - +speed2 * step;
        //pętla całkująca
        for (i = 0; i <= k + 2000; i++) {
            speed1 = speed1 - acc1;
            speed2 = speed2 - acc2;
            acc1 = 0.0005607 * Math.abs(speed1) * speed1;
            acc2 = 0.0005607 * Math.abs(speed2) * speed2 + 9.81 * step;
            distance = distance + speed1 * step;
            height = height + speed2 * step;
            if (height < 0) {
                v = Dane.time * i / k;
                d = distance;
                break;
            }

            s1.add(distance, height);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EC3616A6-06F5-542E-5991-F8CCA10B7D37]
    // </editor-fold> 

    /**
     * @return
     */
    public static JPanel createWoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }


}

