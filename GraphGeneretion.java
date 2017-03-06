
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraphGeneretion extends ApplicationFrame implements ActionListener  {

    private TimeSeries timser;
    int i=0;
    private double lastValue ;
    private Timer timecounter = new Timer(125, this);// Timer to refresh graph
    public GraphGeneretion(final String title) {

        super(title);
        this.timser = new TimeSeries("PACKET RATE", Millisecond.class);
        final TimeSeriesCollection inputset = new TimeSeriesCollection(this.timser);
        final JFreeChart graph = createGraph(inputset);
        timecounter.setInitialDelay(100);
        graph.setBackgroundPaint(Color.WHITE);
        final JPanel entry = new JPanel(new BorderLayout());
        final ChartPanel graphpanel = new ChartPanel(graph);
        entry.add(graphpanel);
        graphpanel.setPreferredSize(new java.awt.Dimension(5000, 5000));
        setContentPane(entry);
        timecounter.start();
    }
    private JFreeChart createGraph(final XYDataset data) {
        final JFreeChart output = ChartFactory.createTimeSeriesChart("packet Length","Time","packets",data, true,true,false);
        final XYPlot graphplot = output.getXYPlot();
        graphplot.setBackgroundPaint(Color.WHITE);
        graphplot.setDomainGridlinesVisible(true);
        graphplot.setDomainGridlinePaint(Color.BLACK);
        graphplot.setRangeGridlinesVisible(true);
        graphplot.setRangeGridlinePaint(Color.BLACK);
        ValueAxis xaxis = graphplot.getDomainAxis();
        xaxis.setAutoRange(true);
        xaxis.setFixedAutoRange(300000.0);  //X axis show data 30 seconds 
        xaxis.setVerticalTickLabels(true);
        ValueAxis yaxis = graphplot.getRangeAxis();
        yaxis.setRange(0.0, 1514.0);
        return output;
    }
    public void actionPerformed(final ActionEvent e) {
        this.lastValue = networkpacketanalyser.arr[i];
        final Millisecond now = new Millisecond();
        this.timser.add(new Millisecond(), this.lastValue);
        System.out.println("Timestamp = " + now.toString()+", packet length: "+this.lastValue);
        i++;
    }

    public static void main(final String[] args) {
        final GraphGeneretion obj = new GraphGeneretion("Packet Analyser");
        obj.pack();
        RefineryUtilities.centerFrameOnScreen(obj);
        obj.setVisible(true);

    }

}  