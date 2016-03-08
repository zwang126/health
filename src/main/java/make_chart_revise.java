
import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class make_chart_revise extends ApplicationFrame {

    public make_chart_revise(String applicationTitle, String chartTitle, ArrayList<String> date, HashMap<String, ArrayList<Integer>> hp) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Time", "Value",
                createDataset(date, hp),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(ArrayList<String> date, HashMap<String, ArrayList<Integer>> hp) {
        XYSeries series1 = new XYSeries("Object 1");
        XYSeries series2 = new XYSeries("Object 2");
        XYSeries series3 = new XYSeries("Object 3");
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";
        String category5 = "Category 5";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        for (String d : date) {
            for (int i = 0; i < hp.get(d).size(); i++) {
                if (i % 2 == 0) {
                    

                    dataset.addValue(hp.get(d).get(i), (Comparable) series1, d);
                } else {
                    dataset.addValue(hp.get(d).get(i), (Comparable) series2, d);
                }
            }
        }
        
        return dataset1;
    }

    public static void main(String[] args) {
        ArrayList<String> date = new ArrayList<String>();
        date.add("10.1");
        date.add("10.2");
        date.add("10.3");
        ArrayList<Integer> pressure1 = new ArrayList<Integer>();
        pressure1.add(120);
        pressure1.add(80);
        ArrayList<Integer> pressure2 = new ArrayList<Integer>();
        pressure2.add(130);
        pressure2.add(60);
        ArrayList<Integer> pressure3 = new ArrayList<Integer>();
        pressure3.add(140);
        pressure3.add(70);
        HashMap<String, ArrayList<Integer>> hp = new HashMap<String, ArrayList<Integer>>();
        hp.put("10.1", pressure1);
        hp.put("10.2", pressure2);
        hp.put("10.3", pressure3);
        make_chart_revise chart = new make_chart_revise(
                "School Vs Years",
                "Numer of Schools vs years", date, hp);

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}
