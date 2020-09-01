package org.lanqiao.bean;



public class ConsumptionGson {
	
	private double sumRecharge;
	private double sumConsumption;
	private double sumMonthRecharge;
	private double sumMonthConsumption;
	
	@Override
	public String toString() {
		return "ConsumptionGson [sumRecharge=" + sumRecharge + ", sumConsumption=" + sumConsumption
				+ ", sumMonthRecharge=" + sumMonthRecharge + ", sumMonthConsumption=" + sumMonthConsumption + "]";
	}
	
	public double getSumRecharge() {
		return sumRecharge;
	}
	public void setSumRecharge(double sumRecharge) {
		this.sumRecharge = sumRecharge;
	}
	public double getSumConsumption() {
		return sumConsumption;
	}
	public void setSumConsumption(double sumConsumption) {
		this.sumConsumption = sumConsumption;
	}
	public double getSumMonthRecharge() {
		return sumMonthRecharge;
	}
	public void setSumMonthRecharge(double sumMonthRecharge) {
		this.sumMonthRecharge = sumMonthRecharge;
	}
	public double getSumMonthConsumption() {
		return sumMonthConsumption;
	}
	public void setSumMonthConsumption(double sumMonthConsumption) {
		this.sumMonthConsumption = sumMonthConsumption;
	}
	
}
