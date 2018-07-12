package com.zzl.thinking.chapter21.section21_5_4.toast;
/**
 * 
 * @author zzl
 * ��˾
 */
public class Toast {
	public enum Status {
		DRY,
		BUTTERED,
		JAMMED
	}
	
	private Status status = Status.DRY;
	// ��˾id
	private final int id;
	public Toast(int id) {
		this.id = id;
	}
	// Ĩ����
	public void butter() {
		status = Status.BUTTERED;
	}
	// Ϳ����
	public void jam() {
		status = Status.JAMMED;
	}
	// ��ȡ��ǰ״̬
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
