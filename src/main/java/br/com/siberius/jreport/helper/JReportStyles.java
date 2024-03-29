package br.com.siberius.jreport.helper;

import java.awt.Color;

import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;

public class JReportStyles {
	
	public static Style titleStyle = new StyleBuilder(true)
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setFont(new Font(14, Font._FONT_TIMES_NEW_ROMAN, true))
		.setPaddingBottom(5)
		.build();

	public static Style subtitleStyle = new StyleBuilder(true)
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setFont(Font.TIMES_NEW_ROMAN_MEDIUM)
		.setPaddingTop(-10)
		.setPaddingBottom(10)
		.build();

	
	public static Style columnHeaderStyle = new StyleBuilder(true)
		.setTextColor(Color.black)
		.setFont(Font.TIMES_NEW_ROMAN_MEDIUM_BOLD)
		.setBorder(Border.THIN())
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	public static Style columnDetailStyle = new StyleBuilder(true)
		.setVerticalAlign(VerticalAlign.TOP)
		.setTextColor(Color.black)
		.setFont(new Font(10, Font._FONT_TIMES_NEW_ROMAN, false))
		.setBorder(Border.THIN())
		.setBorderColor(Color.DARK_GRAY)
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	public static Style lineStyle  = new StyleBuilder(true)
		.setBorderTop(Border.PEN_1_POINT())
		.setBorderBottom(Border.PEN_1_POINT())
		.setFont(Font.ARIAL_MEDIUM_BOLD)
		.setTextColor(Color.black)
		.setHorizontalAlign(HorizontalAlign.LEFT)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	public static Style headerVariables = new StyleBuilder(true)
		.setFont(Font.ARIAL_MEDIUM_BOLD)
		.setHorizontalAlign(HorizontalAlign.RIGHT)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	
	public static Style headerVariablesStyle = new StyleBuilder(true)
		.setHorizontalAlign(HorizontalAlign.LEFT)
		.setFont(new Font(Font.MEDIUM, null, true))
		.build();


	public static Style oddRowStyle = new StyleBuilder(true)
		.setBorder(Border.NO_BORDER())
		.setBackgroundColor(Color.LIGHT_GRAY)
		.build();

	public static Style detailSubReportStyle = new StyleBuilder(true)
		.setVerticalAlign(VerticalAlign.TOP)
		.setTextColor(Color.black)
		.setBorder(Border.NO_BORDER())
		.setBorderTop(Border.PEN_1_POINT())
		.setBorderBottom(Border.PEN_1_POINT())
		.setBorderLeft(Border.PEN_1_POINT())
		.setBorderRight(Border.PEN_1_POINT())
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	public static Style headerSubReportStyle = new StyleBuilder(true)
		.setFont(Font.ARIAL_MEDIUM_BOLD)
		.setBorderBottom(Border.PEN_1_POINT())
		.setBorderTop(Border.PEN_1_POINT())
		.setBorderLeft(Border.PEN_1_POINT())
		.setBorderRight(Border.PEN_1_POINT())
		.setTextColor(Color.black)
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.setTransparency(Transparency.OPAQUE)
		.build();

	public static Style headerVariablesSubReportStyle = new StyleBuilder(true)
		.setFont(Font.ARIAL_MEDIUM_BOLD)
		.setBorderBottom(Border.PEN_1_POINT())
		.setBorderTop(Border.PEN_1_POINT())
		.setBorderLeft(Border.PEN_1_POINT())
		.setBorderRight(Border.PEN_1_POINT())
		.setTextColor(Color.black)
		.setHorizontalAlign(HorizontalAlign.RIGHT)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.build();

	public static Style titleSubReportStyle = new StyleBuilder(true)
		.setFont(new Font(10, null, true))
		.setFont(Font.ARIAL_MEDIUM_BOLD)
		.setBorderBottom(Border.PEN_1_POINT())
		.setBorderTop(Border.PEN_1_POINT())
		.setBorderLeft(Border.PEN_1_POINT())
		.setBorderRight(Border.PEN_1_POINT())
		.setTextColor(Color.black)
		.setBackgroundColor(Color.LIGHT_GRAY)
		.setHorizontalAlign(HorizontalAlign.CENTER)
		.setVerticalAlign(VerticalAlign.MIDDLE)
		.setTransparency(Transparency.OPAQUE)
		.build();

	public static Style oddRowSubReportStyle = new StyleBuilder(true)
		.setBorder(Border.NO_BORDER())
		.setBackgroundColor(Color.LIGHT_GRAY)
		.setTransparency(Transparency.OPAQUE)
		.build();
	
	public static Style footerTextStyle = new StyleBuilder(true)
			.setFont(Font.TIMES_NEW_ROMAN_SMALL)
			.build();
}
