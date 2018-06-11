/**
 * 
 */
package pobl4.negocio;

import java.awt.Color;
import java.awt.RenderingHints;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Lucas
 *
 */
public class GraficoFactory {
	
	public static ChartPanel getGraficoBarras(Map<String,Double> consumos) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("Consumo", "Periodo", "Consumo(kw)", dataset, PlotOrientation.VERTICAL,true,true,false);
		
		for(Entry<String, Double> e: consumos.entrySet()) {
			dataset.addValue(e.getValue(), "Row 1", e.getKey());
		}
		
		//render
		
		//Opts
		chart.setBackgroundPaint(Color.LIGHT_GRAY);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.green);
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, Color.DARK_GRAY);
		renderer.setDrawBarOutline(false);
		renderer.setItemMargin(0.0);
		ChartPanel panel = new ChartPanel(chart,true);
		
		return panel;
		
	}

}
