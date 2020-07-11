package com.neo.chart;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.TextAnchor;

public class MyIpChart {
	
	public MyIpChart( Map<String, Integer> clickCountMap,String path,String fileName) {
		this.createChart( clickCountMap, path, fileName );
	}



	// 获得数据集 （这里的数据是为了测试我随便写的一个自动生成数据的例子）
	public DefaultCategoryDataset createDataset(Map<String, Integer> clickCountMap) {

		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		
		
		// 曲线名称
		String series = "网站访问量统计"; // series指的就是报表里的那条数据线  最下面的底部标题
		// 因此 对数据线的相关设置就需要联系到serise
		// 比如说setSeriesPaint 设置数据线的颜色
		for (String key : clickCountMap.keySet()) {
			 System.out.println("今天的图表已经生成，不用再次生成key="+key);
			   linedataset.addValue(clickCountMap.get(key),series,key);
		}
	
		return linedataset;
	}

	
	
	
	// 生成图标对象JFreeChart
	/*
	 * 整个大的框架属于JFreeChart 坐标轴里的属于 Plot 其常用子类有：CategoryPlot, MultiplePiePlot,
	 * PiePlot , XYPlot
	 *
	 ***
	 */
	public void createChart( Map<String, Integer> clickCountMap,String path,String fileName) {

		//创建主题样式  
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");  
		//设置标题字体  
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.BOLD, 20));  
		//设置轴向字体  
		mChartTheme.setLargeFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
		//设置图例字体  
		mChartTheme.setRegularFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
		//应用主题样式  
		ChartFactory.setChartTheme(mChartTheme);  
		///////////////以上主题设置必须位于创建图表函数之前才能生效////////////  
		
		try {
			// 定义图标对象
			JFreeChart chart = ChartFactory.createLineChart(
					"每日网站访问量统计", // 报表题目，字符串类型
					"采集时间", // 横轴
					"访问量", // 纵轴
					this.createDataset(clickCountMap), // 获得数据集
					PlotOrientation.VERTICAL, // 图标方向垂直
					true, // 显示图例
					false, // 不用生成工具
					false // 不用生成URL地址
			);
			
			 //图表标题设置  
			 TextTitle mTextTitle = chart.getTitle();  
		     mTextTitle.setFont(new Font("黑体", Font.BOLD, 20));  
		     
		   //图表图例设置  
	        LegendTitle mLegend = chart.getLegend();  
	        if(mLegend != null)  
	            mLegend.setItemFont(new Font("宋体", Font.CENTER_BASELINE, 15));  
	        
	      
			
	        
	        
			// 整个大的框架属于chart 可以设置chart的背景颜色

			// 生成图形
			CategoryPlot plot = chart.getCategoryPlot();
			// 图像属性部分
			plot.setBackgroundPaint(Color.getHSBColor(62,58,57));
			plot.setDomainGridlinesVisible(true); // 设置背景网格线是否可见
			plot.setDomainGridlinePaint(Color.BLACK); // 设置背景网格线颜色
			plot.setRangeGridlinePaint(Color.GRAY);
			plot.setNoDataMessage("没有数据");// 没有数据时显示的文字说明。
			//plot.setNoDataMessageFont(  new Font("宋体", Font.PLAIN, 12)  );
			
		    // ２、对图里面的汉字设定,也就是Ｐlot的设定
	        Font font2 = new Font("SimSun", 10, 16); // 设定字体、类型、字号
	        plot.getDomainAxis().setLabelFont(font2);// 相当于横轴或理解为X轴
	        plot.getRangeAxis().setLabelFont(font2);// 相当于竖轴理解为Y轴
			
			
	        // 3、下面的方块区域是 LegendTitle 对象  
	        Font font3 = new Font("SimSun", 10, 12); // 设定字体、类型、字号
	        chart.getLegend().setItemFont(font3);// 最下方
	        
	        
	        // 这是处理Ｐlot里面的横轴，同理可以正理竖轴  就是坐标轴的x轴 下方对应的数据
	        CategoryAxis categoryaxis = plot.getDomainAxis(); // 横轴上的
	        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);// 45度倾斜,可以改成其他,默认是水平
	        categoryaxis.setTickLabelFont(new Font("SansSerif", 10, 12));// 设定字体、类型、字号
	        // categoryaxis.setTickLabelFont(new Font("SimSun", 10, 12));//
			
			// 数据轴属性部分
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			rangeAxis.setAutoRangeIncludesZero(true); // 自动生成
			rangeAxis.setUpperMargin(0.20);
			rangeAxis.setLabelAngle(Math.PI / 2.0);
			rangeAxis.setAutoRange(false);
			rangeAxis.setLabelFont( new Font("宋体", Font.PLAIN, 12) );	//左边栏字体
	
			
			
			
			
			// 数据渲染部分 主要是对折线做操作
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setSeriesPaint(0, Color.black); // 设置折线的颜色
			renderer.setBaseShapesFilled(true);
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBasePositiveItemLabelPosition(
					new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			
			
			/*
			 * 这里的StandardCategoryItemLabelGenerator()我想强调下：当时这个地*方被搅得头很晕，
			 * Standard**ItemLabelGenerator是通用的 因为我创建*的是CategoryPlot
			 * 所以很多设置都是Category相关 而XYPlot 对应的则是 ： StandardXYItemLabelGenerator
			 */
			// 对于编程人员 这种根据一种类型方法联想到其他类型相似方法的思
			// 想是必须有的吧！目前只能慢慢培养了。。
			renderer.setBaseItemLabelFont(new Font("Dialog", 1, 14)); // 设置提示折点数据形状
			plot.setRenderer(renderer);
			// 区域渲染部分
			double lowpress = 500;
			double uperpress = 1000; // 设定正常血糖值的范围
			IntervalMarker inter = new IntervalMarker(lowpress, uperpress);
			inter.setLabelOffsetType(LengthAdjustmentType.EXPAND); // 范围调整——扩张
			inter.setPaint(Color.GREEN);// 域顏色

			inter.setLabelFont(  new Font("宋体", Font.PLAIN, 12) );
			inter.setLabelPaint(Color.RED);
			inter.setLabel("                     正常访问量范围"); // 设定区域说明文字
			plot.addRangeMarker(inter, Layer.FOREGROUND); // 添加mark到图形
															// BACKGROUND使得数据折线在区域的前端

			
			// 创建文件输出流
			//File fos_jpg = new File("E://bloodSugarChart11.jpg ");
			File fos_jpg = new File(path+""+fileName);
			// 输出到哪个输出流
			ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // 统计图表对象
					1000, // 宽
					500 // 高
			);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 测试类
	public static void main(String[] args) {
		
	}

}