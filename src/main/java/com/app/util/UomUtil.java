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
public class UomUtil {
	public void generatePie(String path,List<Object[]> data) {
		//1.create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}
		//2.convert dataset to jfreechart
		JFreeChart chart=ChartFactory.createPieChart3D("Uom Type", dataset, true, true, false);
		//3.save image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/uomPie.jpg"), chart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void generateBar(String path,List<Object[]> data) {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()),d[0].toString(),"");
		
		}
			/*JFreeChart chart=ChartFactory.createBarChart("Uom Types", "UomType", "count", dataset,PlotOrientation.HORIZONTAL ,true, true, false);*/
		JFreeChart chart=ChartFactory.createBarChart("uomtype", "uomtype", "count", dataset);
			try {
				ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/uomBar.jpg"), chart, 250, 250);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	

