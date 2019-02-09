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
public class ShipmentTypeUtil {
	
	public void generatePie(String path,List<Object[]> data) {
		//1.creating data set
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}
		//2.converting dataset to jfreeChart
		JFreeChart chart=ChartFactory.createPieChart3D("Shipment PieChart", dataset,true,true,false);
		//3.save image 
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/stPie.jpg"),  chart, 250, 250);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void generateBar(String path,List<Object[]> data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		JFreeChart chart=ChartFactory.createBarChart("ShipmentmodeType", "Shipment Mode","count", dataset,PlotOrientation.VERTICAL,true, true, false);
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/shipBar.jpg"), chart, 250, 250);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
