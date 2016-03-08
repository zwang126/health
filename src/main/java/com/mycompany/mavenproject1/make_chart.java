/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Administrator
 */
public class make_chart extends ApplicationFrame {

    public make_chart(String title, ArrayList<String> name, HashMap<String, ArrayList<Integer>> pressure, HashMap<String, Float> tang, ArrayList<Float> date) {
        super(title);
        final XYDataset dataset = createDataset(name, pressure, tang, date);
        final JFreeChart chart = createChart(title, dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(ArrayList<String> name, HashMap<String, ArrayList<Integer>> pressure, HashMap<String, Float> tang, ArrayList<Float> date) {
        final XYSeries series3 = new XYSeries("First");
        final XYSeries series4 = new XYSeries("Second");
        final XYSeries series5 = new XYSeries("First");
        for (Float d : date) {
            for (String n : name) {
                /*
                ArrayList<Integer> press = pressure.get(n);
                int size = press.size();
                for (int i = 0; i < size; i++) {
                    if (i % 2 == 0) {
                        int high = press.get(i);
                        series3.add(d.floatValue(), high);
                    } else {
                        int low = press.get(i);
                        series4.add(d.floatValue(), low);
                    }
                }
                        */
                Float sugr = tang.get(n);
                float suger = sugr.floatValue();
                series5.add(d.floatValue(), suger);
                
            }
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        //dataset.addSeries(series3);
        //dataset.addSeries(series4);
        dataset.addSeries(series5);
        return dataset;
    }

    private JFreeChart createChart(String title, final XYDataset dataset) {
        final JFreeChart chart = ChartFactory.createXYLineChart(
                title, // chart title
                "time", // x axis label
                "data", // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );
        chart.setBackgroundPaint(Color.white);
        XYItemRenderer renderer1 = new XYLineAndShapeRenderer(true, false);
        renderer1.setBasePositiveItemLabelPosition(
            new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        renderer1.setBaseItemLabelFont(
            renderer1.getBaseItemLabelFont().deriveFont(14f));
        renderer1.setBaseItemLabelsVisible(true);
        renderer1.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setRenderer(renderer1);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);
        
       
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(4.0, 20.0);
        
        return chart;
    }

    public static void main(final String[] args) {
        ArrayList<Integer> pressure = new ArrayList<Integer>();
        ArrayList<Float> date = new ArrayList<Float>();
        ArrayList<Float> tang1 = new ArrayList<Float>();
        ArrayList<String> name = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> pressure1 = new HashMap<String, ArrayList<Integer>>();
        HashMap<String, Float> tang = new HashMap<String, Float>();
        name.add("a");
        name.add("b");
        name.add("c");

        date.add((float) 10.2);
        date.add((float) 10.3);
        date.add((float) 10.4);

        pressure.add(20);
        pressure.add(2);
        pressure.add(30);
        pressure.add(1);
        pressure.add(40);
        pressure.add(3);
        pressure1.put(name.get(0), pressure);
        tang.put(name.get(0), (float) 11);
        tang.put(name.get(1), (float) 10.3);
        tang.put(name.get(2), (float) 9.0);
        // String title, ArrayList<String> name, HashMap<String, ArrayList<Integer>> pressure, HashMap<String, Float> tang, ArrayList<Float> date
        final make_chart demo = new make_chart("test", name, pressure1, tang, date);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
