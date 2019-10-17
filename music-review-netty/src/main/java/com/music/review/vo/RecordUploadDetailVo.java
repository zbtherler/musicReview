package com.music.review.vo;

import java.io.Serializable;
/**
 * 接收上传信息详情
 * @author user
 *
 */
public class RecordUploadDetailVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 设备Id
	 */
	private String deviceId;
	
	/**
	 * mac地址
	 */
	private String macAddress;
	
	/**
	 * 用户Id
	 */
	private String memberId;
	
	/**
	 * 刷牙时间 几点几分开始
	 */
	private String brushTeethTime;
	
	/**
	 * 刷牙时长（秒） 
	 */
	private int brushTeethDuration;
	
	/**
	 * 外侧左边上方X轴刷牙次数
	 */
	private int outLeftUpXBrushCount;
	
	/**
	 * 外侧左边上方Y轴刷牙次数
	 */
	private int outLeftUpYBrushCount;
	
	/**
	 * 外侧左边上方45°角刷牙次数
	 */
	private int outLeftUp45DegreeCount;
	
	/**
	 * 外左上拂刷次数
	 */
	private int outLeftUpWhiskCount;
	
	/**
	 * 外侧左边上方刷牙时间
	 */
	private int outLeftUpBrushTime;
	
	/**
	 * 外侧左边下方X轴刷牙次数
	 */
	private int outLeftDownXBrushCount;
	
	/**
	 * 外侧左边下方Y轴刷牙次数
	 */
	private int outLeftDownYBrushCount;
	
	/**
	 * 外侧左边下方45°角刷牙次数
	 */
	private int outLeftDown45DegreeCount;
	
	/**
	 * 外左下拂刷次数
	 */
	private int outLeftDownWhiskCount;
	
	/**
	 * 外侧左边下方刷牙时间
	 */
	private int outLeftDownBrushTime;
	
	/**
	 * 外侧中间上方X轴刷牙次数
	 */
	private int outCenterUpXBrushCount;
	
	/**
	 * 外侧中间上方Y轴刷牙次数
	 */
	private int outCenterUpYBrushCount;
	
	/**
	 * 外侧中间上方45°角刷牙次数
	 */
	private int outCenterUp45DegreeBrushCount;
	
	/**
	 * 外中上拂刷次数
	 */
	private int outCenterUpWhiskCount;
	
	/**
	 * 外侧中间上方刷牙时间
	 */
	private int outCenterUpBrushTime;
	
	/**
	 * 外侧中间下方X轴刷牙次数
	 */
	private int outCenterDownXBrushCount;
	
	/**
	 * 外侧中间下方Y轴刷牙次数
	 */
	private int outCenterDownYBrushCount;
	
	/**
	 * 外侧中间下方45°角刷牙次数
	 */
	private int outCenterDown45DegreeBrushCount;
	
	/**
	 * 外中下拂刷次数
	 */
	private int outCenterDownWhiskCount;
	
	/**
	 * 外侧中间下方刷牙时间
	 */
	private int outCenterDownBrushTime;
	
	/**
	 * 外侧右边上方X轴刷牙次数
	 */
	private int outRightUpXBrushCount;
	
	/**
	 * 外侧右边上方Y轴刷牙次数
	 */
	private int outRightUpYBrushCount;
	
	/**
	 * 外侧右边上方45°角刷牙次数
	 */
	private int outRightUp45DegreeBrushCount;
	
	/**
	 * 外右上拂刷次数
	 */
	private int outRightUpWhiskCount;
	
	/**
	 * 外侧右边上方刷牙时间
	 */
	private int outRightUpBrushTime;
	
	/**
	 * 外侧右边下方X轴刷牙次数
	 */
	private int outRightDownXBrushCount;
	
	/**
	 * 外侧右边下方Y轴刷牙次数
	 */
	private int outRightDownYBrushCount;
	
	/**
	 * 外侧右边下方45°角刷牙次数
	 */
	private int outRightDown45DegreeBrushCount;
	
	/**
	 * 外右下拂刷次数
	 */
	private int outRightDownWhiskCount;
	
	/**
	 * 外侧右边下方刷牙时间
	 */
	private int outRightDownBrushTime;
	
	/**
	 * 内侧左边上方刷牙次数
	 */
	private int innerLeftUpBrushCount;
	
	/**
	 * 内左上拂刷次数
	 */
	private int innerLeftUpWhiskCount;
	
	/**
	 * 内侧左边上方刷牙时间
	 */
	private int innerLeftUpBrushTime;
	
	/**
	 * 内侧左边下方刷牙次数
	 */
	private int innerLeftDownBrushCount;
	
	/**
	 * 内左下拂刷次数
	 */
	private int innerLeftDownWhiskCount;
	
	/**
	 * 内侧左边下方刷牙时间
	 */
	private int innerLeftDownBrushTime;
	
	/**
	 * 内侧中间上方刷牙次数
	 */
	private int innerCenterUpBrushCount;
	
	/**
	 * 内中上拂刷次数
	 */
	private int innerCenterUpWhiskCount;
	
	/**
	 * 内侧中间上方刷牙时间
	 */
	private int innerCenterUpBrushTime;
	
	/**
	 * 内侧中间下方刷牙次数
	 */
	private int innerCenterDownBrushCount;
	
	/**
	 * 内中上拂刷次数
	 */
	private int innerCenterDownWhiskCount;
	
	/**
	 * 内侧中间下方刷牙时间
	 */
	private int innerCenterDownBrushTime;
	
	/**
	 * 内侧右边上方刷牙次数
	 */
	private int innerRightUpBrushCount;
	
	/**
	 * 内右上拂刷次数
	 */
	private int innerRightUpWhiskCount;
	
	/**
	 * 内侧右边上方刷牙时间
	 */
	private int innerRightUpBrushTime;
	
	/**
	 * 内侧右边下方刷牙次数
	 */
	private int innerRightDownBrushCount;
	
	/**
	 * 内右下拂刷次数
	 */
	private int innerRightDownWhiskCount;
	
	/**
	 * 内侧右边下方刷牙时间
	 */
	private int innerRightDownBrushTime;
	
	/**
	 * 咬合面上方左边刷牙次数
	 */
	private int upLeftBrushCount;
	
	/**
	 * 咬合面上方左边刷牙时间
	 */
	private int upLeftBrushTime;
	
	/**
	 * 咬合面下方左边刷牙次数
	 */
	private int downLeftBrushCount;
	
	/**
	 * 咬合面下方左边刷牙时间
	 */
	private int downLeftBrushTime;
	
	/**
	 * 咬合面上方右边刷牙次数
	 */
	private int upRightBrushCount;
	
	/**
	 * 咬合面上方右边刷牙时间
	 */
	private int upRightBrushTime;
	
	/**
	 * 咬合面下方右边刷牙次数
	 */
	private int downRightBrushCount;
	
	/**
	 * 咬合面下方右边刷牙时间
	 */
	private int downRightBrushTime;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getBrushTeethTime() {
		return brushTeethTime;
	}

	public void setBrushTeethTime(String brushTeethTime) {
		this.brushTeethTime = brushTeethTime;
	}

	public int getOutLeftUpXBrushCount() {
		return outLeftUpXBrushCount;
	}

	public void setOutLeftUpXBrushCount(int outLeftUpXBrushCount) {
		this.outLeftUpXBrushCount = outLeftUpXBrushCount;
	}

	public int getOutLeftUpYBrushCount() {
		return outLeftUpYBrushCount;
	}

	public void setOutLeftUpYBrushCount(int outLeftUpYBrushCount) {
		this.outLeftUpYBrushCount = outLeftUpYBrushCount;
	}

	public int getOutLeftUp45DegreeCount() {
		return outLeftUp45DegreeCount;
	}

	public void setOutLeftUp45DegreeCount(int outLeftUp45DegreeCount) {
		this.outLeftUp45DegreeCount = outLeftUp45DegreeCount;
	}

	public int getOutLeftUpBrushTime() {
		return outLeftUpBrushTime;
	}

	public void setOutLeftUpBrushTime(int outLeftUpBrushTime) {
		this.outLeftUpBrushTime = outLeftUpBrushTime;
	}

	public int getOutLeftDownXBrushCount() {
		return outLeftDownXBrushCount;
	}

	public void setOutLeftDownXBrushCount(int outLeftDownXBrushCount) {
		this.outLeftDownXBrushCount = outLeftDownXBrushCount;
	}

	public int getOutLeftDownYBrushCount() {
		return outLeftDownYBrushCount;
	}

	public void setOutLeftDownYBrushCount(int outLeftDownYBrushCount) {
		this.outLeftDownYBrushCount = outLeftDownYBrushCount;
	}

	public int getOutLeftDown45DegreeCount() {
		return outLeftDown45DegreeCount;
	}

	public void setOutLeftDown45DegreeCount(int outLeftDown45DegreeCount) {
		this.outLeftDown45DegreeCount = outLeftDown45DegreeCount;
	}

	public int getOutLeftDownBrushTime() {
		return outLeftDownBrushTime;
	}

	public void setOutLeftDownBrushTime(int outLeftDownBrushTime) {
		this.outLeftDownBrushTime = outLeftDownBrushTime;
	}

	public int getOutCenterUpXBrushCount() {
		return outCenterUpXBrushCount;
	}

	public void setOutCenterUpXBrushCount(int outCenterUpXBrushCount) {
		this.outCenterUpXBrushCount = outCenterUpXBrushCount;
	}

	public int getOutCenterUpYBrushCount() {
		return outCenterUpYBrushCount;
	}

	public void setOutCenterUpYBrushCount(int outCenterUpYBrushCount) {
		this.outCenterUpYBrushCount = outCenterUpYBrushCount;
	}

	public int getOutCenterUp45DegreeBrushCount() {
		return outCenterUp45DegreeBrushCount;
	}

	public void setOutCenterUp45DegreeBrushCount(int outCenterUp45DegreeBrushCount) {
		this.outCenterUp45DegreeBrushCount = outCenterUp45DegreeBrushCount;
	}

	public int getOutCenterUpBrushTime() {
		return outCenterUpBrushTime;
	}

	public void setOutCenterUpBrushTime(int outCenterUpBrushTime) {
		this.outCenterUpBrushTime = outCenterUpBrushTime;
	}

	public int getOutCenterDownXBrushCount() {
		return outCenterDownXBrushCount;
	}

	public void setOutCenterDownXBrushCount(int outCenterDownXBrushCount) {
		this.outCenterDownXBrushCount = outCenterDownXBrushCount;
	}

	public int getOutCenterDownYBrushCount() {
		return outCenterDownYBrushCount;
	}

	public void setOutCenterDownYBrushCount(int outCenterDownYBrushCount) {
		this.outCenterDownYBrushCount = outCenterDownYBrushCount;
	}

	public int getOutCenterDown45DegreeBrushCount() {
		return outCenterDown45DegreeBrushCount;
	}

	public void setOutCenterDown45DegreeBrushCount(
			int outCenterDown45DegreeBrushCount) {
		this.outCenterDown45DegreeBrushCount = outCenterDown45DegreeBrushCount;
	}

	public int getOutCenterDownBrushTime() {
		return outCenterDownBrushTime;
	}

	public void setOutCenterDownBrushTime(int outCenterDownBrushTime) {
		this.outCenterDownBrushTime = outCenterDownBrushTime;
	}

	public int getOutRightUpXBrushCount() {
		return outRightUpXBrushCount;
	}

	public void setOutRightUpXBrushCount(int outRightUpXBrushCount) {
		this.outRightUpXBrushCount = outRightUpXBrushCount;
	}

	public int getOutRightUpYBrushCount() {
		return outRightUpYBrushCount;
	}

	public void setOutRightUpYBrushCount(int outRightUpYBrushCount) {
		this.outRightUpYBrushCount = outRightUpYBrushCount;
	}

	public int getOutRightUp45DegreeBrushCount() {
		return outRightUp45DegreeBrushCount;
	}

	public void setOutRightUp45DegreeBrushCount(int outRightUp45DegreeBrushCount) {
		this.outRightUp45DegreeBrushCount = outRightUp45DegreeBrushCount;
	}

	public int getOutRightUpBrushTime() {
		return outRightUpBrushTime;
	}

	public void setOutRightUpBrushTime(int outRightUpBrushTime) {
		this.outRightUpBrushTime = outRightUpBrushTime;
	}

	public int getOutRightDownXBrushCount() {
		return outRightDownXBrushCount;
	}

	public void setOutRightDownXBrushCount(int outRightDownXBrushCount) {
		this.outRightDownXBrushCount = outRightDownXBrushCount;
	}

	public int getOutRightDownYBrushCount() {
		return outRightDownYBrushCount;
	}

	public void setOutRightDownYBrushCount(int outRightDownYBrushCount) {
		this.outRightDownYBrushCount = outRightDownYBrushCount;
	}

	public int getOutRightDown45DegreeBrushCount() {
		return outRightDown45DegreeBrushCount;
	}

	public void setOutRightDown45DegreeBrushCount(int outRightDown45DegreeBrushCount) {
		this.outRightDown45DegreeBrushCount = outRightDown45DegreeBrushCount;
	}

	public int getOutRightDownBrushTime() {
		return outRightDownBrushTime;
	}

	public void setOutRightDownBrushTime(int outRightDownBrushTime) {
		this.outRightDownBrushTime = outRightDownBrushTime;
	}

	public int getInnerLeftUpBrushCount() {
		return innerLeftUpBrushCount;
	}

	public void setInnerLeftUpBrushCount(int innerLeftUpBrushCount) {
		this.innerLeftUpBrushCount = innerLeftUpBrushCount;
	}

	public int getInnerLeftUpBrushTime() {
		return innerLeftUpBrushTime;
	}

	public void setInnerLeftUpBrushTime(int innerLeftUpBrushTime) {
		this.innerLeftUpBrushTime = innerLeftUpBrushTime;
	}

	public int getInnerLeftDownBrushCount() {
		return innerLeftDownBrushCount;
	}

	public void setInnerLeftDownBrushCount(int innerLeftDownBrushCount) {
		this.innerLeftDownBrushCount = innerLeftDownBrushCount;
	}

	public int getInnerLeftDownBrushTime() {
		return innerLeftDownBrushTime;
	}

	public void setInnerLeftDownBrushTime(int innerLeftDownBrushTime) {
		this.innerLeftDownBrushTime = innerLeftDownBrushTime;
	}

	public int getInnerCenterUpBrushCount() {
		return innerCenterUpBrushCount;
	}

	public void setInnerCenterUpBrushCount(int innerCenterUpBrushCount) {
		this.innerCenterUpBrushCount = innerCenterUpBrushCount;
	}

	public int getInnerCenterUpBrushTime() {
		return innerCenterUpBrushTime;
	}

	public void setInnerCenterUpBrushTime(int innerCenterUpBrushTime) {
		this.innerCenterUpBrushTime = innerCenterUpBrushTime;
	}

	public int getInnerCenterDownBrushCount() {
		return innerCenterDownBrushCount;
	}

	public void setInnerCenterDownBrushCount(int innerCenterDownBrushCount) {
		this.innerCenterDownBrushCount = innerCenterDownBrushCount;
	}

	public int getInnerCenterDownBrushTime() {
		return innerCenterDownBrushTime;
	}

	public void setInnerCenterDownBrushTime(int innerCenterDownBrushTime) {
		this.innerCenterDownBrushTime = innerCenterDownBrushTime;
	}

	public int getInnerRightUpBrushCount() {
		return innerRightUpBrushCount;
	}

	public void setInnerRightUpBrushCount(int innerRightUpBrushCount) {
		this.innerRightUpBrushCount = innerRightUpBrushCount;
	}

	public int getInnerRightUpBrushTime() {
		return innerRightUpBrushTime;
	}

	public void setInnerRightUpBrushTime(int innerRightUpBrushTime) {
		this.innerRightUpBrushTime = innerRightUpBrushTime;
	}

	public int getInnerRightDownBrushCount() {
		return innerRightDownBrushCount;
	}

	public void setInnerRightDownBrushCount(int innerRightDownBrushCount) {
		this.innerRightDownBrushCount = innerRightDownBrushCount;
	}

	public int getInnerRightDownBrushTime() {
		return innerRightDownBrushTime;
	}

	public void setInnerRightDownBrushTime(int innerRightDownBrushTime) {
		this.innerRightDownBrushTime = innerRightDownBrushTime;
	}

	public int getUpLeftBrushCount() {
		return upLeftBrushCount;
	}

	public void setUpLeftBrushCount(int upLeftBrushCount) {
		this.upLeftBrushCount = upLeftBrushCount;
	}

	public int getUpLeftBrushTime() {
		return upLeftBrushTime;
	}

	public void setUpLeftBrushTime(int upLeftBrushTime) {
		this.upLeftBrushTime = upLeftBrushTime;
	}

	public int getDownLeftBrushCount() {
		return downLeftBrushCount;
	}

	public void setDownLeftBrushCount(int downLeftBrushCount) {
		this.downLeftBrushCount = downLeftBrushCount;
	}

	public int getDownLeftBrushTime() {
		return downLeftBrushTime;
	}

	public void setDownLeftBrushTime(int downLeftBrushTime) {
		this.downLeftBrushTime = downLeftBrushTime;
	}

	public int getUpRightBrushCount() {
		return upRightBrushCount;
	}

	public void setUpRightBrushCount(int upRightBrushCount) {
		this.upRightBrushCount = upRightBrushCount;
	}

	public int getUpRightBrushTime() {
		return upRightBrushTime;
	}

	public void setUpRightBrushTime(int upRightBrushTime) {
		this.upRightBrushTime = upRightBrushTime;
	}

	public int getDownRightBrushCount() {
		return downRightBrushCount;
	}

	public void setDownRightBrushCount(int downRightBrushCount) {
		this.downRightBrushCount = downRightBrushCount;
	}

	public int getDownRightBrushTime() {
		return downRightBrushTime;
	}

	public void setDownRightBrushTime(int downRightBrushTime) {
		this.downRightBrushTime = downRightBrushTime;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
	public int getBrushTeethDuration() {
		return brushTeethDuration;
	}

	public void setBrushTeethDuration(int brushTeethDuration) {
		this.brushTeethDuration = brushTeethDuration;
	}

	public int getOutLeftUpWhiskCount() {
		return outLeftUpWhiskCount;
	}

	public void setOutLeftUpWhiskCount(int outLeftUpWhiskCount) {
		this.outLeftUpWhiskCount = outLeftUpWhiskCount;
	}

	public int getOutLeftDownWhiskCount() {
		return outLeftDownWhiskCount;
	}

	public void setOutLeftDownWhiskCount(int outLeftDownWhiskCount) {
		this.outLeftDownWhiskCount = outLeftDownWhiskCount;
	}

	public int getOutCenterUpWhiskCount() {
		return outCenterUpWhiskCount;
	}

	public void setOutCenterUpWhiskCount(int outCenterUpWhiskCount) {
		this.outCenterUpWhiskCount = outCenterUpWhiskCount;
	}

	public int getOutCenterDownWhiskCount() {
		return outCenterDownWhiskCount;
	}

	public void setOutCenterDownWhiskCount(int outCenterDownWhiskCount) {
		this.outCenterDownWhiskCount = outCenterDownWhiskCount;
	}

	public int getOutRightUpWhiskCount() {
		return outRightUpWhiskCount;
	}

	public void setOutRightUpWhiskCount(int outRightUpWhiskCount) {
		this.outRightUpWhiskCount = outRightUpWhiskCount;
	}

	public int getOutRightDownWhiskCount() {
		return outRightDownWhiskCount;
	}

	public void setOutRightDownWhiskCount(int outRightDownWhiskCount) {
		this.outRightDownWhiskCount = outRightDownWhiskCount;
	}

	public int getInnerLeftUpWhiskCount() {
		return innerLeftUpWhiskCount;
	}

	public void setInnerLeftUpWhiskCount(int innerLeftUpWhiskCount) {
		this.innerLeftUpWhiskCount = innerLeftUpWhiskCount;
	}

	public int getInnerLeftDownWhiskCount() {
		return innerLeftDownWhiskCount;
	}

	public void setInnerLeftDownWhiskCount(int innerLeftDownWhiskCount) {
		this.innerLeftDownWhiskCount = innerLeftDownWhiskCount;
	}

	public int getInnerCenterUpWhiskCount() {
		return innerCenterUpWhiskCount;
	}

	public void setInnerCenterUpWhiskCount(int innerCenterUpWhiskCount) {
		this.innerCenterUpWhiskCount = innerCenterUpWhiskCount;
	}

	public int getInnerCenterDownWhiskCount() {
		return innerCenterDownWhiskCount;
	}

	public void setInnerCenterDownWhiskCount(int innerCenterDownWhiskCount) {
		this.innerCenterDownWhiskCount = innerCenterDownWhiskCount;
	}

	public int getInnerRightUpWhiskCount() {
		return innerRightUpWhiskCount;
	}

	public void setInnerRightUpWhiskCount(int innerRightUpWhiskCount) {
		this.innerRightUpWhiskCount = innerRightUpWhiskCount;
	}

	public int getInnerRightDownWhiskCount() {
		return innerRightDownWhiskCount;
	}

	public void setInnerRightDownWhiskCount(int innerRightDownWhiskCount) {
		this.innerRightDownWhiskCount = innerRightDownWhiskCount;
	}
	

}
