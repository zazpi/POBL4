/**
 * 
 */
package electricom.negocio;

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
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

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

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setGradientPaintTransformer(null);
		renderer.setBarPainter(new StandardBarPainter());
		renderer.setMaximumBarWidth(0.2);
		
		ChartPanel panel = new ChartPanel(chart,true);
		
		return panel;
		
	}
	
	public static ChartPanel getGraficoTarta(Map<String,Double> valores) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Entry<String, Double> e: valores.entrySet()) {
			dataset.setValue(e.getKey(),e.getValue());
		}
		JFreeChart chart = ChartFactory.createPieChart("",dataset,false,true,false);
		ChartPanel panel = new ChartPanel(chart,true);
		return panel;
	}

}
