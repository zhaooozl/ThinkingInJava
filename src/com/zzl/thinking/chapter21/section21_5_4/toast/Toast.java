package com.zzl.thinking.chapter21.section21_5_4.toast;
/**
 * 
 * @author zzl
 * 吐司
 */
public class Toast {
	public enum Status {
		DRY,
		BUTTERED,
		JAMMED
	}
	
	private Status status = Status.DRY;
	// 吐司id
	private final int id;
	public Toast(int id) {
		this.id = id;
	}
	// 抹黄油
	public void butter() {
		status = Status.BUTTERED;
	}
	// 涂果酱
	public void jam() {
		status = Status.JAMMED;
	}
	// 获取当前状态
	public Status getStatus() {
		return status;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Toast " + id + ": " + status;
	}
	

}
