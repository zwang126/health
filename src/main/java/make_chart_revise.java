
import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class make_chart_revise extends ApplicationFrame {

    public make_chart_revise(String applicationTitle, String chartTitle, ArrayList<String> date, HashMap<String, ArrayList<Integer>> hp) {
        super(applicationTitle);
        //  JFreeChart chart = createChart2(dataset, "NN");
        XYDataset dataset = createDataset(date, hp);

        JFreeChart chart = createChart2(dataset, "School Vs Years"  ,date, hp);

        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        chartPanel.setVisible(true);
        

    }

    private XYDataset createDataset(ArrayList<String> date, HashMap<String, ArrayList<Integer>> hp) {
        XYSeries series1 = new XYSeries("high");
        XYSeries series2 = new XYSeries("low");
        XYSeries series3 = new XYSeries("Object 3");
        String category1 = "Category 1";
        String category2 = "Category 2";
        String category3 = "Category 3";
        String category4 = "Category 4";
        String category5 = "Category 5";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultXYDataset dataset1 = new DefaultXYDataset();
        int j = 0;
        int k = 0;
        for (String d : date) {
            for (int i = 0; i < hp.get(d).size(); i++) {
                if (i % 2 == 0) {

                    series1.add(hp.get(d).get(i).doubleValue(), j);
                    j++;
                } else {
                    series2.add(hp.get(d).get(i).doubleValue(), k);
                    //dataset.addValue(hp.get(d).get(i).doubleValue(), k);
                    k++;
                }
            }
        }
        dataset1.addSeries(getTitle(), series1.toArray());
        dataset1.addSeries(getTitle(), series2.toArray());

        return dataset1;
    }

    private JFreeChart createChart2( XYDataset data,String chartTitle, ArrayList<String> date, HashMap<String, ArrayList<Integer>> hp) {
        
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                chartTitle, // chart title
                "time", // x axis label
                "data", // y axis label
                data, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );
        XYPlot plot = (XYPlot) lineChart.getPlot();
        plot.setForegroundAlpha(0.5f);

        String[] grade = new String[date.size()];
        for (int i = 0; i < date.size(); i++) {
            grade[i] = date.get(i);
        }
        SymbolAxis rangeAxis = new SymbolAxis("Words", grade);

        rangeAxis.setTickUnit(new NumberTickUnit(1));
        rangeAxis.setRange(0, grade.length);
        plot.setRangeAxis(rangeAxis);
        return lineChart;
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
