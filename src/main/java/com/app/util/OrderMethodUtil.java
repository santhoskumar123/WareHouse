package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class OrderMethodUtil {

	public void generatePie(String path,List<Object[]> data) {
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));

			JFreeChart chart=ChartFactory.createPieChart3D("Order Pie", dataset, true, true, false);

			try {
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/pie.jpg"), chart, 250, 250);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	public void generateBar(String path,List<Object[]> data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		JFreeChart chart=ChartFactory.createBarChart("Order Modes", "OrderMode", "count", dataset, PlotOrientation.VERTICAL, true, true,false);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/orderBar.jpg"), chart, 250, 250);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
