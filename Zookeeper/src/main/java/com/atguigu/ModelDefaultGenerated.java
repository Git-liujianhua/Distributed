package com.atguigu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelDefaultGenerated {

	/**
	 * 模块id
	 */
	private Integer formmodeid = 17;
	/**
	 * 模块创建人id
	 */
	private Integer modedatacreater = 1;
	/**
	 * 创建人类型(插入默认值0即可)
	 */
	private Integer modedatacreatertype = 0;
	/**
	 * 模块的创建日期
	 */
	private String modedatacreatedate = dateString();
	/**
	 * 模块的创建时间
	 */
	private String modedatacreatetime = timeString();
	
	/**
	 * 模块修改人id
	 */
	private Integer modedatamodifier = 0;
	
	/**
	 * 模块修改日期时间
	 */
	private String modedatamodifydatetime = dateTimeString();
	
	private static final Date date = new Date();
	//格式化日期
	private static String dateString() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String createdate = sdf.format(date);
		return createdate;
	}
	//格式化时间
	private static String timeString() {
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	String createdate = sdf.format(date);
		return createdate;
	}
	
	//格式化日期时间
		private static String dateTimeString() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String createdate = sdf.format(date);
			return createdate;
		}

	public ModelDefaultGenerated() {
	}

	public ModelDefaultGenerated(Integer formmodeid, Integer modedatacreater, Integer modedatacreatertype, String modedatacreatedate, String modedatacreatetime, Integer modedatamodifier, String modedatamodifydatetime) {
		this.formmodeid = formmodeid;
		this.modedatacreater = modedatacreater;
		this.modedatacreatertype = modedatacreatertype;
		this.modedatacreatedate = modedatacreatedate;
		this.modedatacreatetime = modedatacreatetime;
		this.modedatamodifier = modedatamodifier;
		this.modedatamodifydatetime = modedatamodifydatetime;
	}

	public Integer getFormmodeid() {
		return formmodeid;
	}

	public void setFormmodeid(Integer formmodeid) {
		this.formmodeid = formmodeid;
	}

	public Integer getModedatacreater() {
		return modedatacreater;
	}

	public void setModedatacreater(Integer modedatacreater) {
		this.modedatacreater = modedatacreater;
	}

	public Integer getModedatacreatertype() {
		return modedatacreatertype;
	}

	public void setModedatacreatertype(Integer modedatacreatertype) {
		this.modedatacreatertype = modedatacreatertype;
	}

	public String getModedatacreatedate() {
		return modedatacreatedate;
	}

	public void setModedatacreatedate(String modedatacreatedate) {
		this.modedatacreatedate = modedatacreatedate;
	}

	public String getModedatacreatetime() {
		return modedatacreatetime;
	}

	public void setModedatacreatetime(String modedatacreatetime) {
		this.modedatacreatetime = modedatacreatetime;
	}

	public Integer getModedatamodifier() {
		return modedatamodifier;
	}

	public void setModedatamodifier(Integer modedatamodifier) {
		this.modedatamodifier = modedatamodifier;
	}

	public String getModedatamodifydatetime() {
		return modedatamodifydatetime;
	}

	public void setModedatamodifydatetime(String modedatamodifydatetime) {
		this.modedatamodifydatetime = modedatamodifydatetime;
	}

	@Override
	public String toString() {
		return "ModelDefaultGenerated{" +
				"formmodeid=" + formmodeid +
				", modedatacreater=" + modedatacreater +
				", modedatacreatertype=" + modedatacreatertype +
				", modedatacreatedate='" + modedatacreatedate + '\'' +
				", modedatacreatetime='" + modedatacreatetime + '\'' +
				", modedatamodifier=" + modedatamodifier +
				", modedatamodifydatetime='" + modedatamodifydatetime + '\'' +
				'}';
	}
}
